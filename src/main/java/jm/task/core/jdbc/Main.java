package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    private static final User user1 = new User("Name1", "LastName1", (byte) 20);
    private static final User user2 = new User("Name2", "LastName2", (byte) 15);
    private static final User user3 = new User("Name3", "LastName3", (byte) 37);
    private static final User user4 = new User("Name4", "LastName4", (byte) 76);
    public static void main(String[] args) throws SQLException {
        Connection connection = Util.getConnection();
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());

        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());

        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());

        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());

        userService.getAllUsers();
        System.out.println (userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();

        connection.close();
    }
}
