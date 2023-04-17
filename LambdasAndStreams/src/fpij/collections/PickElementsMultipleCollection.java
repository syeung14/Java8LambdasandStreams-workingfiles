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
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import static fpij.collections.Folks.comrades;
import static fpij.collections.Folks.editors;
import static fpij.collections.Folks.friends;


public class PickElementsMultipleCollection {

    final Function<String, Predicate<String>> startWith =
        (String letter) -> {
            return (String name) -> name.startsWith(letter);
        };

    static void pickName(List<String> names, String startLetter) {
        final Optional<String> foundName = names.stream()
            .filter(n -> n.startsWith(startLetter))
            .findFirst();

        System.out.println(String.format("%s : %s", startLetter, foundName.orElse("no found")));

        foundName.ifPresent(n -> System.out.println("hi " + n));
    }

    public static void main(final String[] args) {
        {
            final long countFriendsStartN =
                friends.stream()
                       .filter(name -> name.startsWith("N")).count();

            final long countEditorsStartN =
                editors.stream()
                       .filter(name -> name.startsWith("N")).count();

            final long countComradesStartN =
                comrades.stream()
                        .filter(name -> name.startsWith("N")).count();

            System.out.println(countFriendsStartN);
            System.out.println(countComradesStartN);
            System.out.println(countEditorsStartN);
        }

        {
            final Predicate<String> preName = name -> name.startsWith("X");
            friends.stream()
                   .filter(preName)
                   .count();

        }
        {
            final Predicate<String> startsWithN = name -> name.startsWith("N");

            final long countFriendsStartN =
                friends.stream()
                       .filter(startsWithN)
                       .count();
            final long countEditorsStartN =
                editors.stream()
                       .filter(startsWithN)
                       .count();
            final long countComradesStartN =
                comrades.stream()
                        .filter(startsWithN)
                        .count();

            System.out.println(countFriendsStartN);
            System.out.println(countComradesStartN);
            System.out.println(countEditorsStartN);
        }
    }
}
