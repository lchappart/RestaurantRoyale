
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;

public class Restaurant {
    int id;
    String name;
    String address;
    Menu menu;
    ArrayList<Orders> orders;
    ArrayList<Employee> employees; 

    public Restaurant(int id, String name, String address, Menu menu, ArrayList<Orders> orders, ArrayList<Employee> employees) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.menu = menu;
        this.orders = orders;
        this.employees = employees;
    }

    public void addOrder(Orders order) {
        this.orders.add(order);
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
    }

    public ArrayList<Employee> getEmployeesByRole(String role) {
        ArrayList<Employee> employeesByRole = new ArrayList<Employee>();
        for (int i = 0; i < this.employees.size(); i++) {
            if (this.employees.get(i).getRole().equals(role)) {
                employeesByRole.add(this.employees.get(i));
            }
        }
        return employeesByRole;
    }

    public void printEmployees() {
        for (int i = 0; i < this.employees.size(); i++) {
            System.out.println(this.employees.get(i).toString());
        }
    }

    public void saveOrders() {
        String path = "Restaurants/Restaurant" + this.id + "/Orders.txt";
        String template = "Commande#{0} : Plats : {1}, Prix : {2}";
        String dishes = "";
        for (int i = 0; i < this.orders.size(); i++) {
            dishes = "";
            for (int j = 0; j < this.orders.get(i).dishes.size(); j++) {
                dishes += this.orders.get(i).dishes.get(j).name + ", ";
            }
            String content = MessageFormat.format(template, this.orders.get(i).id, dishes, this.orders.get(i).totalPrice);
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(path));
                writer.write(content);
                writer.write('\n');
                writer.close();
            }
            catch (IOException e) {
                System.out.println("Il y a eu une erreur lors de la création du fichier");
                e.printStackTrace();
            }

        }
    }

    public double getAllSalaries() {
        double allSalaries = 0;
        for (int i = 0; i < this.employees.size(); i++) {
            allSalaries += this.employees.get(i).getSalary();
        }
        return allSalaries;
    }

    public void printRestaurant() {
        System.out.println("Restaurant#" + this.id + " : Nom : " + this.name + ", Adresse : " + this.address);
    }

    public void getSales() {
        double sales = 0;
        for (int i = 0; i < this.orders.size(); i++) {
            sales += this.orders.get(i).getTotalPrice();
        }
        System.out.println("Le restaurant a fait un chiffre d'affaire de " + sales);
    }
}
