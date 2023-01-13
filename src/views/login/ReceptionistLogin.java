package views.login;

import controllers.Auth;
import interfaces.IDefaultView;
import java.util.HashMap;
import java.util.Scanner;
import layouts.Banner;
import layouts.Field;
import layouts.Halter;
import routes.Router;

public class ReceptionistLogin implements IDefaultView {
    private HashMap<String, String> credentials = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private Halter halter = new Halter();
    
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
            halter.render();
            Router.navigate("receptionist-dashboard");
        } else {
            System.out.println("Unauthorized User. Please contact administrator");
            halter.render();
            Router.navigate("main-menu");
        }
        
    }

}
