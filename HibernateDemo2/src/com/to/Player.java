package com.to;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="player")
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int playerID;
	@Column(nullable = false , name="name")
	private String playerName;
	//private String teamName;
	//@OneToOne
	//private Team team;
	
	@OneToMany
	List<Team> teamList = new ArrayList<>();
	private int age;


	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	
	//public String getTeamName() {
	//	return teamName;
	//}

	//public void setTeamName(String teamName) {
	//	this.teamName = teamName;
	//}

	/*
	 * public Team getTeam() { return team; }
	 * 
	 * public void setTeam(Team team) { this.team = team; }
	 */

	
	public int getAge() {
		return age;
	}

	public List<Team> getTeamList() {
		return teamList;
	}

	public void setTeamList(List<Team> teamList) {
		this.teamList = teamList;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Player [playerID=" + playerID + ", playerName=" + playerName + ", teamList=" + teamList + ", age=" + age
				+ "]";
	}

	public Player(String playerName, List<Team> teamList, int age) {
		super();
		this.playerName = playerName;
		this.teamList = teamList;
		this.age = age;
	}

	public Player() {
		super();
	}

	/*
	 * @Override public String toString() { return "Player [playerID=" + playerID +
	 * ", playerName=" + playerName + ", teamName=" + team + ", age=" + age + "]"; }
	 */

	/*
	 * public Player(String playerName, Team team, int age) { super();
	 * this.playerName = playerName; this.team = team; this.age = age; }
	 */
	
	





	
	
	
	
	
	
	

}
