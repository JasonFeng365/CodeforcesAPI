package codeforces.data.status;

import java.util.Arrays;

public class ProblemInfo {
	public long contestId;
	public String index, name, type;
	public int rating;
	public String[] tags;

	@Override
	public String toString() {
		return "ProblemInfo{" +
				"contestId=" + contestId +
				", index='" + index + '\'' +
				", name='" + name + '\'' +
				", type='" + type + '\'' +
				", rating=" + rating +
				", tags=" + Arrays.toString(tags) +
				'}';
	}
}
