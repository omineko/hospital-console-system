package layouts;

import interfaces.IDefaultLayout;
import java.util.Scanner;

public class ChoiceField implements IDefaultLayout {
    private Enum[] values;
    private Scanner scanner = new Scanner(System.in);
    private int choice;
    private String fieldName;
    
    public String renderAndReturn() {
        this.render();
        System.out.println("Enter Choice: ");
        
        try {
            this.choice = scanner.nextInt();
            
            if (this.choice > 0 && this.choice <= this.values.length) {
                return this.values[this.choice - 1].toString();
            } 
        } catch (Exception e) {
            this.renderAndReturn();
        }
        
        System.out.println("Invalid Choice. Try again");
        new Halter().render();
        
        this.renderAndReturn();
        return null;
    }
    
    public ChoiceField(Enum[] values, String fieldName) {
        this.fieldName = fieldName;
        this.values = values;
    }

    @Override
    public void render() {
        System.out.printf("Enter %s: \n", this.fieldName);
        for (int i = 1; i <= this.values.length; i++) {
            System.out.printf("[%d] -> %s \n", i, this.values[i - 1]);
        }
    }
    
}
