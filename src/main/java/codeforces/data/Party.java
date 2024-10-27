package codeforces.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Party {
	public long contestId;
	public List<Member> members;
	public String participantType;
	public long teamId;
	public String teamName;
	public boolean ghost;
	public long room, startTimeSeconds;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public Party(
			@JsonProperty("contestId") long contestId,
			@JsonProperty("members") Member[] members,
			@JsonProperty("participantType") String participantType,
			@JsonProperty("teamId") long teamId,
			@JsonProperty("teamName") String teamName,
			@JsonProperty("ghost") boolean ghost,
			@JsonProperty("room") long room,
			@JsonProperty("startTimeSeconds") long startTimeSeconds
	) {
		this.contestId = contestId;
		this.members = Collections.unmodifiableList(Arrays.asList(members));
		this.participantType = participantType;
		this.teamId = teamId;
		this.teamName = teamName;
		this.ghost = ghost;
		this.room = room;
		this.startTimeSeconds = startTimeSeconds;
	}

	public long getContestId() {
		return contestId;
	}

	public List<Member> getMembers() {
		return members;
	}

	public String getParticipantType() {
		return participantType;
	}

	public long getTeamId() {
		return teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public boolean isGhost() {
		return ghost;
	}

	public long getRoom() {
		return room;
	}

	public long getStartTimeSeconds() {
		return startTimeSeconds;
	}

	@Override
	public String toString() {
		return "Party{" +
				"contestId=" + contestId +
				", members=" + members +
				", participantType='" + participantType + '\'' +
				", teamId=" + teamId +
				", teamName='" + teamName + '\'' +
				", ghost=" + ghost +
				", room=" + room +
				", startTimeSeconds=" + startTimeSeconds +
				'}';
	}
}
