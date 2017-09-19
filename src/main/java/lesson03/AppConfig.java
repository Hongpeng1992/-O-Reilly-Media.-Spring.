package lesson03;

import lesson03.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "lesson03")
public class AppConfig {

	@Autowired
	private DataSource dataSource;

	@Resource
	private Team redSox;

	@Resource
	private Team cubs;

	@Bean
	public Game game() {
		BaseballGame baseballGame = new BaseballGame(redSox, cubs);
		baseballGame.setDataSource(dataSource);
		return  baseballGame;
	}



}

