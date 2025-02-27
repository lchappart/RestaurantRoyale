package Commands;

import Royale.Dishes;

import java.util.ArrayList;
import java.util.Scanner;

public class AddDish extends Command {
    int restaurantId;
    Scanner sc;
    public AddDish(Scanner scanner, int restaurantId) {
        this.sc = scanner;
        this.restaurantId = restaurantId;
    }

    @Override
    public String getLabel() {
        return "Ajouter un plat";
    }

    @Override
    public void execute() {
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
        String[] ingredients = new String[numberOfIngredients];
        for (int i = 0; i < numberOfIngredients; i++) {
            System.out.println("Entrez l'ingrédient du plat n° " + (i + 1));
            ingredients[i] = sc.nextLine();
        }
        System.out.println("Entrez le nombre de calories du plat (Attention, il faut mettre une ',' et pas un '.')");
        double calories = sc.nextDouble();
        sc.nextLine();
        System.out.println("Entrez le prix spécial du plat (Attention, il faut mettre une ',' et pas un '.')");
        double specialPrice = sc.nextDouble();
        sc.nextLine();
        System.out.println("Entrez le prix du plat (Attention, il faut mettre une ',' et pas un '.')");
        double price = sc.nextDouble();
        Dishes dish = new Dishes(restaurantId, nameDish, dishDescription, size, dateOfCreation, disponibility, typeOfDish, preparationTimeInMinutes, Image, ingredients, calories, specialPrice, price);
    }
}
    

   