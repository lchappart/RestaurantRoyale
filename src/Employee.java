import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;

public class Employee {
    private static int id;
    private String name;
    private String firstName;
    private String role;
    private String hiringDate;
    private double salary;

    public Employee(int restaurantId, String name, String firstName, String role, String hiringDate, double salary) {
        String template = "Employee#{0} : Name : {1}, First Name : {2}, Role : {3}, Hiring Date : {4}, Salary : {5}";
        File employeesDirectory = new File("Restaurants/Restaurant" + restaurantId + "/Employees"); 
        File[] listOfFiles = employeesDirectory.listFiles();
        id = listOfFiles.length + 1;
        String content = MessageFormat.format(template, id, name, firstName, role, hiringDate, salary);
        String filePath = "Restaurants/Restaurant" + restaurantId + "/Employees/" + id + ".txt";
        try {
            System.out.println("5");
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content);
            writer.close();
            System.out.println("L'emplyé a bien été créé");
        } catch (IOException e) {
            System.out.println("Il y a eu une erreur lors de la création du fichier");
            e.printStackTrace();
        }
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.role = role;
        this.hiringDate = hiringDate;
        this.salary = salary;
    }

    public int getid() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getRole() {
        return this.role;
    }

    public String getHiringDate() {
        return this.hiringDate;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setid(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setHiringDate(String hiringDate) {
        this.hiringDate = hiringDate;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    } 

    public String toString() {
        String template = "Employee#{0} : Name : {1}, First Name : {2}, Role : {3}, Hiring Date : {4}, Salary : {5}";
        return MessageFormat.format(template, this.id, this.name, this.firstName, this.role, this.hiringDate, this.salary);
    }
}
