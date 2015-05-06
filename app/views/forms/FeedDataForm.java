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
public class FeedDataForm {
  public Calendar time;
  public String entry;
  public Farmer farmer;
  public long id;

  /**
   * Default constructor.
   */
  public FeedDataForm() {
  }

  /**
   * Constructor using feed.
   *
   * @param feed the feed to use
   */
  public FeedDataForm(Feed feed) {
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
