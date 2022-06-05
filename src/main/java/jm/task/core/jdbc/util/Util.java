package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static Connection connection = null;

    static
    {
        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        final String HOST = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=Europe/Moscow";
        final String LOGIN = "root1";
        final String PASSWORD = "qwerty1234!";
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(HOST, LOGIN, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}
