package com.cs.atk.webmvctutorial.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataBaseConfig {
	
//	@Bean(name = "dbUserService")
//	@ConfigurationProperties(prefix = "spring.datasource")
//	@Primary
//	public DataSource createProductServiceDataSource() {
//		return DataSourceBuilder.create().build();
//	}
//	
//	@Bean(name = "jdbcUserService")
//	@Autowired
//	public JdbcTemplate JdbcTempleteMysql(@Qualifier("dbUserService") DataSource userServiceDS) {
//		return new JdbcTemplate(userServiceDS);
//	}

}
