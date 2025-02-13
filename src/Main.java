import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int choice = 1;
        while (choice != 0) {
            System.out.println("Sur quel restaurant souhaitez-vous travailler ? (Entrez le numéro du restaurant)");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            File restaurantChosen = new File("Restaurants/Restaurant" + choice);
            if (!restaurantChosen.exists()) {
                System.out.println("This restaurant does not exist");
            } else {
                while(choice != 0) {
                    System.out.println("You are now working in the restaurant number " + choice);
                    System.out.println("Quelle action souhaitez-vous effectuer ? \n 1.Ajouter un employé \n 2.Ajouter un plat \n 0.Quitter");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 0:
                            break;
                        case 1:
                            System.out.println("Entrez le nom de l'employé");
                            String name = sc.next();
                            System.out.println("Entrez le prénom de l'employé");
                            String firstName = sc.next();
                            System.out.println("Entrez le role de l'employé");
                            String role = sc.next();
                            System.out.println("Entrez la date d'embauche de l'employé (aaaa/mm/jj)");
                            String hiringDate = sc.next();
                            System.out.println("Entrez le salaire de l'employé (Attention, il faut mettre une \',\' et pas un \'.\')");
                            double salary = sc.nextDouble();
                            Employee employee = new Employee(choice, name, firstName, role, hiringDate, salary);
                            break;
                        case 2:
                            System.out.println("Entrez le nom du plat");
                            String nameDish = sc.next();
                            System.out.println("Entrez la description du plat");
                            String description = sc.next();
                            System.out.println("Entrez la taille du plat");
                            String size = sc.next();
                            System.out.println("Entrez la date de création du plat (aaaa/mm/jj)");
                            String dateOfCreation = sc.next();
                            System.out.println("Entrez la disponibilité du plat");
                            String disponibility = sc.next();
                            System.out.println("Entrez le type du plat");
                            String typeOfDish = sc.next();
                            System.out.println("Entrez le temps de préparation en minutes");
                            String preparationTimeInMinutes = sc.next();
                            System.out.println("Entrez l'image du plat");
                            String Image = sc.next();
                            System.out.println("Combien d'ingrédients comporte le plat ?");
                            int numberOfIngredients = sc.nextInt();
                            ArrayList<String> ingredients = new ArrayList<String>();
                            for (int i = 0; i < numberOfIngredients; i++) {
                                System.out.println("Entrez l'ingrédient du plat n° " + (i + 1));
                                ingredients.add(sc.next());
                            }
                            System.out.println("Entrez le nombre de calories du plat (Attention, il faut mettre une \\',\\' et pas un \\'.\\')");
                            double calories = sc.nextDouble();
                            System.out.println("Entrez le prix spécial du plat (Attention, il faut mettre une \\',\\' et pas un \\'.\\')");
                            double specialPrice = sc.nextDouble();
                            System.out.println("Entrez le prix du plat (Attention, il faut mettre une \\',\\' et pas un \\'.\\')");
                            double price = sc.nextDouble();
                            Dishes dish = new Dishes(nameDish, description, size, dateOfCreation, disponibility, typeOfDish, preparationTimeInMinutes, Image, ingredients, calories, specialPrice, price);
                            break;
                        default:
                            throw new AssertionError();
                    }
                }
            }
        }
    }
}
