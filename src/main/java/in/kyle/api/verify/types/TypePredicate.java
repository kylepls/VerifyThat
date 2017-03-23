package in.kyle.api.verify.types;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

import in.kyle.api.verify.Predicate;
import in.kyle.api.verify.Result;

/**
 * Created by Kyle on 3/23/2017.
 */
public class TypePredicate extends Predicate<Type> {
    
    public TypePredicate(Type compare) {
        super(compare);
    }
    
    public Result isClass() {
        return result(compare instanceof Class, "Type is not class, expected class");
    }
    
    public Result isNotClass() {
        return result(compare instanceof Class, "Type is class, expected not class");
    }
    
    
    public Result isParameterizedType() {
        return result(compare instanceof ParameterizedType,
                      "Type is not parameterize type: {}",
                      compare.getClass().getName());
    }
    
    public Result isNotParameterizedType() {
        return result(!(compare instanceof ParameterizedType),
                      "Type is parameterize type: {}",
                      compare.getClass().getName());
    }
    
    public Result isGenericArrayType() {
        return result(compare instanceof GenericArrayType,
                      "Type is not generic array type: {}",
                      compare.getClass().getName());
    }
    
    public Result isNotGenericArrayType() {
        return result(!(compare instanceof GenericArrayType),
                      "Type is generic array type: {}",
                      compare.getClass().getName());
    }
    
    public Result isWildcardType() {
        return result(compare instanceof WildcardType,
                      "Type is not wildcard type: {}",
                      compare.getClass().getName());
    }
    
    public Result isNotWildcardType() {
        return result(!(compare instanceof WildcardType),
                      "Type is wildcard type: {}",
                      compare.getClass().getName());
    }
    
    public Result isTypeVariable() {
        return result(compare instanceof TypeVariable,
                      "Type is not type variable: {}",
                      compare.getClass().getName());
    }
    
    public Result isNotTypeVariable() {
        return result(!(compare instanceof TypeVariable),
                      "Type is type variable: {}",
                      compare.getClass().getName());
    }
}
