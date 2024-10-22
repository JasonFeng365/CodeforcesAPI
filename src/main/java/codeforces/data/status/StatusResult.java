package codeforces.data.status;

import java.util.Arrays;

public class StatusResult {
	public String status, comment;
	public StatusSubmission[] result;

	@Override
	public String toString() {
		return "StatusResult{" +
				"status='" + status + '\'' +
				", comment='" + comment + '\'' +
				", result=" + Arrays.toString(result) +
				'}';
	}
}

