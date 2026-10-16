
import java.util.canner;

class Product {
    int id;
    String name;
    int quantity;
    double price;

    Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    void display() {
        System.out.println("Product ID: " + id);
        System.out.println("Product Name: " + name);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: Rs. " + price);
        System.out.println("----------------------");
    }
}

public class WarehouseInventory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] products = new Product[100];
        int count = 0;
        int choice;

        do {
            System.out.println("\n=== WAREHOUSE INVENTORY SYSTEM ===");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Stock");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (count == products.length) {
                        System.out.println("Warehouse record is full!");
                        break;
                    }

                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();

                    boolean exists = false;
                    for (int i = 0; i < count; i++) {
                        if (products[i].id == id) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Product ID already exists!");
                        break;
                    }

                    sc.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    if (quantity < 0 || price < 0) {
                        System.out.println("Quantity and price cannot be negative!");
                        break;
                    }

                    products[count] =
                        new Product(id, name, quantity, price);
                    count++;

                    System.out.println("Product added successfully!");
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No product records found.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            products[i].display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Product ID: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (products[i].id == searchId) {
                            System.out.print(
                                "Enter new quantity: ");
                            int newQuantity = sc.nextInt();

                            if (newQuantity >= 0) {
                                products[i].quantity = newQuantity;
                                System.out.println(
                                    "Stock updated successfully!");
                            } else {
                                System.out.println(
                                    "Quantity cannot be negative!");
                            }

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Product not found!");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
