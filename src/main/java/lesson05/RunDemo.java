package lesson05;

import lesson05.entities.Game;
import lesson05.entities.Team;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunDemo {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		Team royals = context.getBean("royals", Team.class);

		Game game1 = context.getBean("game", Game.class);
		System.out.println(game1);

		Game game2 = context.getBean("game", Game.class);

		game2.setAwayTeam(royals);
		System.out.println(game2);

		System.out.println(game1);

//		System.out.println("There are " + context.getBeanDefinitionCount() + " beans");
//
//		for (String name : context.getBeanDefinitionNames()) {
//			System.out.println(name);
//		}

	}
}
