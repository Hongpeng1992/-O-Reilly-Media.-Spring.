package lesson02.entities;

public interface Game {
	void setHomeTeam(Team team);
	Team getHomeTeam();
	void setAwayTeam(Team team);
	Team getAwayTeam();
	String playGame();
}
