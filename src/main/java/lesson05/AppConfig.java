package lesson05;

import lesson05.entities.BaseballGame;
import lesson05.entities.Game;
import lesson05.entities.RedSox;
import lesson05.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.Set;

@Configuration
@ComponentScan
public class AppConfig {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private List<Team> teams;

	@Bean
	@Scope("prototype")
	public Game game() {
		BaseballGame baseballGame = new BaseballGame(readSox(), teams.get(1));
		baseballGame.setDataSource(dataSource);
		return  baseballGame;
	}

	@Bean
	public Team readSox() {
		return new RedSox();
	}



}

