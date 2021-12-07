package Task.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CloudHomePage {
  private WebDriver driver;

  public CloudHomePage(WebDriver driver) {
    this.driver = driver;
  }

  public CloudHomePage openPage() {
    driver.get("https://cloud.google.com/");
    return this;
  }

  public CloudSearchResultsPage search(String searchTerm) {
    this.waitTillElementUpload(10, By.name("q"));
    this.getElement(By.name("q")).sendKeys(searchTerm + "\n");
    return new CloudSearchResultsPage(driver);
  }

  private void waitTillElementUpload(int seconds, By by) {
    new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.presenceOfElementLocated(by));
  }

  private WebElement getElement(By by) {
    return driver.findElement(by);
  }
}