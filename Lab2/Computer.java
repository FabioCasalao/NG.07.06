import java.util.*;

public class Computer {
  private String id;
  private String brand;
  private List<Component> components;

  public Computer(String id, String brand) {
    this.id = id;
    this.brand = brand;
    this.components = new ArrayList<>();
  }

  public String getId() {
    return id;
  }

  public String getBrand() {
    return brand;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public boolean addComponent(Component component) { 
    if(component == null) {
      return false;
    }
    for (Component c : components) {
      if (c.getId().equals(component.getId())) {
        return false;
      }
    }

    return components.add(component) && true;
  }

  public boolean removeComponent(String id) {
    Component component = null;
    for (Component c : components) {
      component = c.findComponentById(id);
      if (component != null) {
        break;
      }
    }
    if (component == null) {
      return false;
    }
    return components.remove(component);
  }

  public List<Component> getComponents() {
    return components;
  }

  int countAllComponents() {
    int count = 0;
    for (Component c : components) {
      count += 1 + c.countDescendants();
    }
    return count;
  }
}