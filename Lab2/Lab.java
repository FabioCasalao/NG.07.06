import java.util.List;
import java.util.ArrayList;

public class Lab {
  private String name;
  private List<Computer> computers;

  public Lab(String name) {
    this.name = name;
    this.computers = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addComputer(Computer c) {
    if (findComputerById(c.getId()) == null) {
      computers.add(c);
    }
  }

  public Computer removeComputer(String id) {
    Computer c = findComputerById(id);
    if (c != null) {
      computers.remove(c);
    }
    return c;
  }

  public Computer findComputerById(String id) {
    for (Computer c : computers) {
      if (c.getId().equals(id)) {
        return c;
      }
    }
    return null;
  }

  public List<Computer> getComputers() {
    return computers;
  }
}