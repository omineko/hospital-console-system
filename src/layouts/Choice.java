package layouts;

import interfaces.IDefaultLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import routes.Route;
import routes.Router;

public class Choice implements IDefaultLayout {
    private HashMap<String, Route> routes;
    private String[] choices = new String[20];
    private PriorityQueue<String> selectedRoutes = new PriorityQueue<>();
    private int count = 1;
    private int choice;
    private Scanner scanner = new Scanner(System.in);
    
    public Choice(PriorityQueue<String> selectedRoutes) {
        this.selectedRoutes = selectedRoutes;
        this.routes = Router.getRoutes();
    }
    
    @Override
    public void render() {
        
        while (true) {
            this.count = 1;
            
            for (String selectedRoute : selectedRoutes) {
                this.routes.forEach((String key, Route route) -> {
                    if (selectedRoute.equals(key)) {
                        choices[this.count] = key;
                        System.out.println("[" + this.count + "] -> " + route.getName());
                        this.count += 1;
                    }
                });
            }

            try {
                System.out.print("Enter your choice: ");
                this.choice = scanner.nextInt();
                
                if (this.choice <= 10) {
                    Router.navigate(choices[this.choice]);
                    break;
                }
            } catch (Exception e) {
                // quits application
                break;
            }
        }
        
    }

}
