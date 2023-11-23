package com.example.postdatabase;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Log
@SpringBootApplication
public class PostdatabaseApplication {
	private final DataSource dataSource;

	public PostdatabaseApplication(final DataSource dataSource){
		this.dataSource = dataSource;
	}



	public static void main(String[] args) {
		SpringApplication.run(PostdatabaseApplication.class, args);
	}


	public void run(final String... args){
		log.info("Data source: "+ dataSource.toString());
		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		restTemplate.execute("select-1");
	}



}
