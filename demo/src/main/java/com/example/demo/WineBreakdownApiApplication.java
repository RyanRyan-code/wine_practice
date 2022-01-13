package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication

public class WineBreakdownApiApplication {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		//InitDatabase.getInitialized();

		SpringApplication.run(WineBreakdownApiApplication.class, args);

		System.out.println("\nOn!\n");







	}

}
