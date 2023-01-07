

package views;

import interfaces.IDefaultView;
import routes.Router;


public class SignOut implements IDefaultView {

    @Override
    public void show() {
        Router.toggleLoggedIn();
        Router.navigate("main-menu");
    }

}
