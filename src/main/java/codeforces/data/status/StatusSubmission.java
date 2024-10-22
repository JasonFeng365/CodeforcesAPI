package codeforces.data.status;

public class StatusSubmission {
	public long id, contestId, creationTimeSeconds, relativeTimeSeconds;
	public ProblemInfo problem;
	public Author author;

	public String programmingLanguage, verdict, testset;
	public long passedTestCount, timeConsumedMillis, memoryConsumedBytes, teamName;

	@Override
	public String toString() {
		return "StatusSubmission{" +
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
				", teamName=" + teamName +
				'}';
	}
}
