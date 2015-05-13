package controllers;

import models.Farmer;
import models.FarmerDB;
import models.Feed;
import models.FeedDB;
import models.Market;
import models.MarketDB;
import models.RecipeDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.forms.EditFarmerData;
import views.forms.FeedData;
import views.forms.IngredientFormData;
import views.forms.MarketData;
import views.html.AvailableNow;
import views.html.Cookbook;
import views.html.EditFarmer;
import views.html.FarmersDashboard;
import views.html.FarmersProfile;
import views.html.Index;
import views.html.Login;
import views.html.Markets;
import views.html.MealPlanner;
import views.html.NewIngredient;
import views.html.Recipe;
import views.html.SignUp;
import views.loginData.LoginData;
import views.loginData.SignUpForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Provides controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page.
   *
   * @return The resulting home page.
   */
  public static Result index() {
    return ok(Index.render("Index", Secured.isLoggedIn(ctx()), Secured.getFarmer(ctx())));

  }


  /**
   * Logs the current user out.
   *
   * @return The login page
   */
  @Security.Authenticated(Secured.class)
  public static Result logout() {
    session().clear();
    flash("success", "You've been logged out");
    return index();
  }


  /**
   * Returns the login page.
   *
   * @return The resulting sign up page.
   */
  public static Result login() {
    LoginData data = new LoginData();

    Form<LoginData> formData = Form.form(LoginData.class).fill(data);
    return ok(Login.render(formData, Secured.isLoggedIn(ctx()), Secured.getFarmer(ctx())));
  }

  /**
   * Processes a login form.
   *
   * @return The user's dashboard.
   */
  public static Result postLogin() {
    Form<LoginData> formData = Form.form(LoginData.class).bindFromRequest();
    if (formData.hasErrors()) {
      System.out.println("Errors found.");
      return badRequest(Login.render(formData, Secured.isLoggedIn(ctx()), Secured.getFarmer(ctx())));
    }
    LoginData data = formData.get();
    System.out.println("OK: " + data.name + " " + data.password);
    session("username", data.name);
    return redirect(routes.Application.farmersDashboard());

  }

  /**
   * Returns the sign up page.
   *
   * @return The resulting sign up page.
   */
  public static Result signUp() {
    SignUpForm data = new SignUpForm();

    Form<SignUpForm> formData = Form.form(SignUpForm.class).fill(data);
    return ok(SignUp.render(formData, Secured.isLoggedIn(ctx()), Secured.getFarmer(ctx())));
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
      return badRequest(SignUp.render(formData, Secured.isLoggedIn(ctx()), Secured.getFarmer(ctx())));
    }
    SignUpForm data = formData.get();
    System.out.println("OK: " + data.name + " " + data.password);
    session("username", data.name);
    FarmerDB.addFarmer(new Farmer(data.name, data.location));
    return redirect(routes.Application.farmersDashboard());

  }

  /**
   * Provides the Profile page (only to authenticated users).
   *
   * @return The Profile page.
   */
  @Security.Authenticated(Secured.class)
  public static Result farmersDashboard() {
    FeedData data = new FeedData();

    Form<FeedData> formData = Form.form(FeedData.class).fill(data);
    return ok(FarmersDashboard.render(formData, Secured.getFarmer(ctx()), Secured.isLoggedIn(ctx())));
  }

  /**
   * Returns the Farmer's profile page.
   *
   * @param name The name of the farmer.
   * @return The resulting Farmer's profile page.
   */
  public static Result farmersProfile(String name) {
    Farmer farmer = FarmerDB.getFarmer(name);
    return ok(FarmersProfile.render(farmer, Secured.isLoggedIn(ctx())));
  }

  /**
   * Returns the cookbook page.
   *
   * @return The resulting cookbook page.
   */
  public static Result cookbook() {
    //return ok(Cookbook.render(RecipeDB.getRecipe()));
    return ok(Cookbook.render(RecipeDB.getRecipe(), Secured.isLoggedIn(ctx()), Secured.getFarmer(ctx())));
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

    return ok(Recipe.render(r, Secured.isLoggedIn(ctx()), Secured.getFarmer(ctx())));
  }

  /**
   * Returns the farmersMarket page.
   *
   * @return The resulting local page.
   */
  public static Result farmersMarkets(String state) {
    List<Market> markets;
    if (state != "") {
          markets = MarketDB.getMarketsByState(state);
      }
    else {
      markets = MarketDB.getMarkets();
    }

    return ok(Markets.render("Welcome to markets.", markets, Secured.isLoggedIn(ctx()), Secured.getFarmer(ctx())));
  }

  /**
   * Returns the Meal Planner page.
   *
   * @return The resulting Meal Planner page.
   */
  public static Result mealPlanner() {
    return ok(MealPlanner.render("Welcome to Meal Planner.", RecipeDB.getFreshRecipeList(), Secured.isLoggedIn(ctx()), Secured.getFarmer(ctx())));
  }


  /**
   * Returns the available now page.
   *
   * @return The resulting available now page.
   */
  public static Result availableNow(String market) {
    return ok(AvailableNow.render(FarmerDB.getFarmers(), Secured.isLoggedIn(ctx()), Secured.getFarmer(ctx()), MarketDB.getMarkets(), MarketDB.getMarket(market)));
  }

  /**
   * Deletes the ingredient from the farmer's stock.
   *
   * @param farmer     the current farmer
   * @param ingredient the ingredient to delete
   * @return Result the resulting page
   */
  @Security.Authenticated(Secured.class)
  public static Result deleteIngredient(String farmer, long ingredient) {
    Farmer.deleteIngredient(farmer, ingredient);
    return redirect(routes.Application.farmersDashboard());
  }

  public static Result editFarmer(String farmer) {
    Farmer f = Farmer.findFarmer(farmer);
    EditFarmerData data = new EditFarmerData(f);
    Form<EditFarmerData> formData = Form.form(EditFarmerData.class).fill(data);
    Map<Market, Boolean> dietTypeMap = MarketData.getMarkets(data.getMarkets());
    return ok(EditFarmer.render(formData, Secured.isLoggedIn(ctx()), Secured.getFarmer(ctx()), dietTypeMap));
   }

  public static Result postEditFarmer(String farmer) {
    Form<EditFarmerData> formData = Form.form(EditFarmerData.class).bindFromRequest();
    if (formData.hasErrors()) {
      System.out.println("Errors found.");
      return badRequest(EditFarmer.render(formData, Secured.isLoggedIn(ctx()), Secured.getFarmer(ctx()), MarketData.getMarkets()));
    }
    EditFarmerData data = formData.get();
    session("username", data.getName());
    FarmerDB.editFarmer(data);
    return redirect(routes.Application.farmersDashboard());
  }

  /**
   * Adds just one quantity to the ingredient.
   *
   * @param farmer     the current farmer name
   * @param ingredient the ingredient to increment
   * @return the Dashboard with the new ingredient amount
   */
  @Security.Authenticated(Secured.class)
  public static Result addOne(String farmer, long ingredient) {

    Farmer.addOneToIngredient(farmer, ingredient);
    return redirect(routes.Application.farmersDashboard());
  }

  /**
   * Subtracts just one quantity from the ingredient.
   *
   * @param farmer     the current farmer name
   * @param ingredient the ingredient to subtract
   * @return the Dashboard with the new ingredient amount
   */
  @Security.Authenticated(Secured.class)
  public static Result subOne(String farmer, long ingredient) {
    Farmer.subtractOneToIngredient(farmer, ingredient);
    return redirect(routes.Application.farmersDashboard());
  }


  /**
   *  Retrieves the new ingredient page for a user to add a new ingredient.
   * @param farmer the current farmer name.
   * @return new ingredient page.
   */
  @Security.Authenticated(Secured.class)
  public static Result newIngredient(String farmer) {
    IngredientFormData data = new IngredientFormData();
    Form<IngredientFormData> formData = Form.form(IngredientFormData.class).fill(data);
    return ok(NewIngredient.render(formData, Secured.isLoggedIn(ctx()), Farmer.findFarmer(farmer)));
  }

  /**
   *
   * Sends a post request to add the new ingredient using the form.
   * @param farmer the current farmer name.
   * @return the new ingredient page.
   */
  @Security.Authenticated(Secured.class)
  public static Result postIngredient(String farmer) {
    System.out.println("In post Ingredient.");
    Form<IngredientFormData> formData = Form.form(IngredientFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      System.out.println("Form has errors.");
      return badRequest(NewIngredient.render(formData, Secured.isLoggedIn(ctx()), Farmer.findFarmer(farmer)));
    }
    else {
      IngredientFormData data = formData.get();
      System.out.println("Trying to add ingredient " + farmer);
      Secured.getFarmer(ctx()).addIngredient(data);
      return redirect(routes.Application.farmersDashboard());
    }
  }

  /**
   *  Retrieves the new ingredient page for a user to edit ingredient.
   * @param farmer the current farmer name.
   * @return edit ingredient page.
   */
  @Security.Authenticated(Secured.class)
  public static Result editIngredient(String farmer, long ingredient) {
    IngredientFormData data = new IngredientFormData(Farmer.findFarmer(farmer).findIngredient(ingredient));
    Form<IngredientFormData> formData = Form.form(IngredientFormData.class).fill(data);
    return ok(NewIngredient.render(formData, Secured.isLoggedIn(ctx()), Farmer.findFarmer(farmer)));
  }

  /**
   * Processes a new feed form.
   *
   * @return The user's dashboard.
   */
  @Security.Authenticated(Secured.class)
  public static Result postFeed() {
    Form<FeedData> formData = Form.form(FeedData.class).bindFromRequest();
    if (formData.hasErrors()) {
      System.out.println("Errors found.");
      return badRequest(FarmersDashboard.render(formData, Secured.getFarmer(ctx()), Secured.isLoggedIn(ctx())));
    }
    FeedData data = formData.get();
    FeedDB.addProcedure(new Feed(data.entry, Secured.getFarmer(ctx())));
    return redirect(routes.Application.farmersDashboard());

  }

}
