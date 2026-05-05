import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        // Criar vários objetos Item
        Item espada = new Item("Espada Longa", "weapon", 3, LocalDate.of(2025, Month.MARCH, 10));
        Item pocao = new Item("Poção de Vida", "potion", 2, LocalDate.of(2025, Month.MARCH, 11));
        Item armadura = new Item("Armadura de Couro", "armor", 4, LocalDate.of(2025, Month.MARCH, 12));
        
        // Dois itens com os mesmos dados (iguais segundo equals/hashCode)
        Item espadaDuplicada = new Item("Espada Longa", "weapon", 3, LocalDate.of(2025, Month.MARCH, 10));
        Item pocaoDuplicada = new Item("Poção de Vida", "potion", 2, LocalDate.of(2025, Month.MARCH, 11));

        // Criar o gestor genérico para itens
        CollectionManager<Item> manager = new CollectionManager<>();

        // ---- Teste da List (Nível 2) ----
        System.out.println("=== LISTA (permite duplicados) ===");
        manager.addToList(espada);
        manager.addToList(pocao);
        manager.addToList(armadura);
        manager.addToList(espadaDuplicada); // duplicado permitido na lista
        manager.addToList(pocaoDuplicada);  // duplicado permitido na lista

        System.out.println("Todos os itens na lista:");
        for (Item item : manager.getAllFromList()) {
            System.out.println("  " + item);
        }

        // ---- Teste do Set (Nível 3) ----
        System.out.println("\n=== SET (itens únicos) ===");
        manager.addToSet(espada);
        manager.addToSet(pocao);
        manager.addToSet(armadura);
        boolean adicionouEspadaDuplicada = manager.addToSet(espadaDuplicada);
        boolean adicionouPocaoDuplicada = manager.addToSet(pocaoDuplicada);

        System.out.println("Adicionou espada duplicada ao Set? " + adicionouEspadaDuplicada);
        System.out.println("Adicionou poção duplicada ao Set? " + adicionouPocaoDuplicada);
        System.out.println("Itens únicos no Set:");
        for (Item item : manager.getAllFromSet()) {
            System.out.println("  " + item);
        }

        // ---- Teste do Map (Nível 4) ----
        System.out.println("\n=== MAP (associação ID -> Item) ===");
        manager.putInMap("ID001", espada);
        manager.putInMap("ID002", pocao);
        manager.putInMap("ID003", armadura);
        // Tentar associar outro item ao mesmo ID (substitui)
        manager.putInMap("ID001", espadaDuplicada); 

        System.out.println("Todos os itens no Map:");
        for (var entry : manager.getAllFromMap().entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        // Buscar por identificador
        System.out.println("\nBuscar ID002: " + manager.getFromMap("ID002"));
        
        // Remover por identificador
        manager.removeFromMap("ID003");
        System.out.println("\nApós remover ID003:");
        for (var entry : manager.getAllFromMap().entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}