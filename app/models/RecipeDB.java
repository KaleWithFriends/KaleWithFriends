package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Recipe database to hold all the recipes.
 * Created by Jack on 4/4/2015.
 */


public class RecipeDB {
  /**
   * Adds a recipe to the database.
   *
   * @param recipe The recipe.
   * @return The index of the item added. This should be saved for future reference.
   */
  public static void addRecipe(Recipe recipe) {
    for (TimedIngredient ti : recipe.getTimedIngredients()) {
      ti.setRecipe(recipe);
      ti.save();
    }
    recipe.save();
  }

  /**
   * Gets a recipe given the id.
   *
   * @param id The farmer id.
   * @return The corresponding recipe.
   */
  public static Recipe getRecipe(long id) {
    Recipe r = Recipe.find().byId(id);

    if (r == null) {
      throw new RuntimeException();
    }
    return r;
  }

  /**
   * Gets a list of all the recipes.
   *
   * @return The list of recipes.
   */
  public static List<Recipe> getRecipes() {
    return Recipe.find().all();
  }

  /**
   * Gets a list of recipes that is currently available with fresh ingredients.
   *
   * @return The list of recipes that can be made with fresh ingredients.
   */
  public static List<Recipe> getFreshRecipeList() {
    // All fresh ingredients available currently from farmers
    List<Ingredient> freshIngredients = new ArrayList<>();

    // Finds the complete list of all ingredients from each farmer.
    // Optimize by checking for duplicate entries.
    for (KaleUser farmer : UserDB.getUsers("Farmer")) {
      for (Ingredient ingredient : farmer.getIngredients()) {
        freshIngredients.add(ingredient);
      }
    }

    return IngredientsToRecipe.getRecipesFromIngredients(freshIngredients);
  }
}
