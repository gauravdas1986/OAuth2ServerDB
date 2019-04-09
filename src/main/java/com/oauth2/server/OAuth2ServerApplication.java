package com.oauth2.server;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan

public class OAuth2ServerApplication {

//	@Autowired
//	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(OAuth2ServerApplication.class, args);
	}
	
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource mainDataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
//	@Autowired
//	public void init(AuthenticationManagerBuilder auth) throws Exception {
//			// @formatter:off
//		
//			auth.jdbcAuthentication().dataSource(dataSource);
//			//.withUser("dave").password("secret").roles("USER");
//			
//			// @formatter:on
//	}

}
