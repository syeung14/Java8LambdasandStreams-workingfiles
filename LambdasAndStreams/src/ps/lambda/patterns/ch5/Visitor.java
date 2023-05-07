package ps.lambda.patterns.ch5;

public interface Visitor<R> {
    R visit(Object o);
}
