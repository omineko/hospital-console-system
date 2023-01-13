package layouts;

import interfaces.IDefaultLayout;
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
                        choices[this.count - 1] = key;
                        System.out.println("[" + this.count + "] -> " + route.getName());
                        this.count += 1;
                    }
                });
            }

            System.out.print("Enter your choice: ");
            this.choice = scanner.nextInt();

            if (choices[this.choice - 1] != null) {
                Router.navigate(choices[this.choice - 1]);
                break;
            } else {
                System.out.println("Invalid Choice. Try Again.");
                new Halter().render();
            }

        }
    }

}
