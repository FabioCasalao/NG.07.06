
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;

public class BankAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    // Atributos
    private int id;
    private String holder;
    private double balance;

    private List<Transaction> movements = new java.util.ArrayList<>();

    // constructor
    public BankAccount(int id, String holder, double balance) {
        
        if(id <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0.");
        }

        if(holder == null || holder.trim().isEmpty()) {
            throw new IllegalArgumentException("Holder name cannot be null or empty.");
        }

        if(balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        
        this.id = id;
        this.holder = holder;
        this.balance = balance;
    }


    // sets e gets
    public int getId() {
        return id;
    }

    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Metodos

    public double deposit(double amount) throws BankAccountException.InvalidTransactionAmountException {
        if (amount <= 0) {
            throw new BankAccountException.InvalidTransactionAmountException("Deposit amount must be greater than 0.");
        }

        balance += amount;

        // Adicionar a transação à lista de movimentos
        movements.add(new Transaction(Transaction.TransactionType.DEPOSIT.name(), amount));
        
        return balance;
    }

    public double withdraw(double amount) throws BankAccountException.InvalidTransactionAmountException {
        if (amount <= 0) {
            throw new BankAccountException.InvalidTransactionAmountException("Withdrawal amount must be greater than 0.");
        }
        if (amount > balance) {
            throw new BankAccountException.InvalidTransactionAmountException("Withdrawal amount cannot exceed current balance.");
        }
        balance -= amount;

        // Adicionar a transação à lista de movimentos
        movements.add(new Transaction(Transaction.TransactionType.WITHDRAWAL.name(), amount));
        
        return balance;
    }

    public void getMovements() {
        if (movements == null || movements.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction transaction : movements) {
                System.out.println("Type: " + transaction.getType() + ", Amount: " + transaction.getAmount());
            }
        }
    }

    // 4.1 Salvar num ficheiro
    public void saveToFile() throws IOException, SecurityException {
        Path file = Path.of("idConta.txt");

        Path parent = file.getParent();
        if (parent != null) Files.createDirectories(parent);

        try (BufferedWriter w = Files.newBufferedWriter(file,
               StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            w.write("Conta: " + id);
            w.newLine();
            w.write("Titular: " + holder);
            w.newLine();
            w.write("Saldo atual: " + balance);
            w.newLine();

            if (movements != null && !movements.isEmpty()) {
                w.write("Movimentos: ");
                w.newLine();
                for (Transaction t : movements) {
                    w.write(t.getType() + " | " + t.getAmount());
                    w.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            throw e;
        } catch (SecurityException e) {
            System.err.println("Permission denied: " + e.getMessage());
            throw e;
        }
    }

    // 4.2 Serializar o objeto BankAccount para ficheiro (.ser)
    public void saveObject(Path file) throws IOException, NotSerializableException {
        Objects.requireNonNull(file, "file cannot be null");
        Path parent = file.getParent();
        if (parent != null) Files.createDirectories(parent);

        try (ObjectOutputStream oos = new ObjectOutputStream(
                Files.newOutputStream(file, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING))) {
            oos.writeObject(this);
        }
    }

    // 4.3 Desserializar um BankAccount a partir de ficheiro
    public static BankAccount loadObject(Path file) throws IOException, ClassNotFoundException, NotSerializableException {
        Objects.requireNonNull(file, "file cannot be null");
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(file))) {
            return (BankAccount) ois.readObject();
        }
    }

    
    
}
