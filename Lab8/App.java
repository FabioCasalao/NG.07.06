import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        List<Student> students = List.of(
                new Student(12345, "Alice", 8.5, 3),
                new Student(21234, "Bob", 6.0, 1),
                new Student(32145, "Charlie", 9.0, 4),
                new Student(43215, "Diana", 7.5, 2),
                new Student(54321, "Eve", 5.0, 1),
                new Student(65432, "Frank", 8.0, 5),
                new Student(76543, "Grace", 6.5, 3),
                new Student(87654, "Heidi", 7.0, 2)
        );

        ClassGroup classGroup = new ClassGroup("Math", students);
        System.out.println("Before removal:");
        System.out.println(classGroup);

        //Nivel 1
        //classGroup.removeByEnrollments(3);
        //System.out.println("After removal:");
        //System.out.println(classGroup);

        //Nivel 2
        long count = classGroup.countGrades(7.0);
        System.out.println("Number of students with grade above 7.0: " + count);
        System.out.println("--------------------------------------------------");

        classGroup.removeByEnrollmentsF(2);
        System.out.println("After functional removal:");
        System.out.println(classGroup);
        System.out.println("--------------------------------------------------");

        //Nivel 3
        List<Student> sortedByName = classGroup.sortByName();
        System.out.println("After sorting by name:");
        System.out.println(sortedByName);
        System.out.println("--------------------------------------------------");

        List<Student> top3Students = classGroup.top3();
        System.out.println("Top 3 students:");
        System.out.println(top3Students);
        System.out.println("--------------------------------------------------");

        classGroup.avgGrade();
        System.out.println("Average grade: " + classGroup.avgGrade());
        System.out.println("--------------------------------------------------");

        //Nivel 4
        classGroup.hasLowerGrade(count);
        System.out.println("Has students with grade lower than " + count + ": " + classGroup.hasLowerGrade(count));
        System.out.println("--------------------------------------------------");

        classGroup.validNumbers();
        System.out.println("All students have valid numbers: " + classGroup.validNumbers());
    
    }
}
