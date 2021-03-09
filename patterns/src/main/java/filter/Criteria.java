package filter;

import bridge.Shape;

import java.util.Collection;

/**
 * Фильтр\критерий паттерн
 * позволяет фильтровать объекты и соединять критерии логическими операциями в один
 */
public interface Criteria {
    Collection<Person> meet(Collection<Person> collection);
}
