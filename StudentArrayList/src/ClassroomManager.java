import java.util.ArrayList;
import java.util.Scanner;

public class ClassroomManager {
    private static int index = 0;
    Scanner scanner = new Scanner(System.in);
    public ArrayList<ClassRoom> listClassRooms;

    public ClassroomManager(){
        listClassRooms= new ArrayList<>();
    }

    public ClassRoom creatClassroom(Scanner scanner) {
        int id = index + 1;
        System.out.println("Enter name of class " + (index + 1));
        String className = scanner.nextLine();
        System.out.println("Enter name of School " + (index + 1));
        String schoolName = scanner.nextLine();
        return new ClassRoom(id, className, schoolName);
    }

    public void addClassRoom(Scanner scanner) {
        listClassRooms.add(creatClassroom(scanner));
        index++;
        System.out.println("Add classroom success!");
    }

    public ArrayList<ClassRoom> deleteClassById(Scanner scanner) {
        System.out.println("Enter Id of classroom you wanna delete:");
        int delId = Integer.parseInt(scanner.nextLine());
        if (delId < listClassRooms.size() && delId > 0) {
            listClassRooms.remove(delId-1);
        } else {
            System.out.println("Out of classroom's index:");
        }
        return listClassRooms;
    }

    public void displayClassroom() {
        for (ClassRoom c : listClassRooms) {
            if (c != null) {
                System.out.println(c);
            }
        }
    }

    public void displayClassroomById(ArrayList<ClassRoom> listClassRooms, Scanner scanner) {
        System.out.println("Enter ID of classroom you wanna display:");
        int idDisplay = Integer.parseInt(scanner.nextLine());
        if (idDisplay < listClassRooms.size() && idDisplay>0) {
            System.out.println(listClassRooms.get(idDisplay-1));
        } else {
            System.out.println("Out of classroom's ID!");
        }
    }

    public ArrayList<ClassRoom> editClassroomById(ArrayList<ClassRoom> listClassRooms, Scanner scanner) {
        System.out.println("Enter Id of classroom you wanna edit: ");
        int editId = Integer.parseInt(scanner.nextLine());
        if (editId <= listClassRooms.size() && editId > 0) {
            System.out.println("Enter new name of classroom: ");
            String getNewName = scanner.nextLine();
            String className;
            if (getNewName.equals("")) {
                className = listClassRooms.get(editId-1).getClassname();
            } else {
                className = getNewName;
            }
            System.out.println("Enter new school's name of classroom:");
            String getNewSchoolName = scanner.nextLine();
            String schoolName;
            if (getNewSchoolName.equals("")) {
                schoolName = listClassRooms.get(editId-1).getSchoolName();
            } else {
                schoolName = getNewSchoolName;
            }
            ClassRoom newClassroom = new ClassRoom(editId, className, schoolName);
            listClassRooms.set(editId - 1, newClassroom);
        } else {
            System.out.println("Out of classroom's ID");
        }
        return listClassRooms;

    }

    public ClassRoom checkClass(String checkClassName,Scanner scanner) {
        ClassRoom classCheck = null;
            for (ClassRoom c : listClassRooms) {
                if (c.getClassname().equalsIgnoreCase(checkClassName)) {
                    classCheck = c;
                    return classCheck;
                }
            }
            System.out.println("Please creat new classroom");
            classCheck = creatClassroom(scanner);
            index++;
        return classCheck;
    }
    public void classManager(int choice){
        do {
            System.out.println("1.Add new classroom");
            System.out.println("2. Delete classroom by ID");
            System.out.println("3. Display all classroom");
            System.out.println("4. Display classroom by ID");
            System.out.println("5. Edit classroom by ID");
            System.out.println("0. Exit");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addClassRoom(scanner);
                    break;
                case 2:
                   deleteClassById(scanner);
                   displayClassroom();
                    break;
                case 3:
                    displayClassroom();
                    break;
                case 4:
                    displayClassroomById(listClassRooms,scanner);
                    break;
                case 5:
                  editClassroomById(listClassRooms, scanner);
                  displayClassroom();
                    break;
            }
        }
        while (choice!=0);
    }
}

