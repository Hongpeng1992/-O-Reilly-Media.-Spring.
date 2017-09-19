package lesson01;

import lesson01.AppConfig;
import lesson01.entities.Game;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunDemo {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		Game game = context.getBean("game", Game.class);
		System.out.println(game.playGame());

	}
}
