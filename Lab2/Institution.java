import java.util.List;
import java.util.ArrayList;

public class Institution {
  private String name;
  private List<Lab> labs;

  public Institution(String name) {
    this.name = name;
    this.labs = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public List<Lab> getLabs() {
    return labs;
  }

  public boolean addLab(Lab lab) {
    if(this.name.equals(lab.getName())) {
      return false;
    }
    return labs.add(lab) && true;
  }
}