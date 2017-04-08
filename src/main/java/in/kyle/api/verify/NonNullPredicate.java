package in.kyle.api.verify;

/**
 * Created by Kyle on 4/7/2017.
 */
public class NonNullPredicate<T> extends Predicate<T> {
    public NonNullPredicate(T compare) {
        super(compare);
        isNotNull();
    }
}
