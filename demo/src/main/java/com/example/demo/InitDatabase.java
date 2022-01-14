package com.example.demo;

import org.postgresql.util.PSQLException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class InitDatabase {

    public static void getInitialized() throws SQLException {

        try {


            Connection conn_wine = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5433/wine_lots",
                    "postgres",
                    "Dave060480");
            Statement stm = conn_wine.createStatement();

            String sql = "CREATE TABLE wine_component " +
                    "(id SERIAL PRIMARY KEY, lotcode text, percentage int, region text, variety text, year text)";
            stm.executeUpdate(sql);

            sql = "CREATE TABLE wine_lot_codes " +
                    "(id SERIAL PRIMARY KEY, volume real, lot_code text UNIQUE, description text, tank_code text, product_state text, owner_name text)";
            stm.executeUpdate(sql);


            File path = new File("./init data");
            File[] files = path.listFiles();

            HttpClient httpClient = HttpClient.newHttpClient();
            String url = "http://localhost:8080/api/post";



            for(File file:files){

                String content = Files.readString(file.toPath());
                System.out.println(content);

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .POST(HttpRequest.BodyPublishers.ofString(content))
                        .header("Content-Type", "application/json")
                        .build();

                HttpResponse<String> response = httpClient.send(request,HttpResponse.BodyHandlers.ofString());
                System.out.println(response);

            }




        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e){
            System.out.println("already initialized before");
        }

    }
}

