import models.UserDB;
import models.KaleUser;
import models.Ingredient;
import models.IngredientDB;
import models.IngredientDate;
import models.TimedIngredient;
import models.Recipe;
import models.RecipeDB;
import models.Market;

import models.UserType;
import play.Application;
import play.GlobalSettings;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Initializes application with some data.
 * Created by Jack on 4/4/2015.
 */
public class Global extends GlobalSettings {

  @Override
  public void onStart(Application application) {
    super.onStart(application);

    /********* SET UP INGREDIENTS ***********/
    if (IngredientDB.getIngredients().isEmpty()) {
      IngredientDB.addIngredient(new Ingredient("Nalo Greens"));
      IngredientDB.addIngredient(new Ingredient("Dandelion Greens"));
      IngredientDB.addIngredient(new Ingredient("Braising Greens"));
      IngredientDB.addIngredient(new Ingredient("Baby Kale"));
      IngredientDB.addIngredient(new Ingredient("Baby Swiss Chard"));
      IngredientDB.addIngredient(new Ingredient("Tat Soi"));
      IngredientDB.addIngredient(new Ingredient("Okra"));
      IngredientDB.addIngredient(new Ingredient("Baby Eggplant"));
    }

    /********* SET UP USER TYPES ***********/
    if (UserDB.getUserTypes().isEmpty()) {
      UserDB.addUserType(new UserType("Farmer"));
      UserDB.addUserType(new UserType("Consumer"));
    }

    /********* SET UP MARKETS ***********/
    if (UserDB.getMarkets().isEmpty()) {
      UserDB.addMarket(new Market("Farmers Market at Windward Mall", "Neal Blaisdell Concert Hall"));
      UserDB.addMarket(new Market("Kapiolani Community College Farmers Market", "Mililani High School"));
      UserDB.addMarket(new Market("Kailua@Night", "Longs Kailua Parking Structure"));
    }

    /********* SET UP USERS & TIMED INGREDIENTS FOR FARMERS ***********/
    if (UserDB.getUsers().isEmpty()) {
      KaleUser consumer1 = new KaleUser("Consumer1", "Consumer");
      KaleUser consumer2 = new KaleUser("Consumer2", "Consumer");
      KaleUser farmer1 = new KaleUser("Farmer1", "Farmer");
      KaleUser farmer2 = new KaleUser("Farmer2", "Farmer");

      consumer1.setLocation("2500 Campus Road, Honolulu, HI 96822");
      consumer2.setLocation("3071 Pualei Circle 96815");
      farmer1.setLocation("41-574 Makakalo Street Waimanalo, HI 96795");
      farmer1.setPictureLocation("images/farmPicture.jpg");
      farmer2.setLocation("91-1440 Farrington Hwy, Kapolei, HI 96707");
      farmer2.setPictureLocation("images/farmPicture.jpg");

      if (farmer1.getTimedIngredients().isEmpty()) {
        farmer1.addTimedIngredient(new TimedIngredient("Nalo Greens", 50,
            IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
            IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
            "6.00"));

        farmer1.addTimedIngredient(new TimedIngredient("Dandelion Greens", 30,
            IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
            IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
            "5.00"));
      }

      // Give the farmers a couple items each.
      if (farmer2.getTimedIngredients().isEmpty()) {
        farmer2.addTimedIngredient(new TimedIngredient("Braising Greens", 50,
            IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
            IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
            "6.00"));

        farmer2.addTimedIngredient(new TimedIngredient("Baby Kale", 30,
            IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
            IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
            "5.00"));
      }

      // Add a single market for each farmer.
      if (farmer1.getMarkets().isEmpty()) {
        farmer1.addMarket("Farmers Market at Windward Mall");
      }

      if (farmer2.getMarkets().isEmpty()) {
        farmer2.addMarket("Kapiolani Community College Farmers Market");
      }

      // Add all the users to the data base.
      UserDB.addUser(consumer1);
      UserDB.addUser(consumer2);
      UserDB.addUser(farmer1);
      UserDB.addUser(farmer2);
    }

    /********* SET UP RECIPES ***********/
    if (RecipeDB.getRecipes().isEmpty()) {
      ArrayList<TimedIngredient> recipe1Ingredients = new ArrayList<>();
      recipe1Ingredients.add(new TimedIngredient(IngredientDB.getIngredient("Nalo Greens"), 2, null, null, null));
      recipe1Ingredients.add(new TimedIngredient(IngredientDB.getIngredient("Braising Greens"), 3, null, null, null));

      ArrayList<String> proc1 = new ArrayList<>();
      proc1.add("Mix greens in bowl.");
      proc1.add("Eat it.");

      RecipeDB.addRecipe(new Recipe("Greens Salad", "A simple green salad.", recipe1Ingredients,  proc1, "images/stirFryChoySum.jpg"));

      ArrayList<TimedIngredient> recipe2Ingredients = new ArrayList<>();
      recipe1Ingredients.add(new TimedIngredient(IngredientDB.getIngredient("Dandelion Greens"), 4, null, null, null));
      recipe1Ingredients.add(new TimedIngredient(IngredientDB.getIngredient("Baby Kale"), 4, null, null, null));

      ArrayList<String> proc2 = new ArrayList<>();
      proc1.add("Mix kale and dandelion greens in bowl.");
      proc1.add("Eat it. Or don't. I don't care.");

      RecipeDB.addRecipe(new Recipe("Dandelion and Kale salad", "It's dandelions and kale.", recipe2Ingredients,  proc2, "images/orange.jpg"));
    }


/*
    ArrayList<TimedIngredient> ingredients = new ArrayList<TimedIngredient>();
    ingredients.add(new TimedIngredient("Nalo Greens", 20, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "6.00"));
    ingredients.add(new TimedIngredient("Dandelion Greens", 15, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "6.00"));
    ingredients.add(new TimedIngredient("Braising Greens", 13, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "6.00"));
    ingredients.add(new TimedIngredient("Baby Kale", 21, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients.add(new TimedIngredient("Baby Swiss Chard", 9, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients.add(new TimedIngredient("Tat Soi", 7, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients.add(new TimedIngredient("Purslane", 5, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients.add(new TimedIngredient("Okra", 5, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.50"));
    ingredients.add(new TimedIngredient("Baby Eggplant", 7, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients.add(new TimedIngredient("Sweet Basil", 9, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.25"));
    ingredients.add(new TimedIngredient("Italian Parsley", 5, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.75"));
    ingredients.add(new TimedIngredient("American Parsley", 6, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.25"));
    ingredients.add(new TimedIngredient("Mint", 6, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients.add(new TimedIngredient("Cilantro", 6, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.25"));
    ingredients.add(new TimedIngredient("Morimoto Tomato (Small)", 13,
        IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients.add(new TimedIngredient("Nalo Tomato (Large)", 10, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "1.50"));
    ingredients.add(new TimedIngredient("Sumida Watercress", 4, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients.add(new TimedIngredient("Kamiya Papaya", 10, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "3.00"));
    ingredients.add(new TimedIngredient("Fat Law Baby Cucumber", 9,
        IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients.add(new TimedIngredient("Nozawa Corn", 10, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients.add(new TimedIngredient("Ho Farm Tomato", 14, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "1.00"));
    Farmer farmer = new Farmer(0, "Nalo LIFE", "Farmer", "41-574 Makakalo Street Waimanalo, HI 96795",
        "Farmers Market at Windward Mall, Honolulu@Night (Neal Blaisdell Concert Hall), "
            + "Kailua@Night (Longs Kailua Parking Structure), Farmers Market @ HMSA,"
            + " Kapiolani Community College Farmers Market, Mililani High School",
        "808-259-7698", "images/farmPicture.jpg", ingredients);
    FarmerDB.addFarmer(farmer);

    ArrayList<TimedIngredient> ingredients2 = new ArrayList<TimedIngredient>();
    ingredients2.add(new TimedIngredient("Green Onions", 21, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "0.50"));
    ingredients2.add(new TimedIngredient("Pak Choy", 14, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients2.add(new TimedIngredient("Choy Sum", 14, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients2.add(new TimedIngredient("Kai Choy", 13, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients2.add(new TimedIngredient("Daikon", 17, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "1.50"));
    ingredients2.add(new TimedIngredient("Radish", 9, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "1.50"));
    ingredients2.add(new TimedIngredient("Zucchini", 12, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients2.add(new TimedIngredient("Won Bok (Chinese Cabbage)", 12,
        IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients2.add(new TimedIngredient("Apple Banana", 17, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "0.45"));
    ingredients2.add(new TimedIngredient("Mint", 16, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients2.add(new TimedIngredient("Basil", 14, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.25"));
    ingredients2.add(new TimedIngredient("Chives", 16, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients2.add(new TimedIngredient("Chinese Parsley", 19, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients2.add(new TimedIngredient("American Parsley", 24, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.50"));
    ingredients2.add(new TimedIngredient("Lemon Grass", 11, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients2.add(new TimedIngredient("Shanghai Pak Choy", 21, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients2.add(new TimedIngredient("Ewa Sweet Onion", 14, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "0.50"));
    ingredients2.add(new TimedIngredient("Eggplant (Long)", 15, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients2.add(new TimedIngredient("Japanese Cucumber", 18, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients2.add(new TimedIngredient("Long Beans", 19, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "1.00"));
    ingredients2.add(new TimedIngredient("String Beans", 21, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "1.00"));
    ingredients2.add(new TimedIngredient("Paria Leaf (Bitter Melon Leaf)", 5,
        IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients2.add(new TimedIngredient("Camote Leaf (Potato Leaf)", 4,
        IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients2.add(new TimedIngredient("Saluyot", 22, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "1.00"));
    ingredients2.add(new TimedIngredient("Horenso", 14, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "1.00"));
    ingredients2.add(new TimedIngredient("Head Cabbage", 10, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "0.50"));
    ingredients2.add(new TimedIngredient("Cantaloupe", 20, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "1.00"));
    ingredients2.add(new TimedIngredient("Honeydew", 21, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "0.50"));
    ingredients2.add(new TimedIngredient("Sunburst", 25, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "3.00"));
    ingredients2.add(new TimedIngredient("Ewa Sweet Onion", 14, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "0.50"));
    ingredients2.add(new TimedIngredient("Broccoli", 19, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients2.add(new TimedIngredient("Sweet Corn", 20, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    ingredients2.add(new TimedIngredient("Halloween Pumpkin", 0, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "0.50"));
    ingredients2.add(new TimedIngredient("Kabocha Squash", 2, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "3.00"));
    ingredients2.add(new TimedIngredient("Thai Watermelon", 7, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "0.25"));
    ingredients2.add(new TimedIngredient("Curly Kale", 9, IngredientDate.makeCalendar(2015, Calendar.APRIL, 5),
        IngredientDate.makeCalendar(2016, Calendar.MAY, 30), "2.00"));
    Farmer farmer2 = new Farmer(1, "Aloun Farms", "Farmer", "91-1440 Farrington Hwy, Kapolei, HI 96707",
        "Kapiolani Community College Farmers Market", "808-677-9516", "images/farmPicture.jpg", ingredients2);
    FarmerDB.addFarmer(farmer2);

    ArrayList<Ingredient> fridge1 = new ArrayList<Ingredient>();
    fridge1.add(new Ingredient("Banana", 3));
    fridge1.add(new Ingredient("Kale", 2));
    fridge1.add(new Ingredient("Rice", 4));
    fridge1.add(new Ingredient("Flour", 2));
    fridge1.add(new Ingredient("Kalua Pig", 1));
    fridge1.add(new Ingredient("Spinach", 3));
    fridge1.add(new Ingredient("Tomato", 1));
    fridge1.add(new Ingredient("Milk", 1));
    fridge1.add(new Ingredient("Avocado", 2));
    fridge1.add(new Ingredient("Sliced Bread", 1));
    Consumer consumer1 = new Consumer(1, "Kale Lover", "Consumer", "2500 Campus Road, Honolulu, HI 96822", fridge1);
    ConsumerDB.addConsumer(consumer1);


    ArrayList<Ingredient> fridge2 = new ArrayList<Ingredient>();
    fridge2.add(new Ingredient("Olives", 1));
    fridge2.add(new Ingredient("Lettuce", 3));
    fridge2.add(new Ingredient("Poi", 3));
    fridge2.add(new Ingredient("Ginger", 1));
    fridge2.add(new Ingredient("Soy Milk", 1));
    fridge2.add(new Ingredient("Pita Bread", 2));
    fridge2.add(new Ingredient("Greek Yogurt", 1));
    fridge2.add(new Ingredient("Fresh Garlic", 1));
    fridge2.add(new Ingredient("Apples", 2));
    fridge2.add(new Ingredient("Cheddar Cheese", 1));
    Consumer consumer2 = new Consumer(2, "Kale Friend", "Consumer", "3071 Pualei Circle 96815", fridge2);
    ConsumerDB.addConsumer(consumer2);

    ArrayList<Ingredient> saladIngredients = new ArrayList<Ingredient>();
    saladIngredients.add(new Ingredient("Baby Kale", 2));
    saladIngredients.add(new Ingredient("Cantaloupe", 1));
    saladIngredients.add(new Ingredient("Nalo Greens", 2));
    ArrayList<String> saladProcedure = new ArrayList<String>();
    saladProcedure.add("Chop Cantaloupe, Kale, and Nalo Greens");
    saladProcedure.add("Mix chopped Kale, Cantaloupe, and Nalo Greens");
    saladProcedure.add("Add choice of salad dressing and enjoy.");
    Recipe kaleSalad = new Recipe(RecipeDB.getCurrentId(), "Kale Salad",
        "A very simple kale salad made from kale, nalo greens and cantaloupe.",
        saladIngredients, saladProcedure, "images/kaleSalad.jpg");
    RecipeDB.addRecipe(kaleSalad);


    ArrayList<Ingredient> stirFryChoySumIngredients = new ArrayList<Ingredient>();
    stirFryChoySumIngredients.add(new Ingredient("Choy Sum", 2));
    stirFryChoySumIngredients.add(new Ingredient("Baby Eggplant", 2));
    stirFryChoySumIngredients.add(new Ingredient("String Beans", 1));
    ArrayList<String> stirFryChoySumProcedure = new ArrayList<String>();
    stirFryChoySumProcedure.add("Heat wok until it smokes.");
    stirFryChoySumProcedure.add("Add oil and heat until it shimmers and is about to start smoking.");
    stirFryChoySumProcedure.add("Add ginger and garlic, stir fry until very fragrant, about forty seconds");
    stirFryChoySumProcedure.add("Add choy sum, string beans, and eggplant all at once, and stir fry"
       + " very vigorously; water will escape from the greens immediately.");
    stirFryChoySumProcedure.add("Stir and fry until the leaves are wilted and the stems are just starting to wilt");
    stirFryChoySumProcedure.add("Immediately remove from heat and "
        + "scrape into a heated serving platter and serve right away.");
    Recipe stirFryChoySum = new Recipe(RecipeDB.getCurrentId(), "Stir Fry Choy Sum",
        "A simple stir fry of choy sum, eggplant, and string beans.",
        stirFryChoySumIngredients, stirFryChoySumProcedure, "images/stirFryChoySum.jpg");
    RecipeDB.addRecipe(stirFryChoySum);

    ArrayList<Ingredient> orangeIngredients = new ArrayList<Ingredient>();
    orangeIngredients.add(new Ingredient("Orange", 1));
    ArrayList<String> orangeProcedure = new ArrayList<String>();
    orangeProcedure.add("Peel skin and eat.");
    Recipe orange = new Recipe(RecipeDB.getCurrentId(), "Orange", "Just an orange.", orangeIngredients,
        orangeProcedure, "images/orange.jpg");
    RecipeDB.addRecipe(orange);


    ArrayList<Ingredient> cornIngredients = new ArrayList<Ingredient>();
    cornIngredients.add(new Ingredient("Sweet Corn", 1));
    ArrayList<String> cornProcedure = new ArrayList<String>();
    cornProcedure.add("Husk the corn.");
    cornProcedure.add("Rinse the corn.");
    cornProcedure.add("Bring a pot of water to a boil.");
    cornProcedure.add("Place corn in the water.");
    cornProcedure.add("Wait for the water to return to a boil.");
    cornProcedure.add("Cook the corn for about 5 to 7 minutes or until soft.");
    cornProcedure.add("Remove corn from water and serve.");
    Recipe corn = new Recipe(RecipeDB.getCurrentId(), "Corn on the Cob", "Corn on the Cob!", cornIngredients,
        cornProcedure, "images/cornOnTheCob.jpg");
    RecipeDB.addRecipe(corn);

    ArrayList<Ingredient> mintTeaIngredients = new ArrayList<Ingredient>();
    mintTeaIngredients.add(new Ingredient("Mint", 1));
    ArrayList<String> mintTeaProcedure = new ArrayList<String>();
    mintTeaProcedure.add("Put 2 cups of water into a cooking bowl.");
    mintTeaProcedure.add("Rinse the mint under clean water and mix into bowl.");
    mintTeaProcedure.add("Boil the water until boiling.");
    mintTeaProcedure.add("Turn off heat and stir for 3 minutes.");
    mintTeaProcedure.add("Strain the leaves.");
    mintTeaProcedure.add("Add sugar and serve.");
    Recipe mintTea = new Recipe(RecipeDB.getCurrentId(), "Mint Tea",
        "A simple tea created with mint leaves.", mintTeaIngredients,
        mintTeaProcedure, "images/mintTea.jpg");
    RecipeDB.addRecipe(mintTea);

*/
  }

}
