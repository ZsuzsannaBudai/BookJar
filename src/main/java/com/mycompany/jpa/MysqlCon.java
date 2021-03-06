package com.mycompany.jpa;

import java.sql.*;

public class MysqlCon {
    
    private static MysqlCon Instance = null;
    
    public Connection mysqlconnection = null;

    private Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://hosting2128384.online.pro:3306/00504526_bookjardatabase",
                    "00504526_bookjardatabase", "_9CHmpXxNgqMs8W");
            return con;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    private MysqlCon() {
        this.mysqlconnection = getConnection();
    }
    
    public static MysqlCon getInstance(){
        if(Instance == null){
            Instance = new MysqlCon();
        }
        return Instance;
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = this.mysqlconnection.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {

        }
        return null;
    }
    
    public void CloseConnection(){
        try{
            mysqlconnection.close();
            System.out.println("Database connection close()");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void executeUpdate(String insert) {
        try {
            Statement stmt = this.mysqlconnection.createStatement();
            stmt.execute(insert);
        } catch (SQLException e) {

        }
    }
    
    public void executeUpdate_Delete(String delete){
        try {
            Statement stmt = this.mysqlconnection.prepareStatement(delete);
            stmt.execute(delete);
        } catch (SQLException e) {

        }
    }
}
