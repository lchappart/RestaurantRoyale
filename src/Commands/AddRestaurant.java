package Commands;

import Databases.DbRestaurant;
import Royale.Employee;
import Royale.Menu;
import Royale.Orders;
import Royale.Restaurant;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddRestaurant extends Command {
    DbRestaurant dbRestaurant;
    Scanner scanner;

    public AddRestaurant (DbRestaurant dbRestaurant, Scanner scanner) {
        this.dbRestaurant = dbRestaurant;
        this.scanner = scanner;
    }
    Scanner sc = new Scanner(System.in);
    @Override
    public String getLabel() {
        return "Ajouter un restaurant";
    }

    @Override
    public void execute() {
        ArrayList<Menu> menus = new ArrayList<Menu>();
        ArrayList<Orders> orders = new ArrayList<Orders>();
        ArrayList<Employee> employees = new ArrayList<Employee>();
        int id = getMaxId() + 1;
        System.out.println("Entrez le nom du restaurant (Mettre des _ au lieu d'espaces)");
        String name = sc.nextLine();
        System.out.println("Entrez l'adresse du restaurant");
        String address = sc.nextLine();
        File restaurantFolder = new File("Restaurants/Restaurant" + id);
        File menuFolder = new File("Restaurants/Restaurant" + id + "/Menus");
        File orderFolder = new File("Restaurants/Restaurant" + id + "/Orders");
        File employeeFolder = new File("Restaurants/Restaurant" + id + "/Employees");
        File dishFolder = new File("Restaurants/Restaurant" + id + "/Dishes");
        restaurantFolder.mkdir();
        menuFolder.mkdir();
        orderFolder.mkdir();
        employeeFolder.mkdir();
        dishFolder.mkdir();
        File restaurantFile = new File("Restaurants/Restaurant" + id + "/Restaurant" + id + ".txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(restaurantFile));
            writer.write(getMaxId());
            writer.newLine();
            writer.write(name);
            writer.newLine();
            writer.write(address);
            writer.close();
        } catch (IOException e) {
            System.out.println("Erreur lors de la création du fichier restaurant");
        }
        dbRestaurant.restaurants.add(new Restaurant(name, address, menus, orders, employees));
    }

    public int getMaxId() {
        File restaurantsFolder = new File("Restaurants");
        File[] listOfFiles = restaurantsFolder.listFiles();
        int maxId = 0;
        for (File file : listOfFiles) {
            String fileName = file.getName();
            String[] fileNameParts = fileName.split("t");
            int id = Integer.parseInt(fileNameParts[2]);
            if (id > maxId) {
                maxId = id;
            }
        }
        return maxId;
    }
}
