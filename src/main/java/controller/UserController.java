
package controller;

import model.User;
import model.UserServiceImp;
import repository.DBUtil;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserController {
    private static final Scanner scanner = new Scanner(System.in);
    private  static final UserServiceImp userServiceImp = new UserServiceImp();
    private Connection connection;
    public UserController() {
        connection = DBUtil.getConnection();
    }


    public void createUser() {
        try {
            System.out.println("==");
            System.out.print("Enter user UUID: ");
            String uuid = scanner.nextLine();
            System.out.print("Enter user name: ");
            String name = scanner.nextLine();
            System.out.print("Enter user email: ");
            String email = scanner.nextLine();
            System.out.print("Enter user password: ");
            String password = scanner.nextLine();
            User user = new User(0, uuid, name, email, password, false, false);
            userServiceImp.createUser(user);
            System.out.println("User created successfully.");
            System.out.println("==");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format for user ID.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid value.");
        }
    }

    public  void viewAllUsers() {
        List<User> users = new ArrayList<>();
        userServiceImp.getAllUsers(users);
        System.out.println("==");
        for (User user : users) {
            System.out.println(user.getUserId() + ": " + user.getUserName() + " - " + user.getUserEmail());
        }
        System.out.println("==");
    }
    public void updateUser() {
        List<User> users = new ArrayList<>();
        try {
            System.out.print("Enter user ID to update: ");
            int userId = scanner.nextInt();
            scanner.nextLine();
            User existingUser = userServiceImp.getUserById(users , userId);
            if (existingUser == null) {
                System.out.println("User not found with ID " + userId);
                return;
            }
            System.out.println("==");
            System.out.print("Enter new user UUID: ");
            String uuid = scanner.nextLine();
            System.out.print("Enter new user name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new user email: ");
            String email = scanner.nextLine();
            System.out.print("Enter new user password: ");
            String password = scanner.nextLine();
            User updatedUser = new User(userId, uuid, name, email, password, existingUser.isDeleted(), existingUser.isVerified());
            userServiceImp.updateUser(updatedUser);
            System.out.println("User updated successfully.");
            System.out.println("==");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format for user ID.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid value.");
        }
    }

    public  void deleteUser() {
        List<User> users = new ArrayList<>();
        try {
            System.out.println("==");
            System.out.print("Enter user ID to delete: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer ID.");
                scanner.nextLine();
                return;
            }
            int userId = scanner.nextInt();
            scanner.nextLine();

            if (userServiceImp.getUserById(users, userId) == null) {
                System.out.println("User with ID " + userId + " not found.");
                return;
            }
            userServiceImp.deleteUser(userId);
            System.out.println("User deleted successfully.");
            System.out.println("==");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer ID.");
            scanner.nextLine();
        }
    }


}
