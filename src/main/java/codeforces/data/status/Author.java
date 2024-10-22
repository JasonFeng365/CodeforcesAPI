package codeforces.data.status;

import java.util.Arrays;

public class Author {
	public String contestId;
	public Member[] members;
	public String participantType;
	public boolean ghost;
	public long startTimeSeconds;

	@Override
	public String toString() {
		return "Author{" +
				"contestId='" + contestId + '\'' +
				", members=" + Arrays.toString(members) +
				", participantType='" + participantType + '\'' +
				", ghost=" + ghost +
				", startTimeSeconds=" + startTimeSeconds +
				'}';
	}
}
