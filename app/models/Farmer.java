package models;

import play.db.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * Model for farmers. Contains a farmer's name, location, and their produces.
 * <p>
 * Created by Jack on 4/4/2015.
 */
@Entity
public class Farmer extends Model {

  private String location;

  private String pictureLocation = "images/farmPicture.jpg";
  private String markets;
  private String phone;
  private String password;
  private String name;

  @Id
  private long id;

  @OneToMany(mappedBy = "farmer", cascade = CascadeType.PERSIST)
  private List<TimedIngredient> ingredientList;


  @OneToMany(mappedBy = "farmer", cascade = CascadeType.PERSIST)
  private List<Feed> feedList;


  /**
   * The EBean ORM finder method for database queries.
   *
   * @return The finder method.
   */
  public static Finder<Long, Farmer> find() {
    return new Finder<Long, Farmer>(Long.class, Farmer.class);
  }


  /**
   * Creates a farmer object with default id.
   *
   * @param name     The name of the farmer.
   * @param location The location of the farmer.
   */
  public Farmer(String name, String location) {
    this.id = 0;
    this.name = name;
    this.location = location;
  }

  /**
   * Creates a farmer object.
   *
   * @param id             The id of the farmer.
   * @param name           The name of the farmer.
   * @param markets        The location of the farmers markets.
   * @param phone          The phone number of the farmer.
   * @param location       The location of the farmer.
   * @param ingredientList The list of current farmer stock.
   */
  public Farmer(long id, String name, String location,
                String markets, String phone, ArrayList<TimedIngredient> ingredientList) {
    this.id = id;
    this.name = name;
    this.location = location;
    this.markets = markets;
    this.phone = phone;
    this.ingredientList = ingredientList;
  }


  /**
   * Creates a farmer object with an associated picture location.
   *
   * @param id              The id of the farmer.
   * @param name            The name of the farmer.
   * @param markets         The location of the farmers markets.
   * @param phone           The phone number of the farmer.
   * @param location        The location of the farmer.
   * @param pictureLocation The location of the picture.
   * @param ingredientList  The list of current farmer stock.
   */
  public Farmer(long id, String name, String location,
                String markets, String phone, String pictureLocation, ArrayList<TimedIngredient> ingredientList) {
    this.id = id;
    this.name = name;
    this.location = location;
    this.markets = markets;
    this.phone = phone;
    this.ingredientList = ingredientList;
    this.pictureLocation = pictureLocation;
  }


  /**
   * Creates a farmer object with an associated picture location without the id.
   *
   * @param name            The name of the farmer.
   * @param markets         The location of the farmers markets.
   * @param phone           The phone number of the farmer.
   * @param location        The location of the farmer.
   * @param pictureLocation The location of the picture.
   * @param ingredientList  The list of current farmer stock.
   */
  public Farmer(String name, String location,
                String markets, String phone, String pictureLocation, ArrayList<TimedIngredient> ingredientList) {
    this.id = id;
    this.name = name;
    this.location = location;
    this.markets = markets;
    this.phone = phone;
    this.ingredientList = ingredientList;
    this.pictureLocation = pictureLocation;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  /**
   * Gets the name of the farmer.
   *
   * @return The name.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the location of the farmer.
   *
   * @return The location.
   */
  public String getLocation() {
    return location;
  }

  /**
   * Gets the location of the farmer.
   *
   * @return The location.
   */
  public String getMarkets() {
    return markets;
  }

  /**
   * Gets the location of the farmer.
   *
   * @return The location.
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Gets the current stock of the farmer.
   *
   * @return The list of farmer's produce.
   */
  public List<TimedIngredient> getIngredientList() {
    Collections.sort(ingredientList);
    return ingredientList;
  }

  /**
   * Gets the location for the logo/picture for the farmer.
   *
   * @return The logo/picture of the farmer as a String.
   */
  public String getPictureLocation() {
    return pictureLocation;
  }

  /**
   * Gets the fresh ingredients the farmers has in stock.
   *
   * @return The list of fresh ingredients.
   */
  public ArrayList<TimedIngredient> getFreshIngredientList() {
    ArrayList<TimedIngredient> freshIngredients = new ArrayList<TimedIngredient>();

    for (TimedIngredient ingredient : ingredientList) {
      Calendar today = Calendar.getInstance();
      if (today.after(ingredient.getStartDate()) && today.before(ingredient.getEndDate())) {
        freshIngredients.add(ingredient);
      }
    }
    return freshIngredients;
  }

  /**
   * Finds and returns a Farmer based on a name. Null if not found.
   *
   * @param farmer the Farmer name.
   * @return f the Farmer object
   */
  public static Farmer findFarmer(String farmer) {
    return FarmerDB.getFarmer(farmer);
  }

  /**
   * Finds and returns a Farmer's TimedIngredient based on a name. Null if not found.
   *
   * @param ingredient the TimedIngredient name
   * @return i the TimedIngredient object
   */
  public TimedIngredient findIngredient(String ingredient) {
    return TimedIngredient.find().where().eq("name", ingredient).findUnique();
  }


  /**
   * Finds and returns a Farmer's TimedIngredient based on a name. Null if not found.
   *
   * @param ingredient the TimedIngredient id.
   * @return i the TimedIngredient object
   */
  public TimedIngredient findIngredient(Long ingredient) {
    return TimedIngredient.find().byId(ingredient);
  }

  /**
   * Deletes an ingredient from this farmer's ingredient list.
   *
   * @param farmer     the farmer whose ingredient is being deleted
   * @param ingredient the ingredient to delete
   */
  public static void deleteIngredient(String farmer, long ingredient) {

    TimedIngredient.find().byId(ingredient).delete();
  }

  /**
   * Adds an ingredient to this farmer's ingredient list.
   *
   * @param ingredient the ingredient to add
   * @param amount     the amount of ingredient to add
   * @param start      the start date of the ingredient to add
   * @param end        the end date of the ingredient to add
   * @param price      the price of the ingredient.
   */
  public void addIngredient(String ingredient, int amount, Calendar start, Calendar end, String price) {
    TimedIngredient i = new TimedIngredient(ingredient, amount, start, end, price);
    ingredientList.add(i);
  }

  /**
   * Adds one stock to the ingredient.
   *
   * @param farmer     The ingredient's owner (farmer).
   * @param ingredient The ingredient.
   */
  public static void addOneToIngredient(String farmer, long ingredient) {
    TimedIngredient.find().byId(ingredient).addQuantity(1);
  }

  /**
   * Subtracts one stock from the ingredient.
   *
   * @param farmer     The ingredient's owner (farmer).
   * @param ingredient The ingredient.
   */
  public static void subtractOneToIngredient(String farmer, long ingredient) {
    TimedIngredient.find().byId(ingredient).subtractQuantity(1);
  }

  //methods below are originally from the obsolete class

  /**
   * Sets the user name.
   *
   * @param name the user name
   */
  public void setName(String name) {
    this.name = name;
  }


  /**
   * Gets the user id.
   *
   * @return the user id
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the user id.
   *
   * @param id the user id.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Checks if a user with a specified name exists.
   *
   * @param name The username to check for
   * @return true or false if the name exists
   */
  public static boolean isName(String name) {
    if ((FarmerDB.getFarmer(name) == null)) {
      return false;
    }
    else {
      return true;
    }
  }

  /**
   * Gets a user given its name.
   *
   * @param name The name of the user
   * @return The user object
   */
  public static Farmer getFarmer(String name) {
    if (isName(name)) {
      return FarmerDB.getFarmer(name);
    }
    else {
      return null;
    }
  }

  /**
   * Sets the location.
   *
   * @param location The location.
   */
  public void setLocation(String location) {
    this.location = location;
  }

  /**
   * Sets the ingredient list.
   *
   * @param ingredientList The ingredient list.
   */
  public void setIngredientList(ArrayList<TimedIngredient> ingredientList) {
    this.ingredientList = ingredientList;
  }

  /**
   * Sets the picture lcoation.
   *
   * @param pictureLocation The picture location.
   */
  public void setPictureLocation(String pictureLocation) {
    this.pictureLocation = pictureLocation;
  }

  /**
   * Sets the market.
   *
   * @param markets The market.
   */
  public void setMarkets(String markets) {
    this.markets = markets;
  }

  /**
   * Sets the phone number.
   *
   * @param phone The phone number.
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Gets the feed of the farmer.
   *
   * @return The feed.
   */
  public List<Feed> getFeedList() {
    return feedList;
  }

  /**
   * Sets the feed list.
   *
   * @param feedList The feed list.
   */
  public void setFeedList(ArrayList<Feed> feedList) {
    this.feedList = feedList;
  }

  public void setIngredientList(List<TimedIngredient> ingredientList) {
    this.ingredientList = ingredientList;
  }

  public void setFeedList(List<Feed> feedList) {
    this.feedList = feedList;
  }
}
