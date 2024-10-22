package codeforces;

public final class CodeforcesApiBuilder {
	private boolean authenticated=false;
	private String key=null, secret=null;
	private CodeforcesApiBuilder(){}

	public static CodeforcesApiBuilder newBuilder() {
		return new CodeforcesApiBuilder();
	}

	public CodeforcesApi build() {
		if (authenticated) return new CodeforcesApiImpl(key, secret);
		else return new CodeforcesApiImpl();
	}

	public CodeforcesApiBuilder authenticate(String key, String secret) {
		this.key = key;
		this.secret = secret;
		authenticated = true;
		return this;
	}

}
