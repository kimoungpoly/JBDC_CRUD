
package view;
import controller.UserController;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserView {
    private static final UserController userController = new UserController();
    private static   final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            try {
                System.out.println("==".repeat(10));
                System.out.println("1. Create user");
                System.out.println("2. View all users");
                System.out.println("3. Update user");
                System.out.println("4. Delete user");
                System.out.println("5. Exit");
                System.out.println("==".repeat(10));
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        userController.createUser();
                        break;
                    case 2:
                        userController.viewAllUsers();
                        break;
                    case 3:
                        userController.updateUser();
                        break;
                    case 4:
                        userController.deleteUser();
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

}
