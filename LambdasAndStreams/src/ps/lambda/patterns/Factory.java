package ps.lambda.patterns;

import ps.lambda.patterns.model.Circle;

import java.awt.*;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Factory<T> extends Supplier<T> {
    default T newInstance() {
        return get();
    }

    default List<T> get5Circles() {
        return IntStream.range(0, 5)
            .mapToObj(i -> newInstance())
            .collect(Collectors.toList());
    }

    static Factory<Circle> createFactory() {
        return () -> new Circle();
    }

//    static Factory<Circle> createFactory(Color color) {
//        Function<Color, Circle> constructor = c -> new Circle();
//        return () -> constructor.apply(color);
//    }

//    static Factory<Circle> createFactory(Function<Color, Circle> fn, Color color) {
//        return () -> fn.apply(color);
//    }

    static <T, R> Factory<R> createFactory(Function<T, R> fn, T color) {
        return () -> fn.apply(color);
    }
    static <T> Factory<T> createFactory(Supplier<T> supplier) {
        return () -> supplier.get();
    }

}
