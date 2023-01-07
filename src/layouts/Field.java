

package layouts;

import interfaces.IDefaultLayout;
import java.util.Scanner;


public class Field implements IDefaultLayout {
    private String fieldName;
    private boolean isInt;
    private Scanner scanner = new Scanner(System.in);
    
    public Field(String fieldName) {
        this(fieldName, false);
    }
    
    public Field(String fieldName, boolean isInt) {
        this.fieldName = fieldName;
        this.isInt = isInt;
    }
    
    public String renderAndReturn() {
        this.render();
        if (isInt) {
            return String.valueOf(scanner.nextInt());
        } else {
            return scanner.nextLine();
        }
    }

    @Override
    public void render() {
        System.out.print(this.fieldName + ": ");
    }

}
