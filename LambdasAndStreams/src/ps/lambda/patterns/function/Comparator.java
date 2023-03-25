package ps.lambda.patterns.function;

import ps.lambda.patterns.model.Person;

import java.util.Objects;
import java.util.function.Function;

public interface Comparator<T> {

    static <T, U extends Comparable> Comparator<T> comparing(Function<T, U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (p1, p2) -> {
            U n1 = keyExtractor.apply(p1);
            U n2 = keyExtractor.apply(p2);
            return n1.compareTo(n2);
        };
    }

    default Comparator<T> reversed() {
        return (t1, t2) -> this.compare(t2, t1);
    }

    int compare(T t1, T t2);

    default Comparator<T> thenComparing(Comparator<T> other) {
        return (T t1, T t2) -> {
            int comp = this.compare(t1, t2);
            if (comp == 0) {
                return other.compare(t1, t2);
            }
            return comp;
        };
    }

    default <U extends Comparable<U>> Comparator<T> thenComparing(Function<T, U> key) {
        Objects.requireNonNull(key);
        Comparator<T> other = comparing(key);
        return this.thenComparing(other);
    }
}
