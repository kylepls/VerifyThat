package in.kyle.api.verify.types;

import in.kyle.api.verify.Predicate;

public class NumberPredicate extends Predicate<Number, NumberPredicate> {
    
    public NumberPredicate(Number compare) {
        super(compare);
    }
    
    public NumberPredicate isZero() {
        isNotNull();
        isEqual(0);
        return this;
    }
    
    public NumberPredicate isNotZero() {
        isNotNull();
        process(compare.doubleValue() != 0, "x != 0");
        return this;
    }
    
    public NumberPredicate isLessThan(double other) {
        isNotNull();
        process(compare.doubleValue() < other, "x < " + other);
        return this;
    }
    
    public NumberPredicate isGreaterThan(double other) {
        isNotNull();
        process(compare.doubleValue() > other, "x > " + other);
        return this;
    }
    
    public NumberPredicate isWholeNumber() {
        isNotNull();
        double value = compare.doubleValue();
        process(value == Math.floor(value) && !Double.isInfinite(value), "wholeNumber(x)");
        return this;
    }
    
    public NumberPredicate isNotWholeNumber() {
        isNotNull();
        double value = compare.doubleValue();
        process(value != Math.floor(value) && !Double.isInfinite(value), "notWholeNumber(x)");
        return this;
    }
    
    public NumberPredicate isFinite() {
        isNotNull();
        process(Double.isFinite(compare.doubleValue()), "finite(x)");
        return this;
    }
    
    public NumberPredicate isNotFinite() {
        isNotNull();
        process(!Double.isFinite(compare.doubleValue()), "notFinite(x)");
        return this;
    }
    
    public NumberPredicate isDivisibleBy(int number) {
        isNotNull();
        process(compare.doubleValue() % number == 0, "x % " + number + " = 0", false);
        return this;
    }
    
    public NumberPredicate isNotDivisibleBy(int number) {
        isNotNull();
        process(compare.doubleValue() % number != 0, "x % " + number + " != 0", false);
        return this;
    }
    
    @Override
    public NumberPredicate isEqual(Number number) {
        double a = correctNegativeZero(number.doubleValue());
        double compare = correctNegativeZero(this.compare.doubleValue());
        
        process(Double.compare(compare, a) == 0, Double.toString(a));
        return this;
    }
    
    private double correctNegativeZero(double a) {
        if (a == -0) {
            a = 0;
        }
        return a;
    }
}
