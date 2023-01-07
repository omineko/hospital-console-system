

package views;

import interfaces.IDefaultView;
import routes.Router;


public class GoBack implements IDefaultView {

    @Override
    public void show() {
        Router.goBack();
    }

}
