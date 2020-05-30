package com.project4.utils;

import java.sql.*;

/**
 *
 * @author Austin Helmholz
 */
public class Database {

    public static final String URL = "jdbc:mysql://localhost:3306/proj2database";
    // public static final String URL =
    // "jdbc:mysql://localhost:3306/proj2database?useSSL=false&serverTimezone=UTC";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    // public static final String PASSWORD = "password";

    public Connection conn;

    public Database() {
        conn = null;
    }

    public void openConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(Database.URL, Database.USERNAME, Database.PASSWORD);
    }

    public void closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
            conn = null;
        }
    }

    public ResultSet executQuery(String query) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(query);
        return statement.executeQuery();
    }

}