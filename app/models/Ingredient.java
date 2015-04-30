package models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * An entity for the user type. This entity has a one-to-many relation with users.
 */

@Entity
public class Ingredient extends play.db.ebean.Model {
  /** The id. */
  @Id
  private long id;

  /** The list of timed ingredients associated with this ingredient */
  @OneToMany(mappedBy = "ingredient", cascade = CascadeType.PERSIST)
  private List<TimedIngredient> timedIngredients;

  /** The type of user. */
  private String name;

  /**
   * Default constructor.
   *
   * @param name The user type to set
   */
  public Ingredient(String name) {
    this.name = name;
  }

  /**
   * The EBean ORM finder method for database queries.
   *
   * @return The finder method.
   */
  public static Finder<Long, Ingredient> find() {
    return new Finder<Long, Ingredient>(Long.class, Ingredient.class);
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
   * Get the id.
   *
   * @return the id.
   */
  public long getId() {
    return id;
  }

  /**
   * Get the ingredient name.
   *
   * @return the ingredient name.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the ingredient name.
   *
   * @param name the user type.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get the timed ingredients associated with this ingredient.
   *
   * @return The timed ingredients.
   */
  public List<TimedIngredient> getTimedIngredients() {
    return timedIngredients;
  }

  /**
   * Add an ingredient to the list of ingredients for bidirectional link.
   *
   * @param timedIngredient the ingredient to add.
   */
  public void addTimedIngredient(TimedIngredient timedIngredient) {
    timedIngredients.add(timedIngredient);
  }

  /**
   * Sets the list of timed ingredients.
   *
   * @param timedIngredients The list.
   */
  public void setTimedIngredients(List<TimedIngredient> timedIngredients) {
    this.timedIngredients = timedIngredients;
  }
}
