
package repository;

import model.User;

import java.sql.Connection;
import java.util.List;

public class UserRepository {
    private Connection connection;
    public UserRepository() {
        connection = DBUtil.getConnection();
    }

}
