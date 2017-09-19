package lesson09.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class infrastructureConfig {
	@Bean
	public DataSource dataSource() {
		return new DriverManagerDataSource();
	}
}
