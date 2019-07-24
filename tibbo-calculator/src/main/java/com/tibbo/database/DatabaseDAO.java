package com.tibbo.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseDAO
{

  public static void conection() throws ClassNotFoundException, SQLException {
    Class.forName("org.postgresql.Driver");
    Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:6789/server_calculator","my_postgres", "root");
    connection.close();
  }

  private static Session session = null;

  static
  {
    SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .buildSessionFactory();

    session = sessionFactory.openSession();
  }

  public static Session getSession()
  {
    return session;
  }
  
  public static void registerUser(String username, String password)
  {
    //Выполнить Insert в базу данных
/*
    try{
      String url = "jdbc:mysql://localhost/store?serverTimezone=Europe/Moscow&useSSL=false";
      String username = "root";
      String password = "password";
      Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

      try (Connection conn = DriverManager.getConnection(url, username, password)){

        Statement statement = conn.createStatement();
        int rows = statement.executeUpdate("INSERT Products(ProductName, Price) VALUES ('iPhone X', 76000)," +
                "('Galaxy S9', 45000), ('Nokia 9', 36000)");
        System.out.printf("Added %d rows", rows);
      }
    }
    catch(Exception ex){
      System.out.println("Connection failed...");

      System.out.println(ex);
    } */

  }
  
  public static boolean checkUserExist(String username, String password)
  {
    //Выполнить SELECT в базу данных
    //если то, что вернулось не пусто, то true в другом случае false;
    return true;
  }
}


//создать поток -  передаем сокет / зациклить /