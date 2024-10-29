package codeforces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public final class Request<ResponseType> {
//	https://codeforces.com/api/contest.status?....
	private static final String API_ENDPOINT="https://codeforces.com/api/";
	private final Class<ResponseType> responseTypeClass;
	private final TreeMap<String, String> params;
	private final String key, secret, methodName;
	private final boolean authorized;
	private String curRandom;
	Request(String methodName, TreeMap<String, String> params, Class<ResponseType> responseTypeClass) {
		this.methodName = methodName;
		this.params = params;
		this.responseTypeClass = responseTypeClass;
		key = null;
		secret = null;
		authorized = false;
	}
	Request(String methodName, TreeMap<String, String> params, Class<ResponseType> responseTypeClass, String key, String secret) {
		this.methodName = methodName;
		this.params = params;
		this.responseTypeClass = responseTypeClass;
		this.key = key;
		this.secret = secret;
		authorized = true;
	}
	private static String getTimeSeconds() {
		return Long.toString(System.currentTimeMillis()/1000);
	}
	private static String getRand() {
		return Integer.toString((int)(Math.random()*900000) + 100000);
	}
	private static String sha512Hex(String string) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] hash = md.digest(string.getBytes(StandardCharsets.UTF_8));

			StringBuilder hexString = new StringBuilder();
			for (byte b : hash) {
				hexString.append(String.format("%02x", b));
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	private String getParamString() {
		TreeMap<String, String> params = new TreeMap<>(this.params);
		if (authorized) {
			params.put("apiKey", key);
			params.put("time", getTimeSeconds());
		}

		List<String> paramList = params.entrySet().stream().map(
				entry -> entry.getKey() + "=" + entry.getValue()
		).collect(Collectors.toList());

		return String.join("&", paramList);
	}

	private String getHash() {
		curRandom = getRand();

		String paramString = getParamString();
		String toHash = String.format("%s/%s?%s#%s", curRandom, methodName, paramString, secret);
		String hashed = sha512Hex(toHash);

//		System.out.println("Hash: "+curRandom+hashed);

		return curRandom+hashed;
	}

	public String getURL() {
		String allParams = getParamString();
		StringBuilder base = new StringBuilder(API_ENDPOINT);
		base.append(methodName);
		if (!allParams.isEmpty()) base.append('?').append(allParams);
		if (authorized) {
			String hashed = getHash();
			base.append("&apiSig=").append(hashed);
		}
		return base.toString();
	}

	/*

	def getApiSig(methodName, params):

		params.append(("apiKey", apiKey))
		params.append(("time", str(time)))
		paramsString = "&".join(map(joinParamPair, sorted(params)))


		# <rand>/<methodName>?param1=value1&param2=value2...&paramN=valueN#<secret>
		string = f"{rand}/{methodName}?{paramsString}#{apiSecret}"
		return string

	# Example usage

	# sig = getApiSig("contest.status", [("contestId", "522146"), ("groupCode", "ANhuR0iBIH"), ("asManager", "true"), ("count", "5")])
	sig = getApiSig("contest.status", [("contestId", "2000"), ("count", "5")])
	print(sig)
	hash_value = sha512hex(sig)
	print("Time:", time)
	print("apiSig: 123456"+hash_value)
	 */

	private String makeHttpRequest() {
		try {
			HttpClient client = HttpClient.newHttpClient();

			String url = getURL();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(url))
					.header("Content-Type", "application/json; charset=utf-8")
					.header("User-Agent", "")
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();

			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			String jsonResponse = response.body();

			return jsonResponse;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public synchronized ResponseType sendRequest() {
		String jsonString = makeHttpRequest();

		ObjectMapper mapper = new ObjectMapper();
//		mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
//		mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
//		mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ResponseType response = null;
		try {
			response = mapper.readValue(jsonString, responseTypeClass);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return response;
	}
}
