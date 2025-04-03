package codeforces.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contest {
	private long id;
	private String name, type, phase;
	private boolean frozen;
	private long durationSeconds, freezeDurationSeconds, startTimeSeconds, relativeTimeSeconds;
	private String preparedBy, websiteUrl, description;
	private int difficulty;
	private String kind, icpcRegion, country, city, season;

	public Contest(
			@JsonProperty("id") long id,
			@JsonProperty("name") String name,
			@JsonProperty("type") String type,
			@JsonProperty("phase") String phase,
			@JsonProperty("frozen") boolean frozen,
			@JsonProperty("durationSeconds") long durationSeconds,
			@JsonProperty("freezeDurationSeconds") long freezeDurationSeconds,
			@JsonProperty("startTimeSeconds") long startTimeSeconds,
			@JsonProperty("relativeTimeSeconds") long relativeTimeSeconds,
			@JsonProperty("preparedBy") String preparedBy,
			@JsonProperty("websiteUrl") String websiteUrl,
			@JsonProperty("description") String description,
			@JsonProperty("difficulty") int difficulty,
			@JsonProperty("kind") String kind,
			@JsonProperty("icpcRegion") String icpcRegion,
			@JsonProperty("country") String country,
			@JsonProperty("city") String city,
			@JsonProperty("season") String season
	) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.phase = phase;
		this.frozen = frozen;
		this.durationSeconds = durationSeconds;
		this.freezeDurationSeconds = freezeDurationSeconds;
		this.startTimeSeconds = startTimeSeconds;
		this.relativeTimeSeconds = relativeTimeSeconds;
		this.preparedBy = preparedBy;
		this.websiteUrl = websiteUrl;
		this.description = description;
		this.difficulty = difficulty;
		this.kind = kind;
		this.icpcRegion = icpcRegion;
		this.country = country;
		this.city = city;
		this.season = season;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getPhase() {
		return phase;
	}

	public boolean isFrozen() {
		return frozen;
	}

	public long getDurationSeconds() {
		return durationSeconds;
	}

	public long getFreezeDurationSeconds() {
		return freezeDurationSeconds;
	}

	public long getStartTimeSeconds() {
		return startTimeSeconds;
	}

	public long getRelativeTimeSeconds() {
		return relativeTimeSeconds;
	}

	public String getPreparedBy() {
		return preparedBy;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public String getDescription() {
		return description;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public String getKind() {
		return kind;
	}

	public String getIcpcRegion() {
		return icpcRegion;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getSeason() {
		return season;
	}

	@Override
	public String toString() {
		return "Contest{" +
				"id=" + id +
				", name='" + name + '\'' +
				", type='" + type + '\'' +
				", phase='" + phase + '\'' +
				", frozen=" + frozen +
				", durationSeconds=" + durationSeconds +
				", freezeDurationSeconds=" + freezeDurationSeconds +
				", startTimeSeconds=" + startTimeSeconds +
				", relativeTimeSeconds=" + relativeTimeSeconds +
				", preparedBy='" + preparedBy + '\'' +
				", websiteUrl='" + websiteUrl + '\'' +
				", description='" + description + '\'' +
				", difficulty=" + difficulty +
				", kind='" + kind + '\'' +
				", icpcRegion='" + icpcRegion + '\'' +
				", country='" + country + '\'' +
				", city='" + city + '\'' +
				", season='" + season + '\'' +
				'}';
	}
}
