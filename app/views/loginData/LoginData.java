package views.loginData;

import models.KaleUser;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amytakayesu on 4/6/15.
 */
public class LoginData {
  /**
   * User name field.
   */
  public String name;

  /**
   * Login type field.
   */
  public String loginType;


  /**
   * Default constructor.
   */
  public LoginData() {
  }

  /**
   * Constructor using existing login.
   *
   * @param kaleUser existing contact
   */
  public LoginData(KaleUser kaleUser) {
    this.loginType = kaleUser.getUserType().getUserType();
    this.name = kaleUser.getName();
  }


  /**
   * Checks for field validations.
   *
   * @return List of errors or null if there are no errors
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();

    if (loginType == null || !LoginTypes.isType(loginType)) {
      errors.add(new ValidationError("loginType", "Login type is invalid."));
    }
      return errors.isEmpty() ? null : errors;
  }

}
