package controllers;

import models.Farmer;
import models.FarmerDB;
import models.FeedDB;
import models.RecipeDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.forms.FeedDataForm;
import views.html.AvailableNow;
import views.html.Cookbook;
import views.html.FarmersDashboard;
import views.html.FarmersProfile;
import views.html.Index;
import views.html.Local;
import views.html.MealPlanner;
import views.html.NewFeed;
import views.html.Recipe;
import views.html.SignUp;
import views.loginData.LoginData;
import views.loginData.SignUpForm;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page.
   *
   * @param username the current user, if there is one
   * @return The resulting home page.
   */
  public static Result index(String username) {
    if (username == null) {
      LoginData data = new LoginData();

      Form<LoginData> formData = Form.form(LoginData.class).fill(data);
      return ok(Index.render(formData));
    }
    Farmer data = Farmer.getFarmer(username);
    return ok(FarmersDashboard.render(FarmerDB.getFarmer(data.getName())));


  }

  /**
   * Processes the form submitted from the Login page.
   *
   * @return The appropriate user home page
   */
  public static Result login() {
    Form<LoginData> formData = Form.form(LoginData.class).bindFromRequest();
    if (formData.hasErrors()) {
      System.out.println("Errors found.");
      return badRequest(Index.render(formData));
    }
    LoginData data = formData.get();
    System.out.println("OK: " + data.name + " " + data.password);
    session("username", data.name);
    return ok(FarmersDashboard.render(FarmerDB.getFarmer(data.name)));
  }

  /**
   * Logs the current user out.
   *
   * @return The login page
   */
  public static Result logout() {
    session().clear();
    flash("success", "You've been logged out");
    return index(null);
  }


  /**
   * Returns the sign up page.
   *
   * @return The resulting sign up page.
   */
  public static Result signUp() {
    SignUpForm data = new SignUpForm();

    Form<SignUpForm> formData = Form.form(SignUpForm.class).fill(data);
    return ok(SignUp.render(formData));
  }

  /**
   * Processes a new user form.
   *
   * @return The new user's dashboard.
   */
  public static Result postSignUp() {
    Form<SignUpForm> formData = Form.form(SignUpForm.class).bindFromRequest();
    if (formData.hasErrors()) {
      System.out.println("Errors found.");
      return badRequest(SignUp.render(formData));
    }
    SignUpForm data = formData.get();
    System.out.println("OK: " + data.name + " " + data.password);
    session("username", data.name);
    FarmerDB.addFarmer(new Farmer(data.name, data.location));
    return ok(FarmersDashboard.render(FarmerDB.getFarmer(data.name)));

  }


  /**
   * Returns the Farmer's profile page.
   *
   * @param name The name of the farmer.
   * @return The resulting Farmer's profile page.
   */
  public static Result farmersProfile(String name) {
    Farmer farmer = FarmerDB.getFarmer(name);
    return ok(FarmersProfile.render(farmer));
  }

  /**
   * Returns the cookbook page.
   *
   * @return The resulting cookbook page.
   */
  public static Result cookbook() {
    //return ok(Cookbook.render(RecipeDB.getRecipe()));
    return ok(Cookbook.render(RecipeDB.getRecipe()));
  }

  /**
   * Returns the recipe page.
   *
   * @param id The id for the recipe.
   * @return The resulting recipe page.
   */
  public static Result recipe(long id) {
    ArrayList<models.Recipe> r = new ArrayList<>();
    r.add(RecipeDB.getRecipe(id));

    return ok(Recipe.render(r));
  }

  /**
   * Returns the local page.
   *
   * @return The resulting local page.
   */
  public static Result local() {
    List<String> addresses = new ArrayList<>();

    for (Farmer f : FarmerDB.getFarmers()) {
      addresses.add(f.getName() + "|" + f.getLocation());
    }

    return ok(Local.render("Welcome to local.", addresses));
  }

  /**
   * Returns the Meal Planner page.
   *
   * @return The resulting Meal Planner page.
   */
  public static Result mealPlanner() {
    return ok(MealPlanner.render("Welcome to Meal Planner.", RecipeDB.getFreshRecipeList()));
  }


  /**
   * Returns the available now page.
   *
   * @return The resulting available now page.
   */
  public static Result availableNow() {
    return ok(AvailableNow.render(FarmerDB.getFarmers()));
  }

  /**
   * Deletes the ingredient from the farmer's stock.
   *
   * @param farmer     the current farmer
   * @param ingredient the ingredient to delete
   * @return Result the resulting page
   */
  public static Result deleteIngredient(String farmer, long ingredient) {
    Farmer.deleteIngredient(farmer, ingredient);
    return ok(FarmersDashboard.render(Farmer.findFarmer(farmer)));
  }

  //public static Result editStock(TimedIngredient ingredient) {

  //
  // }

  /**
   * Adds just one quantity to the ingredient.
   *
   * @param farmer     the current farmer name
   * @param ingredient the ingredient to increment
   * @return the Dashboard with the new ingredient amount
   */
  public static Result addOne(String farmer, long ingredient) {

    Farmer.addOneToIngredient(farmer, ingredient);
    return ok(FarmersDashboard.render(Farmer.findFarmer(farmer)));
  }

  /**
   * Subtracts just one quantity from the ingredient.
   *
   * @param farmer     the current farmer name
   * @param ingredient the ingredient to subtract
   * @return the Dashboard with the new ingredient amount
   */
  public static Result subOne(String farmer, long ingredient) {
    Farmer.subtractOneToIngredient(farmer, ingredient);
    return ok(FarmersDashboard.render(Farmer.findFarmer(farmer)));
  }


  public static Result newFeed(){
    FeedDataForm data = new FeedDataForm();
    Form<FeedDataForm> formData = Form.form(FeedDataForm.class).fill(data);
    return ok(NewFeed.render(formData));
  }


  /**
   * Processes form fields from new feed page.
   *
   * @return The NewFeed.
   */
  public static Result postFeed() {
    System.out.println("In post Feed.");
    Form<FeedDataForm> formData = Form.form(FeedDataForm.class).bindFromRequest();
    if (formData.hasErrors()) {
      System.out.println("Form has errors.");
      return badRequest(NewFeed.render(formData));
    }
    else {
      FeedDataForm data = formData.get();
      FeedDB.addFeed(data);
      return ok(NewFeed.render(formData));
    }
  }
}
