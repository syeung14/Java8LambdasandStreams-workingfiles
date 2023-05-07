package ps.lambda.patterns.function;

import org.junit.Test;
import ps.lambda.patterns.model.Meteo;
import ps.lambda.patterns.model.Person;

public class TestConsumers {

    public static void main(String[] args) {

    }

    @Test
    public void testAndThen() {
        Consumer<String> c1 = s -> System.out.println("c1 = " + s);
        Consumer<String> c2 = s -> System.out.println("c2 = " + s);

        Consumer<String> c3 = c1.andThen(c2);

        c3.accept("sth");
    }

    @Test
    public void testFunction() {
        Function<Meteo, Integer> readCelsius = m -> m.getTemperature();
        Function<Integer, Double> cTof = t -> t * .9d / 5d + 32d;

        //a Function use two other Functions
        Function<Meteo, Double> readF = readCelsius.andThen(cTof);

        Meteo m = new Meteo(10);
        System.out.println("Meteo F " + readF.apply(m));

       readF = cTof.compose(readCelsius);
        System.out.println(readF.apply(m));

    }

    @Test
    public void onPredicates() {
        Predicate<String> p1 = s -> s != null;
        Predicate<String> p2 = s -> !s.isBlank();

        Predicate<String> p3 = p1.and(p2);
        System.out.println(p3.test("'"));
        System.out.println(p3.negate());

        Function<String, Integer> fn = s -> 30;

        Function<Person, String> getName = p -> p.getName();

        System.out.println(fn.apply("John"));
    }
}
