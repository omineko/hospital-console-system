package views.admin;

import controllers.Admin;
import interfaces.IDefaultView;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import layouts.Banner;
import layouts.Halter;
import models.User;
import routes.Router;

public class ListAdmins implements IDefaultView {
    private Scanner scanner = new Scanner(System.in);
    private Halter halter = new Halter();
    
    private void listAdmins(ArrayList<User> admins) {
        new Banner(false, "ADMINS LIST").render();
        
        Formatter fmt = new Formatter();  
        fmt.format("%15s %15s \n", "ID", "USERNAME");
        for(User user : admins){
            fmt.format("%15s %15s \n", user.getId(), user.getUsername());
        }
        System.out.println(fmt);
    }

    @Override
    public void show() {
        ArrayList<User> admins = Admin.listAdmins();
        
        if (admins.isEmpty()) {
             new Banner("NO ADMINS FOUND.").render();
        } else this.listAdmins(admins);

        halter.render();
        Router.navigate("admin-dashboard");
    }
}
