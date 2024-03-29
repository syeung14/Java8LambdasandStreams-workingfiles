/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
***/
package fpij.designing.sample;

import java.util.List;
import java.util.stream.Stream;
import java.io.File;
import java.io.IOException;

public class HandleException {
  public static void main(String[] args) throws IOException {
    Stream.of("/usr", "/tmp")
//          .map(path -> new File(path).getCanonicalPath())         //uncomment to see the error
          .forEach(System.out::println);    
    //Error, this code will not compile
  }
}
