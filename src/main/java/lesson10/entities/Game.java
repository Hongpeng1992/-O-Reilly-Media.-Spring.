package lesson10.entities;

public interface Game {
	void setHomeTeam(Team team);

	Team getHomeTeam();

	void setAwayTeam(Team team);

	Team getAwayTeam();

	String playGame();

	void startGame();

	void endGame();
}
