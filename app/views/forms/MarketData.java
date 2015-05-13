package views.forms;

import models.Market;
import models.MarketDB;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jack on 5/13/2015.
 */
public class MarketData {


  private static List<Market> types = MarketDB.getMarkets();


  /**
   * Makes map of diet types initialized to false.
   *
   * @return The diet type map.
   */
  public static Map<Market, Boolean> getMarkets() {
    Map<Market, Boolean> marketMap = new HashMap<Market, Boolean>();
    for (Market market : types) {
      marketMap.put(market, false);
    }

    return marketMap;
  }

  /**
   * Checks if type is in diet type map.
   *
   * @param type The type to check
   * @return True if in map, false otherwise.
   */
  public static Boolean isMarket(Market type) {
    return getMarkets().containsKey(type);
  }

  /**
   * Makes map of diet type where one type is set to true.
   *
   * @param market The type to set true.
   * @return The diet type map.
   */
  public static Map<Market, Boolean> getMarkets(Market market) {
    Map<Market, Boolean> marketMap = getMarkets();
    if (isMarket(market)) {
      marketMap.put(market, true);
    }

    return marketMap;
  }

  /**
   * Makes map of diet type where one type is set to true.
   *
   * @param types The types to set true.
   * @return The diet type map.
   */
  public static Map<Market, Boolean> getMarkets(List<Market> types) {
    Map<Market, Boolean> marketMap = getMarkets();

    for (Market market : types) {
      if (isMarket(market)) {
        marketMap.put(market, true);
      }
    }

    return marketMap;
  }
}
