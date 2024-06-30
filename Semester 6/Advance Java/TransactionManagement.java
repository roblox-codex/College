import java.sql.*;

public class TransactionManagement {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/transmang";
    private static final String DB_USERNAME = "roblox";
    private static final String DB_PASSWORD = "xyrrox";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            conn.setAutoCommit(false); // Start a new transaction

            // Function to print all balances
            printBalances(conn);

            // Prepare SQL to get balances
            PreparedStatement balanceStmt = conn.prepareStatement("SELECT balance FROM Account WHERE name = ?");

            // Check Digvijay's balance
            balanceStmt.setString(1, "Digvijay");
            ResultSet rs = balanceStmt.executeQuery();
            if (!rs.next() || rs.getInt("balance") < 1000) {
                throw new RuntimeException("Digvijay doesn't have enough balance!");
            }

            // Prepare SQL to update balances
            PreparedStatement updateStmt = conn.prepareStatement("UPDATE Account SET balance = balance + ? WHERE name = ?");

            // Deduct 1000 from Digvijay
            updateStmt.setInt(1, -1000);
            updateStmt.setString(2, "Digvijay");
            updateStmt.executeUpdate();

            // Credit 1000 to DIG_VIJAY
            updateStmt.setInt(1, 1000);
            updateStmt.setString(2, "DIG_VIJAY");
            updateStmt.executeUpdate();

            conn.commit(); // If no error, commit the transaction

            // print balances after updates
            printBalances(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printBalances(Connection conn) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT name, balance FROM Account");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.println("Account name: " + rs.getString("name") + ", Balance: " + rs.getInt("balance"));
        }
    }
}
