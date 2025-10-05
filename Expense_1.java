import java.sql.*;

public class Expense_1 {

    // Add expense
    public void addExpense(Expense expense) {
        String sql = "INSERT INTO expenses(amount, date, note, category) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, expense.getAmount());
            ps.setString(2, expense.getDate());
            ps.setString(3, expense.getNote());
            ps.setString(4, expense.getCategory());
            ps.executeUpdate();
            System.out.println("Expense added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View all expenses
    public void viewExpenses() {
        String sql = "SELECT * FROM expenses";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            System.out.println("ID | Amount | Date | Note | Category");
            System.out.println("----------------------------------------");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getDouble("amount") + " | " +
                                   rs.getString("date") + " | " + rs.getString("note") + " | " +
                                   rs.getString("category"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update expense
    public void updateExpense(Expense expense) {
        String sql = "UPDATE expenses SET amount=?, date=?, note=?, category=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, expense.getAmount());
            ps.setString(2, expense.getDate());
            ps.setString(3, expense.getNote());
            ps.setString(4, expense.getCategory());
            ps.setInt(5, expense.getId());
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Expense updated successfully.");
            else
                System.out.println("No record found with that ID.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete expense
    public void deleteExpense(int id) {
        String sql = "DELETE FROM expenses WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Expense deleted successfully.");
            else
                System.out.println("No record found with that ID.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Filter by category
    public void filterByCategory(String category) {
        String sql = "SELECT * FROM expenses WHERE category=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();
            System.out.println("Expenses for category: " + category);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getDouble("amount") + " | " +
                                   rs.getString("date") + " | " + rs.getString("note"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Summary report (total spent per category)
    public void showSummary() {
        String sql = "SELECT category, SUM(amount) AS total FROM expenses GROUP BY category";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            System.out.println("\nCategory | Total Spent");
            System.out.println("----------------------");
            while (rs.next()) {
                System.out.println(rs.getString("category") + " | " + rs.getDouble("total"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
