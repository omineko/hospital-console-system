package views.dashboard;

import interfaces.IDefaultView;
import java.util.ArrayList;
import layouts.Banner;
import layouts.Choice;

public class AdminDashboard implements IDefaultView {
    private ArrayList<String> selectedRoutes = new ArrayList<>();
    
    public AdminDashboard() {
        selectedRoutes.add("add-doctor");
        selectedRoutes.add("add-receptionist");
        selectedRoutes.add("list-doctors");
        selectedRoutes.add("list-receptionists");
        selectedRoutes.add("remove-doctor");
        selectedRoutes.add("remove-receptionist");
    }
    
    @Override
    public void show() {
        Banner banner = new Banner("Admin Dashboard");
        Choice choice = new Choice(selectedRoutes);
        
        banner.render();
        choice.render();
    }
}
