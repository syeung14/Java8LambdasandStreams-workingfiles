/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package fpij.compare;

import java.util.StringJoiner;

class CharObj {
    String printIt(int ch) {
        System.out.println((char)ch);
        return (char)ch + "-";
    }
}
public class IterateString {

    private static void printChar(int aChar) {
        System.out.println((char) (aChar));
    }

    static void test() {
        final String str = "w00t";

//        str.chars().forEach( c -> System.out.println((char)c));
//        str.chars().forEach(IterateString::printChar);

        str.chars()
            .mapToObj(ch -> new CharObj().printIt(ch))
            .forEach(System.out::println);


    }

    public static void main(String[] args) {
        test();
    }

    static void testOrg() {
        System.out.println("//" + "START:ITERATE_OUTPUT");

        final String str = "w00t";

        str.chars()
           .forEach(ch -> System.out.println(ch));
        System.out.println("//" + "END:ITERATE_OUTPUT");

        str.chars()
           .forEach(System.out::println);

        System.out.println("//" + "START:FIX_OUTPUT");
        str.chars()
           .forEach(IterateString::printChar);
        System.out.println("//" + "END:FIX_OUTPUT");

        str.chars()
           .mapToObj(ch -> Character.valueOf((char) ch))
           .forEach(System.out::println);

        System.out.println("//" + "START:FILTER_OUTPUT");
        str.chars()
           .filter(ch -> Character.isDigit(ch))
           .forEach(ch -> printChar(ch));
        System.out.println("");
        System.out.println("//" + "END:FILTER_OUTPUT");

        str.chars()
           .filter(ch -> Character.isDigit(ch));

        str.chars()
           .filter(Character::isDigit);

        str.chars()
           .filter(Character::isDigit)
           .forEach(IterateString::printChar);

    }
}
