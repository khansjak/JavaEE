package com.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Actors")
public class Actors {
	@Id
	private int actorID;
	@Column(name="actorName")
	private String actorName;
	private int actorAge;
	private String movieDid;
	
	public Actors() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getActorID() {
		return actorID;
	}

	public void setActorID(int actorID) {
		this.actorID = actorID;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public int getActorAge() {
		return actorAge;
	}

	public void setActorAge(int actorAge) {
		this.actorAge = actorAge;
	}

	public String getMovieDid() {
		return movieDid;
	}

	public void setMovieDid(String movieDid) {
		this.movieDid = movieDid;
	}

	public Actors(int actorID, String actorName, int actorAge, String movieDid) {
		super();
		this.actorID = actorID;
		this.actorName = actorName;
		this.actorAge = actorAge;
		this.movieDid = movieDid;
	}

	@Override
	public String toString() {
		return "Actors [actorID=" + actorID + ", actorName=" + actorName + ", actorAge=" + actorAge + ", movieDid="
				+ movieDid + "]";
	}
	
	
	
	

}
