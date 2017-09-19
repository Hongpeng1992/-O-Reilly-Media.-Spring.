package lesson10;

import lesson10.config.AppConfig;
import lesson10.entities.Game;
import lesson10.entities.Team;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunDemo {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		Game game = context.getBean("game", Game.class);
		Team royals = context.getBean("royals", Team.class);
		Team redSox = context.getBean("redSox", Team.class);
		Team cubs = context.getBean("cubs", Team.class);

		game.setHomeTeam(royals);
		game.setAwayTeam(cubs);
		game.playGame();

		game.setHomeTeam(cubs);
		game.setAwayTeam(redSox);
		game.playGame();

		context.close();

	}
}
