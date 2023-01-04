package layouts;

import interfaces.IDefaultLayout;

public class Banner implements IDefaultLayout {
    private boolean isHero;
    private int size;
    private String text, title;
    
    public Banner(String title) {
        this(true, title);
    }
    
    public Banner(boolean isHero, String title) {
        this(isHero, 50, title);
    }
    
    public Banner(boolean isHero, int size, String title) {
        this(isHero, size, "*", title);
    }
    
    public Banner(boolean isHero, int size, String text, String title) {
        this.isHero = isHero;
        this.size = size;
        this.text = text;
        this.title = title;
    }
    
    private void renderBorder() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.text);
        }
        System.out.print("\n");
    }
    
    private void renderSide() {
        if (this.text.length() < this.size) {
            int sideSize = ((this.size - this.title.length()) / 2) - 1;
            for (int i = 0; i < sideSize; i++) {
                System.out.print(this.text);
            }
        }
    }

    @Override
    public void render() {
       if (this.isHero) {
           this.renderBorder();
           this.renderSide();
           System.out.print(" ");
           System.out.print(this.title);
           System.out.print(" ");
           this.renderSide();
           System.out.print("\n");
           this.renderBorder();
       } else {
           this.renderSide();
           System.out.print(this.title);
           this.renderSide();
           System.out.print("\n"); 
       }
    }
}
