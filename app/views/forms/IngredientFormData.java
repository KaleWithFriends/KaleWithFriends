package views.forms;

import models.Farmer;
import models.TimedIngredient;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * The backend for the ingredient form data.
 * Created by Jack on 5/6/2015.
 */
public class IngredientFormData {

  /**
   * The farmer.
   */
  public Farmer farmer;

  /**
   * The price.
   */
  public String price;

  /**
   * The image.
   */
  public String image;

  /**
   * The name.
   */
  public String name;

  /**
   * The quantity.
   */
  public String quantity;

  /**
   * The expiration month.
   */
  public int expMonth;

  /**
   * The expiration day.
   */
  public int expDay;

  /**
   * The expiration year.
   */
  public int expYear;


  /**
   * The start date.
   */
  public Calendar startDate;

  /**
   * The end date.
   */
  public Calendar endDate;

  /**
   * The id.
   */
  public long id;


  /**
   * Public no arg constructor for Play.
   */
  public IngredientFormData() {
    //no arg constructor
  }

  /**
   * Creates a ingredient given a ingredient.
   *
   * @param ingredient The ingredient.
   */
  public IngredientFormData(TimedIngredient ingredient) {
    this.price = ingredient.getPrice();
    this.endDate = ingredient.getEndDate();
    this.startDate = ingredient.getStartDate();
    this.id = ingredient.getId();
    this.quantity = Integer.toString(ingredient.getQuantity());
    this.image = ingredient.getImage();
    this.name = ingredient.getName();
  }


  /**
   * Creates a model of a ingredient without the id. Method used for testing purposes.
   *
   * @param name the name
   * @param price the price
   * @param quantity the quantity
   * @param image the image
   * @param expMonth the expMonth
   * @param expDay the expDay
   * @param expYear the expYear
   */
  public IngredientFormData(String name, String price, String quantity, String image,
                            int expMonth, int expDay, int expYear) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.image = image;
    this.expMonth = expMonth;
    this.expDay = expDay;
    this.expYear = expYear;

  }

  /**
   * Creates a model of a ingredient without the id. Method used for testing purposes.
   *
   * @param name the name
   * @param price the price
   * @param quantity the quantity
   * @param image the image
   * @param startDate the startDate
   * @param endDate the endDate
   */
  public IngredientFormData(String name, String price, String quantity,
                            String image, Calendar startDate, Calendar endDate) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.image = image;
    this.startDate = startDate;
    this.endDate = endDate;

  }


  /**
   * Checks if a string is a number.
   *
   * @param s the string to check
   * @return true or false if number or not
   */
  public boolean isNumeric(String s) {
    return s.matches("[-+]?\\d*\\.?\\d+");
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


    if (price == null || price.length() == 0) {
      errors.add(new ValidationError("price", "Price is required."));
    }

    if (!isNumeric(price)) {
      errors.add(new ValidationError("price", "Price must contain only numbers or decimals."));
    }

    if (quantity == null || quantity.length() == 0 || !isNumeric(quantity)) {
      errors.add(new ValidationError("quantity", "Quantity is required."));
    }

    if (!isNumeric(quantity)) {
      errors.add(new ValidationError("price", "Quantity must contain only numbers or decimals."));
    }

    return errors.isEmpty() ? null : errors;
  }
}
