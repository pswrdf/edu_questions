package composite;

import java.util.Collection;

/**
 * Позволяет обращаться с множеством объектов как с одним, создаёт дерево объектов
 */
public class Employee {
    String name;
    Collection<Employee> subordinates;
}
