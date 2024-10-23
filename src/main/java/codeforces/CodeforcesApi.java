package codeforces;

public final class CodeforcesApi {
	private final String KEY, SECRET;
	private final boolean authenticated;
	public CodeforcesApi() {
		KEY=null;
		SECRET=null;
		authenticated=false;
	}

	public CodeforcesApi(String key, String secret) {
		KEY=key;
		SECRET=secret;
		authenticated=true;
	}

//	@Override
//	public List<Submission> getAllSubmissions() {
//		return null;
//	}
//
//	@Override
//	public List<Submission> getSubmissionsAfter(long time) {
//		return null;
//	}

	public StatusRequestBuilder newStatusRequest() {
		if (authenticated) return new StatusRequestBuilder(KEY, SECRET);
		else return new StatusRequestBuilder();
	}
}