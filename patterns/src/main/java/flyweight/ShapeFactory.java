package flyweight;

import factory.Factory;
import factory.Shape;

import java.util.HashMap;

/**
 * Суть чтобы переиспользовать тяжелые объекты, не пересоздавать их
 * Но соответственно значения будут переопределяться
 */
public class ShapeFactory extends Factory {
    HashMap<Type, Shape> map;

    @Override
    public Shape create(Type type) {
        Shape shape = map.get(type);
        if (shape == null) {
            shape = super.create(type);
            map.put(type, shape);
        }
        return shape;
    }

}

