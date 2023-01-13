package views.login;

import controllers.Auth;
import interfaces.IDefaultView;
import java.util.HashMap;
import java.util.Scanner;
import layouts.Banner;
import layouts.Field;
import layouts.Halter;
import routes.Router;

public class DoctorLogin implements IDefaultView {
    private HashMap<String, String> credentials = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    
    @Override
    public void show() {
        Banner viewTitle = new Banner(false, "DOCTOR LOGIN");
        Halter halter = new Halter();
        
        viewTitle.render();
        
        credentials.put("role", "doctor");
        credentials.put("username", new Field("Username").renderAndReturn());
        credentials.put("password", new Field("Password").renderAndReturn());
        
        if (Auth.login(credentials)) {
            System.out.println("Logged In");
            halter.render();
            Router.navigate("doctor-dashboard");
        } else {
            System.out.println("Unauthorized User. Please contact administrator");
            halter.render();
            Router.navigate("main-menu");
        }
        
    }
}
