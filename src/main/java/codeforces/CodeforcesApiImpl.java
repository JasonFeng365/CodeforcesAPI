package codeforces;

import codeforces.data.status.StatusResult;
import codeforces.util.RequestBuilder;
import codeforces.util.StatusRequestBuilder;
import codeforces.util.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public final class CodeforcesApiImpl implements CodeforcesApi {
	private final String KEY, SECRET;
	private final boolean authenticated;
	public CodeforcesApiImpl() {
		KEY=null;
		SECRET=null;
		authenticated=false;
	}

	public CodeforcesApiImpl(String key, String secret) {
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