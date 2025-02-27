package Commands;

import Royale.Employee;

import java.util.Scanner;

public class AddEmployee extends Command {
    int restaurantId;
    Scanner sc = new Scanner(System.in);
    
    public AddEmployee(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public String getLabel() {
        return "Ajouter un employé";
    }

    @Override
    public void execute() {
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
        Employee employee = new Employee(restaurantId, name, firstName, role, hiringDate, salary);
    }
    
}
