package in.kyle.api.conditions.types;

import in.kyle.api.conditions.Predicate;
import in.kyle.api.conditions.Result;

/**
 * Created by Kyle on 3/23/2017.
 */
public class NumberPredicate extends Predicate<Number> {
    
    public NumberPredicate(Number compare) {
        super(compare);
    }
    
    public Result isZero() {
        return result(compare.doubleValue() == 0, "Value is not zero, {}, expected zero", compare);
    }
    
    public Result isNotZero() {
        return result(compare.doubleValue() != 0, "Value zero, expected non-zero");
    }
    
    public Result isLessThan(double other) {
        return result(compare.doubleValue() < other, "Value not less than {} < {}", compare, other);
    }
    
    public Result isGreaterThan(double other) {
        return result(compare.doubleValue() > other,
                      "Value not greater than {} > {}",
                      compare,
                      other);
    }
    
    public Result isWholeNumber() {
        double value = compare.doubleValue();
        return result(value == Math.floor(value) && !Double.isInfinite(value),
                      "Value is not whole number {}, expected whole number",
                      value);
    }
    
    public Result isNotWholeNumber() {
        double value = compare.doubleValue();
        return result(value != Math.floor(value) && !Double.isInfinite(value),
                      "Value is whole number {}, expected non-whole number",
                      value);
    }
    
    public Result isFinite() {
        return result(Double.isFinite(compare.doubleValue()),
                      "Value is not finite, {}, expected finite",
                      compare);
    }
    
    public Result isNotFinite() {
        return result(!Double.isFinite(compare.doubleValue()),
                      "Value is finite, {}, expected non-finite",
                      compare);
    }
    
    public Result isDivisibleBy(int number) {
        return result(compare.doubleValue() % number == 0,
                      "Number not divisible {} % {} != 0",
                      compare,
                      number);
    }
    
    public Result isNotDivisibleBy(int number) {
        return result(compare.doubleValue() % number == 1,
                      "Number divisible {} % {} == 0",
                      compare,
                      number);
    }
}
