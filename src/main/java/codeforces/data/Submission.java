package codeforces.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Submission {
	private long id, contestId, creationTimeSeconds, relativeTimeSeconds;
	private Problem problem;
	private Party author;
	private String programmingLanguage, verdict, testset;
	private long passedTestCount, timeConsumedMillis, memoryConsumedBytes;
	private float points;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public Submission(
			@JsonProperty("id") long id,
			@JsonProperty("contestId") long contestId,
			@JsonProperty("creationTimeSeconds") long creationTimeSeconds,
			@JsonProperty("relativeTimeSeconds") long relativeTimeSeconds,
			@JsonProperty("problem") Problem problem,
			@JsonProperty("author") Party author,
			@JsonProperty("programmingLanguage") String programmingLanguage,
			@JsonProperty("verdict") String verdict,
			@JsonProperty("testset") String testset,
			@JsonProperty("passedTestCount") long passedTestCount,
			@JsonProperty("timeConsumedMillis") long timeConsumedMillis,
			@JsonProperty("memoryConsumedBytes") long memoryConsumedBytes,
			@JsonProperty("points") float points
	) {
		this.id = id;
		this.contestId = contestId;
		this.creationTimeSeconds = creationTimeSeconds;
		this.relativeTimeSeconds = relativeTimeSeconds;
		this.problem = problem;
		this.author = author;
		this.programmingLanguage = programmingLanguage;
		this.verdict = verdict;
		this.testset = testset;
		this.passedTestCount = passedTestCount;
		this.timeConsumedMillis = timeConsumedMillis;
		this.memoryConsumedBytes = memoryConsumedBytes;
		this.points = points;
	}

	public long getId() {
		return id;
	}

	public long getContestId() {
		return contestId;
	}

	public long getCreationTimeSeconds() {
		return creationTimeSeconds;
	}

	public long getRelativeTimeSeconds() {
		return relativeTimeSeconds;
	}

	public Problem getProblem() {
		return problem;
	}

	public Party getAuthor() {
		return author;
	}

	public String getProgrammingLanguage() {
		return programmingLanguage;
	}

	public String getVerdict() {
		return verdict;
	}

	public String getTestset() {
		return testset;
	}

	public long getPassedTestCount() {
		return passedTestCount;
	}

	public long getTimeConsumedMillis() {
		return timeConsumedMillis;
	}

	public long getMemoryConsumedBytes() {
		return memoryConsumedBytes;
	}

	public float getPoints() {
		return points;
	}

	@Override
	public String toString() {
		return "Submission{" +
				"id=" + id +
				", contestId=" + contestId +
				", creationTimeSeconds=" + creationTimeSeconds +
				", relativeTimeSeconds=" + relativeTimeSeconds +
				", problem=" + problem +
				", author=" + author +
				", programmingLanguage='" + programmingLanguage + '\'' +
				", verdict='" + verdict + '\'' +
				", testset='" + testset + '\'' +
				", passedTestCount=" + passedTestCount +
				", timeConsumedMillis=" + timeConsumedMillis +
				", memoryConsumedBytes=" + memoryConsumedBytes +
				", points=" + points +
				'}';
	}
}
