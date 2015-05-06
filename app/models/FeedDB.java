package models;

import views.forms.FeedDataForm;

/**
 * The database for all the farmer's feeds.
 * Created by Jack on 5/5/2015.
 */
public class FeedDB {


  /**
   * Adds a recipe to the database.
   *
   * @param feedData The feed to be added.
   */
  public static void addFeed(FeedDataForm feedData) {
    Feed feed = new Feed();
    feed.setEntry(feedData.entry);
    feed.setFarmer(feedData.farmer);
    feed.setTime(feedData.time);



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

}
