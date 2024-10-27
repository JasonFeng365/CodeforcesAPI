package codeforces.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StatusResult {
	public String status, comment;
	public List<Submission> result;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public StatusResult(
			@JsonProperty("status") String status,
			@JsonProperty("comment") String comment,
			@JsonProperty("result") Submission[] result
			) {
		this.status = status;
		this.comment = comment;
		this.result = Collections.unmodifiableList(Arrays.asList(result));
	}

	public String getStatus() {
		return status;
	}

	public String getComment() {
		return comment;
	}

	public List<Submission> getResult() {
		return result;
	}

	@Override
	public String toString() {
		return "StatusResult{" +
				"status='" + status + '\'' +
				", comment='" + comment + '\'' +
				", result=" + result +
				'}';
	}
}

