package ps.lambda.patterns.ch5;

import java.util.function.Function;

@FunctionalInterface
public interface VisitorBuilder<R> {
    void register(Class<?> type, Function<Object, R> function);
}
