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

    public Farmer farmer;

    public String price;

    public String image;

    public String name;

    public String quantity;

  public int expMonth;
  public int expDay;
  public int expYear;


    public Calendar startDate;
    public Calendar endDate;

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
   * @param name
   * @param price
   * @param quantity
   * @param image
   */
  public IngredientFormData(String name, String price, String quantity, String image, int expMonth, int expDay, int expYear) {
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
     * @param name
     * @param price
     * @param quantity
     * @param image
     * @param startDate
     */
    public IngredientFormData(String name, String price, String quantity, String image, Calendar startDate, Calendar endDate) {
      this.name = name;
      this.price = price;
      this.quantity = quantity;
      this.image = image;
      this.startDate = startDate;
      this.endDate = endDate;

    }


  /**
   * Checks if a string is a number.
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
