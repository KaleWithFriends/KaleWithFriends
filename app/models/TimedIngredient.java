package models;

import java.util.Calendar;

/**
 * Model for ingredients with time and price. Subclass of Ingredients.
 * <p/>
 * Created by Jack on 4/4/2015.
 */
public class TimedIngredient extends Ingredient {

  private Calendar startDate;
  private Calendar endDate;
  private String price;
  private String image;

  /**
   * Creates an ingredient object that also contains the time (freshness) and price.
   *
   * @param name      The name.
   * @param quantity  The quantity.
   * @param startDate The start date.
   * @param endDate   The end date.
   * @param price     The price.
   */
  public TimedIngredient(String name, int quantity, Calendar startDate, Calendar endDate, String price) {
    super(name, quantity);
    this.startDate = startDate;
    this.endDate = endDate;
    this.price = price;
  }


  /**
   * Creates an ingredient object that also contains the time (freshness) and price.
   *
   * @param name      The name.
   * @param quantity  The quantity.
   * @param startDate The start date.
   * @param endDate   The end date.
   * @param price     The price.
   * @param image     The image location.
   */
  public TimedIngredient(String name, int quantity, Calendar startDate, Calendar endDate, String price, String image) {
    super(name, quantity);
    this.startDate = startDate;
    this.endDate = endDate;
    this.price = price;
    this.image = image;
  }


  /**
   * Gets start date.
   *
   * @return The start date.
   */
  public Calendar getStartDate() {
    return startDate;
  }

  /**
   * Gets the end date.
   *
   * @return The end date.
   */
  public Calendar getEndDate() {
    return endDate;
  }

  /**
   * Gets the price.
   *
   * @return The price.
   */
  public String getPrice() {
    return price;
  }

  /**
   * Gets the image location.
   *
   * @return The image location as a string.
   */
  public String getImage() {
    return image;
  }
}
