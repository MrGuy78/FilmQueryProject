package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Film {
	
	private int filmId;
	private String filmTitle;
	private String filmDesc;
	private int releaseYear;
	private int langId;
	private int rentDur;
	private int rentRate;
	private int filmLength;
	private double replCost;
	private String filmRating;
	private String specFeat;
	private List<Actor> actors;
	
	public Film() {
		super();
	}
	
	public Film(int filmId, String filmTitle, String filmDesc, int releaseYear, int langId, int rentDur, int rentRate,
			int filmLength, double replCost, String filmRating, String specFeat) {
		super();
		this.filmId = filmId;
		this.filmTitle = filmTitle;
		this.filmDesc = filmDesc;
		this.releaseYear = releaseYear;
		this.langId = langId;
		this.rentDur = rentDur;
		this.rentRate = rentRate;
		this.filmLength = filmLength;
		this.replCost = replCost;
		this.filmRating = filmRating;
		this.specFeat = specFeat;
	}

	public int getFilmId() {
		return filmId;
	}
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	public String getFilmTitle() {
		return filmTitle;
	}
	public void setFilmTitle(String filmTitle) {
		this.filmTitle = filmTitle;
	}
	public String getFilmDesc() {
		return filmDesc;
	}
	public void setFilmDesc(String filmDesc) {
		this.filmDesc = filmDesc;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public int getLangId() {
		return langId;
	}
	public void setLangId(int langId) {
		this.langId = langId;
	}
	public int getRentDur() {
		return rentDur;
	}
	public void setRentDur(int rentDur) {
		this.rentDur = rentDur;
	}
	public int getRentRate() {
		return rentRate;
	}
	public void setRentRate(int rentRate) {
		this.rentRate = rentRate;
	}
	public int getFilmLength() {
		return filmLength;
	}
	public void setFilmLength(int filmLength) {
		this.filmLength = filmLength;
	}
	public double getReplCost() {
		return replCost;
	}
	public void setReplCost(double replCost) {
		this.replCost = replCost;
	}
	public String getFilmRating() {
		return filmRating;
	}
	public void setFilmRating(String filmRating) {
		this.filmRating = filmRating;
	}
	public String getSpecFeat() {
		return specFeat;
	}
	public void setSpecFeat(String specFeat) {
		this.specFeat = specFeat;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filmDesc == null) ? 0 : filmDesc.hashCode());
		result = prime * result + filmId;
		result = prime * result + filmLength;
		result = prime * result + ((filmRating == null) ? 0 : filmRating.hashCode());
		result = prime * result + ((filmTitle == null) ? 0 : filmTitle.hashCode());
		result = prime * result + langId;
		result = prime * result + releaseYear;
		result = prime * result + rentDur;
		result = prime * result + rentRate;
		long temp;
		temp = Double.doubleToLongBits(replCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((specFeat == null) ? 0 : specFeat.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (filmDesc == null) {
			if (other.filmDesc != null)
				return false;
		} else if (!filmDesc.equals(other.filmDesc))
			return false;
		if (filmId != other.filmId)
			return false;
		if (filmLength != other.filmLength)
			return false;
		if (filmRating == null) {
			if (other.filmRating != null)
				return false;
		} else if (!filmRating.equals(other.filmRating))
			return false;
		if (filmTitle == null) {
			if (other.filmTitle != null)
				return false;
		} else if (!filmTitle.equals(other.filmTitle))
			return false;
		if (langId != other.langId)
			return false;
		if (releaseYear != other.releaseYear)
			return false;
		if (rentDur != other.rentDur)
			return false;
		if (rentRate != other.rentRate)
			return false;
		if (Double.doubleToLongBits(replCost) != Double.doubleToLongBits(other.replCost))
			return false;
		if (specFeat == null) {
			if (other.specFeat != null)
				return false;
		} else if (!specFeat.equals(other.specFeat))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Film [filmId=" + filmId + ", filmTitle=" + filmTitle + ", filmDesc=" + filmDesc + ", releaseYear="
				+ releaseYear + ", langId=" + langId + ", rentDur=" + rentDur + ", rentRate=" + rentRate
				+ ", filmLength=" + filmLength + ", replCost=" + replCost + ", filmRating=" + filmRating + ", specFeat="
				+ specFeat + "]";
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	
}
