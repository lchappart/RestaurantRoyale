import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.io.FileWriter;

public class Menu {
    int id;
    String nameOfMenu;
    String creationDate;
    String typeOfMenu;
    ArrayList<Dishes> dishes;
    String path;

    public Menu(String nameOfMenu, String creationDate, String typeOfMenu, ArrayList<Dishes> dishes, int restaurantId) {
        this.nameOfMenu = nameOfMenu;
        this.creationDate = creationDate;
        this.typeOfMenu = typeOfMenu;
        this.dishes = new ArrayList<Dishes>();
        this.id = getMaxId(restaurantId);
        this.path = "Restaurants/Restaurant" + restaurantId + "/Menu/" + this.id + ".txt";
    }

    public void printMenu(int restaurantId, int id) {
        File fileToRead = new File("Restaurants/Restaurant" + restaurantId + "/Menu/" + id + ".txt");
        try( FileReader fileStream = new FileReader( fileToRead ); 
        BufferedReader bufferedReader = new BufferedReader( fileStream ) ) {

        System.out.println( bufferedReader.readLine() );
        } catch ( IOException ex ) {
            System.out.println("Il y a eu une erreur lors de la lecture du fichier");
            ex.printStackTrace();
        }
    }

    public void setName(String nameOfMenu) {
        this.nameOfMenu = nameOfMenu;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setType(String typeOfMenu) {
        this.typeOfMenu = typeOfMenu;
    }

    public void setDishes (ArrayList<Dishes> dishes) {
        this.dishes = dishes;
    }
    
    public void saveMenu() {
        String template = "Menu#{0} : Name : {1}, Creation Date : {2}, Type : {3}, Dishes : {4}";
        String dishes = "";
        for (int i = 0; i < this.dishes.size(); i++) {
            dishes += this.dishes.get(i).name + ", ";
        }
        String content = (MessageFormat.format(template, this.id, this.nameOfMenu, this.creationDate, this.typeOfMenu, dishes));
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.path));
            writer.write(content);
            writer.close();
            System.out.println("Le menu a bien été créé");
        } catch (IOException e) {
            System.out.println("Il y a eu une erreur lors de la création du fichier");
            e.printStackTrace();
        }
    }

    public void addDish(Dishes dish) {
        this.dishes.add(dish);
    }

    public void removeDish(Dishes dish) {
        this.dishes.remove(dish);
    }

    private int getMaxId(int restaurantId) {
    File employeesDirectory = new File("Restaurants/Restaurant" + restaurantId + "/Menu"); 
    File[] listOfFiles = employeesDirectory.listFiles();
    if (listOfFiles == null) {
        return 1;
    }
    String fileName;
    ArrayList<Integer> ids = new ArrayList<>();
    for (int i = 0; i < listOfFiles.length; i++) {
        if (listOfFiles[i].isFile()) {
            fileName = listOfFiles[i].getName().split("\\.")[0];
            ids.add(Integer.parseInt(fileName));
        }
    }
    return ids.stream().mapToInt(Integer::intValue).max().orElse(0) + 1;
    }
}
