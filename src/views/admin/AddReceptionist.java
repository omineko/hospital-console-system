

package views.admin;

import interfaces.IDefaultView;


public class AddReceptionist implements IDefaultView {

    @Override
    public void show() {
        System.out.println("-- ADD RECEPTIONIST --");
        
        System.out.println("* Account Information:");
        System.out.print("New Username: ");
        System.out.println("New Password: ");
        
        // confirm
    }

}
