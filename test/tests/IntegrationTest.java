package tests;

import org.junit.Test;
import play.libs.F.Callback;
import play.test.TestBrowser;
import tests.pages.AvailableNowPage;
import tests.pages.CookbookPage;
import tests.pages.FarmerDashboardPage;
import tests.pages.FarmerProfilePage;
import tests.pages.LoginPage;
import tests.pages.MarketsPage;
import tests.pages.MealPlannerPage;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;

/**
 * Runs a server with a fake in-memory database to test the system.
 */
public class IntegrationTest {

  /**
   * The port to be used for testing.
   */
  private final int port = 3333;


  /**
   * Check to see that both the index and page1 pages can be retrieved.
   */
  @Test
  public void test() {
    running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.goTo("http://localhost:3333");
        assertThat(browser.pageSource()).contains("Kale With Friends");

        browser.goTo("http://localhost:3333/farmersprofile");
        assertThat(browser.pageSource()).contains("Farm location");

        browser.goTo("http://localhost:3333/mealplanner");
        assertThat(browser.pageSource()).contains("Meal Planner");

        browser.goTo("http://localhost:3333/cookbook");
        assertThat(browser.pageSource()).contains("Public Recipes");

        browser.goTo("http://localhost:3333/availablenow");
        assertThat(browser.pageSource()).contains("Available");

      }
    });
  }

  /**
   * Check to see that the farmer's profile can be retrieved.
   */
  @Test
  public void testRetrieveFarmersProfilePage() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();
            FarmerProfilePage farmerProfilePage = new FarmerProfilePage(browser.getDriver(), port);
            browser.goTo(farmerProfilePage);
            farmerProfilePage.isAt();
          }
        });
  }


  /**
   * Check to see that the available now page can be retrieved.
   */
  @Test
  public void testRetrieveAvailableNowPage() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();
            AvailableNowPage availableNowPage = new AvailableNowPage(browser.getDriver(), port);
            browser.goTo(availableNowPage);
            availableNowPage.isAt();
          }
        });
  }

  /**
   * Check to see that the cookbook page can be retrieved.
   */
  @Test
  public void testRetrieveCookbookPage() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();
            CookbookPage cookbookPage = new CookbookPage(browser.getDriver(), port);
            browser.goTo(cookbookPage);
            cookbookPage.isAt();
          }
        });
  }

  /**
   * Check to see that the markets page can be retrieved.
   */
  @Test
  public void testRetrieveMarketsPage() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();
            MarketsPage marketsPage = new MarketsPage(browser.getDriver(), port);
            browser.goTo(marketsPage);
            marketsPage.isAt();
          }
        });
  }


  /**
   * Check to see that the markets page can be retrieved.
   */
  @Test
  public void testRetrieveMealPlannerPage() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();
            MealPlannerPage mealPlannerPage = new MealPlannerPage(browser.getDriver(), port);
            browser.goTo(mealPlannerPage);
            mealPlannerPage.isAt();
          }
        });
  }
  /**
   * Check to see that the login page can be retrieved.
   */
  @Test
  public void testRetrieveLoginPage() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();
            LoginPage loginPage = new LoginPage(browser.getDriver(), port);
            browser.goTo(loginPage);
            loginPage.isAt();
          }
        });
  }


  /**
   * Check to see that the login authentication works.
   */
  @Test
  public void testLoginPage() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();
            LoginPage loginPage = new LoginPage(browser.getDriver(), port);
            browser.goTo(loginPage);
            loginPage.isAt();
            String name = "Aloun Farms";
            String password = "password";
            loginPage.inputData(name, password);
            FarmerDashboardPage farmerDashboardPage = new FarmerDashboardPage(browser.getDriver(), port);
            browser.goTo(farmerDashboardPage);
            farmerDashboardPage.isAt();

          }
        });
  }

}
