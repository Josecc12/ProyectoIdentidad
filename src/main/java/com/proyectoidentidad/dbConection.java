package com.proyectoidentidad;

import java.sql.*;

public class dbConection {
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "adrian12";
    private static final String url = "jdbc:mysql://localhost:3306/mydb";

    public dbConection(){
        conn =null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);
            if(conn !=null){
                System.out.println("Conexion Establecida...");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error en la conexion"+e);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return conn;
    }

    public void disconnect(){
        conn = null;
        if(conn ==null){
            System.out.println("Conexion Terminada...");
        }
    }

    public void print_test(){
        Statement statement;

        {
            try {
                statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from clientes");
                while(resultSet.next()){
                    System.out.println(resultSet.getString("Nombre"));
                    System.out.println(resultSet.getString("Direccion"));
                    System.out.println(resultSet.getString("Nit"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
