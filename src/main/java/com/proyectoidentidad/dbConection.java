package com.proyectoidentidad;

import java.sql.*;

public class dbConection {
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "admin";
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

    public int ejecutarSenctenciaSQL(String strSentenciaSQL){
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }

    public ResultSet consultarRegistros(String strSentenciaSQL){
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();

            return respuesta;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

}
