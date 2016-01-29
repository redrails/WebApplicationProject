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
		
		ds.setUrl("jdbc:mysql://mysql.mcscw3.le.ac.uk:3306/mic7");
		ds.setUsername("mic7");
		ds.setPassword("shigiiho");
		return ds;
		/*
		ds.setUrl("jdbc:mysql://localhost:3306/webapp");
		ds.setUsername("root");
		ds.setPassword("localhost321");
	    return ds;*/
	}
}


