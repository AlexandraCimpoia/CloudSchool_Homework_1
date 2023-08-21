package ex1;

import java.io.*;

public class StudentRegister {
    private File file;
    private Student[] students;

    public StudentRegister(String filename) {
        this.file = new File(filename);
        this.students = new Student[0];
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void saveStudentsToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(students);
            System.out.println("Students array saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadStudentsFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            students = (Student[]) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
