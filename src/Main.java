import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int actionChoice = 1;
        int choice = 1;
        ArrayList<Dishes> dishes = new ArrayList<Dishes>();
        Menu menu = new Menu("", "", "", dishes, 1);
        while (choice != 0) {
            System.out.println("Sur quel restaurant souhaitez-vous travailler ? (Entrez le numéro du restaurant) \nFaites 0 pour quitter");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            sc.nextLine();
            File restaurantChosen = new File("Restaurants/Restaurant" + choice);
            if (!restaurantChosen.exists()) {
                if (choice != 0) {
                    System.out.println("Le restaurant n'existe pas");
                }
                System.out.println("Au revoir !");
            } else {
                while(actionChoice != 0) {
                    System.out.println("Vous travaillez sur le restaurant n°" + choice);
                    System.out.println("Quelle action souhaitez-vous effectuer ? \n 1.Ajouter un employé \n 2.Ajouter un plat \n 3.Ajouter un menu \n 4.Afficher un menu \n 0.Quitter");
                    actionChoice = sc.nextInt();
                    sc.nextLine();
                    switch (actionChoice) {
                        case 0:
                            break;
                        case 1:
                            System.out.println("Entrez le nom de l'employé");
                            String name = sc.nextLine();
                            System.out.println("Entrez le prénom de l'employé");
                            String firstName = sc.nextLine();
                            System.out.println("Entrez le role de l'employé");
                            String role = sc.nextLine();
                            System.out.println("Entrez la date d'embauche de l'employé (aaaa/mm/jj)");
                            String hiringDate = sc.nextLine();
                            System.out.println("Entrez le salaire de l'employé (Attention, il faut mettre une ',' et pas un '.')");
                            double salary = sc.nextDouble();
                            Employee employee = new Employee(choice, name, firstName, role, hiringDate, salary);
                            break;
                        case 2:
                            System.out.println("Entrez le nom du plat (Mettre des _ au lieu d'espaces)");
                            String nameDish = sc.nextLine();
                            System.out.println("Entrez la description du plat");
                            String dishDescription = sc.nextLine();
                            System.out.println("Entrez la taille du plat");
                            String size = sc.nextLine();
                            System.out.println("Entrez la date de création du plat (aaaa/mm/jj)");
                            String dateOfCreation = sc.nextLine();
                            System.out.println("Entrez la disponibilité du plat");
                            String disponibility = sc.nextLine();
                            System.out.println("Entrez le type du plat");
                            String typeOfDish = sc.nextLine();
                            System.out.println("Entrez le temps de préparation en minutes");
                            String preparationTimeInMinutes = sc.nextLine();
                            System.out.println("Entrez l'image du plat");
                            String Image = sc.nextLine();
                            System.out.println("Combien d'ingrédients comporte le plat ?");
                            int numberOfIngredients = sc.nextInt();
                            sc.nextLine();
                            ArrayList<String> ingredients = new ArrayList<String>();
                            for (int i = 0; i < numberOfIngredients; i++) {
                                System.out.println("Entrez l'ingrédient du plat n° " + (i + 1));
                                ingredients.add(sc.nextLine());
                            }
                            System.out.println("Entrez le nombre de calories du plat (Attention, il faut mettre une ',' et pas un '.')");
                            double calories = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("Entrez le prix spécial du plat (Attention, il faut mettre une ',' et pas un '.')");
                            double specialPrice = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("Entrez le prix du plat (Attention, il faut mettre une ',' et pas un '.')");
                            double price = sc.nextDouble();
                            Dishes dish = new Dishes(choice, nameDish, dishDescription, size, dateOfCreation, disponibility, typeOfDish, preparationTimeInMinutes, Image, ingredients, calories, specialPrice, price);
                            break;
                        case 3:
                            System.out.println("Entrez le nom du menu");
                            String nameOfMenu = sc.nextLine();
                            menu.setName(nameOfMenu);
                            System.out.println("Entrez la date de création du menu (aaaa/mm/jj)");
                            String creationDate = sc.nextLine();
                            menu.setCreationDate(creationDate);
                            System.out.println("Entrez le type du menu");
                            String typeOfMenu = sc.nextLine();
                            menu.setType(typeOfMenu);
                            System.out.println("Combien de plats comporte le menu ?");
                            int numberOfDishes = sc.nextInt();
                            sc.nextLine();
                            for (int i = 0; i < numberOfDishes; i++) {
                                System.out.println("Entrez le nom du plat n° " + (i + 1));
                                String nameDishMenu = sc.nextLine();
                                Dishes dishMenu = new Dishes(choice, nameDishMenu, "", "", "", "", "", "", "", new ArrayList<String>(), 0, 0, 0);
                                dishes.add(dishMenu);
                            }
                            menu.setDishes(dishes);
                            menu.saveMenu();
                            break;
                        case 4:
                            System.out.println("Entrez le numéro du menu que vous souhaitez afficher");
                            int idMenu = sc.nextInt();
                            menu.printMenu(choice, idMenu);
                            break;
                        default:
                            System.out.println("Cette action n'est pas disponible");
                    }
                }
            }
        }
    }
}
