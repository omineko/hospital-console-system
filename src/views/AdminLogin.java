package views;

import interfaces.IDefaultView;
import java.util.Scanner;
import layouts.Banner;

public class AdminLogin implements IDefaultView {
    private String username;
    private String password;
    private Scanner scanner = new Scanner(System.in);
    
    @Override
    public void show() {
        Banner banner = new Banner(false, "Administrator Login");
        
        banner.render();
        
        System.out.print("username: ");
        this.username = scanner.nextLine();
        
        System.out.print("password: ");
        this.password = scanner.nextLine();
    }

}
