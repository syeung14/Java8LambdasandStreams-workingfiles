/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package fpij.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static fpij.collections.Folks.friends;

public class Iteration {

    public static void test() {
        List<String> up = new ArrayList<>();
        friends.forEach(n -> up.add(n.toUpperCase()));
        System.out.println(up);

        friends.stream()
            .map(n -> n.toUpperCase() + ":"+ n.length())
            .forEach(n -> System.out.print(n + " "));


        friends.stream()
            .filter(n -> n.startsWith("N"))
            .forEach(System.out::println);
    }

    public static void main(final String[] args) {
        test();
    }

    static void testorg() {
        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }

        for (String name : friends) {
            System.out.println(name);
        }

        System.out.println("//" + "START:INTERNAL_FOR_EACH_OUTPUT");

        friends.forEach(new Consumer<String>() {

            public void accept(final String name) {
                System.out.println(name);
            }
        });

        System.out.println("//" + "END:INTERNAL_FOR_EACH_OUTPUT");

        System.out.println("//" + "START:INTERNAL_OUTPUT");
        friends.forEach((final String name) -> System.out.println(name));
        System.out.println("//" + "END:INTERNAL_OUTPUT");

        friends.forEach((name) -> System.out.println(name));

        friends.forEach(name -> System.out.println(name));

        friends.forEach(System.out::println);
    }
}
