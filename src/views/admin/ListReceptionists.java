

package views.admin;

import controllers.Admin;
import interfaces.IDefaultView;
import java.util.ArrayList;
import java.util.Formatter;
import models.Doctor;
import models.User;

public class ListReceptionists implements IDefaultView {

    @Override
    public void show() {
        ArrayList<User> receptionists = Admin.listReceptionists();
        Formatter fmt = new Formatter();  
        fmt.format("%15s %15s \n", "ID", "USERNAME");
        for(User user : receptionists){
            fmt.format("%15s %15s \n", user.getId(), user.getUsername());
        }
        System.out.println(fmt);
    }

}
