import java.util.ArrayList;
import java.util.Scanner;

class Itemc {
    int itemId;
    String itemName;
    int quantity;
    double price;

    Item(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    void display() {
        System.out.println("Item ID   : " + itemId);
        System.out.println("Item Name : " + itemName);
        System.out.println("Quantity  : " + quantity);
        System.out.println("Price     : " + price);
        System.out.println("------------------------");
    }
}

