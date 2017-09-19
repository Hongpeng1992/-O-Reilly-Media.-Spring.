package lesson11.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "lesson11")
@PropertySource("classpath:prod.properties")
public class AppConfig {

	@Autowired
	private Environment environment;

	@Profile("test")
	@Bean(name = "dataSource", destroyMethod = "shutdown")
	public DataSource dataSourceForTest() {
		return new EmbeddedDatabaseBuilder()
				.generateUniqueName(true)
				.setType(EmbeddedDatabaseType.H2)
				.setScriptEncoding("UTF-8")
				.ignoreFailedDrops(true)
				.addScript("schema.sql")
				.addScripts("data.sql")
				.build();
	}

	@Profile("test")
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManagerForTest() {
		return new DataSourceTransactionManager(dataSourceForTest());
	}

	@Profile("prod")
	@Bean(name = "dataSource")
	public DataSource dataSourceForProd() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(environment.getProperty("db.driver"));
		dataSource.setUrl(environment.getProperty("db.url"));
		dataSource.setUsername(environment.getProperty("db.user"));
		dataSource.setPassword(environment.getProperty("db.pass"));
		return dataSource;
	}

	@Profile("prod")
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSourceForProd());
	}
}
