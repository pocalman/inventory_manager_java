package src;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {

            // Read the SQL script
            try (BufferedReader reader = new BufferedReader(new FileReader("path/to/create_database.sql"))) {
                StringBuilder script = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    script.append(line).append("\n");
                }

                // Execute the SQL script
                statement.executeUpdate(script.toString());
                System.out.println("Database initialized successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
