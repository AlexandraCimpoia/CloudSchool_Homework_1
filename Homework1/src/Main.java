import ex1.Student;
import ex1.StudentRegister;
import ex2.Device;
import ex2.Document;
import ex2.Printer;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        System.out.println("Exercise 1: ");

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
            for (Student s : loadedStudents) {
                System.out.println(s);
            }
        }

        System.out.println("-------------------------------------------------------------------------- ");
        System.out.println("Exercise 2: ");

        Queue<Document> documentsQueue = new LinkedList<>();

        Thread printerThread = new Thread(new Printer(documentsQueue));
        printerThread.start();

        Thread[] devicesThreads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            devicesThreads[i] = new Thread(new Device("Device" + (i + 1), documentsQueue));
            devicesThreads[i].start();
        }

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        printerThread.interrupt();
        for (Thread producerThread : devicesThreads) {
            producerThread.interrupt();
        }
    }
}