package in.kyle.api.verify.types;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

import in.kyle.api.verify.Predicate;

/**
 * Created by Kyle on 3/23/2017.
 */
public class TypePredicate extends Predicate<Type> {
    
    public TypePredicate(Type compare) {
        super(compare);
    }
    
    public void isClass() {
        isNotNull();
        process(compare instanceof Class, "Type is not class, expected class");
    }
    
    public void isNotClass() {
        isNotNull();
        process(compare instanceof Class, "Type is class, expected not class");
    }
    
    
    public void isParameterizedType() {
        isNotNull();
        process(compare instanceof ParameterizedType,
                "Type is not parameterize type: {}",
                compare.getClass().getName());
    }
    
    public void isNotParameterizedType() {
        isNotNull();
        process(!(compare instanceof ParameterizedType),
                "Type is parameterize type: {}",
                compare.getClass().getName());
    }
    
    public void isGenericArrayType() {
        isNotNull();
        process(compare instanceof GenericArrayType,
                "Type is not generic array type: {}",
                compare.getClass().getName());
    }
    
    public void isNotGenericArrayType() {
        isNotNull();
        process(!(compare instanceof GenericArrayType),
                "Type is generic array type: {}",
                compare.getClass().getName());
    }
    
    public void isWildcardType() {
        isNotNull();
        process(compare instanceof WildcardType,
                "Type is not wildcard type: {}",
                compare.getClass().getName());
    }
    
    public void isNotWildcardType() {
        isNotNull();
        process(!(compare instanceof WildcardType),
                "Type is wildcard type: {}",
                compare.getClass().getName());
    }
    
    public void isTypeVariable() {
        isNotNull();
        process(compare instanceof TypeVariable,
                "Type is not type variable: {}",
                compare.getClass().getName());
    }
    
    public void isNotTypeVariable() {
        isNotNull();
        process(!(compare instanceof TypeVariable),
                "Type is type variable: {}",
                compare.getClass().getName());
    }
}
