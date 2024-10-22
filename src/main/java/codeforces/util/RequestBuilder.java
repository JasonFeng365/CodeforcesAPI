package codeforces.util;

import codeforces.data.ApiMethod;

import java.util.Map;
import java.util.TreeMap;

public abstract class RequestBuilder<ResponseType> {
	protected final String key, secret;
	protected final boolean authenticated;
	protected Map<String, String> params = new TreeMap<>();
	protected RequestBuilder() {
		key=null;
		secret=null;
		authenticated=false;
	}
	protected RequestBuilder(String key, String secret) {
		this.key = key;
		this.secret = secret;
		authenticated = true;
	}

	protected TreeMap<String, String> buildParams() {
		return new TreeMap<>(params);
	}

	protected Request<ResponseType> build(Class<ResponseType> responseClass) {
		if (authenticated) return new Request<>(getMethodName(), buildParams(), responseClass, key, secret);
		else return new Request<>(getMethodName(), buildParams(), responseClass);
	}
	public abstract Request<ResponseType> build();
	public abstract String getMethodName();
}
