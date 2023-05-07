package ps.lambda.patterns.function;

import java.util.Objects;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
    default Predicate<T> and(Predicate<T> o) {
        Objects.requireNonNull(o);
        return (T t) -> this.test(t) && o.test(t);
    }

    default Predicate<T> negate() {
        return (T t) -> !this.test(t);
    }
}
