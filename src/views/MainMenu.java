package views;

import interfaces.IDefaultView;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import layouts.Banner;
import layouts.Choice;
import routes.Router;

public class MainMenu implements IDefaultView {
    private PriorityQueue<String> selectedRoutes = new PriorityQueue<>();
    
    public MainMenu() {
        selectedRoutes.add("admin-login");
        selectedRoutes.add("doctor-login");
        selectedRoutes.add("patient-login");
        selectedRoutes.add("receptionist-login");
        selectedRoutes.add("quit");
    }
    
    @Override
    public void show() {
        Banner banner = new Banner("Apple Lake Hospital");
        Choice choice = new Choice(selectedRoutes);
        
        banner.render();
        
        try {
            choice.render();
        } catch (InputMismatchException e) {
            Router.navigate("main-menu");
        }
    }
}
