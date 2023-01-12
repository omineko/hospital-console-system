package layouts;

import interfaces.IDefaultLayout;
import java.util.Scanner;

public class Field implements IDefaultLayout {
    private String fieldName;
    private Scanner scanner = new Scanner(System.in);
    
    public Field(String fieldName) {
        this.fieldName = fieldName;
    }
    
    public String renderAndReturn() {
        this.render();
        return scanner.nextLine();
    }

    @Override
    public void render() {
        System.out.print(this.fieldName + ": ");
    }

}
