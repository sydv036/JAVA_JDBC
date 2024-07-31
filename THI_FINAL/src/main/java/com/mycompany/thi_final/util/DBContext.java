package com.mycompany.thi_final.util;

import com.mycompany.thi_final.common.LogUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
    public static final String HOSTNAME = "localhost";
    public static final String PORT = "1433";
    public static final String DBNAME = "THI_FINAL_JAVA";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "songlong";


    public static Connection getConnection() {
        String connectionUrl = "jdbc:sqlserver://" + HOSTNAME + ":" + PORT + ";"
                + "databaseName=" + DBNAME + ";encrypt=true;trustServerCertificate=true;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(connectionUrl, USERNAME, PASSWORD);
            return connection;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
