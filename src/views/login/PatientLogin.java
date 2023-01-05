package views.login;

import controllers.Auth;
import interfaces.IDefaultView;
import java.util.HashMap;
import java.util.Scanner;
import layouts.Banner;
import routes.Router;

public class PatientLogin implements IDefaultView {
    private HashMap<String, String> credentials = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    
    @Override
    public void show() {
        Banner viewTitle = new Banner(false, "Patient Login");
        
        viewTitle.render();
        
        try {
            System.out.print("username: ");
            credentials.put("username", scanner.nextLine());

            System.out.print("password: ");
            credentials.put("password", scanner.nextLine());
        } catch (Exception e) {
            Banner errorBanner = new Banner(false, "Invalid credentials.");
            Router.navigate("main-menu");
        }
        
        credentials.put("role", "patient");
        
        if (Auth.login(credentials)) {
            System.out.println("Logged In");
        } else {
            System.out.println("Unauthorized User. Please contact administrator");
            Router.navigate("main-menu");
        }
        
    }

}
