
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
    ArrayList<String> ingredients;
    double calories;
    double specialPrice;
    double price;

    public Dishes(int restaurantId, String name, String description, String size, String dateOfCreation, String disponibility, String typeOfDish, String preparationTimeInMinutes, String Image, ArrayList<String> ingredients, double calories, double specialPrice, double price) {
        String template = "Name : {0}, Description : {1}, Size : {2}, Date of Creation : {3}, Disponibility : {4}, Type of Dish : {5}, Preparation Time in Minutes : {6}, Image : {7}, Ingredients : {8}, Calories : {9} kcal, Special Price : {10} €, Price : {11} €";
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
