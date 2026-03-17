import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int option;

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
          createAudioVisualEquipment(scanner);
          break;
        case 2:
          createComputingEquipment(scanner);
          break;
        case 3:
          createLaptop(scanner);
          break;
        case 4:
          createDesktop(scanner);
          break;
        case 5:
          compareEquipments(scanner);
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

  private static void createAudioVisualEquipment(Scanner scanner) {
    // Implementar lógica para criar AudioVisualEquipment
    System.out.print("Digite o nome do equipamento: ");
    String name = scanner.next();
    System.out.print("Digite a marca do equipamento: ");
    String brand = scanner.next();
    System.out.print("Digite o preço do equipamento: ");
    double price = scanner.nextDouble();
    // Criar instância de AudioVisualEquipment
    AudioVisualEquipment audioVisualEquipment = new AudioVisualEquipment(name, brand, price);
    System.out.println("AudioVisualEquipment criado com sucesso!");
  }

  private static void createComputingEquipment(Scanner scanner) {
    // Implementar lógica para criar ComputingEquipment
    System.out.print("Digite o nome do equipamento: ");
    String name = scanner.next();
    System.out.print("Digite a marca do equipamento: ");
    String brand = scanner.next();
    System.out.print("Digite o preço do equipamento: ");
    double price = scanner.nextDouble();
    // Criar instância de ComputingEquipment
    ComputingEquipment computingEquipment = new ComputingEquipment(name, brand, price);
    System.out.println("ComputingEquipment criado com sucesso!");
  }

  private static void createLaptop(Scanner scanner) {
    // Implementar lógica para criar Laptop
    System.out.print("Digite o nome do laptop: ");
    String name = scanner.next();
    System.out.print("Digite a marca do laptop: ");
    String brand = scanner.next();
    System.out.print("Digite o preço do laptop: ");
    double price = scanner.nextDouble();
    // Criar instância de Laptop
    Laptop laptop = new Laptop(name, brand, price);
    System.out.println("Laptop criado com sucesso!");
  }

  private static void createDesktop(Scanner scanner) {
    // Implementar lógica para criar Desktop
    System.out.print("Digite o nome do desktop: ");
    String name = scanner.next();
    System.out.print("Digite a marca do desktop: ");
    String brand = scanner.next();
    System.out.print("Digite o preço do desktop: ");
    double price = scanner.nextDouble();
    // Criar instância de Desktop
    Desktop desktop = new Desktop(name, brand, price);
    System.out.println("Desktop criado com sucesso!");
  }

  private static void compareEquipments(Scanner scanner) {
    // Implementar lógica para comparar dois equipamentos
    System.out.print("Digite o nome do primeiro equipamento: ");
    String name1 = scanner.next();
    System.out.print("Digite o nome do segundo equipamento: ");
    String name2 = scanner.next();
    // Lógica para comparar os equipamentos
  }
}
