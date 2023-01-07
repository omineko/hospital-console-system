package layouts;

import interfaces.IDefaultLayout;

public class DisplayError implements IDefaultLayout {
    private String errType;
    
    public DisplayError(String errType) {
        this.errType = errType.toUpperCase();
    }
    
    private void identifyError(String errType) {
        
    }

    @Override
    public void render() {
        switch (this.errType) {
            case "USERNAME_UNIQ_ERROR":
                System.err.println("ERROR: Username must BE BLANK");
                break;
            case "USERNAME_BLANK_ERROR":
                System.err.println("ERROR: Username must NOT BE BLANK");
                break;
            case "PASSWORD_BLANK_ERROR":
                System.err.println("ERROR: Password must NOT BE BLANK");
                break;
            case "NAME_ILLEGAL_ERROR":
                System.err.println("ERROR: Illegal character detected. Only letters allowed");
            default:
                if (this.errType.isBlank()) {
                    System.err.println("Something went wrong.");
                } else {
                    System.err.println(this.errType);
                }
        }
    }

}
