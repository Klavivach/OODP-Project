import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OnlineMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Product> products = new ArrayList<>();
        products.add(new Product("XYZ-123", "Gaming Mouse", "High-quality gaming mouse with customizable RGB lighting", 29.99));
        products.add(new Product("ABC-456", "Gaming Keyboard", "Mechanical gaming keyboard with programmable keys", 79.99));
        products.add(new Product("DEF-789", "Gaming Headset", "Noise-cancelling gaming headset with 7.1 surround sound", 99.99));

        List<User> users = new ArrayList<>();
        users.add(new User("johndoe", "John", "Doe", "johndoe@example.com", "password123"));

        List<Order> orders = new ArrayList<>();

        while (true) {
            System.out.println("Welcome to the Online Market!");
            System.out.println("Please select an option:");
            System.out.println("1. Login");
            System.out.println("2. Create an account");
            System.out.println("3. Browse products");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            if (choice == 1) {
                User user = login(users, scanner);
                if (user == null) {
                    System.out.println("Invalid username or password.");
                } else {
                    System.out.println("Welcome back, " + user.getFirstName() + "!");
                    while (true) {
                        System.out.println("Please select an option:");
                        System.out.println("1. View orders");
                        System.out.println("2. Logout");

                        choice = scanner.nextInt();

                        if (choice == 1) {
                            viewOrders(orders, user);
                        } else if (choice == 2) {
                            break;
                        } else {
                            System.out.println("Invalid option. Please try again.");
                        }
                    }
                }
            } else if (choice == 2) {
                User user = createAccount(users, scanner);
                System.out.println("Account created successfully!");
                System.out.println("Please log in to continue.");
            } else if (choice == 3) {
                browseProducts(products, scanner, orders, users);
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static User login(List<User> users, Scanner scanner) {
        System.out.println("Please enter your username:");
        String username = scanner.next();
        System.out.println("Please enter your password:");
        String password = scanner.next();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public static User createAccount(List<User> users, Scanner scanner) {
        System.out.println("Please enter your first name:");
        String firstName = scanner.next();
        System.out.println("Please enter your last name:");
        String lastName = scanner.next();
        System.out.println("Please enter your email address:");
        String email = scanner.next();
        System.out.println("Please choose a username:");
        String username = scanner.next();
        System.out.println("Please choose a password:");
        String password = scanner.next();
        User user = new User(username, firstName, lastName, email, password);
        users.add
