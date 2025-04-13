import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (" + price + ")";
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 75000),
                new Product("Smartphone", "Electronics", 50000),
                new Product("Table", "Furniture", 10000),
                new Product("Chair", "Furniture", 5000));

        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));

        double avgPrice = products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);

        System.out.println("Most Expensive Product per Category:");
        mostExpensiveByCategory.forEach((category, product) -> System.out
                .println(category + ": " + product.get().getName() + " (" + product.get().getPrice() + ")"));

        System.out.println("\nAverage Price of All Products: " + avgPrice);
    }
}
