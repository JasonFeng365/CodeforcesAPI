package codeforces.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Standings {
	private Contest contest;
	private List<Problem> problems;
	private List<RanklistRow> rows;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public Standings(
			@JsonProperty("contest") Contest contest,
			@JsonProperty("problems") Problem[] problems,
			@JsonProperty("rows") RanklistRow[] rows
	) {
		this.contest = contest;
		if (problems==null) problems=new Problem[0];
		this.problems = List.of(problems);
		if (rows==null) rows = new RanklistRow[0];
		this.rows = List.of(rows);
	}

	public Contest getContest() {
		return contest;
	}

	public List<Problem> getProblems() {
		return problems;
	}

	public List<RanklistRow> getRows() {
		return rows;
	}

	@Override
	public String toString() {
		return "Standings{" +
				"contest=" + contest +
				", problems=" + problems +
				", rows=" + rows +
				'}';
	}
}
