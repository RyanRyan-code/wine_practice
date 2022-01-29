package com.example.demo;

import org.mockito.Mock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.util.List;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class WineBreakdownApiApplication {

	public static void main(String[] args) {


		Flyway flyway = Flyway
				.configure()
				.dataSource("jdbc:postgresql://localhost:5433/postgres", "postgres", "Dave060480")
				.mixed(true)
				.load();

		flyway.migrate();





		SpringApplication.run(WineBreakdownApiApplication.class, args);

		//InitDatabase.getInitialized();

		System.out.println("\nOn!\n");



	}
}
