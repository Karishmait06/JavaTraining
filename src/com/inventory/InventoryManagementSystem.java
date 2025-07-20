/*
Design a Java console application to manage inventory in a small store.
The system should allow the admin to:
Add new items (with unique ID, name, price, quantity)
Update stock quantity (increase/decrease)
View individual item details
View all items in inventory
Search item by name
Exit system
 */

package com.inventory;

import java.time.LocalDate;
import java.util.*;


class InvalidStockOperationException extends RuntimeException {
    public InvalidStockOperationException(String msg) {
        super(msg);
    }
}

class InvalidCategoryException extends RuntimeException {
    public InvalidCategoryException(String msg) {
        super(msg);
    }
}

class InvalidItemDataException extends RuntimeException {
    public InvalidItemDataException(String msg) {
        super(msg);
    }
}

 interface Stockable {
    void addStock(int qty);
    void removeStock(int qty);
}

 abstract class Item implements Stockable {
    private final long id;
    private final String category;  // Electronics, Grocery, Clothing, etc.
    protected String name;
    protected double price;
    protected int quantity;

    protected Item(long id, String category, String name, double price, int quantity) {
        if (price < 0) throw new InvalidItemDataException("Price cannot be negative");
        if (quantity < 0) throw new InvalidItemDataException("Quantity cannot be negative");
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public long getId()           { return id; }
    public String getCategory()   { return category; }
    public int getQuantity()      { return quantity; }

    @Override
    public void addStock(int qty) {
        if (qty <= 0) throw new InvalidStockOperationException("Quantity to add must be positive");
        this.quantity += qty;
    }

    @Override
    public void removeStock(int qty) {
        if (qty <= 0) throw new InvalidStockOperationException("Quantity to remove must be positive");
        if (qty > this.quantity) throw new InvalidStockOperationException("Not enough stock to remove");
        this.quantity -= qty;
    }

    @Override
    public String toString() {
        return String.format("ID:%d | %s | Cat:%s | Price:₹%.2f | Qty:%d",
                id, name, category, price, quantity);
    }
}

// ---------- Category‑specific subclasses ----------
class Electronics extends Item {
    private int warrantyMonths;
    public Electronics(long id, String name, double price, int qty, int warrantyMonths) {
        super(id, "Electronics", name, price, qty);
        if (warrantyMonths < 0) throw new InvalidItemDataException("Warranty cannot be negative");
        this.warrantyMonths = warrantyMonths;
    }

    @Override public String toString() {
        return super.toString() + " | Warranty:" + warrantyMonths + "m";
    }
}

class Grocery extends Item {
    private LocalDate expiry;
    public Grocery(long id, String name, double price, int qty, LocalDate expiry) {
        super(id, "Grocery", name, price, qty);
        if (expiry.isBefore(LocalDate.now())) throw new InvalidItemDataException("Expiry date cannot be in the past");
        this.expiry = expiry;
    }

    @Override public String toString() {
        return super.toString() + " | Exp:" + expiry;
    }
}

class Clothing extends Item {
    private String size;
    public Clothing(long id, String name, double price, int qty, String size) {
        super(id, "Clothing", name, price, qty);
        if (!List.of("S", "M", "L", "XL").contains(size.toUpperCase()))
            throw new InvalidItemDataException("Invalid size. Must be S, M, L, or XL");
        this.size = size.toUpperCase();
    }

    @Override public String toString() {
        return super.toString() + " | Size:" + size;
    }
}

 class InventoryManager {
    private final Map<Long, Item> items = new HashMap<>();
    private long nextId = 1001;

    public void addNewItem(String category, String name, double price, int qty, Scanner sc) {
        Item item;
        try {
            switch (category.toLowerCase()) {
                case "electronics" -> {
                    System.out.print("Enter warranty in months: ");
                    int w = Integer.parseInt(sc.nextLine());
                    item = new Electronics(nextId, name, price, qty, w);
                }
                case "grocery" -> {
                    System.out.print("Enter expiry date (YYYY-MM-DD): ");
                    LocalDate exp = LocalDate.parse(sc.nextLine());
                    item = new Grocery(nextId, name, price, qty, exp);
                }
                case "clothing" -> {
                    System.out.print("Enter size (S/M/L/XL): ");
                    String size = sc.nextLine();
                    item = new Clothing(nextId, name, price, qty, size);
                }
                default -> throw new InvalidCategoryException("Unknown category: " + category);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
        items.put(nextId, item);
        System.out.println("Added → " + item);
        nextId++;
    }

    public void addStock(long id, int qty) {
        try {
            Item i = items.get(id);
            if (i != null) {
                i.addStock(qty);
                System.out.println("Stock updated.");
            } else {
                System.out.println("Item not found.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void removeStock(long id, int qty) {
        try {
            Item i = items.get(id);
            if (i != null) {
                i.removeStock(qty);
                System.out.println("Stock reduced.");
            } else {
                System.out.println("Item not found.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewItem(long id) {
        Item i = items.get(id);
        System.out.println(i != null ? i : "Item not found");
    }

    public void searchByName(String n) {
        items.values().stream()
                .filter(i -> i.name.equalsIgnoreCase(n))
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("No match."));
    }

    public void list() {
        if (items.isEmpty()) System.out.println("Inventory empty");
        else items.values().forEach(System.out::println);
    }
}

// ---------- CLI ----------
public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryManager mgr = new InventoryManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menu ===\n1 Add Item 2 AddStock 3 RemStock 4 ViewID 5 List 6 Search 7 Exit");
            int c;
            try {
                c = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid input.");
                continue;
            }
            try {
                switch (c) {
                    case 1 -> {
                        System.out.print("Category (Electronics/Grocery/Clothing): ");
                        String cat = sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Price: ");
                        double price = Double.parseDouble(sc.nextLine());
                        System.out.print("Qty: ");
                        int qty = Integer.parseInt(sc.nextLine());
                        mgr.addNewItem(cat, name, price, qty, sc);
                    }
                    case 2 -> {
                        System.out.print("ID: ");
                        long id = Long.parseLong(sc.nextLine());
                        System.out.print("Qty add: ");
                        int q = Integer.parseInt(sc.nextLine());
                        mgr.addStock(id, q);
                    }
                    case 3 -> {
                        System.out.print("ID: ");
                        long id = Long.parseLong(sc.nextLine());
                        System.out.print("Qty remove: ");
                        int q = Integer.parseInt(sc.nextLine());
                        mgr.removeStock(id, q);
                    }
                    case 4 -> {
                        System.out.print("ID: ");
                        long id = Long.parseLong(sc.nextLine());
                        mgr.viewItem(id);
                    }
                    case 5 -> mgr.list();
                    case 6 -> {
                        System.out.print("Name: ");
                        String n = sc.nextLine();
                        mgr.searchByName(n);
                    }
                    case 7 -> {
                        System.out.println("Bye");
                        return;
                    }
                    default -> System.out.println("Choose 1-7");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

