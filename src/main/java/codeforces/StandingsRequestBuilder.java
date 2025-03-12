package codeforces;

import codeforces.data.StandingsResult;
import codeforces.data.StatusResult;

public final class StandingsRequestBuilder extends RequestBuilder<StandingsResult> {
	public StandingsRequestBuilder() {
		super();
	}
	public StandingsRequestBuilder(String key, String secret) {
		super(key, secret);
	}
	public StandingsRequestBuilder setAsManager(boolean asManager) {
		params.put("asManager", Boolean.toString(asManager));
		return this;
	}
	public StandingsRequestBuilder setFrom(int firstSubmission) {
		params.put("from", Integer.toString(firstSubmission));
		return this;
	}
	public StandingsRequestBuilder setCount(int numberOfSubmissions) {
		params.put("count", Integer.toString(numberOfSubmissions));
		return this;
	}

	public StandingsRequestBuilder setHandle(String handle) {
		params.put("handle", handle);
		return this;
	}

	public StandingsRequestBuilder setContestId(long contestId) {
		setContestId(Long.toString(contestId));
		return this;
	}
	public StandingsRequestBuilder setContestId(String contestId) {
		params.put("contestId", contestId);
		return this;
	}
	public StandingsRequestBuilder setGroupCode(String groupCode) {
		params.put("groupCode", groupCode);
		return this;
	}

	@Override
	public Request<StandingsResult> build() {
		return build(StandingsResult.class);
	}
	@Override
	public String getMethodName() {
		return "contest.standings";
	}
}
