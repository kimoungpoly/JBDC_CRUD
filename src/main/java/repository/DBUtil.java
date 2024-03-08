package repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
    public static Connection connection;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        try {
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("src/main/resources/application.properties");
            props.load(fis);

            String url = props.getProperty("database_url");
            String username = props.getProperty("database_username");
            String password = props.getProperty("database_password");

            connection = DriverManager.getConnection(url, username, password);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
