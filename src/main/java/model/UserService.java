package model;

import java.util.List;

public interface UserService{
    void createUser(User user);
    void  getAllUsers(List<User> users);
    void updateUser(User user);
    void deleteUser(int userId);
    User getUserById(List<User> users, int userId);

}
