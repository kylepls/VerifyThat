package in.kyle.api.verify.types.reflect;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ReflectModifier {
    PUBLIC(0x00000001),
    PRIVATE(0x00000002),
    PROTECTED(0x00000004),
    STATIC(0x00000008),
    FINAL(0x00000010),
    SYNCHRONIZED(0x00000020),
    VOLATILE(0x00000040),
    TRANSIENT(0x00000080),
    NATIVE(0x00000100),
    INTERFACE(0x00000200),
    ABSTRACT(0x00000400),
//    STRICT(0x00000800), -- unpredictable
    BRIDGE(0x00000040),
    VARARGS(0x00000080),
    SYNTHETIC(0x00001000),
    ANNOTATION(0x00002000),
    ENUM(0x00004000),
    MANDATED(0x00008000);
    
    @Getter
    private final int value;
    
    public boolean isPresent(int mod) {
        return (mod & value) != 0;
    }
    
    public static Collection<ReflectModifier> getAll(int mod) {
        return Stream.of(values()).filter(m -> m.isPresent(mod)).collect(Collectors.toSet());
    }
}