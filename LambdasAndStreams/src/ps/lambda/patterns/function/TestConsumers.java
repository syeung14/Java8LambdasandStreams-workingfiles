package ps.lambda.patterns.function;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class TestConsumers {

    public static void main(String[] args) {
        Consumer<String> c1 = s -> System.out.println("c1 = " + s);
        Consumer<String> c2 = s -> System.out.println("c2 = " + s);

        Consumer<String> c3 = s -> {
            c1.accept(s);
            c2.accept(s);
        };


        c3.accept("hihihi");
    }

    @Test
    public void onPredicates() {
        Predicate<String> p1 = s -> s != null;

        System.out.println(p1.test("'"));

        Function<String, Integer> fn = s -> 30;

        System.out.println(fn.apply("John"));
    }
}
