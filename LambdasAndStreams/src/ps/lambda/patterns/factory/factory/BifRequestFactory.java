package ps.lambda.patterns.factory.factory;

import java.util.function.Supplier;

public interface BifRequestFactory<T> extends Supplier<T> {
    default T newInstance() {
        return get();
    }

}
