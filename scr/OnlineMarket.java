
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



public class OnlineMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Product> products = new ArrayList<>();
        products.add(new Product("XYZ-123", "Razer Gaming Mouse", "High-quality gaming mouse with customizable RGB lighting","Gaming Mouse", 29.99));
        products.add(new Product("ABC-456", "Logitech G", "Mechanical gaming keyboard with programmable keys","Gaming Keyboard" ,79.99));
        products.add(new Product("DEF-789", "Hyper X", "Noise-cancelling gaming headset with 7.1 surround sound", "Gaming Headset",99.99));

        List<User> users = readUsersFromFile();

        List<Order> orders = new ArrayList<>();

        while (true) {
            System.out.println("=======================================");
            System.out.println("|    Welcome to the Online Market!     |");
            System.out.println("=======================================");
            System.out.println("|                                      |");
            System.out.println("| 1. Login                             |");
            System.out.println("| 2. Create an account                 |");
            System.out.println("| 3. Exit                              |");
            System.out.println("|                                      |");
            System.out.println("=======================================");
            int choice = scanner.nextInt();

            if (choice == 1) {
                User user = login(users, scanner);
                if (user == null) {
                    System.out.println("Invalid username or password.");
                } else {
                    System.out.println("Welcome back, " + user.getUsername() + "!");
                    while (true) {
                        System.out.println("Please select an option:");
                        System.out.println("1. BrowseProducts");
                        System.out.println("2. View orders");
                        System.out.println("3. Logout");
                        choice = scanner.nextInt();

                        if (choice == 1) {
                            browseProducts(products, scanner, orders, user);
                        }
                        else if (choice == 2) {
                            viewOrders(orders, user);
                        } else if (choice == 3) {
                            break;
                        } else {
                            System.out.println("Invalid option. Please try again.");
                        }
                    }
                }
            } else if (choice == 2) {
                User user = createAccount(users, scanner);
                System.out.println("Account created successfully!");
                System.out.println();
                System.out.println("Please log in to continue.");
                System.out.println();
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void browseProducts(List<Product> products, Scanner scanner, List<Order> orders, User user) {
        while (true) {
            System.out.println("======================================Products available======================================");
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
                Product selectedProduct = getProductById(products, productId);
                if (selectedProduct == null) {
                    System.out.println("Invalid product ID.");
                } else {
                    System.out.println("Please enter the quantity:");
                    int quantity = getUserInput(scanner);
                    if (quantity <= 0) {
                        System.out.println("Invalid quantity. Please enter a positive integer.");
                        continue;
                    }
                    Order order = new Order(selectedProduct, quantity, new Date(), user);
                    orders.add(order);
                    System.out.println("Product added to your cart.");
                    System.out.println("=============================================================================================");
                }
            } else if (choice == 2) {
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    
    private static Product getProductById(List<Product> products, String productId) {
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        return null;
    }
    
    private static int getUserInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next();
        }
        return scanner.nextInt();
    }
    
    private static void viewOrders(List<Order> orders, User user) {
        if (orders == null) {
            System.out.println("Orders list is null.");
            return;
        }
        if (user == null) {
            System.out.println("User is null.");
            return;
        }
        System.out.println("Your Orders:");
        int count = 0;
        for (Order order : orders) {
            if (order != null && order.getUser() != null && order.getUser().equals(user)) {
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
        } else {
            System.out.println("Total orders: " + count);
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
    
        // Read the user data from the file
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 5 && userData[0].equals(username) && userData[4].equals(password)) {
                    return new User(userData[0], userData[1], userData[2], userData[3], userData[4]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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
    
        // Write the user data to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            writer.write(user.getUsername() + "," + user.getFirstName() + "," + user.getLastName() + "," + user.getEmail() + "," + user.getPassword());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return user;
    }
    private static List<User> readUsersFromFile() {
        List<User> users = new ArrayList<>();
        File file = new File("users.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",");
                String username = tokens[0];
                String password = tokens[1];
                String firstName = tokens[2];
                String lastName = tokens[3];
                String email = tokens[4];
                User user = new User(username, password, firstName, lastName, email);
                users.add(user);
            }
        } catch (FileNotFoundException e) {
            System.out.println("User file not found.");
        }
        return users;
    }
    
    
}