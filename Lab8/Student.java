public class Student {

    private int number;
    private String name;
    private double grade;
    private int enrollments;

    public Student(int number, String name,
                   double grade, int enrollments) {

        this.number = number;
        this.name = name;
        this.grade = grade;
        this.enrollments = enrollments;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public int getEnrollments() {
        return enrollments;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", enrollments=" + enrollments +
                '}';
    }
}
