/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
***/
package fpij.designing;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AssetUtil {
  public static int totalAssetValues(final List<Asset> assets) {
    return assets.stream()
                 .mapToInt(Asset::getValue)
                 .sum();
  }

  public static int totalBondValues(final List<Asset> assets) {
    return assets.stream()
                 .mapToInt(asset -> 
                    asset.getType() == Asset.AssetType.BOND ? asset.getValue() : 0)
                 .sum();
  }

  public static int totalStockValues(final List<Asset> assets) {
    return assets.stream()
                 .mapToInt(asset -> 
                    asset.getType() == Asset.AssetType.STOCK ? asset.getValue() : 0)
                 .sum();
  }

  static int common(final List<Asset> assets, final Predicate<Asset> assetSelector) {
    return assets.stream()
        .filter(assetSelector)
        .mapToInt(Asset::getValue)
        .sum();

  }

  static void testCommon() {
    System.out.println("total value: " + common(assets, a -> true)); //always true
    System.out.println("total bonds: " + common(assets, a -> a.getType() == Asset.AssetType.BOND));
  }

  final static List<Asset> assets = Arrays.asList(
      new Asset(Asset.AssetType.BOND, 1000),
      new Asset(Asset.AssetType.BOND, 2000),
      new Asset(Asset.AssetType.STOCK, 3000),
      new Asset(Asset.AssetType.STOCK, 4000)
  );

  public static void main(final String[] args) {

    System.out.println("//" + "START:TOTAL_ALL_OUTPUT");
    System.out.println("Total of all assets: " + totalAssetValues(assets));
    System.out.println("//" + "END:TOTAL_ALL_OUTPUT");

    System.out.println("//" + "START:TOTAL_BONDS_OUTPUT");
    System.out.println("Total of bonds: " + totalBondValues(assets));
    System.out.println("//" + "END:TOTAL_BONDS_OUTPUT");

    System.out.println("//" + "START:TOTAL_STOCKS_OUTPUT");
    System.out.println("Total of stocks: " + totalStockValues(assets));      
    System.out.println("//" + "END:TOTAL_STOCKS_OUTPUT");
  }
}
