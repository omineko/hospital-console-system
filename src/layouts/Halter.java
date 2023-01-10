package layouts;

import interfaces.IDefaultLayout;
import java.util.Scanner;

public class Halter implements IDefaultLayout {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void render() {
        System.out.println("Press any to continue.");
        scanner.nextLine();
    }
    
}
