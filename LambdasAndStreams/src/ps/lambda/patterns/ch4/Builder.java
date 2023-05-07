package ps.lambda.patterns.ch4;

@FunctionalInterface
public interface Builder<T> {

    void register(String label, Factory<T> factory);

}
