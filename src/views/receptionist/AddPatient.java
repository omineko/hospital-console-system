package views.receptionist;

import controllers.Admin;
import controllers.Receptionist;
import interfaces.IDefaultView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import layouts.Banner;
import layouts.ChoiceField;
import layouts.DisplayError;
import layouts.Field;
import routes.Router;
import views.Enums;

public class AddPatient implements IDefaultView {
    private HashMap<String, String> data = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void show() {
        try {
            System.out.println("-- ADD PATIENT --");

            System.out.println("* Account Information:");
            data.put("username", new Field("New Username").renderAndReturn());
            data.put("password", new Field("New Password").renderAndReturn());

            System.out.println("* Personal Information:");
            data.put("first-name", new Field("First Name").renderAndReturn());
            data.put("last-name", new Field("Last Name").renderAndReturn());
            data.put("address", new Field("Address").renderAndReturn());
            data.put("contact", new Field("Contact", true).renderAndReturn());
            data.put("sex", new ChoiceField(Enums.Sex.values(), "Sex").renderAndReturn());
            data.put("blood-type", new ChoiceField(Enums.BloodType.values(), "Blood Type").renderAndReturn());
            data.put("initial-diagnosis", new Field("Initial Diagnosis").renderAndReturn());
            this.displayConfirmation();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Invalid Input. Patient not saved. Reverting..");
            Router.navigate("receptionist-dashboard");
        }
    }
    
    private void displayConfirmation() {
        // review information
        new Banner(false, "Review Information").render();
        
        System.out.println("* Account Information:");
        System.out.printf("[%s]: %s \n", "USERNAME", data.get("username"));
        System.out.printf("[%s]: %s \n", "PASSWORD", data.get("password"));
        System.out.println("* Personal Information:");
        System.out.printf("[%s]: %s \n", "FIRST NAME", data.get("first-name"));
        System.out.printf("[%s]: %s \n", "LAST NAME", data.get("last-name"));
        System.out.printf("[%s]: %s \n", "ADDRESS", data.get("address"));
        System.out.printf("[%s]: %s \n", "CONTACT", data.get("contact"));
        System.out.printf("[%s]: %s \n", "SEX", data.get("sex"));
        System.out.printf("[%s]: %s \n", "BLOOD TYPE", data.get("blood-type"));
        System.out.printf("[%s]: %s \n", "INITIAL DIAGNOSIS", data.get("initial-diagnosis"));
        
        // confirm
        System.out.println("Are you sure the details were correct? [Y]");
        String choice = scanner.nextLine();
        
        if (choice.toUpperCase().equals("Y")) {
            this.save();
        } else {
            System.out.println("Patient profile not save. Aborting...");
            this.show();
        }
    }
    
    private void save() {
        ArrayList<HashMap<String, String>> errors = Receptionist.addPatient(data);
        
        if (!errors.isEmpty()) {
            new Banner(false, "Errors Detected. Not Saved.").render();
            new DisplayError(errors).render();
            this.show();
        } else {
            System.out.println("Patient Profile Saved.");
            Router.navigate("go-back");
        }
    }
    
}
