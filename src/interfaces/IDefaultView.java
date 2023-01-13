package interfaces;

public interface IDefaultView {
    void show();
    default boolean peek() {
        System.out.println("Peek method is not overridden.");
        return false;
    }
}
