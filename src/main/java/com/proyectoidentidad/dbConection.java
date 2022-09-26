package com.proyectoidentidad;

import java.sql.*;

public class dbConection {
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "adrian12";
    private static final String url = "jdbc:mysql://localhost:3306/identidad";

    public dbConection(){
        conn =null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);

        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return conn;
    }


    public int ejecutarSenctenciaSQL(String strSentenciaSQL){
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
        } catch (SQLException e) {
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
            return null;
        }
    }

}
