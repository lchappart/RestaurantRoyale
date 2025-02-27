import java.util.Scanner;

import Commands.Command;
import Databases.DbRestaurant;


public class Main {
    public static void main(String[] args) throws Exception {
        DbRestaurant dbRestaurant = new DbRestaurant();
        dbRestaurant.loadAllRestaurants();
        System.out.println(dbRestaurant.restaurants);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu :");

            Command[] commands = {
                    new Commands.AddRestaurant(dbRestaurant, scanner),
            };

            for (int i = 0; i < commands.length; i++) {
                System.out.println((i + 1) + ". " + commands[i].getLabel());
            }

            int option = chooseOption(scanner);

            if (option < 0 || option >= commands.length) {
                System.out.println("Option inconnue");
                continue;
            }

            commands[option].execute();
        }
    }

    private static int chooseOption(Scanner scanner) {
        try {
            if (scanner.hasNextInt()) {
                return scanner.nextInt() - 1;
            } else {
                scanner.next();
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
    }
}