package views.loginData;

import models.FarmerDB;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amytakayesu on 5/3/15.
 */
public class SignUpForm {
  /**
   * Farmer name field.
   */
  public String name;

  /**
   * Login type field.
   */
  public String type;

  /**
   * Location field.
   */
  public String location;

  /**
   * The password field.
   */
  public String password;

  /**
   * Default constructor.
   */
  public SignUpForm() {
  }


  /**
   * Validates Form
   * Called automatically in the controller by bindFromRequest().
   * Checks to see that email and password are valid credentials.
   * @return Null if valid, or a List[ValidationError] if problems found.
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();

    if ((name == null) || (password == null) || FarmerDB.getFarmer(name) != null) {
      errors.add(new ValidationError("name", "Invalid"));
      errors.add(new ValidationError("password", "Invalid"));
    }

    return (errors.size() > 0) ? errors : null;
  }

  /**
   * Gets the current user's name.
   * @return the user's name
   */
  public String getName() {
    return name;
  }

}
