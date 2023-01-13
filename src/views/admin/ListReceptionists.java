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

public class ListReceptionists implements IDefaultView {
    private Scanner scanner = new Scanner(System.in);
    private Halter halter = new Halter();
    
    private void listReceptionists(ArrayList<User> receptionists) {
        Formatter fmt = new Formatter();  
        fmt.format("%15s %15s \n", "ID", "USERNAME");
        for(User user : receptionists){
            fmt.format("%15s %15s \n", user.getId(), user.getUsername());
        }
        System.out.println(fmt);
    }
    
    @Override
    public boolean peek() {
        ArrayList<User> receptionists = Admin.listReceptionists();
        
        if (receptionists.isEmpty()) {
             new Banner("NO RECEPTIONISTS FOUND.").render();
        } else this.listReceptionists(receptionists);
        
        return !receptionists.isEmpty();
    }

    @Override
    public void show() {
        this.peek();
        
        halter.render();
        Router.navigate("admin-dashboard");
    }

}
