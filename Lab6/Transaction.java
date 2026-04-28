

import java.io.Serializable;

public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;

    // Atributos
    private String type;
    private double amount;

    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Constructor
    public Transaction(String type, double amount) {

        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Transaction type cannot be null or empty.");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Transaction amount must be greater than 0.");
        }

        this.type = type;
        this.amount = amount;
    }

    public enum TransactionType {
        DEPOSIT, WITHDRAWAL
    }

}
