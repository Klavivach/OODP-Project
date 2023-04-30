import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchFunctionality{
    private String name;
    private String category;
    private double price;

    public SearchFunctionality(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static void main(String[] args) {
        List<SearchFunctionality> itemList = new ArrayList<>();
        itemList.add(new SearchFunctionality("Call of Duty", "Shooter", 50.0));
        itemList.add(new SearchFunctionality("World of Warcraft", "MMORPG", 30.0));
        itemList.add(new SearchFunctionality("FIFA 22", "Sports", 60.0));
        itemList.add(new SearchFunctionality("Minecraft", "Sandbox", 20.0));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the online market for gaming items!");

        while (true) {
            System.out.println("What would you like to search for?");
            System.out.println("1. By name");
            System.out.println("2. By category");
            System.out.println("3. By price");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            if (choice == 4) {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter name to search for: ");
                    String name = scanner.next();
                    searchByName(itemList, name);
                    break;
                case 2:
                    System.out.print("Enter category to search for: ");
                    String category = scanner.next();
                    searchByCategory(itemList, category);
                    break;
                case 3:
                    System.out.print("Enter price to search for: ");
                    double price = scanner.nextDouble();
                    searchByPrice(itemList, price);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void searchByName(List<SearchFunctionality> itemList, String name) {
        List<SearchFunctionality> result = new ArrayList<>();
        for (SearchFunctionality item : itemList) {
            if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(item);
            }
        }
        printItems(result);
    }

    private static void searchByCategory(List<SearchFunctionality> itemList, String category) {
        List<SearchFunctionality> result = new ArrayList<>();
        for (SearchFunctionality item : itemList) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                result.add(item);
            }
        }
        printItems(result);
    }

    private static void searchByPrice(List<SearchFunctionality> itemList, double price) {
        List<SearchFunctionality> result = new ArrayList<>();
        for (SearchFunctionality item : itemList) {
            if (item.getPrice() <= price) {
                result.add(item);
            }
        }
        printItems(result);
    }

    private static void printItems(List<SearchFunctionality> itemList) {
        if (itemList.size() == 0) {
            System.out.println("No items found.");
            return;
        }
        System.out.println("Items found:");
        for (SearchFunctionality item : itemList) {
            System.out.println("Name: " + item.getName() + " ");
        }
    }
}