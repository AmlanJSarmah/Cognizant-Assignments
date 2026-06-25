package DSA;

import java.util.HashMap;
import java.util.Map;

class Product{
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    Product(int productId, String productName, int quantity, double price){
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void setProductName(String productName) { this.productName = productName; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }

    public String toString(){
        return "Product{id=" + productId + ", name='" + productName + "', qty=" + quantity + ", price=" + price + "}";
    }
}

class Inventory{
    private Map<Integer, Product> products;

    Inventory(){
        products = new HashMap<>();
    }

    public void addProduct(Product p){
        if(products.containsKey(p.getProductId())){
            System.out.println("Product with ID " + p.getProductId() + " already exists.");
            return;
        }
        products.put(p.getProductId(), p);
        System.out.println("Added: " + p);
    }

    public void updateProduct(int productId, String name, int qty, double price){
        Product p = products.get(productId);
        if(p == null){
            System.out.println("Product not found.");
            return;
        }
        p.setProductName(name);
        p.setQuantity(qty);
        p.setPrice(price);
        System.out.println("Updated: " + p);
    }

    public void deleteProduct(int productId){
        Product removed = products.remove(productId);
        if(removed == null){
            System.out.println("Product not found.");
            return;
        }
        System.out.println("Deleted: " + removed);
    }

    public void displayAll(){
        if(products.isEmpty()){
            System.out.println("Inventory is empty.");
            return;
        }
        for(Product p : products.values()){
            System.out.println(p);
        }
    }
}

public class Exercise1 {
    public static void main(String[] args){
        Inventory inv = new Inventory();

        inv.addProduct(new Product(101, "Laptop", 10, 75000));
        inv.addProduct(new Product(102, "Mouse", 50, 500));
        inv.addProduct(new Product(103, "Keyboard", 30, 1200));

        inv.displayAll();

        inv.updateProduct(102, "Wireless Mouse", 60, 650);
        inv.deleteProduct(103);

        System.out.println("\nAfter updates:");
        inv.displayAll();
    }
}
