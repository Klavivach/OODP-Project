import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.Other;


public class OnlineMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Product> products = new ArrayList<>();
        products.add(new Product("XYZ-123", "Razer Gaming Mouse", "High-quality gaming mouse with customizable RGB lighting","Gaming Mouse", 29.99));
        products.add(new Product("ABC-456", "Logitech G", "Mechanical gaming keyboard with programmable keys","Gaming Keyboard" ,79.99));
        products.add(new Product("DEF-789", "Hyper X", "Noise-cancelling gaming headset with 7.1 surround sound", "Gaming Headset",99.99));

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
                    System.out.println("Welcome back, " + user.getUsername() + "!");
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

    private static void browseProducts(List<Product> products, Scanner scanner, List<Order> orders, List<User> users) {
        while (true) {
            System.out.println("Products available:");
            for (Product product : products) {
                System.out.println(product.getId() + " - " + product.getName() + " - $" + product.getPrice());
                System.out.println(product.getDescription());
            }
            System.out.println("Please select an option:");
            System.out.println("1. Add a product to your cart");
            System.out.println("2. Go back to main menu");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Please enter the ID of the product you want to add to your cart:");
                String productId = scanner.next();
                Product selectedProduct = null;
                for (Product product : products) {
                    if (product.getId().equals(productId)) {
                        selectedProduct = product;
                        break;
                    }
                }
                if (selectedProduct == null) {
                    System.out.println("Invalid product ID.");
                } else {
                    System.out.println("Please enter the quantity:");
                    int quantity = scanner.nextInt();
                    Order order = new Order(selectedProduct, quantity, new Date(), users.get(0));
                    orders.add(order);
                    System.out.println("Product added to your cart.");
                }
            } else if (choice == 2) {
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
    

    private static void viewOrders(List<Order> orders, User user) {
        System.out.println("Your Orders:");
        int count = 0;
        for (Order order : orders) {
            if (order.getUser().equals(user)) {
                count++;
                System.out.println("Order #" + count);
                System.out.println("Date: " + order.getOrderDate());
                System.out.println("Product: " + order.getProduct().getName());
                System.out.println("Price: $" + order.getProduct().getPrice());
                System.out.println("-----------------------------");
            }
        }
        if (count == 0) {
            System.out.println("You have no orders.");
        }
    }
    

    public static User login(List<User> users, Scanner scanner) {
        if (users.isEmpty()) {
            System.out.println("No users found. Please create an account.");
            return null;
        }
        if (users == null || scanner == null) {
            // Handle null input parameters
            return null;
        }  
        
        System.out.println("Please enter your username:");
        String username = scanner.next();
        System.out.println("Please enter your password:");
        String password = scanner.next();
    
        for (User user : users) {
            if (user.getUsername() != null && user.getPassword() != null
                && user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
    
        System.out.println("Invalid username or password.");
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
        users.add(user);
        return user;
    }
}