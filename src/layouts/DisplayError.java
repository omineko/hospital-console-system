package layouts;

import interfaces.IDefaultLayout;

public class DisplayError implements IDefaultLayout {
    private String errType;
    
    public DisplayError(String errType) {
        this.errType = errType.toUpperCase();
    }

    @Override
    public void render() {
        switch (this.errType) {
            case "USERNAME_UNIQ_ERROR":
                System.out.println("ERROR: Username must BE BLANK");
                break;
            case "USERNAME_BLANK_ERROR":
                System.out.println("ERROR: Username must NOT BE BLANK");
                break;
            case "PASSWORD_BLANK_ERROR":
                System.out.println("ERROR: Password must NOT BE BLANK");
                break;
            default:
                System.out.println("Something went wrong.");
        }
    }

}
