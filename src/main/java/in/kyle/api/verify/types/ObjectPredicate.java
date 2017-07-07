package in.kyle.api.verify.types;

import in.kyle.api.verify.Predicate;

public class ObjectPredicate extends Predicate<Object, ObjectPredicate> {
    public ObjectPredicate(Object compare) {
        super(compare);
    }
}
