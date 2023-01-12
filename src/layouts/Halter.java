package layouts;

import interfaces.IDefaultLayout;
import java.util.Scanner;
import jdk.javadoc.internal.doclets.formats.html.markup.Text;

public class Halter implements IDefaultLayout {
    private Scanner scanner = new Scanner(System.in);
    private String text;
    
    public Halter() {
        this("Press any to continue");
    }
    
    public Halter(String text) {
        this.text = text;
    }
    
    @Override
    public void render() {
        System.out.println("\n" + this.text);
        scanner.nextLine();
    }
    
}
