import ex1.Student;
import ex1.StudentRegister;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Alex", 9.5f);
        Student student2 = new Student("Mihai", 8.5f);
        Student student3 = new Student("Ana", 7.0f);
        Student student4 = new Student("Vlad", 4.5f);
        Student student5 = new Student("Andrei", 2.0f);

        Student[] students  = {student1, student2, student3, student4, student5};

        StudentRegister register = new StudentRegister("students.data");
        register.setStudents(students);
        register.saveStudentsToFile();

        register.loadStudentsFromFile();
        Student[] loadedStudents = register.getStudents();

        if (loadedStudents != null) {
            System.out.println("Loaded students from file:");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }
}