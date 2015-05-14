package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Model for ingredients with time and price. Subclass of Ingredients.
 * <p>
 * Created by Jack on 4/4/2015.
 */
@Entity
public class TimedIngredient extends Model implements Comparable<TimedIngredient> {

  private Calendar startDate;
  private Calendar endDate;
  private String price;
  private String image;
  private String name;
  private int quantity;


  @ManyToOne
  private Farmer farmer;


  @ManyToOne

  private Recipe recipe;

  @Id
  private long id;

  /**
   * The EBean ORM finder method for database queries.
   *
   * @return The finder method.
   */
  public static Finder<Long, TimedIngredient> find() {
    return new Finder<Long, TimedIngredient>(Long.class, TimedIngredient.class);
  }

  /**
   * Creates an ingredient object with name and quantity.
   *
   * @param name     The name.
   * @param quantity The quantity.
   */
  public TimedIngredient(String name, int quantity) {
    this.name = name;
    this.quantity = quantity;
  }

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
    this.name = name;
    this.quantity = quantity;
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
    this.name = name;
    this.quantity = quantity;
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

  /**
   * Gets the name of the ingredient.
   *
   * @return The name.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the quantity of the ingredient.
   *
   * @return The quantity.
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Adds an amount to the quantity.
   *
   * @param add The amount of stock to add.
   */
  public void addQuantity(int add) {
    quantity = quantity + add;
    this.save();
  }

  /**
   * Subtracts an amount from the quantity.
   *
   * @param sub The amount of stock to subtract.
   */
  public void subtractQuantity(int sub) {
    if (quantity - sub >= 0) {
      quantity = quantity - sub;
      this.save();
    }
    //you cannot have a negative quantity
    else {
      quantity = 0;
      this.save();
    }
  }

  @Override
  public int compareTo(TimedIngredient other) {
    if (this.getId() < other.getId()) {
      return -1;
    }
    else {
      return 1;
    }
  }

  /**
   * Sets the start date.
   *
   * @param startDate the start date
   */
  public void setStartDate(Calendar startDate) {
    this.startDate = startDate;
  }

  /**
   * Sets the end date.
   *
   * @param endDate The end date.
   */
  public void setEndDate(Calendar endDate) {
    this.endDate = endDate;
  }

  /**
   * Sets the price.
   *
   * @param price The price.
   */
  public void setPrice(String price) {
    this.price = price;
  }

  /**
   * Sets the image path.
   *
   * @param image The image path.
   */
  public void setImage(String image) {
    this.image = image;
  }

  /**
   * Sets the name.
   *
   * @param name The name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the quantity.
   *
   * @param quantity The quantity.
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * Gets the id.
   *
   * @return The id of the ingredient.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the id of the ingredient.
   *
   * @param id The id to be set.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets the recipe.
   *
   * @return The recipe.
   */
  public Recipe getRecipe() {
    return recipe;
  }

  /**
   * Sets the recipe.
   *
   * @param recipe The recipe to set to.
   */
  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
  }


  /**
   * Gets the farmer.
   * @return the farmer
   */
  public Farmer getFarmer() {
    return farmer;
  }

  /**
   * Sets the farmer.
   * @param farmer the farmer
   */
  public void setFarmer(Farmer farmer) {
    this.farmer = farmer;
  }

  /**
   * Prints the date.
   * @return the string to print
   */
  public String printDate() {
    Calendar cal = endDate;
    if (cal != null) {
      SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
      String formatted = format1.format(cal.getTime());
      return formatted;
    }
    else {
      return null;
    }
  }
}


