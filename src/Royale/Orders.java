package Royale;

import java.util.ArrayList;


public class Orders {
    int id;
    ArrayList<Dishes> dishes;
    double totalPrice;

    public Orders (ArrayList<Dishes> dishes, double totalPrice) {
        this.dishes = dishes;
        this.totalPrice = totalPrice;
    }

    public void addDish(Dishes dish) {
        this.dishes.add(dish);
        this.totalPrice += dish.price;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void toString(int id) {
        String dishesName = "";
        for (int i = 0 ; i < this.dishes.size(); i++) {
            dishesName += this.dishes.get(i).name + ", ";
        }
        System.out.println("Order#" + id + " : Dishes : " + dishesName + ", Total Price : " + this.totalPrice);
    }   
}
