public class Student {
    private String matricNumber;
    private String name;
    private int age;
    private String department;
    private double gpa;



    public Student(String matricNumber, String name, int age, String department, double gpa){
        this.matricNumber = matricNumber;
        this.name = name;
        this.age = age;
        this.department = department;
        this.gpa = gpa;
    }

    public void setMatricNumber(String matricNumber) {
        this.matricNumber = matricNumber;
    }

    public String getMatricNumber() {
        return matricNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

/*  @Override
    public String toString(){
        return "Matric Number: " + matricNumber + " , Name: " + name + " , Age: " + age + " , Department: " + department + " , GPA: " + gpa;
    }
*/
    @Override
    public  String toString(){
        return String.format("%-10s %-20s %-5d %-20s %-5.2f", matricNumber,name,age,department,gpa);
    }
}
