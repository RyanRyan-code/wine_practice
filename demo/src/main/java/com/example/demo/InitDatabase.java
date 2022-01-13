package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class InitDatabase {

    public static void getInitialized() throws SQLException {

        try{
            DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5433/wine_lots",
                    "postgres",
                    "Dave060480");
        }catch(SQLException e){

            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5433/postgres",
                    "postgres",
                    "Dave060480");
            Statement stm = conn.createStatement();

            String sql = "CREATE DATABASE wine_lots";
            stm.execute(sql);


            Connection conn_wine = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5433/wine_lots",
                    "postgres",
                    "Dave060480");
            stm = conn_wine.createStatement();

            sql = "CREATE TABLE wine_component " +
                    "(id SERIAL PRIMARY KEY, lotcode text, percentage int, region text, variety text, year text)";
            stm.executeUpdate(sql);

            sql = "CREATE TABLE wine_lot_codes " +
                    "(id SERIAL PRIMARY KEY, volume real, lot_code text UNIQUE, description text, tank_code text, product_state text, owner_name text)";
            stm.executeUpdate(sql);

            



        }








    }












}
