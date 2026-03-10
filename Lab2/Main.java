public class Main {
  public static void main(String[] args) {
    // Criar uma instância da classe Institution
    Institution institution = new Institution("IPS");

    // Criar três instâncias da classe Lab
    Lab labRedes = new Lab("LabRedes");
    Lab labProgramacao1 = new Lab("LabProgramacao1");
    Lab labProgramacao2 = new Lab("LabProgramacao2");

    // Adicionar os laboratórios à instituição
    institution.addLab(labRedes);
    institution.addLab(labProgramacao1);
    institution.addLab(labProgramacao2);

    System.out.println("Labs in " + institution.getName() + ":");
    for (Lab lab : institution.getLabs()) {
      System.out.println("- " + lab.getName());
    }

    // Criar duas instâncias da classe Computer
    Computer pc1 = new Computer("PC1", "Dell");
    Computer pc2 = new Computer("PC2", "HP");

    // Adicionar os computadores ao laboratório "LabProgramacao1"
    labProgramacao1.addComputer(pc1);
    labProgramacao1.addComputer(pc2);

    // Invocar os métodos implementados em Lab
    System.out.println("Computers in " + labProgramacao1.getName() + ":");
    for (Computer computer : labProgramacao1.getComputers()) {
      System.out.println("- " + computer.getId() + " (" + computer.getBrand() + ")");
    }

    // Criar componentes para o computador "PC1"
    Component motherboard = new Component("C1", "Motherboard");
    Component ssd = new Component("C5", "SSD");
    Component powerSupply = new Component("C6", "PowerSupply");

    // Adicionar componentes ao computador "PC1"
    pc1.addComponent(motherboard);
    pc1.addComponent(ssd);
    pc1.addComponent(powerSupply);

    // Criar subcomponentes da "Motherboard"
    Component cpu = new Component("C2", "CPU");
    Component ram = new Component("C3", "RAM");
    motherboard.addPart(cpu);
    motherboard.addPart(ram);

    // Criar subcomponentes da "CPU"
    Component cache = new Component("C4", "Cache");
    cpu.addPart(cache);

    // Invocar os métodos implementados
    System.out.println("Components of " + pc1.getId() + ":");
    for (Component component : pc1.getComponents()) {
      System.out.println("- " + component.getId() + " (" + component.getName() + ")");
    }

    System.out.println("Parts of " + motherboard.getName() + ":");
    for (Component part : motherboard.getParts()) {
      System.out.println("- " + part.getId() + " (" + part.getName() + ")");
    }

    System.out.println("Parts of " + cpu.getName() + ":");
    for (Component part : cpu.getParts()) {
      System.out.println("- " + part.getId() + " (" + part.getName() + ")");
    }

    // Remover um componente
    motherboard.removePart("C2");
    System.out.println("After removing CPU, parts of " + motherboard.getName() + ":");
    for (Component part : motherboard.getParts()) {
      System.out.println("- " + part.getId() + " (" + part.getName() + ")");
    }

    // Invocar countDescendants() sobre o componente "Motherboard"
    int motherboardDescendants = motherboard.countDescendants();
    System.out.println("Number of descendants of " + motherboard.getName() + ": " + motherboardDescendants);

    // Invocar countAllComponents() sobre o computador "PC1"
    int pc1ComponentsCount = pc1.countAllComponents();
    System.out.println("Total number of components in " + pc1.getId() + ": " + pc1ComponentsCount);
  }
}
