package layouts;

import interfaces.IDefaultLayout;
import java.util.ArrayList;
import java.util.HashMap;

public class DisplayError implements IDefaultLayout {
    private ArrayList<HashMap<String, String>> errors = new ArrayList<>();
    
    public DisplayError(ArrayList<HashMap<String, String>> errors) {
        this.errors = errors;
    }

    @Override
    public void render() {
        for (HashMap<String, String> error : errors) {
            switch (error.get("errType")) {
                case "INVALID_ERROR":
                    System.out.printf("ERROR: %s is in invalid format \n", error.get("path"));
                    break;
                case "UNIQ_ERROR":
                    System.out.printf("ERROR: %s must BE UNIQUE \n", error.get("path"));
                    break;
                case "BLANK_ERROR":
                    System.out.printf("ERROR: %s must NOT BE BLANK \n", error.get("path"));
                    break;
                case "NAME_ILLEGAL_ERROR":
                    System.out.printf("ERROR: %s: Illegal character detected. Only letters allowed \n", error.get("path"));
                    break;
                case "NUMBER_ILLEGAL_ERROR":
                    System.out.printf("ERROR: %s: Illegal character detected. Only numbers are allowed \n", error.get("path"));
                    break;
                case "NOT_FOUND":
                    System.out.printf("ERROR: %s: User not found \n", error.get("path"));
                    break;
                case "SESSION_NOT_EXPIRED":
                    System.out.printf("ERROR: %s: User is currently in session. \n", error.get("path"));
                    break;
                default:
                    System.out.print("ERROR: Something went wrong. \n");
            }
        }
    }

}
