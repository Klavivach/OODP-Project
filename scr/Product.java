public class Product {
    private String name;
    private String description;
    private String category;
    private double price;
    private String Id;
    



    public Product(String Id, String name, String description, String category, double price) {
        this.Id = Id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }

 

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    // getters and setters
}
