package decorator;

/**
 * позволяет добавлять функциональность не изменяя структуру объекта
 */
public class ShapeDecorator extends Shape {
    Shape shape;

    @Override
    void draw() {
        shape.draw();
        System.out.println("fill Color");
    }
}
