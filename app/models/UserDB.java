package models;

import java.util.List;

/**
 * User database to hold all the users (both farmers and consumers).
 * Also handles user types and markets.
 * Created by Will on 4/29/2015.
 */
public class UserDB {
  /**
   * Adds a user to the database.
   *
   * @param kaleUser The farmer.
   */
  public static void addUser(KaleUser kaleUser) {
    kaleUser.save();
  }

  /**
   * Add a user type to the database.
   *
   * @param userType the new user type to add.
   */
  public static void addUserType(UserType userType) {
    userType.save();
  }

  /**
   * Add a market to the database.
   *
   * @param market The market.
   */
  public static void addMarket(Market market) {
    market.save();
  }

  /**
   * Get a list of all markets
   *
   * @return The list of markets.
   */
  public static List<Market> getMarkets() {
    return Market.find().all();
  }

  /**
   * Get the list of all user types.
   *
   * @return The list of user types.
   */
  public static List<UserType> getUserTypes() {
    return UserType.find().all();
  }

  /**
   * Get the list of all users given a certain type.
   *
   * @param userType The string user type.
   * @return The user type.
   */
  public static UserType getUserType(String userType) {
    UserType u = UserType.find().where().eq("userType", userType).findUnique();

    if (u == null) {
      throw new RuntimeException();
    }

    return u;
  }


  /**
   * Gets a user given the name.
   *
   * @param name The user name.
   * @return The user.
   */
  public static KaleUser getUser(String name) {
    KaleUser u = KaleUser.find().where().eq("name", name).findUnique();

    if (u == null) {
      throw new RuntimeException();
    }

    return u;
  }

  /**
   * Gets a user by id.
   *
   * @param id The user id.
   * @return The user.
   */
  public static KaleUser getUser(long id) {
    KaleUser u = KaleUser.find().byId(id);

    if (u == null) {
      throw new RuntimeException();
    }

    return u;
  }

  /**
   * Gets a list of all users in the database given a string type.
   *
   * @return The list of users of type 'userType'.
   */
  public static List<KaleUser> getUsers(String type) {
    UserType userType = getUserType(type);
    List<KaleUser> u = KaleUser.find().where().eq("userType", userType).findList();

    if (u.isEmpty() == true) {
      throw new RuntimeException();
    }

    return u;
  }

  /**
   * Gets a list of all users in the database given a type.
   *
   * @return The list of users of type 'userType'.
   */
  public static List<KaleUser> getUsers(UserType userType) {
    List<KaleUser> u = KaleUser.find().where().eq("userType", userType).findList();

    if (u.isEmpty() == true) {
      throw new RuntimeException();
    }

    return u;
  }

  /**
   * Gets a list of all the users.
   *
   * @return The list of users.
   */
  public static List<KaleUser> getUsers() {
    return KaleUser.find().all();
  }
}
