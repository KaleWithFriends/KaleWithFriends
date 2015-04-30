package models;

import java.util.List;

/**
 * Ingredient database to hold all the ingredients and timed ingredients.
 * Created by Will on 4/29/2015.
 */


public class IngredientDB {
  /**
   * Adds a ingredient to the database.
   *
   * @param ingredient The ingredient.
   * @return The index of the item added. This should be saved for future reference.
   */
  public static void addIngredient(Ingredient ingredient) {
    ingredient.save();
  }

  /**
   * Adds a timed ingredient to the database.
   * @param timedIngredient The timed ingredient.
   */
  public static void addTimedIngredient(TimedIngredient timedIngredient) {
    timedIngredient.save();
  }
  /**
   * Gets a ingredient given the id.
   *
   * @param id The farmer id.
   * @return The corresponding ingredient.
   */
  public static Ingredient getIngredient(long id) {
    Ingredient i = Ingredient.find().byId(id);

    if (i == null) {
      throw new RuntimeException();
    }
    return i;
  }

  public static Ingredient getIngredient(String name) {
    Ingredient i = Ingredient.find().where().eq("name", name).findUnique();

    if (i == null) {
      throw new RuntimeException();
    }

    return i;
  }

  /**
   * Gets a list of all the ingredients.
   *
   * @return The list of ingredients.
   */
  public static List<Ingredient> getIngredients() {
    return Ingredient.find().all();
  }

  /**
   * Get a list of all timed ingredients.
   * @return The list of timed ingredients.
   */
  public static List<TimedIngredient> getTimedIngredients() {
    return TimedIngredient.find().all();
  }
}
