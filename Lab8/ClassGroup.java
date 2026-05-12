import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ClassGroup {

    private String name;
    private List<Student> students;

    public ClassGroup(String name, List<Student> students) {
        this.name = name;
        this.students = new ArrayList<>(students);
    }

    public void add(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\nClassGroup{" +
                "name='" + name + '\'' +
                ", students=" + students +
                '}';
    }

    //NIvel 1

    public void removeByEnrollments(int x) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getEnrollments() < x) {
                iterator.remove();
            }
        }
    }

    //Nivel 2
    public void removeByEnrollmentsF(int x){
        students.removeIf(student -> student.getEnrollments() > x);
    }

    public long countGrades(double value) {
        return students.stream()
                .filter(student -> student.getGrade() > value)
                .count();
    }

    //Nivel 3
    public List<Student> sortByName() {
        return students.stream()
            .sorted(Comparator.comparing(Student::getName))
            .toList();
    }

    public List<Student> top3(){
        return students.stream()
                .sorted(Comparator.comparing(Student::getGrade).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public double avgGrade(){
        return students.stream()
                .mapToDouble(Student::getGrade)
                .average()
                .orElse(0.0);
    }

    //Nivel 4
    public boolean hasLowerGrade(double value){
        return students.stream()
                .anyMatch(student -> student.getGrade() < value);
    }

    public boolean validNumbers(){
        return students.stream()
                .allMatch(student -> String.valueOf(student.getNumber()).length() == 5);
    }

    //AUXiliar

    public void printStudents() {
        students.forEach(System.out::println);
    }
}