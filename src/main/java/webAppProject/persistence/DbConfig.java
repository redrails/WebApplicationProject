package webAppProject.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
public class DbConfig {
	@Bean
	public DriverManagerDataSource dataSource() {		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		// jdbc:mysql://host:port/db
		ds.setUrl("jdbc:mysql://localhost:3306/webapp");
		ds.setUsername("root");
		ds.setPassword("");
	    	return ds;
	}
}


