## Personal Expense Tracker (Java + JDBC)
### Overview
The Personal Expense Tracker is a simple Java-based console application that helps users manage their day-to-day expenses.
It allows users to add, view, update, and delete expense records stored in a database.

### Features
- Add new expense (amount, date, note)
- View all expenses
- Update an existing expense
- Delete an expense
- Save data to MySQL database
- Input validation and error handling
- Add categories (Food, Travel, Bills, etc.)
- Filter expenses by category
- View summary reports

### Tech Stack
- Language: Java 17+
- Database: MySQL
- Connector: JDBC (MySQL Connector/J)
- IDE: VS Code

### Setup & Run

**step 1**: Clone the Repository
- git clone https://github.com/Rasi-ga12/Expense_Tracker.git
cd Expense_Tracker

**step 2**: Create Database in MySQL
- CREATE DATABASE <database_name>;
- USE <database_name>;
- CREATE TABLE expenses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    amount DOUBLE NOT NULL,
    date DATE NOT NULL,
    note VARCHAR(255),
    category VARCHAR(100));

**step 3**: Add MySQL Connector
- Download MySQL JDBC Driver:
  https://dev.mysql.com/downloads/connector/j/
- Add it to your Java classpath.

**step 4**: Update Database Credentials
- In your Java code (DBConnection.java):
  private static final String URL = "jdbc:mysql://localhost:<mysql_port_number>/<database_name>";
  private static final String USER = "<username>";
  private static final String PASSWORD = "<your_password>";

**step 5**: Compile and Run the Project
 - javac *.java
 - java ExpenseTracker.java

### Sample Output

=== Personal Expense Tracker ===
1. Add Expense
2. View Expenses
3. Update Expense
4. Delete Expense
5. Filter by Category
6. Show Summary Report
0. Exit
-Enter choice: 1

-Amount: 500
-Date: 2025-10-05
-Note: Lunch with friends
-Category: Food
Expense added successfully.


