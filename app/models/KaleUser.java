package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/* Should the User class store an object for user type or just use a string? */

/**
 * Model of a contact.
 * Created by amytakayesu on 3/16/15.
 */
@Entity
public class KaleUser extends play.db.ebean.Model {

  /** The id. */
  @Id
  private long id;

  /** The type of user. */
  @ManyToOne(cascade = CascadeType.PERSIST)
  private UserType userType;

  /** The list of markets associated with this user.
   * This could be a list of markets where a farmer type user is selling produce,
   * or a location for a market that a consumer is planning to attend.
   */
  @ManyToMany(cascade = CascadeType.PERSIST)
  private List<Market> markets;

  /** The list of ingredients this user owns. For now this will only
   * be used by farmers.
   */
  @OneToMany(mappedBy = "kaleUser", cascade = CascadeType.PERSIST)
  private List<TimedIngredient> timedIngredients;

  /** The user's name. */
  private String name;
  /** The user's location. */
  private String location;
  /** The picture location. */
  private String pictureLocation;
  /** The phone number. */
  private String phone;

  /**
   * The EBean ORM finder method for database queries.
   *
   * @return The finder method.
   */
  public static Finder<Long, KaleUser> find() {
    return new Finder<Long, KaleUser>(Long.class, KaleUser.class);
  }

  /**
   * Creates a user.
   *
   * @param name user name
   * @param userType user type
   */
  public KaleUser(String name, UserType userType) {
    this.name = name;
    this.userType = userType;
  }

  /**
   * Creates a user. Does not require a UserType.
   *
   * @param name user name
   * @param userType user type
   */
  public KaleUser(String name, String userType) {
    this.name = name;
    this.userType = UserDB.getUserType(userType);
  }

  /**
   * Gets user name.
   *
   * @return the user name.
   */
  public String getName() {
    return name;
  }

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
   * Gets the user type.
   *
   * @return the user type.
   */
  public UserType getUserType() {
    return userType;
  }

  /**
   * Sets the user type.
   *
   * @param userType the user type to set.
   */
  public void setUserType(UserType userType) {
    this.userType = userType;
  }

  /**
   * Gets the list of markets.
   *
   * @return The list of markets.
   */
  public List<Market> getMarkets() {
    return markets;
  }

  /**
   * Sets the list of markets.
   *
   * @param markets The list of markets.
   */
  public void setMarkets(List<Market> markets) {
    this.markets = markets;
  }

  /**
   * Get the list of timed ingredients.
   *
   * @return The list of timed ingredients.
   */
  public List<TimedIngredient> getTimedIngredients() {
    return timedIngredients;
  }

  /**
   * Set the list of timed ingredients.
   *
   * @param timedIngredients The list of ingredients.
   */
  public void setTimedIngredients(List<TimedIngredient> timedIngredients) {
    this.timedIngredients = timedIngredients;
  }

  /**
   * Get the list of ingredients.
   *
   * @return The list of ingredients.
   */
  public List<Ingredient> getIngredients() {
    List<Ingredient> ingredients = new ArrayList<>();

    for (TimedIngredient timedIngredient : timedIngredients) {
      ingredients.add(timedIngredient.getIngredient());
    }

    return ingredients;
  }

  /**
   * Get the location.
   * @return The location.
   */
  public String getLocation() {
    return location;
  }

  /**
   * Set the location.
   * @param location The location.
   */
  public void setLocation(String location) {
    this.location = location;
  }

  /**
   * The location for the profile picture.
   * @return The picture location.
   */
  public String getPictureLocation() {
    return pictureLocation;
  }

  /**
   * Sets the picture location.
   * @param pictureLocation The picture location.
   */
  public void setPictureLocation(String pictureLocation) {
    this.pictureLocation = pictureLocation;
  }

  /**
   * Get the phone number.
   * @return The phone number.
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Set the phone number.
   * @param phone The phone number.
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Add a timed ingredient to the list.
   *
   * @param timedIngredient the timed ingredient.
   */
  public void addTimedIngredient(TimedIngredient timedIngredient) {
    timedIngredients.add(timedIngredient);
    timedIngredient.setKaleUser(this);
    IngredientDB.addTimedIngredient(timedIngredient);
  }

  /**
   * Add a market given the market name. If no market exists with the name
   * provided, create a new one and add it to the database.
   *
   * @param market The name of the market.
   */
  public void addMarket(String market) {
    Market m = Market.find().where().eq("marketName", market).findUnique();

    if (m == null) {
      // Add a new market with default location
      m = new Market(market, "No location provided.");
      UserDB.addMarket(m);
    }

    markets.add(m);
  }

  /**
   * Add an existing market to the list.
   *
   * @param market The market object.
   */
  public void addMarket(Market market) {
    markets.add(market);
  }
}
