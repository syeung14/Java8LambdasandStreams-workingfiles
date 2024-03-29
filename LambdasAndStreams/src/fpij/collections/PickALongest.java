/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package fpij.collections;

import java.util.List;
import java.util.Arrays;
import java.util.Optional;

import static fpij.collections.Folks.friends;

public class PickALongest {

    public static void testOrg() {
        {
            System.out.println("//" + "START:SUM_OUTPUT");
            System.out.println("Total number of characters in all names: " +
                friends.stream()
                       .mapToInt(name -> name.length())
                       .sum());
        }
        System.out.println("//" + "END:SUM_OUTPUT");

        System.out.println("//" + "END:AVERAGE_OUTPUT");
        System.out.println("//" + "START:REDUCE_OUTPUT");
        final Optional<String> aLongName =
            friends.stream()
                   .reduce((name1, name2) ->
                       name1.length() >= name2.length() ? name1 : name2);
        aLongName.ifPresent(name ->
            System.out.println(String.format("A longest name: %s", name)));
        System.out.println("//" + "END:REDUCE_OUTPUT");

        final String steveOrLonger =
            friends.stream()
                   .reduce("Steve", (name1, name2) ->
                       name1.length() >= name2.length() ? name1 : name2);

        System.out.println(steveOrLonger);
    }

    public static void main(final String[] args) {
        test();
    }

    static void test() {
        friends.stream()
               .mapToInt(n -> n.length())
               .sum();
    }

    static void test2() {
        Optional<String> alname = friends.stream()
                                         .reduce((n1, n2) -> n1.length() >= n2.length() ? n1 : n2);

        alname.ifPresent(n -> System.out.println(String.format("% ", n)));
    }
}
