package ps.lambda.patterns.ch4;

import ps.lambda.patterns.model.Circle;

import java.util.List;
import java.util.function.Supplier;

public class PlayWithFactory {

    public static void main(String[] args) {
        playerOne();
    }

    static void playerOne() {
        CircleFactory factory = () -> new Circle();

        System.out.println(factory.newInstance());
        List<Circle> lst = factory.create5Circles();

        lst.stream().forEach(System.out::println);

    }
}
