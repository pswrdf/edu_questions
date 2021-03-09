package bridge;

/**
 * Отвязать абстракцию от имплементации.
 *
 * color - это и есть мост, мы не знаем реализацию
 *
 * Разделяем отвественность между shape и color
 */
public abstract class Shape {
    Color color;
    abstract void draw();
}
