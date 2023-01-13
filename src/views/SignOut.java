

package views;

import controllers.Auth;
import interfaces.IDefaultView;
import routes.Router;


public class SignOut implements IDefaultView {

    @Override
    public void show() {
        Auth.signOut();
        Router.navigate("main-menu");
    }

}
