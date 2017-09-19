package lesson04;

import lesson04.entities.BaseballGame;
import lesson04.entities.Game;
import lesson04.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "lesson03")
public class AppConfig {

//	@Autowired
//	private DataSource dataSource;
//
//	@Resource
//	private Team redSox;
//
//	@Resource
//	private Team cubs;
//
//	@Bean
//	public Game game() {
//		BaseballGame baseballGame = new BaseballGame(redSox, cubs);
//		baseballGame.setDataSource(dataSource);
//		return  baseballGame;
//	}



}

