package codeforces.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RanklistRow {
	private Party party;
//	private long rank
	private long rank;
	private double points;
	private long penalty;
	List<ProblemResult> problemResults;
	private long lastSubmissionTimeSeconds;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public RanklistRow(
			@JsonProperty("party") Party party,
			@JsonProperty("rank") long rank,
			@JsonProperty("points") double points,
			@JsonProperty("penalty") long penalty,
			@JsonProperty("problemResults") ProblemResult[] problemResults,
			@JsonProperty("lastSubmissionTimeSeconds") long lastSubmissionTimeSeconds
	) {
		if (problemResults == null) problemResults = new ProblemResult[0];
		this.party = party;
		this.rank = rank;
		this.points = points;
		this.penalty = penalty;
		this.problemResults = List.of(problemResults);
		this.lastSubmissionTimeSeconds = lastSubmissionTimeSeconds;
	}

	public Party getParty() {
		return party;
	}

	public long getRank() {
		return rank;
	}

	public double getPoints() {
		return points;
	}

	public long getPenalty() {
		return penalty;
	}

	public List<ProblemResult> getProblemResults() {
		return problemResults;
	}

	public long getLastSubmissionTimeSeconds() {
		return lastSubmissionTimeSeconds;
	}

	@Override
	public String toString() {
		return "RanklistRow{" +
				"party=" + party +
				", rank=" + rank +
				", points=" + points +
				", penalty=" + penalty +
				", problemResults=" + problemResults +
				", lastSubmissionTimeSeconds=" + lastSubmissionTimeSeconds +
				'}';
	}
}
