package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import org.flywaydb.core.Flyway;

@SpringBootApplication

public class WineBreakdownApiApplication {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {



		Flyway flyway = Flyway
				.configure()
				.dataSource("jdbc:postgresql://postgres:5432/wine_lots",
				"postgres",
				"Dave060480")
				.mixed(true)
				.load();

		flyway.migrate();







		SpringApplication.run(WineBreakdownApiApplication.class, args);

		//InitDatabase.getInitialized();



		System.out.println("\nOn!\n");







	}

}
