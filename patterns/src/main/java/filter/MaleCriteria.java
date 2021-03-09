package filter;

import java.util.Collection;
import java.util.stream.Collectors;

public class MaleCriteria implements Criteria{
    @Override
    public Collection<Person> meet(Collection<Person> collection) {
        return collection.stream().filter(Person::male).collect(Collectors.toList());
    }
}
