package factory;

/**
 * логика создания спрятана
 * Тип создаваемого объекта определяется в рантайме
 * Уменьшаем связность
 *
 * Абстрактная фабрика - является фабрикой фабрик.
 * То есть у нас интерфейс "фабрика" и несколько реализаций, определяемых в рантайме
 */
public class Factory {
    public enum Type {
        CIRCLE;
    }

    public Shape create(Type type) {
        if (type == Type.CIRCLE) {
            return new Circle();
        }
        return null;
    }
}
