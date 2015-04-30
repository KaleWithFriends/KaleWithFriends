package models;

import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
/**
 * Model for ingredients with time and price.
 *
 * Created by Jack on 4/4/2015.
 */
@Entity
public class TimedIngredient extends play.db.ebean.Model {
  /** The id. */
  @Id
  private long id;

  /** The ingredient. */
  @ManyToOne(cascade = CascadeType.PERSIST)
  private Ingredient ingredient;

  /** The user that owns this ingredient */
  @ManyToOne(cascade = CascadeType.PERSIST)
  private KaleUser kaleUser;

  /** The recipes that uses this ingredient. */
  @ManyToOne(cascade = CascadeType.PERSIST)
  private Recipe recipe;

  /** The start date for the ingredient. */
  private Calendar startDate;
  /** The end date for the ingredient. */
  private Calendar endDate;
  /** The price of the ingredient per unit. */
  private String price;
  /** The quantity available. */
  private int quantity;

  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method.
   */
  public static Finder<Long, TimedIngredient> find() {
    return new Finder<Long, TimedIngredient>(Long.class, TimedIngredient.class);
  }

  /**
   * Creates an ingredient object that also contains the time (freshness) and price.
   *
   * @param ingredient The ingredient.
   * @param quantity  The quantity.
   * @param startDate The start date.
   * @param endDate   The end date.
   * @param price     The price.
   */
  public TimedIngredient(Ingredient ingredient, int quantity, Calendar startDate, Calendar endDate, String price) {
    this.ingredient = ingredient;
    this.quantity = quantity;
    this.startDate = startDate;
    this.endDate = endDate;
    this.price = price;
  }

  /**
   * Creates an ingredient object that also contains the time (freshness) and price.
   *
   * @param ingredient The string name of an ingredient.
   * @param quantity  The quantity.
   * @param startDate The start date.
   * @param endDate   The end date.
   * @param price     The price.
   */
  public TimedIngredient(String ingredient, int quantity, Calendar startDate, Calendar endDate, String price) {
    this.ingredient = IngredientDB.getIngredient(ingredient);
    this.quantity = quantity;
    this.startDate = startDate;
    this.endDate = endDate;
    this.price = price;
  }


  /**
   * Get the id.
   *
   * @return The Id.
   */
  public long getId() {
    return id;
  }

  /**
   * Set the id.
   *
   * @param id The id.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Get the ingredient object.
   *
   * @return The ingredient.
   */
  public Ingredient getIngredient() {
    return ingredient;
  }

  /**
   * Set the ingredient object.
   *
   * @param ingredient The ingredient.
   */
  public void setIngredient(Ingredient ingredient) {
    this.ingredient = ingredient;
  }

  /**
   * Get the user that owns this ingredient.
   *
   * @return The user.
   */
  public KaleUser getKaleUser() {
    return kaleUser;
  }

  /**
   * Set the user that owns this ingredient.
   *
   * @param kaleUser The user.
   */
  public void setKaleUser(KaleUser kaleUser) {
    this.kaleUser = kaleUser;
  }

  /**
   * Get the recipe that uses this ingredient.
   *
   * @return The recipe.
   */
  public Recipe getRecipe() {
    return recipe;
  }

  /**
   * Set the recipe of this ingredient.
   *
   * @param recipe The recipe.
   */
  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
  }

  /**
   * Get the start date.
   *
   * @return The start date.
   */
  public Calendar getStartDate() {
    return startDate;
  }

  /**
   * Set the start date.
   *
   * @param startDate The start date.
   */
  public void setStartDate(Calendar startDate) {
    this.startDate = startDate;
  }

  /**
   * Get the end date.
   *
   * @return The end date.
   */
  public Calendar getEndDate() {
    return endDate;
  }

  /**
   * Set the end date.
   * @param endDate The end date.
   */
  public void setEndDate(Calendar endDate) {
    this.endDate = endDate;
  }

  /**
   * Get the price.
   *
   * @return The price.
   */
  public String getPrice() {
    return price;
  }

  /**
   * Set the price.
   *
   * @param price The price.
   */
  public void setPrice(String price) {
    this.price = price;
  }

  /**
   * Get the quantity.
   *
   * @return The quantity.
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Set the quantity.
   *
   * @param quantity The quantity.
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
