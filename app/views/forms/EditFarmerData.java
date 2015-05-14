package views.forms;

import models.Farmer;
import models.Market;
import play.data.validation.ValidationError;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * The backend for the ingredient form data.
 * Created by Jack on 5/6/2015.
 */
public class EditFarmerData {

  private String location;
  private String pictureLocation = "images/farmPicture.jpg";
  private List<Market> markets;
  private String phone;
  private String password;
  private String name;

  @Id
  private long id;

  /**
   * Gets the farmer location.
   * @return the location
   */
  public String getLocation() {
    return location;
  }

  /**
   * Sets the farmer location.
   * @param location farmer location
   */
  public void setLocation(String location) {
    this.location = location;
  }

  /**
   * Gets the farmer picture location.
   * @return the picture location
   */
  public String getPictureLocation() {
    return pictureLocation;
  }

  /**
   * Sets the farmer picture location.
   * @param pictureLocation farmer picture location
   */
  public void setPictureLocation(String pictureLocation) {
    this.pictureLocation = pictureLocation;
  }

  public List<Market> getMarkets() {
    return markets;
  }

  public void setMarkets(List<Market> markets) {
    this.markets = markets;
  }

  /**
   * Gets the farmer phone number.
   * @return the phone number
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Sets the farmer phone number.
   * @param phone the phone number
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Gets the farmer password.
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets the farmer password
   * @param password the password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Gets the farmer name.
   * @return the farmer name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the farmer name.
   * @param name the farmer name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the farmer id.
   * @return the id.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the farmer id.
   * @param id the farmer id.
   */
  public void setId(long id) {
    this.id = id;
  }

    /**
     * Public no arg constructor for Play.
     */
    public EditFarmerData() {
      //no arg constructor
    }

  /**
   * Creates a farmer form given a farmer object.
   * @param farmer the farmer in question
   */
    public EditFarmerData(Farmer farmer) {
      this.location = farmer.getLocation();
      this.pictureLocation = farmer.getPictureLocation();
      this.markets = farmer.getMarkets();
      this.phone = farmer.getPhone();
      this.password = farmer.getPassword();
      this.name = farmer.getName();
    }


  /**
     * Validates the form's fields.
     *
     * @return null if valid, list of errors if there are any.
     */
    public List<ValidationError> validate() {
      List<ValidationError> errors = new ArrayList<>();

      if (name == null || name.length() == 0) {
        errors.add(new ValidationError("name", "Name is required."));
      }

      if (password == null || password.length() == 0) {
        errors.add(new ValidationError("password", "Password is required."));
      }

      return errors.isEmpty() ? null : errors;
    }
}
