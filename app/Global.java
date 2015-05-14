import assets.TimeStamp;
import models.Farmer;
import models.FarmerDB;
import models.Market;
import models.MarketDB;
import models.Procedure;
import models.Recipe;
import models.RecipeDB;
import models.Region;
import models.RegionDB;
import models.TimedIngredient;
import play.Application;
import play.GlobalSettings;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Initializes application with some data.
 * Created by Jack on 4/4/2015.
 */
public class Global extends GlobalSettings {

  @Override
  public void onStart(Application application) {
    super.onStart(application);

    Market mk1 = new Market("Honolulu@Night", "Neal Blaisdell Concert Hall, "
        + "777 Ward Ave, Honolulu, HI 96814", "Wednesday 4:00PM - 7:00PM");
    Market mk2 = new Market("Kapiolani Community College Farmers Market",
        "4303 Diamond Head Rd, Honolulu, HI 96816", "Saturday 7:30AM - 11:00AM, Tuesday 4:00PM - 7:00PM");
    Market mk3 = new Market("Farmers Market at Windward Mall",
        "46-056 Kamehameha Hwy, Kaneohe, HI 96744", "Wednesday 2:30PM - 7:30PM, Sunday 10:00AM - 2:00PM");
    Market mk4 = new Market("Mililani Farmers Market",
        "95-1200 Meheula Pkwy, Mililani 96789", "Sunday 8:00AM - 11:00AM");
    Market mk5 = new Market("King's Village Farmers Market",
        "131 Kaiulani St, Honolulu, HI 96815", "Monday, Wednesday, Friday, and Saturday 4:00PM - 9:00PM");
    Market mk6 = new Market("Hyatt Farmers Market", "2424 Kalakaua Ave, Honolulu HI 96815",
        "Thursday 4:00PM - 8:00PM");
    Market mk7 = new Market("People's Open Market", "Old Stadium Mall, 2237 S King St, Honolulu 96818",
        "Wednesday 8:15AM - 9:15AM");
    Market mk8 = new Market("Manoa Farmers Market", " 2753 Woodlawn Dr, Honolulu 96822",
        "Tuesday and Sunday 7:00AM - 11:00AM");
    Market mk9 = new Market("Makiki Farmers Market", "1515 Wilder Ave, Honolulu 96822",
        "Thursday 4:30PM - 7:30PM");
    Market mk10 = new Market("Kakaako Farmers Market", "1050 Ala Moana Blvd, Honolulu 96814",
        "Saturday 8:00AM - 12:00PM");
    Market mk11 = new Market("Kaiser Farmers Market", "1010 Pensacola Ave, Honolulu 96814",
        "Thursday 4:30PM - 7:30PM");
    Market mk12 = new Market("Kekaulike Market", "1039 Kekaulike St, Honolulu, HI 96817",
        "Monday to Saturday, 9:00AM - 5:00PM");
    Market mk13 = new Market("Pearlridge Farmers Market", "98-130 Pali Momi St, Aiea, HI 96701",
        "Saturday 8:00AM - 12:00PM");
    Market mk14 = new Market("Makeke Kapolei", "Kapolei High School, 91-5007 Kapolei Pkwy, Kapolei 96707",
        "Thursday 3:00PM - 6:30PM");
    Market mk15 = new Market("Mahiku Farmers Market", "5105 Iroquois Ave, Ewa Beach 96706",
        "Wednesday 3:00PM - 7:00PM");
    Market mk16 = new Market("Waialua People's Market", "67-106 Kealohanui St, Waialua, HI 96791",
        "Wednesday 4:30PM - 7:00PM, Saturday 8:30PM - 2:00PM");
    Market mk17 = new Market("Haleiwa Farmers Market", "59-864 Kamehameha Hwy, Haleiwa, 96712",
        "Thursday 3:00PM - 7:00PM");
    Market mk18 = new Market("North Shore Country Market", "Sunset Beach Elem, 59-360 Kamehameha Hwy, Haleiwa 96712",
        "Saturday 8:00AM - 2:00PM");
    Market mk19 = new Market("BYU Hawaii Farmers Market", " 55-220 Kulanui St., "
        + "Aloha Center Mall, Room 155/165, Laie 96762", "Every other Friday 10:30AM - 2:00PM");
    Market mk20 = new Market("Kailua Farmers Market", "609 Kailua Rd, Kailua, HI 96734",
        "Thursday 5:00PM - 7:30PM");
    Market mk21 = new Market("Kailua Town Farmers Market", "Kailua Elementary, 315 Kuulei Road, Kailua, HI 96734",
        "Sunday 8:00AM - 12:00PM");

    // Add zip codes around oahu to the database
    if (RegionDB.getRegions().isEmpty()) {
      RegionDB.addRegion(new Region("Aiea", "96701", "South, Central"));
      RegionDB.addRegion(new Region("Ewa Beach", "96706", "South"));
      RegionDB.addRegion(new Region("Kapolei", "96707", "South"));
      RegionDB.addRegion(new Region("Kapolei", "96709", "South"));
      RegionDB.addRegion(new Region("Haleiwa", "96712", "North"));
      RegionDB.addRegion(new Region("Hauula", "96717", "North"));
      RegionDB.addRegion(new Region("Kaaawa", "96730", "North, East"));
      RegionDB.addRegion(new Region("Kahuku", "96731", "North"));
      RegionDB.addRegion(new Region("Kailua", "96734", "East"));
      RegionDB.addRegion(new Region("Kaneohe", "96744", "East"));
      RegionDB.addRegion(new Region("Kunia", "96759", "West, Central"));
      RegionDB.addRegion(new Region("Laie", "96762", "North"));
      RegionDB.addRegion(new Region("Pearl City", "96782", "South, West, Central"));
      RegionDB.addRegion(new Region("Wahiawa", "96786", "South"));
      RegionDB.addRegion(new Region("Mililani", "96789", "Central"));
      RegionDB.addRegion(new Region("Waialua", "96791", "North"));
      RegionDB.addRegion(new Region("Waianae", "96792", "West"));
      RegionDB.addRegion(new Region("Waimanalo", "96795", "East"));
      RegionDB.addRegion(new Region("Waipahu", "96797", "South, Central"));
      RegionDB.addRegion(new Region("Honolulu", "96801", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96802", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96803", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96804", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96805", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96806", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96807", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96808", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96809", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96810", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96811", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96812", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96813", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96814", "South"));
      RegionDB.addRegion(new Region("Waikiki", "96815", "South"));
      RegionDB.addRegion(new Region("Waialae / Kahala", "96816", "South"));
      RegionDB.addRegion(new Region("Kapalama", "96817", "South"));
      RegionDB.addRegion(new Region("Kapalama", "96819", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96820", "South"));
      RegionDB.addRegion(new Region("Waialae / Kahala", "96821", "South"));
      RegionDB.addRegion(new Region("Makiki", "96822", "South"));
      RegionDB.addRegion(new Region("Makiki", "96823", "South"));
      RegionDB.addRegion(new Region("Makiki", "96824", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96825", "South"));
      RegionDB.addRegion(new Region("Makiki", "96826", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96836", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96837", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96838", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96839", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96840", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96841", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96843", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96844", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96846", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96847", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96848", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96849", "South"));
      RegionDB.addRegion(new Region("Honolulu", "96850", "South"));
      RegionDB.addRegion(new Region("Hickam AFB", "96853", "South, Central"));
      RegionDB.addRegion(new Region("Wheeler Army Airfield", "96854", "Central"));
      RegionDB.addRegion(new Region("Schofield Barracks", "96857", "Central"));
      RegionDB.addRegion(new Region("Fort Shafter", "96858", "South, Central"));
      RegionDB.addRegion(new Region("Tripler Army Medical Center", "96859", "South, Central"));
      RegionDB.addRegion(new Region("Pearl Harbor", "96860", "South, Central"));
      RegionDB.addRegion(new Region("Camp H M Smith", "96861", "South, Central"));
      RegionDB.addRegion(new Region("M C B H Kaneohe Bay", "96863", "East"));
    }

    // Create a few markets
    if (MarketDB.getMarkets().isEmpty()) {

      MarketDB.addMarket(mk1);
      MarketDB.addMarket(mk2);
      MarketDB.addMarket(mk3);
      MarketDB.addMarket(mk4);
      MarketDB.addMarket(mk5);
      MarketDB.addMarket(mk6);
      MarketDB.addMarket(mk7);
      MarketDB.addMarket(mk8);
      MarketDB.addMarket(mk9);
      MarketDB.addMarket(mk10);
      MarketDB.addMarket(mk11);
      MarketDB.addMarket(mk12);
      MarketDB.addMarket(mk13);
      MarketDB.addMarket(mk14);
      MarketDB.addMarket(mk15);
      MarketDB.addMarket(mk16);
      MarketDB.addMarket(mk17);
      MarketDB.addMarket(mk18);
      MarketDB.addMarket(mk19);
      MarketDB.addMarket(mk20);
      MarketDB.addMarket(mk21);
    }

    if (TimedIngredient.find().all().isEmpty()) {
      ArrayList<TimedIngredient> ingredients = new ArrayList<TimedIngredient>();
      ingredients.add(new TimedIngredient("Nalo Greens", 20, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "6.00", "images/ingredient/nalo_greens.jpg"));
      ingredients.add(new TimedIngredient("Dandelion Greens", 15, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "6.00", "images/ingredient/dandelion_greens.jpg"));
      ingredients.add(new TimedIngredient("Braising Greens", 13, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "6.00", "images/ingredient/braising_greens.jpg"));
      ingredients.add(new TimedIngredient("Baby Kale", 21, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/baby_kale.jpg"));
      ingredients.add(new TimedIngredient("Baby Swiss Chard", 9, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/baby_swiss_chard.png"));
      ingredients.add(new TimedIngredient("Tat Soi", 7, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/tat_soi.jpg"));
      ingredients.add(new TimedIngredient("Purslane", 5, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/purslane.jpg"));
      ingredients.add(new TimedIngredient("Okra", 5, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.50", "images/ingredient/okra.jpg"));
      ingredients.add(new TimedIngredient("Baby Eggplant", 7, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/baby_eggplant.jpg"));
      ingredients.add(new TimedIngredient("Sweet Basil", 9, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.25", "images/ingredient/sweet_basil.jpg"));
      ingredients.add(new TimedIngredient("Italian Parsley", 5, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.75", "images/ingredient/italian_parsley.jpg"));
      ingredients.add(new TimedIngredient("American Parsley", 6, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.25", "images/ingredient/american_parsley.jpg"));
      ingredients.add(new TimedIngredient("Mint", 6, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/mint.jpg"));
      ingredients.add(new TimedIngredient("Cilantro", 6, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.25", "images/ingredient/cilantro.jpg"));
      ingredients.add(new TimedIngredient("Morimoto Tomato (Small)", 13,
          TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/morimoto_tomato.jpg"));
      ingredients.add(new TimedIngredient("Nalo Tomato (Large)", 10, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "1.50", "images/ingredient/nalo_tomato.jpg"));
      ingredients.add(new TimedIngredient("Sumida Watercress", 4, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/sumida_watercress.jpg"));
      ingredients.add(new TimedIngredient("Kamiya Papaya", 10, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "3.00", "images/ingredient/kamiya_papaya.jpg"));
      ingredients.add(new TimedIngredient("Fat Law Baby Cucumber", 9,
          TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/fat_law_baby_cucumber.jpg"));
      ingredients.add(new TimedIngredient("Nozawa Corn", 10, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/nozawa_corn.jpg"));
      ingredients.add(new TimedIngredient("Ho Farm Tomato", 14, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "1.00", "images/ingredient/ho_farm_tomato.jpg"));

      // Make list of markets for farmer
      List<Market> m = new ArrayList<>();
      m.add(mk1);
      m.add(mk2);
      m.add(mk3);
      m.add(mk18);
      m.add(mk19);


      Farmer farmer = new Farmer("Nalo LIFE", "41-574 Makakalo Street Waimanalo, HI 96795",
          m, "808-259-7698", "images/farmPicture.jpg", ingredients, "password");
      FarmerDB.addFarmer(farmer);

      m.clear();

      ArrayList<TimedIngredient> ingredients2 = new ArrayList<TimedIngredient>();
      ingredients2.add(new TimedIngredient("Green Onions", 21, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "0.50", "images/ingredient/green_onions.jpg"));
      ingredients2.add(new TimedIngredient("Pak Choy", 14, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/pak_choy.jpg"));
      ingredients2.add(new TimedIngredient("Choy Sum", 14, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/choy_sum.jpg"));
      ingredients2.add(new TimedIngredient("Kai Choy", 13, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/kai_choy.jpg"));
      ingredients2.add(new TimedIngredient("Daikon", 17, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "1.50", "images/ingredient/daikon.jpg"));
      ingredients2.add(new TimedIngredient("Radish", 9, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "1.50", "images/ingredient/radish.jpg"));
      ingredients2.add(new TimedIngredient("Zucchini", 12, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/zucchini.jpg"));
      ingredients2.add(new TimedIngredient("Won Bok (Chinese Cabbage)", 12,
          TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/won_bok.jpg"));
      ingredients2.add(new TimedIngredient("Apple Banana", 17, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "0.45", "images/ingredient/apple_banana.jpg"));
      ingredients2.add(new TimedIngredient("Mint", 16, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/mint.jpg"));
      ingredients2.add(new TimedIngredient("Basil", 14, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.25", "images/ingredient/basil.jpg"));
      ingredients2.add(new TimedIngredient("Chives", 16, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/chives.jpg"));
      ingredients2.add(new TimedIngredient("Chinese Parsley", 19, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/chinese_parsley.jpg"));
      ingredients2.add(new TimedIngredient("American Parsley", 24, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.50", "images/ingredient/american_parsley.jpg"));
      ingredients2.add(new TimedIngredient("Lemon Grass", 11, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/lemon_grass.jpg"));
      ingredients2.add(new TimedIngredient("Shanghai Pak Choy", 21, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/shanghai_pak_choy.jpg"));
      ingredients2.add(new TimedIngredient("Ewa Sweet Onion", 14, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "0.50", "images/ingredient/ewa_sweet_onion.jpg"));
      ingredients2.add(new TimedIngredient("Eggplant (Long)", 15, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/eggplant.jpg"));
      ingredients2.add(new TimedIngredient("Japanese Cucumber", 18, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/japanese_cucumber.jpg"));
      ingredients2.add(new TimedIngredient("Long Beans", 19, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "1.00", "images/ingredient/long_beans.jpg"));
      ingredients2.add(new TimedIngredient("String Beans", 21, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "1.00", "images/ingredient/string_beans.jpg"));
      ingredients2.add(new TimedIngredient("Paria Leaf (Bitter Melon Leaf)", 5,
          TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/paria_leaf.jpg"));
      ingredients2.add(new TimedIngredient("Camote Leaf (Potato Leaf)", 4,
          TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/camote_leaf.jpg"));
      ingredients2.add(new TimedIngredient("Saluyot", 22, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "1.00", "images/ingredient/saluyot.jpg"));
      ingredients2.add(new TimedIngredient("Horenso", 14, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "1.00", "images/ingredient/horenso.jpg"));
      ingredients2.add(new TimedIngredient("Head Cabbage", 10, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "0.50", "images/ingredient/head_cabbage.jpg"));
      ingredients2.add(new TimedIngredient("Cantaloupe", 20, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "1.00", "images/ingredient/cantaloupe.jpg"));
      ingredients2.add(new TimedIngredient("Honeydew", 21, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "0.50", "images/ingredient/honeydew.jpg"));
      ingredients2.add(new TimedIngredient("Sunburst", 25, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "3.00", "images/ingredient/cantaloupe.jpg"));
      ingredients2.add(new TimedIngredient("Ewa Sweet Onion", 14, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "0.50", "images/ingredient/ewa_sweet_onion.jpg"));
      ingredients2.add(new TimedIngredient("Broccoli", 19, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/broccoli.jpg"));
      ingredients2.add(new TimedIngredient("Sweet Corn", 20, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/sweet_corn.jpg"));
      ingredients2.add(new TimedIngredient("Halloween Pumpkin", 0, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "0.50", "images/ingredient/pumpkin.jpg"));
      ingredients2.add(new TimedIngredient("Kabocha Squash", 2, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "3.00", "images/ingredient/kabocha_squash.jpg"));
      ingredients2.add(new TimedIngredient("Thai Watermelon", 7, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "0.25", "images/ingredient/thai_watermelon.jpg"));
      ingredients2.add(new TimedIngredient("Curly Kale", 9, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/curly_kale.jpg"));

      // Make list of markets for farmer
      List<Market> m2 = new ArrayList<>();
      m2.add(mk2);
      m2.add(mk10);
      m2.add(mk20);
      m2.add(mk21);
      m2.add(mk15);
      m2.add(mk11);


      Farmer farmer2 = new Farmer("Aloun Farms", "91-1440 Farrington Hwy, Kapolei, HI 96707",
          m2, "808-677-9516", "images/farmPicture.jpg", ingredients2, "password");
      FarmerDB.addFarmer(farmer2);

      m2.clear();

      ArrayList<TimedIngredient> ingredients3 = new ArrayList<TimedIngredient>();
      ingredients3.add(new TimedIngredient("Green Onions", 21, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "0.50", "images/ingredient/green_onions.jpg"));
      ingredients3.add(new TimedIngredient("Pak Choy", 14, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/pak_choy.jpg"));
      ingredients3.add(new TimedIngredient("Choy Sum", 14, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/choy_sum.jpg"));
      ingredients3.add(new TimedIngredient("Kai Choy", 13, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/kai_choy.jpg"));
      ingredients3.add(new TimedIngredient("Daikon", 17, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "1.50", "images/ingredient/daikon.jpg"));
      ingredients3.add(new TimedIngredient("Radish", 9, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "1.50", "images/ingredient/radish.jpg"));
      ingredients3.add(new TimedIngredient("Zucchini", 12, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/zucchini.jpg"));
      ingredients3.add(new TimedIngredient("Won Bok (Chinese Cabbage)", 12,
          TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/won_bok.jpg"));

      // Make list of markets for farmer
      List<Market> m3 = new ArrayList<>();
      m3.add(mk2);
      m3.add(mk4);
      m3.add(mk5);
      m3.add(mk6);
      m3.add(mk7);
      m3.add(mk8);


      Farmer farmer3 = new Farmer("HSN Farm LLC", "Mililani, Oahu, Hawaii 96789",
          m3, "", "images/farmPicture.jpg", ingredients3, "password");
      FarmerDB.addFarmer(farmer3);

      m3.clear();

      ArrayList<TimedIngredient> ingredients4 = new ArrayList<TimedIngredient>();
      ingredients4.add(new TimedIngredient("Head Cabbage", 10, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "0.50", "images/ingredient/head_cabbage.jpg"));
      ingredients4.add(new TimedIngredient("Cantaloupe", 20, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "1.00", "images/ingredient/cantaloupe.jpg"));
      ingredients4.add(new TimedIngredient("Honeydew", 21, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "0.50", "images/ingredient/honeydew.jpg"));
      ingredients4.add(new TimedIngredient("Sunburst", 25, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "3.00", "images/ingredient/cantaloupe.jpg"));
      ingredients4.add(new TimedIngredient("Ewa Sweet Onion", 14, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "0.50", "images/ingredient/ewa_sweet_onion.jpg"));
      ingredients4.add(new TimedIngredient("Broccoli", 19, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/broccoli.jpg"));
      ingredients4.add(new TimedIngredient("Sweet Corn", 20, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/sweet_corn.jpg"));
      ingredients4.add(new TimedIngredient("Halloween Pumpkin", 0, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "0.50", "images/ingredient/pumpkin.jpg"));
      ingredients4.add(new TimedIngredient("Kabocha Squash", 2, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "3.00", "images/ingredient/kabocha_squash.jpg"));
      ingredients4.add(new TimedIngredient("Thai Watermelon", 7, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "0.25", "images/ingredient/thai_watermelon.jpg"));

      // Make list of markets for farmer
      List<Market> m4 = new ArrayList<>();
      m4.add(mk9);
      m4.add(mk12);
      m4.add(mk13);
      m4.add(mk16);
      m4.add(mk14);
      m4.add(mk17);


      Farmer farmer4 = new Farmer("Frankie's Nursery", "41-999 Mahiku Pl, Waimanalo, HI 96795",
          m4, "(808)259-8737", "images/farmPicture.jpg", ingredients4, "password");
      FarmerDB.addFarmer(farmer4);

      m4.clear();

      ArrayList<TimedIngredient> ingredients5 = new ArrayList<TimedIngredient>();
      ingredients5.add(new TimedIngredient("Dandelion Greens", 15, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "6.00", "images/ingredient/dandelion_greens.jpg"));
      ingredients5.add(new TimedIngredient("Braising Greens", 13, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "6.00", "images/ingredient/braising_greens.jpg"));
      ingredients5.add(new TimedIngredient("Baby Kale", 21, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/baby_kale.jpg"));
      ingredients5.add(new TimedIngredient("Baby Swiss Chard", 9, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/baby_swiss_chard.png"));
      ingredients5.add(new TimedIngredient("Tat Soi", 7, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/tat_soi.jpg"));
      ingredients5.add(new TimedIngredient("Purslane", 5, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/purslane.jpg"));
      ingredients5.add(new TimedIngredient("Okra", 5, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.50", "images/ingredient/okra.jpg"));
      ingredients5.add(new TimedIngredient("Baby Eggplant", 7, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.00", "images/ingredient/baby_eggplant.jpg"));
      ingredients5.add(new TimedIngredient("Sweet Basil", 9, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.25", "images/ingredient/sweet_basil.jpg"));
      ingredients5.add(new TimedIngredient("Italian Parsley", 5, TimeStamp.makeCalendar(2015, Calendar.APRIL, 5),
          TimeStamp.makeCalendar(2016, Calendar.MAY, 30), "2.75", "images/ingredient/italian_parsley.jpg"));

      // Make list of markets for farmer
      List<Market> m5 = new ArrayList<>();
      m5.add(mk7);
      m5.add(mk12);
      m5.add(mk13);
      m5.add(mk6);
      m5.add(mk8);


      Farmer farmer5 = new Farmer("Pit Farms", "Wahiawa, Oahu, Hawaii 96786",
          m5, "", "images/farmPicture.jpg", ingredients5, "password");
      FarmerDB.addFarmer(farmer5);

      m5.clear();
    }


    if (Recipe.find().all().isEmpty()) {
      ArrayList<TimedIngredient> saladIngredients = new ArrayList<TimedIngredient>();
      saladIngredients.add(new TimedIngredient("Baby Kale", 2));
      saladIngredients.add(new TimedIngredient("Cantaloupe", 1));
      saladIngredients.add(new TimedIngredient("Nalo Greens", 2));
      List<Procedure> saladProcedure = new ArrayList<Procedure>();
      saladProcedure.add(new Procedure("Chop, Cantaloupe, Kale, and Nalo Greens"));
      saladProcedure.add(new Procedure("Mix chopped Kale, Cantaloupe, and Nalo Greens"));
      saladProcedure.add(new Procedure("Add choice of salad dressing and enjoy."));
      Recipe kaleSalad = new Recipe("Kale Salad",
          "A very simple kale salad made from kale, nalo greens and cantaloupe.",
          saladIngredients, saladProcedure, "images/kaleSalad.jpg");
      RecipeDB.addRecipe(kaleSalad);


      ArrayList<TimedIngredient> stirFryChoySumIngredients = new ArrayList<TimedIngredient>();
      stirFryChoySumIngredients.add(new TimedIngredient("Choy Sum", 2));
      stirFryChoySumIngredients.add(new TimedIngredient("Baby Eggplant", 2));
      stirFryChoySumIngredients.add(new TimedIngredient("String Beans", 1));
      List<Procedure> stirFryChoySumProcedure = new ArrayList<Procedure>();
      stirFryChoySumProcedure.add(new Procedure("Heat wok until it smokes."));
      stirFryChoySumProcedure.add(new Procedure("Add oil and heat until it shimmers and is about to start smoking."));
      stirFryChoySumProcedure.add(new Procedure("Add ginger and garlic, stir fry until "
          + "very fragrant, about forty seconds"));
      stirFryChoySumProcedure.add(new Procedure("Add choy sum, string beans, and eggplant all at once, and stir fry"
          + " very vigorously; water will escape from the greens immediately."));
      stirFryChoySumProcedure.add(new Procedure("Stir and fry until the leaves are wilted and the "
          + "stems are just starting to wilt"));
      stirFryChoySumProcedure.add(new Procedure("Immediately remove from heat and "
          + "scrape into a heated serving platter and serve right away."));
      Recipe stirFryChoySum = new Recipe("Stir Fry Choy Sum",
          "A simple stir fry of choy sum, eggplant, and string beans.",
          stirFryChoySumIngredients, stirFryChoySumProcedure, "images/stirFryChoySum.jpg");
      RecipeDB.addRecipe(stirFryChoySum);

      ArrayList<TimedIngredient> orangeIngredients = new ArrayList<TimedIngredient>();
      orangeIngredients.add(new TimedIngredient("Orange", 1));
      List<Procedure> orangeProcedure = new ArrayList<Procedure>();

      orangeProcedure.add(new Procedure("Peel skin and eat."));
      Recipe orange = new Recipe("Orange", "Just an orange.", orangeIngredients,
          orangeProcedure, "images/orange.jpg");
      RecipeDB.addRecipe(orange);


      ArrayList<TimedIngredient> cornIngredients = new ArrayList<TimedIngredient>();
      cornIngredients.add(new TimedIngredient("Sweet Corn", 1));
      List<Procedure> cornProcedure = new ArrayList<>();
      cornProcedure.add(new Procedure("Husk the corn."));
      cornProcedure.add(new Procedure("Rinse the corn."));
      cornProcedure.add(new Procedure("Bring a pot of water to a boil."));
      cornProcedure.add(new Procedure("Place corn in the water."));
      cornProcedure.add(new Procedure("Wait for the water to return to a boil."));
      cornProcedure.add(new Procedure("Cook the corn for about 5 to 7 minutes or until soft."));
      cornProcedure.add(new Procedure("Remove corn from water and serve."));
      Recipe corn = new Recipe("Corn on the Cob", "Corn on the Cob!", cornIngredients,
          cornProcedure, "images/cornOnTheCob.jpg");
      RecipeDB.addRecipe(corn);

      ArrayList<TimedIngredient> mintTeaIngredients = new ArrayList<TimedIngredient>();
      mintTeaIngredients.add(new TimedIngredient("Mint", 1));
      List<Procedure> mintTeaProcedure = new ArrayList<>();
      mintTeaProcedure.add(new Procedure("Put 2 cups of water into a cooking bowl."));
      mintTeaProcedure.add(new Procedure("Rinse the mint under clean water and mix into bowl."));
      mintTeaProcedure.add(new Procedure("Boil the water until boiling."));
      mintTeaProcedure.add(new Procedure("Turn off heat and stir for 3 minutes."));
      mintTeaProcedure.add(new Procedure("Strain the leaves."));
      mintTeaProcedure.add(new Procedure("Add sugar and serve."));
      Recipe mintTea = new Recipe("Mint Tea",
          "A simple tea created with mint leaves.", mintTeaIngredients,
          mintTeaProcedure, "images/mintTea.jpg");
      RecipeDB.addRecipe(mintTea);

      ArrayList<TimedIngredient> blueberryIngredients = new ArrayList<TimedIngredient>();
      blueberryIngredients.add(new TimedIngredient("Blueberry", 2));
      blueberryIngredients.add(new TimedIngredient("Strawberry", 2));
      blueberryIngredients.add(new TimedIngredient("Greek Yogurt", 1));
      blueberryIngredients.add(new TimedIngredient("Honey", 1));

      List<Procedure> blueberryProcedure = new ArrayList<>();
      blueberryProcedure.add(new Procedure("Rinse blueberries and strawberries."));
      blueberryProcedure.add(new Procedure("Put all ingredients into a blender. Ice is optional"));
      blueberryProcedure.add(new Procedure("Blend for 10 seconds or until smooth."));
      blueberryProcedure.add(new Procedure("Add sugar to taste and serve."));
      Recipe blueberry = new Recipe("Blueberry Smoothie",
          "A delicious refreshing fruit smoothie.", blueberryIngredients,
          blueberryProcedure, "images/blueberry.jpg");
      RecipeDB.addRecipe(blueberry);


      ArrayList<TimedIngredient> strawIngredients = new ArrayList<TimedIngredient>();
      strawIngredients.add(new TimedIngredient("Banana", 2));
      strawIngredients.add(new TimedIngredient("Strawberry", 2));
      strawIngredients.add(new TimedIngredient("Greek Yogurt", 1));
      strawIngredients.add(new TimedIngredient("Honey", 1));

      List<Procedure> strawProcedure = new ArrayList<>();
      strawProcedure.add(new Procedure("Peel bananas and rinse strawberries."));
      strawProcedure.add(new Procedure("Put all ingredients into a blender. Ice is optional"));
      strawProcedure.add(new Procedure("Blend for 10 seconds or until smooth."));
      strawProcedure.add(new Procedure("Add sugar to taste and serve."));
      Recipe straw = new Recipe("Strawberry Banana Smoothie",
          "A delicious refreshing blend of bananas and strawberries.", strawIngredients,
          blueberryProcedure, "images/straw.jpg");
      RecipeDB.addRecipe(straw);


      ArrayList<TimedIngredient> pineIngredients = new ArrayList<TimedIngredient>();
      pineIngredients.add(new TimedIngredient("Blueberry", 2));
      pineIngredients.add(new TimedIngredient("Pineapple", 1));
      pineIngredients.add(new TimedIngredient("Strawberry", 2));
      pineIngredients.add(new TimedIngredient("Greek Yogurt", 1));
      pineIngredients.add(new TimedIngredient("Honey", 1));

      List<Procedure> pineProcedure = new ArrayList<>();
      pineProcedure.add(new Procedure("Peel pineapple and rinse strawberries."));
      pineProcedure.add(new Procedure("Put all ingredients into a blender. Ice is optional"));
      pineProcedure.add(new Procedure("Blend for 10 seconds or until smooth."));
      pineProcedure.add(new Procedure("Add sugar to taste and serve."));
      Recipe pine = new Recipe("Pineapple Smoothie",
          "A delicious refreshing blend of local fruit flavors.", pineIngredients,
          pineProcedure, "images/pine.jpg");
      RecipeDB.addRecipe(pine);

    }

  }

}
