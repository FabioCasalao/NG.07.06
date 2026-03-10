import java.util.*;

public class Component {
  private String id;
  private String name;
  private List<Component> components;

  public Component(String id, String name) {
    this.id = id;
    this.name = name;
    this.components = new ArrayList<>();
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public boolean addPart(Component component) {
    if(component == null) {
      return false;
    }

    if(this.id.equals(component.getId())){
      return false;
    }

    for (Component c : components) {
      if (c.getId().equals(component.getId())) {
        return false;
      }
    }

    if (component.containsId(this.id)) {
      return false;
    }

    return components.add(component);
  }

  boolean containsId(String id) {
    if (this.id.equals(id)) {
      return true;
    }

    for (Component c : components) {
      if (c.containsId(id)) {
        return true;
      }
    }
    return false;
  }

  public Component removePart(String childId){
    Iterator<Component> iterator = components.iterator();
    while (iterator.hasNext()) {
      Component c = iterator.next();
      if (c.getId().equals(childId)) {
        iterator.remove();
        return c;
      }
    }
    return null;
  }

  public List<Component> getParts() {
    return components;
  }

  int countDescendants(){
    int count = 0;
    for (Component c : components) {
      count += 1 + c.countDescendants();
    }
    return count;
  }

  public Component findComponentById(String id) {
    if (this.id.equals(id)) {
      return this;
    }
    for (Component c : components) {
      Component result = c.findComponentById(id);
      if (result != null) {
        return result;
      }
    }
    return null;
  }
}