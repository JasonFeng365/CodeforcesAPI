package codeforces.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StandingsResult {
	private String status, comment;
	private Standings result;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public StandingsResult(
			@JsonProperty("status") String status,
			@JsonProperty("comment") String comment,
			@JsonProperty("result") Standings result
	) {
		this.status = status;
		this.comment = comment;
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public String getComment() {
		return comment;
	}

	public Standings getResult() {
		return result;
	}

	@Override
	public String toString() {
		return "StandingsResult{" +
				"status='" + status + '\'' +
				", comment='" + comment + '\'' +
				", result=" + result +
				'}';
	}
}
