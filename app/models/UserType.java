package models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * An entity for the user type. This entity has a one-to-many relation with users.
 */

@Entity
public class UserType extends play.db.ebean.Model {
  /** The id. */
  @Id
  private long id;
  /** The type of user. */
  private String userType;
  /** The list of users associated with this type */
  @OneToMany(mappedBy = "userType", cascade = CascadeType.PERSIST)
  private List<KaleUser> kaleUsers;

  /**
   * Default constructor.
   *
   * @param userType The user type to set
   */
  public UserType(String userType) {
    this.userType = userType;
  }

  /**
   * The EBean ORM finder method for database queries.
   *
   * @return The finder method.
   */
  public static Finder<Long, UserType> find() {
    return new Finder<Long, UserType>(Long.class, UserType.class);
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
   * Get the type of user.
   *
   * @return the user type.
   */
  public String getUserType() {
    return userType;
  }

  /**
   * Sets the user type.
   *
   * @param userType the user type.
   */
  public void setUserType(String userType) {
    this.userType = userType;
  }

  /**
   * Get the contacts.
   *
   * @return The contacts.
   */
  public List<KaleUser> getKaleUsers() {
    return kaleUsers;
  }

  /**
   * Add a user to the list of users for bidirectional link.
   *
   * @param kaleUser the user to add.
   */
  public void addUser(KaleUser kaleUser) {
    kaleUsers.add(kaleUser);
  }

  /**
   * Sets the list of users.
   *
   * @param kaleUsers The list.
   */
  public void setKaleUsers(List<KaleUser> kaleUsers) {
    this.kaleUsers = kaleUsers;
  }
}
