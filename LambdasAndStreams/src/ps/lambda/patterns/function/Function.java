package ps.lambda.patterns.function;

import ps.lambda.patterns.model.Meteo;

import java.util.Objects;

@FunctionalInterface
public interface Function <T, R>{
    R apply(T t);

    default <V> Function<T, V> andThen(Function<R, V> o) {
        Objects.requireNonNull(o);
        return (T t) -> {
            R r = this.apply(t); //for this so uses <T, R>
            return o.apply(r); //V is new after applying T,R
        };
    }

    default <V> Function<V, R> compose(Function<V, T> o) {

        return (V v) -> {
            T t = o.apply(v);
            return this.apply(t);
        };
    }
    static <T> Function<T, T> identity() {
        return t -> t;
    }
}
