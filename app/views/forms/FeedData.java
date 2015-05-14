package views.forms;

import models.Farmer;
import models.Feed;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by amytakayesu on 4/6/15.
 */
public class FeedData {
  /**
   * The time.
   */
  public Calendar time;

  /**
   * The entry.
   */
  public String entry;

  /**
   * The farmer.
   */
  public Farmer farmer;

  /**
   * The id of the feed.
   */
  public long id;

  /**
   * Default constructor.
   */
  public FeedData() {
  }

  /**
   * Constructor using feed.
   *
   * @param feed the feed to use
   */
  public FeedData(Feed feed) {
    this.time = feed.getTime();
    this.entry = feed.getEntry();
    this.farmer = feed.getFarmer();
  }


  /**
   * Checks for field validations.
   *
   * @return List of errors or null if there are no errors
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();

    if (entry == null) {
      errors.add(new ValidationError("entry", "Your post is empty"));
    }
      return errors.isEmpty() ? null : errors;
  }
}
