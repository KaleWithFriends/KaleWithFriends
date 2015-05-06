package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Calendar;

/**
 * Model to represent a farmer's message feed that will appear on their dashboard/news food.
 * <p>
 * Created by Jack on 5/4/2015.
 */
@Entity
public class Feed extends Model {
  private Calendar time;
  private String entry;


  @ManyToOne
  private Farmer farmer;

  @Id
  private long id;

  /**
   * The EBean ORM finder method for database queries.
   *
   * @return The finder method.
   */
  public static Finder<Long, Feed> find() {
    return new Finder<Long, Feed>(Long.class, Feed.class);
  }


  public Feed(){

  }


  /**
   * Feed that consist of time, farmer and the message.
   *
   * @param time   The time.
   * @param entry  The message.
   * @param farmer The farmer.
   */
  public Feed(Calendar time, String entry, Farmer farmer) {
    this.time = time;
    this.entry = entry;
    this.farmer = farmer;
  }

  /**
   * Constructs a message with the farmer.
   *
   * @param entry  The message.
   * @param farmer The farmer.
   */
  public Feed(String entry, Farmer farmer) {
    time = Calendar.getInstance();
    this.entry = entry;
    this.farmer = farmer;
  }

  /**
   * Gets the timestamp.
   *
   * @return The time.
   */
  public Calendar getTime() {
    return time;
  }

  /**
   * Sets the time.
   *
   * @param time The time to set.
   */
  public void setTime(Calendar time) {
    this.time = time;
  }

  /**
   * Gets the message entry.
   *
   * @return The message.
   */
  public String getEntry() {
    return entry;
  }

  /**
   * Sets the message.
   *
   * @param entry The message.
   */
  public void setEntry(String entry) {
    this.entry = entry;
  }

  /**
   * Gets the farmer.
   *
   * @return The farmer.
   */
  public Farmer getFarmer() {
    return farmer;
  }

  /**
   * Sets the farmer.
   *
   * @param farmer The farmer to set.
   */
  public void setFarmer(Farmer farmer) {
    this.farmer = farmer;
  }


  /**
   * Gets the id.
   *
   * @return The id.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id The id to set.
   */
  public void setId(long id) {
    this.id = id;
  }
}
