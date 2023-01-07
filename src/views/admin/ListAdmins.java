

package views.admin;

import controllers.Admin;
import interfaces.IDefaultView;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import models.User;
import routes.Router;


public class ListAdmins implements IDefaultView {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void show() {
        ArrayList<User> receptionists = Admin.listAdmins();
        Formatter fmt = new Formatter();  
        fmt.format("%15s %15s \n", "ID", "USERNAME");
        for(User user : receptionists){
            fmt.format("%15s %15s \n", user.getId(), user.getUsername());
        }
        System.out.println(fmt);
        
        System.out.println("Press any to exit");
        scanner.nextLine();
        
        Router.navigate("go-back");
    }
}
