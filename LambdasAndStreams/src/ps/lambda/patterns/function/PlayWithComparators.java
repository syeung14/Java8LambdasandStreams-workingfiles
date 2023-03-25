package ps.lambda.patterns.function;

import ps.lambda.patterns.model.Person;

import java.util.function.Function;

public class PlayWithComparators {

    public static void main(String[] args) {
        Person mary = new Person("Mary", 28);
        Person john = new Person("John", 22);
        Person linda = new Person("Linda", 26);
        Person james = new Person("James", 32);
        Person jamesBis = new Person("James", 26);


        Function<Person, String> getName = p -> p.getName();
        Function<Person, Integer> getAge = p -> p.getAge();
        Comparator<Person> cmpName = Comparator.comparing(getName);
        Comparator<Person> cmpAge = Comparator.comparing(getAge);

        Comparator<Person> cmp = Comparator.comparing(Person::getName)
                                               .thenComparing(Person::getAge);

        System.out.println(cmpName.reversed());
    }

}
