package models;

import java.util.List;

/**
 * The database for all the farmer's feeds.
 * Created by Jack on 5/5/2015.
 */
public class FeedDB {


  /**
   * Adds a recipe to the database.
   *
   * @param feed The feed to be added.
   */
  public static void addProcedure(Feed feed) {
    feed.save();
  }

  /**
   * Gets a feed given the id.
   *
   * @param id The feed id.
   * @return The corresponding feed.
   */
  public static Feed getFeed(long id) {
    return Feed.find().byId(id);
  }

  /**
   * Gets a list of all the feeds.
   *
   * @return The list of feeds.
   */
  public static List<Feed> getFeeds() {

    return Feed.find().findList();
  }

}
