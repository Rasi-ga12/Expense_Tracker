import java.util.*;

public class ExpenseTracker{
    public static void main(String[] args) {
        Expense_1 manager = new Expense_1();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Personal Expense Tracker ===");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Update Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Filter by Category");
            System.out.println("6. Show Summary Report");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Date (YYYY-MM-DD): ");
                    String date = sc.nextLine();
                    System.out.print("Note: ");
                    String note = sc.nextLine();
                    System.out.print("Category: ");
                    String cat = sc.nextLine();
                    manager.addExpense(new Expense(amt, date, note, cat));
                    break;

                case 2:
                    manager.viewExpenses();
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Amount: ");
                    double newAmt = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("New Date: ");
                    String newDate = sc.nextLine();
                    System.out.print("New Note: ");
                    String newNote = sc.nextLine();
                    System.out.print("New Category: ");
                    String newCat = sc.nextLine();
                    manager.updateExpense(new Expense(id, newAmt, newDate, newNote, newCat));
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    manager.deleteExpense(delId);
                    break;

                case 5:
                    System.out.print("Enter category: ");
                    String filterCat = sc.nextLine();
                    manager.filterByCategory(filterCat);
                    break;

                case 6:
                    manager.showSummary();
                    break;

                case 0:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);
        sc.close();
    }
}
