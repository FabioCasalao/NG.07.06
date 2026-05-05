

import java.time.LocalDate;
import java.util.Objects;

public class Item {
    private String name;
    private String type;
    private int rarity;
    private LocalDate acquiredDate;

    //getters e setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        if (rarity < 1 || rarity > 5) {
            throw new IllegalArgumentException("Rarity must be between 1 and 5.");
        }

        this.rarity = rarity;
    }

    public LocalDate getAcquiredDate() {
        return acquiredDate;
    }

    public void setAcquiredDate(LocalDate acquiredDate) {
        this.acquiredDate = acquiredDate;
    }

    // construtor
    public Item(String name, String type, int rarity, LocalDate acquiredDate) {
        this.name = name;
        this.type = type;
        setRarity(rarity);
        this.acquiredDate = acquiredDate;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", rarity=" + rarity +
                ", acquiredDate=" + acquiredDate +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Item item = (Item) obj;

        return Objects.equals(name, item.name) 
        && Objects.equals(type, item.type) 
        && rarity == item.rarity 
        && Objects.equals(acquiredDate, item.acquiredDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, rarity, acquiredDate);
    }
}
