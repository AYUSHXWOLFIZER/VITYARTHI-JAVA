import java.util.*;
 
class Student {
    String studentName;
    int studentMarks;

    Student(String studentName, int studentMarks) {
        this.studentName = studentName;
        this.studentMarks = studentMarks;
    }

    void display() {
        System.out.println(studentName + " - " + studentMarks);
    }
}

public class StudentManager {

    public static void main(String[] args) {

        LinkedList<Student> students = new LinkedList<>();
        Scanner input = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n--- Student Manager ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Find Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter student name: ");
                    String name = input.nextLine();

                    System.out.print("Enter marks: ");
                    int marks = input.nextInt();

                    students.add(new Student(name, marks));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        System.out.println("\nStudent List:");
                        for (Student student : students) {
                            student.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = input.nextLine();

                    Student found = null;

                    for (Student student : students) {
                        if (student.studentName.equalsIgnoreCase(searchName)) {
                            found = student;
                            break;
                        }
                    }

                    if (found != null) {
                        System.out.println("Student found:");
                        found.display();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        input.close();
    }
}