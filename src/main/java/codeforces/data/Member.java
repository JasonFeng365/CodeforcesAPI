package codeforces.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Member {
	private final String handle, name;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public Member(
			@JsonProperty("handle") String handle,
			@JsonProperty("name") String name
	) {
		this.handle = handle;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member{" +
				"handle='" + handle + '\'' +
				", name='" + name + '\'' +
				'}';
	}

	public String getHandle() {
		return handle;
	}

	public String getName() {
		return name;
	}
}
