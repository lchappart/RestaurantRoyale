package Databases;

import Royale.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DbRestaurant {
    public ArrayList<Restaurant> restaurants;

    public DbRestaurant() {
        this.restaurants = new ArrayList<>();
    }

    public void loadAllRestaurants() {
        ArrayList<Menu> menus = new ArrayList<Menu>();
        ArrayList<Employee> employees = new ArrayList<Employee>();
        ArrayList<Orders> orders = new ArrayList<Orders>();
        ArrayList<Dishes> dishes = new ArrayList<Dishes>();

        System.out.println("Chargement des restaurants");
        File restaurantFolder = new File("Restaurants");
        if (restaurantFolder.isDirectory()) {
            File[] restaurantFiles = restaurantFolder.listFiles();
            int restaurantCount = restaurantFiles.length;
            for (int i = 1; i < restaurantCount; i++) {
                File ordersFile = new File("Restaurants/Restaurant" + i + "/Orders.txt");
                if (ordersFile.exists()) {
                    try (BufferedReader fileReader = new BufferedReader(new FileReader(ordersFile))) {
                        orders.add(new Orders(dishes, Double.parseDouble(fileReader.readLine())));
                    } catch (IOException e) {
                        System.out.println("Erreur lors du chargement des commandes");
                    }
                }


                File menuFolder = new File("Restaurants/Restaurant" + i + "/Menu");
                File[] menuFiles = menuFolder.listFiles();
                if (menuFiles.length == 0) {
                    System.out.println("Aucun menu n'est disponible pour ce restaurant");
                } else {
                    File dishesFolder = new File("Restaurants/Restaurant" + i + "/Dishes");
                    File[] dishesFiles = dishesFolder.listFiles();
                    if (dishesFiles.length == 0) {
                        System.out.println("Aucun plat n'est disponible pour ce restaurant");
                    } else {
                        for (int k = 0; k < dishesFiles.length; k++) {
                            try (BufferedReader fileReader = new BufferedReader(new FileReader(dishesFiles[k]))) {
                                dishes.add(new Dishes(i,
                                        fileReader.readLine(),
                                        fileReader.readLine(),
                                        fileReader.readLine(),
                                        fileReader.readLine(),
                                        fileReader.readLine(),
                                        fileReader.readLine(),
                                        fileReader.readLine(),
                                        fileReader.readLine(),
                                        fileReader.readLine().split(","),
                                        Double.parseDouble(fileReader.readLine()),
                                        Double.parseDouble(fileReader.readLine()),
                                        Double.parseDouble(fileReader.readLine())));
                            } catch (IOException e) {
                                System.out.println("Erreur lors du chargement des plats");
                            }

                            for (int j = 0; j < menuFiles.length; j++) {
                                try (BufferedReader fileReader = new BufferedReader(new FileReader(menuFiles[j]))) {
                                    menus.add(new Menu(fileReader.readLine(), fileReader.readLine(), fileReader.readLine(), dishes, i));
                                } catch (IOException e) {
                                    System.out.println("Erreur lors du chargement des menus");
                                }
                            }
                        }

                        File employeesFolder = new File("Restaurants/Restaurant" + i + "/Employees");
                        File[] employeesFiles = employeesFolder.listFiles();
                        if (employeesFiles.length == 0) {
                            System.out.println("Aucun employé n'est disponible pour ce restaurant");
                        } else {
                            for (int j = 0; j < employeesFiles.length; j++) {
                                try (BufferedReader fileReader = new BufferedReader(new FileReader(employeesFiles[j]))) {
                                    employees.add(new Employee(i, fileReader.readLine(), fileReader.readLine(), fileReader.readLine(), fileReader.readLine(), Double.parseDouble(fileReader.readLine())));
                                } catch (IOException e) {
                                    System.out.println("Erreur lors du chargement des employés");
                                }

                                try (BufferedReader restaurantFileReader = new BufferedReader(new FileReader(restaurantFiles[i]))) {
                                    this.restaurants.add(new Restaurant(restaurantFileReader.readLine(), restaurantFileReader.readLine(), menus, orders, employees));
                                } catch (IOException e) {
                                    System.out.println("Erreur lors du chargement des restaurants");
                                }
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Erreur lors du chargement des restaurants");
        }
    }
}