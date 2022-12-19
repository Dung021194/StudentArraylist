import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        ClassroomManager classroomManager = new ClassroomManager();
        do {
            System.out.println("MENU");
            System.out.println("1. Add new student");
            System.out.println("2. Delete student by ID");
            System.out.println("3. Display student by ID");
            System.out.println("4. Display all student");
            System.out.println("5. Edit student by ID");
            System.out.println("6. Display student by classroom");
            System.out.println("7. Search student by name");
            System.out.println("8. Manager classroom:");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    studentManager.addStudent(scanner);
                    break;
                case 2:
                    studentManager.deleteStudentByID(scanner);
                    studentManager.displayStudent();
                    break;
                case 3:
                    studentManager.displayStudentById(scanner);
                    break;
                case 4:
                    studentManager.displayStudent();
                    break;
                case 5:
                    studentManager.editStudentById(scanner);
                    break;
                case 6:
                    studentManager.displayStudentByClassroom(scanner);
                    break;
                case 7:
                    studentManager.searchStudentByName(scanner);
                    break;
                case 8:
                    classroomManager.classManager(choice);
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
    }
