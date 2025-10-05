public class Expense {
    private int id;
    private double amount;
    private String date;
    private String note;
    private String category;

    // Constructor for adding
    public Expense(double amount, String date, String note, String category) {
        this.amount = amount;
        this.date = date;
        this.note = note;
        this.category = category;
    }

    // Constructor for updating
    public Expense(int id, double amount, String date, String note, String category) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.note = note;
        this.category = category;
    }

    public int getId() { return id; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }
    public String getNote() { return note; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return id + " | " + amount + " | " + date + " | " + note + " | " + category;
    }
}
