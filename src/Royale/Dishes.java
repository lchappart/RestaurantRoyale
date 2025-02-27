package Royale;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;

public class Dishes {
    String name;
    String description;
    String size;
    String dateOfCreation;
    String disponibility;
    String typeOfDish;
    String preparationTimeInMinutes;
    String Image;
    String[] ingredients;
    double calories;
    double specialPrice;
    double price;

    public Dishes(int restaurantId, String name, String description, String size, String dateOfCreation, String disponibility, String typeOfDish, String preparationTimeInMinutes, String Image, String[] ingredients, double calories, double specialPrice, double price) {
        String template = "{0}\n{1}\n{2}\n{3}\n{4}\n{5}\n{6}\n{7}\n{8}\n{9}\n{10}\n{11}";
        String content = MessageFormat.format(template, name, description, size, dateOfCreation, disponibility, typeOfDish, preparationTimeInMinutes, Image, ingredients, calories, specialPrice, price);
        String filePath = "Restaurants/Restaurant" + restaurantId + "/Dishes/" + name + ".txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content);
            writer.close();
            System.out.println("Le plat a bien été créé");
        } catch (IOException e) {
            System.out.println("Il y a eu une erreur lors de la création du fichier");
            e.printStackTrace();
        }
        this.name = name;
        this.description = description;
        this.size = size;
        this.dateOfCreation = dateOfCreation;
        this.disponibility = disponibility;
        this.typeOfDish = typeOfDish;
        this.preparationTimeInMinutes = preparationTimeInMinutes;
        this.Image = Image;
        this.ingredients = ingredients;
        this.calories = calories;
        this.specialPrice = specialPrice;
        this.price = price;
    }
}