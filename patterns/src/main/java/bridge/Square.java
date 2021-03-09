package bridge;

public class Square extends Shape {
    @Override
    void draw() {
        System.out.println("square drawn. ");
        color.fill();
    }
}
