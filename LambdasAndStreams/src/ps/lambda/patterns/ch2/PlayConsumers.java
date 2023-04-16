package ps.lambda.patterns.ch2;

import java.util.function.Consumer;

public class PlayConsumers {

    public static void main(String[] args) {
        Consumer<String> c1 = s -> System.out.println("c1 = " + s);
        Consumer<String> c2 = s -> System.out.println("c2 = " + s);

        c1.accept("hello");
    }

}
