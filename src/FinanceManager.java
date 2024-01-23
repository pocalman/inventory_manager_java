package src;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FinanceManager {
    public void addItem(Item item) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO items (name, quantity) VALUES (?, ?)")) {

            preparedStatement.setString(1, item.getItemName());
            preparedStatement.setInt(2, item.getQuantity());
            preparedStatement.executeUpdate();

            System.out.println("Item added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to add item.");
        }
    }

    public void generateInventoryReport() {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM items");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            System.out.println("Inventory Report:");
            while (resultSet.next()) {
                System.out.println("Item Name: " + resultSet.getString("name") + ", Quantity: " + resultSet.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to generate inventory report.");
        }
    }

    // Other methods as needed
}