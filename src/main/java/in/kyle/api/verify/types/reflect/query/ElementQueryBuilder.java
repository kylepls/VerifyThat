package in.kyle.api.verify.types.reflect.query;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import in.kyle.api.verify.Predicate;
import in.kyle.api.verify.Verify;
import in.kyle.api.verify.types.CollectionPredicate;
import in.kyle.api.verify.types.reflect.ReflectModifier;

public abstract class ElementQueryBuilder<T extends AnnotatedElement, R extends 
        ElementQueryBuilder<T, R>>
        extends Predicate<Class<?>, R> {
    
    final Collection<T> elements = new HashSet<>();
    
    ElementQueryBuilder(Class<?> compare, String named) {
        super(compare, named);
    }
    
    abstract int getModifiers(T t);
    
    abstract String getName(T t);
    
    abstract Class<?> getType(T t);
    
    abstract String getErrorName();
    
    @SafeVarargs
    public final R hasAnnotation(Class<? extends Annotation>... annotations) {
        for (Class<? extends Annotation> annotation : annotations) {
            removeElements(t -> t.isAnnotationPresent(annotation),
                           "hasAnnotation=" + annotation.getName(),
                           getAnnotationClasses());
        }
        return (R) this;
    }
    
    private Collection<Class<?>> getAnnotationClasses() {
        return Stream.of(compare.getAnnotations())
                     .map(Annotation::getClass)
                     .collect(Collectors.toSet());
    }
    
    public R typeIs(Class<?> type) {
        removeElements(t -> getType(t).equals(type), "typeIs=" + type.getName(), false);
        return (R) this;
    }
    
    public R nameIs(String name) {
        removeElements(t -> getName(t).equals(name), "nameIs=" + name, false);
        return (R) this;
    }
    
    public R isPublic() {
        removeElements(t -> ReflectModifier.PUBLIC.isPresent(getModifiers(t)), "public", false);
        return (R) this;
    }
    
    public R isPrivate() {
        removeElements(t -> ReflectModifier.PRIVATE.isPresent(getModifiers(t)), "private", false);
        return (R) this;
    }
    
    public R isProtected() {
        removeElements(t -> ReflectModifier.PROTECTED.isPresent(getModifiers(t)),
                       "protected",
                       false);
        return (R) this;
    }
    
    public CollectionPredicate<T> getMatched() {
        return Verify.that(elements);
    }
    
    void removeElements(Function<T, Boolean> function, String expected, Object actual) {
        elements.removeIf(t -> !function.apply(t));
        process(elements.size() != 0, "match for (" + expected + ") on " + getErrorName(), actual);
    }
}
