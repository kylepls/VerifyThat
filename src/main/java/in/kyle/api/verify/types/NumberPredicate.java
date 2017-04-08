package in.kyle.api.verify.types;

import in.kyle.api.verify.Predicate;

/**
 * Created by Kyle on 3/23/2017.
 */
public class NumberPredicate extends Predicate<Number> {
    
    public NumberPredicate(Number compare) {
        super(compare);
    }
    
    public void isZero() {
        isNotNull();
        process(compare.doubleValue() == 0, "Value is not zero, {}, expected zero", compare);
    }
    
    public void isNotZero() {
        isNotNull();
        process(compare.doubleValue() != 0, "Value zero, expected non-zero");
    }
    
    public void isLessThan(double other) {
        isNotNull();
        process(compare.doubleValue() < other, "Value not less than {} < {}", compare, other);
    }
    
    public void isGreaterThan(double other) {
        isNotNull();
        process(compare.doubleValue() > other, "Value not greater than {} > {}", compare, other);
    }
    
    public void isWholeNumber() {
        isNotNull();
        double value = compare.doubleValue();
        process(value == Math.floor(value) && !Double.isInfinite(value),
                "Value is not whole number {}, expected whole number",
                value);
    }
    
    public void isNotWholeNumber() {
        isNotNull();
        double value = compare.doubleValue();
        process(value != Math.floor(value) && !Double.isInfinite(value),
                "Value is whole number {}, expected non-whole number",
                value);
    }
    
    public void isFinite() {
        isNotNull();
        process(Double.isFinite(compare.doubleValue()),
                "Value is not finite, {}, expected finite",
                compare);
    }
    
    public void isNotFinite() {
        isNotNull();
        process(!Double.isFinite(compare.doubleValue()),
                "Value is finite, {}, expected non-finite",
                compare);
    }
    
    public void isDivisibleBy(int number) {
        isNotNull();
        process(compare.doubleValue() % number == 0,
                "Number not divisible {} % {} != 0",
                compare,
                number);
    }
    
    public void isNotDivisibleBy(int number) {
        isNotNull();
        process(compare.doubleValue() % number == 1,
                "Number divisible {} % {} == 0",
                compare,
                number);
    }
}
