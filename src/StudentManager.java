import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;


        //This comment is just to push this to git

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner myScanner = new Scanner(System.in);

    public StudentManager(){
        loadFromFile();
    }

    public void menu(){
        while(true){
            System.out.println();
            System.out.println("**************************************************");
            System.out.println("* Welcome to the Student Management System (SMS) *");
            System.out.println("**************************************************");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Save to File");
            System.out.println("6. Exit");
            System.out.print("Select an Option: ");

            int choice = myScanner.nextInt();
            myScanner.nextLine();

            switch (choice){
                case 1 -> addStudent();
                case 2 -> viewStudent();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> saveToFile();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid Choice. Try Again");
            }
        }
    }

    public void addStudent(){
        System.out.print("Enter Matric Number: ");
        String matricNumber = myScanner.nextLine();


        System.out.print("Enter Name: ");
        String name = myScanner.nextLine();


        System.out.print("Enter Age: ");
        int age = myScanner.nextInt();

        myScanner.nextLine();


        System.out.print("Enter Department: ");
        String department = myScanner.nextLine();


        System.out.print("Enter GPA: ");
        double gpa = myScanner.nextDouble();


        Student student = new Student(matricNumber, name, age, department,gpa);

        students.add(student);
        System.out.println("Student added Sucessfully");
    }

    public void viewStudent(){
        if (students.isEmpty()){
            System.out.printf("%-10s %-20s %-5s %-20s %-5.2s", "Matric NO", "Name", "Age" ,"Department","GPA");
            System.out.println();
            System.out.println("------------------------------------------------------------------------------");

            System.out.println("No Student to display");
            return;
        }
        System.out.printf("%-10s %-20s %-5s %-20s %-5.2s", "Matric NO", "Name", "Age" ,"Department","GPA");
        System.out.println();
        System.out.println("------------------------------------------------------------------------------");
        for (Student s : students) {
            System.out.println(s.toString());
        }
    }

    public void updateStudent(){
        System.out.println("Enter Matric number of student to Update");
        String matricNumber = myScanner.nextLine();

        for (Student s : students){
            if (s.getMatricNumber().equals(matricNumber)){
                System.out.println("Enter new Name: ");
                s.setName(myScanner.nextLine());

                System.out.println("Enter new Age: ");
                s.setName(myScanner.nextLine());

                System.out.println("Enter new Department: ");
                s.setName(myScanner.nextLine());

                System.out.println("Enter new GPA: ");
                s.setName(myScanner.nextLine());

                System.out.println("Student updated Sucessfully");
                return;
            }
        }
        System.out.println("Student With Matric Number " + matricNumber + " not found.");
    }

    public void deleteStudent(){
        System.out.println("Enter Matric Number of Student to be Deleted");
        String matricNumber = myScanner.nextLine();

        for ( Student s : students){
            if (s.getMatricNumber().equals(matricNumber)){
                students.remove(s);
                System.out.println("Stuent deleted Sucessfully");
                return;
            }
        }
        System.out.println("Student with Matric Number " + matricNumber + " not found.");
    }

    public void saveToFile(){
        try (FileWriter writer = new FileWriter("student.txt")){
            for (Student s : students){
                writer.write(s.toString() + "\n");
            }
            System.out.println("Students saved to file successfully");
        }catch (IOException e){
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void loadFromFile(){
        try (BufferedReader reader = new BufferedReader(new FileReader("student.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                //Assumes fields are separated by spaces or fixed columns
                String [] parts = line.trim().split("\\s{2,}"); //Splits by 2 spaces

                if (parts.length == 5){
                    String matricNumber = parts[0];
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String department = parts[3];
                    double gpa = Double.parseDouble(parts[4]);

                    Student student = new Student(matricNumber,name,age,department,gpa);
                    students.add(student);
                }
            }
            System.out.println("Students Successfully Loaded From File.");
        }catch (IOException e){
            System.out.println("No Existing Student Data Found");
        }
    }
}
