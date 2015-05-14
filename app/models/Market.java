package models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * An entity for the market object. This entity has a many-to-many relation with users.
 */

@Entity
public class Market extends play.db.ebean.Model {
  /** The id. */
  @Id
  private long id;

  /** The list of contacts associated with this type. */
  @ManyToMany(mappedBy = "markets", cascade = CascadeType.PERSIST)
  private List<Farmer> farmers;

  /** The name of the market. */
  private String marketName;
  /** The location of the market. */
  private String location;

  /** The time of the market. */
  private String time;

  /**
   * Default constructor.
   *
   * @param location the location of market.
   * @param time the time of the market.
   * @param marketName Name of the market.
   */
  public Market(String marketName, String location, String time) {
    this.marketName = marketName;
    this.location = location;
    this.time = time;
  }

  /**
   * The EBean ORM finder method for database queries.
   *
   * @return The finder method.
   */
  public static Finder<Long, Market> find() {
    return new Finder<Long, Market>(Long.class, Market.class);
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
   * Get the location for the market.
   *
   * @return The location.
   */
  public String getLocation() {
    return location;
  }

  /**
   * Set the location of the market.
   * @param location The location.
   */
  public void setLocation(String location) {
    this.location = location;
  }

  /**
   * Get the market name.
   *
   * @return the market name.
   */
  public String getMarketName() {
    return marketName;
  }

  /**
   * Sets the market name.
   *
   * @param marketName Name of the market.
   */
  public void setMarketName(String marketName) {
    this.marketName = marketName;
  }

  /**
   * Get the contacts.
   *
   * @return The contacts.
   */
  public List<Farmer> getFarmers() {
    return farmers;
  }

  /**
   * Get the time.
   *
   * @return the market time.
   */
  public String getTime() {
    return time;
  }

  /**
   * Set the time.
   *
   * @param time the market time.
   */
  public void setTime(String time) {
    this.time = time;
  }

  /**
   * Add a farmer to the list of farmers for bidirectional link.
   *
   * @param farmer the user to add.
   */
  public void addUser(Farmer farmer) {
    farmers.add(farmer);
  }

  /**
   * Sets a list of users.
   *
   * @param farmers The lit of users.
   */
  public void setKaleUsers(List<Farmer> farmers) {
    this.farmers = farmers;
  }
}