package in.kyle.api.verify.types;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

import in.kyle.api.verify.NonNullPredicate;

/**
 * Created by Kyle on 3/23/2017.
 */
public class TypePredicate extends NonNullPredicate<Type> {
    
    public TypePredicate(Type compare) {
        super(compare);
    }
    
    public void isClass() {
        process(compare instanceof Class, "Type is not class, expected class");
    }
    
    public void isNotClass() {
        process(compare instanceof Class, "Type is class, expected not class");
    }
    
    
    public void isParameterizedType() {
        process(compare instanceof ParameterizedType,
                "Type is not parameterize type: {}",
                compare.getClass().getName());
    }
    
    public void isNotParameterizedType() {
        process(!(compare instanceof ParameterizedType),
                "Type is parameterize type: {}",
                compare.getClass().getName());
    }
    
    public void isGenericArrayType() {
        process(compare instanceof GenericArrayType,
                "Type is not generic array type: {}",
                compare.getClass().getName());
    }
    
    public void isNotGenericArrayType() {
        process(!(compare instanceof GenericArrayType),
                "Type is generic array type: {}",
                compare.getClass().getName());
    }
    
    public void isWildcardType() {
        process(compare instanceof WildcardType,
                "Type is not wildcard type: {}",
                compare.getClass().getName());
    }
    
    public void isNotWildcardType() {
        process(!(compare instanceof WildcardType),
                "Type is wildcard type: {}",
                compare.getClass().getName());
    }
    
    public void isTypeVariable() {
        process(compare instanceof TypeVariable,
                "Type is not type variable: {}",
                compare.getClass().getName());
    }
    
    public void isNotTypeVariable() {
        process(!(compare instanceof TypeVariable),
                "Type is type variable: {}",
                compare.getClass().getName());
    }
}
