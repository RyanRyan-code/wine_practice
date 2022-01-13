package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.sql.SQLException;

@SpringBootApplication

public class WineBreakdownApiApplication {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {



		SpringApplication.run(WineBreakdownApiApplication.class, args);

		InitDatabase.getInitialized();

		System.out.println("\nOn!\n");







	}

}
