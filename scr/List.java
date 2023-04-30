import java.util.ArrayList;

public class List{
    public class Product {
        private String name;
        private String description;
        private String category;
        private double price;
    
        public Product(String name, String description, String category, double price) {
            this.name = name;
            this.description = description;
            this.category = category;
            this.price = price;
        }
    
        public String getName() {
            return name;
        }
    
        public String getDescription() {
            return description;
        }
    
        public String getCategory() {
            return category;
        }
    
        public double getPrice() {
            return price;
        }
    }
    
    public class ProductListing {
        private ArrayList<Product> products;
    
        public ProductListing() {
            this.products = new ArrayList<>();
        }
    
        public void addProduct(Product product) {
            products.add(product);
        }
    
        public void removeProduct(Product product) {
            products.remove(product);
        }
    
        public ArrayList<Product> searchProductsByCategory(String category) {
            ArrayList<Product> searchResults = new ArrayList<>();
            for (Product product : products) {
                if (product.getCategory().equals(category)) {
                    searchResults.add(product);
                }
            }
            return searchResults;
        }
    
        public ArrayList<Product> searchProductsByPriceRange(double minPrice, double maxPrice) {
            ArrayList<Product> searchResults = new ArrayList<>();
            for (Product product : products) {
                if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                    searchResults.add(product);
                }
            }
            return searchResults;
        }
    }
    
}
