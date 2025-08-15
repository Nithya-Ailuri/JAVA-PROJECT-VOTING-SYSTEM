import java.util.ArrayList;
import java.util.Scanner;

class Product {
    int id;
    String name;
    int quantity;
    double price;

    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Name: " + name +
               " | Quantity: " + quantity +
               " | Price: " + price;
    }
}

public class InventoryManagement {
    static ArrayList<Product> inventory = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Inventory Management System ===");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product Quantity");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewProducts();
                    break;
                case 3:
                    updateQuantity();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    public static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        inventory.add(new Product(id, name, quantity, price));
        System.out.println("Product added successfully!");
    }

    public static void viewProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            System.out.println("\n=== Product List ===");
            for (Product p : inventory) {
                System.out.println(p);
            }
        }
    }

    public static void updateQuantity() {
        System.out.print("Enter Product ID to update: ");
        int id = sc.nextInt();
        for (Product p : inventory) {
            if (p.id == id) {
                System.out.print("Enter new quantity: ");
                p.quantity = sc.nextInt();
                System.out.println("Quantity updated successfully!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    public static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = sc.nextInt();
        for (Product p : inventory) {
            if (p.id == id) {
                inventory.remove(p);
                System.out.println("Product deleted successfully!");
                return;
            }
        }
        System.out.println("Product not found!");
    }
}
