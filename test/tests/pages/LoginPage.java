package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides testing support for the login profile page.
 *
 */
public class LoginPage extends FluentPage {
  private String url;

  /**
   * Create the farmer's profile page.
   *
   * @param webDriver The driver.
   * @param port      The port.
   */
  public LoginPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/login";
  }

  @Override
  public String getUrl() {
    return this.url;
  }

  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Home (Kale With Friends)");
  }


  /**
   * The input data.
   * @param name the name
   * @param password the password
   */
  public void inputData(String name, String password) {
    fill("#name").with(name);
    fill("#password").with(password);
    submit("#submit");
  }

}
