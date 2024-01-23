package src;
import java.util.Scanner;

public class ConsoleUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Inventory System!");

        FinanceManager financeManager = new FinanceManager();

        int choice;

        do {
            System.out.println("1. Add Item");
            System.out.println("2. Generate Inventory Report");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addItem(financeManager, scanner);
                    break;
                case 2:
                    generateInventoryReport(financeManager);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 3);

        scanner.close();
    }

    private static void addItem(FinanceManager financeManager, Scanner scanner) {
        System.out.print("Enter item name: ");
        String itemName = scanner.next();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
    
        Item newItem = new Item();
        newItem.setItemName(itemName);
        newItem.setQuantity(quantity);  // Corrected method name
    
        financeManager.addItem(newItem);
    }

    private static void generateInventoryReport(FinanceManager financeManager) {
        financeManager.generateInventoryReport();
    }
}