import java.util.ArrayList;
import java.util.Scanner;
class Student {
    String name;
    int rollNumber;
    String grade;
    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}
class StudentManagementSystem {
    private ArrayList<Student> students;
    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.rollNumber == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.rollNumber == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class SimpleStudentManagementSystem {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1.Add student");
            System.out.println("2.Remove student");
            System.out.println("3.Search student");
            System.out.println("4.Display students");
            System.out.println("5.Exit");
            System.out.print("Enter choice:");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent(system, scanner);
                    break;
                case 2:
                    removeStudent(system, scanner);
                    break;
                case 3:
                    searchStudent(system, scanner);
                    break;
                case 4:
                    displayAllStudents(system);
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
        scanner.close();
    }
    private static void addStudent(StudentManagementSystem system, Scanner scanner) {
        System.out.print("Enter the name of the student: ");
        String name = scanner.nextLine();
        System.out.print("Enter the roll number of the student: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        System.out.print("Enter the grade of the student: ");
        String grade = scanner.nextLine();
        system.addStudent(new Student(name, rollNumber, grade));
        System.out.println("Student added successfully.");
    }
    private static void removeStudent(StudentManagementSystem system, Scanner scanner) {
        System.out.print("Enter the roll number of the student to remove: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        system.removeStudent(rollNumber);
        System.out.println("Student removed successfully.");
    }
    private static void searchStudent(StudentManagementSystem system, Scanner scanner) {
        System.out.print("Enter the roll number of the student to search: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        Student student = system.searchStudent(rollNumber);
        if (student != null) {
            System.out.println("Student found:\n" + student);
        } else {
            System.out.println("Student not found.");
        }
    }
    private static void displayAllStudents(StudentManagementSystem system) {
        System.out.println("All Students:");
        system.displayAllStudents();
    }
}
