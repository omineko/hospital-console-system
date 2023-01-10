package views.login;

import controllers.Auth;
import interfaces.IDefaultView;
import java.util.HashMap;
import java.util.Scanner;
import layouts.Banner;
import layouts.Field;
import routes.Router;


public class ReceptionistLogin implements IDefaultView {
    private HashMap<String, String> credentials = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    
    @Override
    public void show() {
        Banner viewTitle = new Banner(false, "Receptionist Login");
        
        viewTitle.render();
        
        try {
            credentials.put("username", new Field("Username").renderAndReturn());
            credentials.put("password", new Field("Password").renderAndReturn());
        } catch (Exception e) {
            Banner errorBanner = new Banner(false, "Invalid credentials.");
            Router.navigate("main-menu");
        }
        
        credentials.put("role", "receptionist");
        
        if (Auth.login(credentials)) {
            System.out.println("Logged In");
            Router.navigate("receptionist-dashboard");
        } else {
            System.out.println("Unauthorized User. Please contact administrator");
            Router.navigate("main-menu");
        }
        
    }

}
