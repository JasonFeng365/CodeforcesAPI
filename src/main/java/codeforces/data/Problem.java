package codeforces.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem {
	private long contestId;
	private String problemsetName, index, name, type;
	private float points;
	private int rating;
	private List<String> tags;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public Problem(
			@JsonProperty("contestId") long contestId,
			@JsonProperty("problemsetName") String problemsetName,
			@JsonProperty("index") String index,
			@JsonProperty("name") String name,
			@JsonProperty("type") String type,
			@JsonProperty("points") float points,
			@JsonProperty("rating") int rating,
			@JsonProperty("tags") String[] tags
	) {
		this.contestId = contestId;
		this.problemsetName = problemsetName;
		this.index = index;
		this.name = name;
		this.type = type;
		this.points = points;
		this.rating = rating;
		if (tags==null) tags = new String[0];
		this.tags = List.of(tags);

		if (!type.equals("IOI")) this.points = 1;
	}

	public long getContestId() {
		return contestId;
	}

	public String getProblemsetName() {
		return problemsetName;
	}

	public String getIndex() {
		return index;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public float getPoints() {
		return points;
	}

	public int getRating() {
		return rating;
	}

	public List<String> getTags() {
		return tags;
	}

	@Override
	public String toString() {
		return "Problem{" +
				"contestId=" + contestId +
				", problemsetName='" + problemsetName + '\'' +
				", index='" + index + '\'' +
				", name='" + name + '\'' +
				", type='" + type + '\'' +
				", points=" + points +
				", rating=" + rating +
				", tags=" + tags +
				'}';
	}
}
