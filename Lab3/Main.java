import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int option;
    // store created equipments
    List<Equipment> equipments = new ArrayList<>();

    do {
      System.out.println("Menu:");
      System.out.println("1. Criar AudioVisualEquipment");
      System.out.println("2. Criar ComputingEquipment");
      System.out.println("3. Criar Laptop");
      System.out.println("4. Criar Desktop");
      System.out.println("5. Comparar dois equipamentos (mesmo tipo)");
      System.out.println("8. Sair");
      System.out.print("Escolha uma opção: ");
      option = scanner.nextInt();

      switch (option) {
        case 1:
          createAudioVisualEquipment(scanner, equipments);
          break;
        case 2:
          createComputingEquipment(scanner, equipments);
          break;
        case 3:
          createLaptop(scanner, equipments);
          break;
        case 4:
          createDesktop(scanner, equipments);
          break;
        case 5:
          compareEquipments(scanner, equipments);
          break;
        case 8:
          System.out.println("Saindo...");
          break;
        default:
          System.out.println("Opção inválida. Tente novamente.");
      }
    } while (option != 8);

    scanner.close();
  }

  private static void createAudioVisualEquipment(Scanner scanner, List<Equipment> equipments) {
    // Implementar lógica para criar AudioVisualEquipment
    System.out.print("Digite o nome do equipamento: ");
    String name = scanner.next();
    System.out.print("Digite a daily price: ");
    double dailyPrice = scanner.nextDouble();
    System.out.print("Digite a resolução (ex: 1080): ");
    String resolution = scanner.next();
    System.out.print("Digite se é inteligente: (1 - sim, 0 - não): ");
    boolean isSmart = scanner.nextInt() == 1;
    // Criar instância de AudioVisualEquipment
    AudioVisualEquipment audioVisualEquipment = new AudioVisualEquipment(name, dailyPrice, resolution, isSmart);
    equipments.add(audioVisualEquipment);
    System.out.println("AudioVisualEquipment criado com sucesso!");
  }

  private static void createComputingEquipment(Scanner scanner, List<Equipment> equipments) {
    // Implementar lógica para criar ComputingEquipment
    System.out.print("Digite o nome do equipamento: ");
    String name = scanner.next();
    System.out.print("Digite a daily price: ");
    double dailyPrice = scanner.nextDouble();
    System.out.print("Digite o processador: ");
    String processor = scanner.next();
    // Criar instância de ComputingEquipment
    ComputingEquipment computingEquipment = new ComputingEquipment(name, dailyPrice, processor);
    equipments.add(computingEquipment);
    System.out.println("ComputingEquipment criado com sucesso!");
  }

  private static void createLaptop(Scanner scanner, List<Equipment> equipments) {
    // Implementar lógica para criar Laptop
    System.out.print("Digite o nome do laptop: ");
    String name = scanner.next();
    System.out.print("Digite a daily price: ");
    double dailyPrice = scanner.nextDouble();
    System.out.print("Digite o processador: ");
    String processor = scanner.next();
    System.out.print("Digite a vida útil da bateria: ");
    int batteryLife = scanner.nextInt();
    System.out.print("Digite o peso do laptop (em kg): ");
    double weightKg = scanner.nextDouble();
    // Criar instância de Laptop
    Laptop laptop = new Laptop(name, dailyPrice, processor, batteryLife, weightKg);
    equipments.add(laptop);
    System.out.println("Laptop criado com sucesso!");
  }

  private static void createDesktop(Scanner scanner, List<Equipment> equipments) {
    // Implementar lógica para criar Desktop
    System.out.print("Digite o nome do desktop: ");
    String name = scanner.next();
    System.out.print("Digite a marca do desktop: ");
    String brand = scanner.next();
    System.out.print("Digite o processador do desktop: ");
    String processor = scanner.next();
    System.out.print("Digite o preço do desktop: ");
    double price = scanner.nextDouble();
    // Criar instância de Desktop
    Desktop desktop = new Desktop(name, brand, processor, price);
    equipments.add(desktop);
    System.out.println("Desktop criado com sucesso!");
  }

  private static void compareEquipments(Scanner scanner, List<Equipment> equipments) {
    // Implementar lógica para comparar dois equipamentos
    System.out.print("Digite o nome do primeiro equipamento: ");
    String name1 = scanner.next();
    System.out.print("Digite o nome do segundo equipamento: ");
    String name2 = scanner.next();
    // find equipments by name
    Equipment e1 = null, e2 = null;
    for (Equipment e : equipments) {
      if (e.getName().equals(name1) && e1 == null) e1 = e;
      else if (e.getName().equals(name2) && e2 == null) e2 = e;
    }

    if (e1 == null) {
      System.out.println("Equipamento '" + name1 + "' não encontrado.");
      return;
    }
    if (e2 == null) {
      System.out.println("Equipamento '" + name2 + "' não encontrado.");
      return;
    }

    if (!e1.getClass().equals(e2.getClass())) {
      System.out.println("Os equipamentos não são do mesmo tipo: " + e1.getEquipmentType() + " vs " + e2.getEquipmentType());
      return;
    }

    // use Equipment.equals
    if (e1.equals(e2)) {
      System.out.println("Os equipamentos são considerados IGUAIS.");
    } else {
      System.out.println("Os equipamentos NÃO são iguais.");
    }
    
  }
}
