package codeforces.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProblemResult {
	private double points;
	private long penalty, rejectedAttemptCount;
	private String type;
	private long bestSubmissionTimeSeconds;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public ProblemResult(
			@JsonProperty("points") double points,
			@JsonProperty("penalty") long penalty,
			@JsonProperty("rejectedAttemptCount") long rejectedAttemptCount,
			@JsonProperty("type") String type,
			@JsonProperty("bestSubmissionTimeSeconds") long bestSubmissionTimeSeconds
	) {
		this.points = points;
		this.penalty = penalty;
		this.rejectedAttemptCount = rejectedAttemptCount;
		this.type = type;
		this.bestSubmissionTimeSeconds = bestSubmissionTimeSeconds;
	}

	public double getPoints() {
		return points;
	}

	public long getPenalty() {
		return penalty;
	}

	public long getRejectedAttemptCount() {
		return rejectedAttemptCount;
	}

	public String getType() {
		return type;
	}

	public long getBestSubmissionTimeSeconds() {
		return bestSubmissionTimeSeconds;
	}

	@Override
	public String toString() {
		return "ProblemResult{" +
				"points=" + points +
				", penalty=" + penalty +
				", rejectedAttemptCount=" + rejectedAttemptCount +
				", type='" + type + '\'' +
				", bestSubmissionTimeSeconds=" + bestSubmissionTimeSeconds +
				'}';
	}
}
