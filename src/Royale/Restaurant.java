package Royale;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;

public class Restaurant {
    int id;
    String name;
    String address;
    ArrayList<Menu> menus;
    ArrayList<Orders> orders;
    ArrayList<Employee> employees; 

    public Restaurant(String name, String address,  ArrayList<Menu> menus, ArrayList<Orders> orders, ArrayList<Employee> employees) {
        this.id = getMaxId();
        this.name = name;
        this.address = address;
        this.menus = menus;
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

    public void saveOrder() {
        String path = "Restaurants/Restaurant" + this.id + "/Orders/Orders" + this.id + ".txt";
        String template = "{0}\n{1}\n{2}";
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

    private int getMaxId() {
        File employeesDirectory = new File("Restaurants");
        File[] listOfFiles = employeesDirectory.listFiles();
        String fileName;
        ArrayList<Integer> ids = new ArrayList<>();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                fileName = listOfFiles[i].getName().split("t")[2];
                ids.add(Integer.parseInt(fileName));
            }
        }
        return ids.stream().mapToInt(Integer::intValue).max().orElse(0);
    }
}
