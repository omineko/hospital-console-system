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
        System.out.println(errors.size());
        for (HashMap<String, String> error : errors) {
            switch (error.get("errType")) {
                case "UNIQ_ERROR":
                    System.err.printf("ERROR: %s must BE UNIQUE \n", error.get("path"));
                    break;
                case "BLANK_ERROR":
                    System.err.printf("ERROR: %s must NOT BE BLANK \n", error.get("path"));
                    break;
                case "NAME_ILLEGAL_ERROR":
                    System.err.printf("ERROR: %s: Illegal character detected. Only letters allowed \n", error.get("path"));
                    break;
                case "NOT_FOUND":
                    System.err.println("User not found \n");
                    break;
                default:
                    System.err.println("ERROR: Something went wrong. \n");
            }
        }
    }

}
