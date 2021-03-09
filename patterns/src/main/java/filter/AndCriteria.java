package filter;

import java.util.Collection;


public class AndCriteria implements Criteria {

    private Criteria criteria1;
    private Criteria criteria2;

    public AndCriteria(Criteria criteria1, Criteria criteria2) {
        this.criteria1 = criteria1;
        this.criteria2 = criteria2;
    }

    @Override
    public Collection<Person> meet(Collection<Person> collection) {
        return criteria2.meet(criteria1.meet(collection));
    }
}
