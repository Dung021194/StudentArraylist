import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private static int index = 0;
    public ArrayList<Student> listStudents;

    public StudentManager() {
        listStudents = new ArrayList<>();
    }
    ClassroomManager classroomManager = new ClassroomManager();
    public Student createStudent(Scanner scanner) {
        int id = index+1;
        System.out.println("Enter name of student " + (index+1));
        String name = scanner.nextLine();
        System.out.println("Enter age of student " + (index+1));
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter gender of student "+ (index+1));
        String gender = choiceGender(scanner);
        System.out.println("Enter address of student " + (index+1));
        String address = scanner.nextLine();
        System.out.println("Enter average point of student "+(index+1));
        double avg = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter classroom of student " + (index+1));
        String checkClassName = scanner.nextLine();
        ClassRoom classRoom = classroomManager.checkClass(checkClassName,scanner);
        classroomManager.listClassRooms.add(classRoom);

       return new Student(id,name,age,gender,address,avg,classRoom);
    }

    private String choiceGender(Scanner scanner) {
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.println("3. Other");
        System.out.println("Enter your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                return "Male";
            case 2:
                return "Female";
            default:
                return "Other";
        }
    }
    public void addStudent(Scanner scanner ){
        listStudents.add(createStudent(scanner));
        index++;
        System.out.println("Add student success");
    }
    public ArrayList<Student> deleteStudentByID(Scanner scanner){
        System.out.println("Enter ID of student you wanna delete: ");
        int delId = Integer.parseInt(scanner.nextLine());
        if (delId>0 && delId <=listStudents.size()) {
            if (!listStudents.isEmpty()) {
                for (Student s : listStudents) {
                    if (s.getId() == delId) {
                      delId=s.getId();
                      break;
                    }
                }
                listStudents.remove(delId - 1);
            }
        }else {
            System.out.println("Please enter again");
        }
        return listStudents;
    }
    public void displayStudent() {
        for (Student s : listStudents) {
            if (s != null) {
                System.out.println(s);
            }
        }
    }
    public void displayStudentById(Scanner scanner) {
        System.out.println("Enter ID of student you wanna display");
        int displayId = Integer.parseInt(scanner.nextLine());
        if (displayId >= 1 && displayId <= listStudents.size()) {
            for (Student s : listStudents) {
                if (s.getId() == displayId) {
                    System.out.println(s);
                }

            }
        }else {
            System.out.println("Out of ID");
        }
    }
    public void displayStudentByClassroom(Scanner scanner){
        System.out.println("Enter classroom's name of student you wanna display ");
        String className = scanner.nextLine();
           if (className!=null) {
               for (Student s : listStudents) {
                   if (s.getClassRoom().getClassname().equalsIgnoreCase(className)) {
                       System.out.println(s);
                   }
               }
           }
           else
           {
            System.out.println("Enter again");
           }

    }
    public void editStudentById(Scanner scanner) {
        System.out.println("Enter ID of student you wanna edit");
        int editId = Integer.parseInt(scanner.nextLine());
        for (Student s : listStudents) {
            if (s.getId() == editId) {
                Student newStudent = new Student();
                newStudent.setId(editId);
                System.out.println("Enter new name");
                String name = scanner.nextLine();
                if (name.equals("")) {
                    newStudent.setName(s.getName());
                } else {
                    newStudent.setName(name);
                }
                System.out.println("Enter new age");
                String inputAge = scanner.nextLine();
                if (inputAge.equals("")) {
                    newStudent.setAge(s.getAge());
                } else {
                    int age = Integer.parseInt(inputAge);
                    newStudent.setAge(age);
                }
                System.out.println("Enter new gender");
                String gender = choiceGender(scanner);
                System.out.println("Enter new address");
                String address = scanner.nextLine();
                if (address.equals("")) {
                    newStudent.setAddress(s.getAddress());
                } else {
                    newStudent.setAddress(address);
                }
                System.out.println("Enter new avg");
                String inputAvg = scanner.nextLine();
                if (inputAvg.equals("")) {
                    newStudent.setAvg(s.getAvg());
                } else {
                    double avg = Double.parseDouble(inputAvg);
                    newStudent.setAvg(avg);
                }
                System.out.println("Enter new classroom");
                String newClassName = scanner.nextLine();
                if (newClassName.equals("")){
                    newStudent.setClassRoom(s.getClassRoom());
                }else {
                    newStudent.setClassRoom(classroomManager.checkClass(newClassName,scanner));
                }


                listStudents.set(editId-1,newStudent);
            }

        }
        displayStudent();
    }
    public void searchStudentByName(Scanner scanner) {
        System.out.println("Enter name of student you wanna search");
        String searchName = scanner.nextLine();
        if (searchName != null) {
            for (Student s : listStudents) {
                if (s.getName().toLowerCase().contains(searchName.toLowerCase())){
                    System.out.println(s);
                }
            }
        }else {
            System.out.println("Please enter again");
        }
    }

}
