package codeforces;

import codeforces.data.StatusResult;

public final class StatusRequestBuilder extends RequestBuilder<StatusResult> {
	public StatusRequestBuilder() {
		super();
	}
	public StatusRequestBuilder(String key, String secret) {
		super(key, secret);
	}
	public StatusRequestBuilder setAsManager(boolean asManager) {
		params.put("asManager", Boolean.toString(asManager));
		return this;
	}
	public StatusRequestBuilder setFrom(int firstSubmission) {
		params.put("from", Integer.toString(firstSubmission));
		return this;
	}
	public StatusRequestBuilder setCount(int numberOfSubmissions) {
		params.put("count", Integer.toString(numberOfSubmissions));
		return this;
	}

	public StatusRequestBuilder setHandle(String handle) {
		params.put("handle", handle);
		return this;
	}

	public StatusRequestBuilder setContestId(long contestId) {
		setContestId(Long.toString(contestId));
		return this;
	}
	public StatusRequestBuilder setContestId(String contestId) {
		params.put("contestId", contestId);
		return this;
	}
	public StatusRequestBuilder setGroupCode(String groupCode) {
		params.put("groupCode", groupCode);
		return this;
	}

	@Override
	public Request<StatusResult> build() {
		return build(StatusResult.class);
	}
	@Override
	public String getMethodName() {
		return "contest.status";
	}
}
