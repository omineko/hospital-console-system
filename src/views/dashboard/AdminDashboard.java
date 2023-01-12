package views.dashboard;

import interfaces.IDefaultView;
import java.util.PriorityQueue;
import layouts.Banner;
import layouts.Choice;

public class AdminDashboard implements IDefaultView {
    private PriorityQueue<String> selectedRoutes = new PriorityQueue<>();
    
    public AdminDashboard() {
        selectedRoutes.add("add-doctor");
        selectedRoutes.add("add-receptionist");
        selectedRoutes.add("add-admin");
        selectedRoutes.add("list-doctors");
        selectedRoutes.add("list-receptionists");
        selectedRoutes.add("list-admins");
        selectedRoutes.add("remove-doctor");
        selectedRoutes.add("remove-receptionist");
        selectedRoutes.add("remove-admin");
        selectedRoutes.add("sign-out");
    }
    
    @Override
    public void show() {
        Banner banner = new Banner("Admin Dashboard");
        Choice choice = new Choice(selectedRoutes);
        
        banner.render();
        choice.render();
    }
}
