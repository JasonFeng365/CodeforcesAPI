package codeforces.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StatusResult {
	private String status, comment;
	private List<Submission> result;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public StatusResult(
			@JsonProperty("status") String status,
			@JsonProperty("comment") String comment,
			@JsonProperty("result") Submission[] result
			) {
		this.status = status;
		this.comment = comment;
		if (result==null) result = new Submission[0];
		this.result = List.of(result);
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

