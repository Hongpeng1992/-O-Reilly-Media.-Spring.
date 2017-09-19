package lesson07;

import lesson07.entities.BaseballGame;
import lesson07.entities.Game;
import lesson07.entities.RedSox;
import lesson07.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.text.NumberFormat;
import java.util.List;

@Configuration
@ComponentScan
public class AppConfig {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private List<Team> teams;

	@Bean
	public NumberFormat numberFormat() {
		return NumberFormat.getCurrencyInstance();
	}

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

