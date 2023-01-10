package views.patient;

import interfaces.IDefaultView;
import java.util.Formatter;
import models.User;

public class ViewInformation implements IDefaultView {

    @Override
    public void show() {
        Formatter fmt = new Formatter();  
        fmt.format("%15s %15s \n", "ID", "USERNAME");
        for(User user : receptionists){
            fmt.format("%15s %15s \n", user.getId(), user.getUsername());
        }
        System.out.println(fmt);
        
        System.out.println("Press any to exit");
        scanner.nextLine();
    }
    
}
