

package views;

import interfaces.IDefaultView;
import routes.Router;


public class Quit implements IDefaultView {

    @Override
    public void show() {
        Router.goBack();
    }

}
