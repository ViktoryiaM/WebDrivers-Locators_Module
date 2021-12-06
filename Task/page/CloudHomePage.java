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

  public void navigateTo(String path) {
    driver.get(path);
  }

  public void waitTillElementUpload(int seconds, By by) {
    new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.presenceOfElementLocated(by));
  }

  public WebElement getElement(By by) {
    return driver.findElement(by);
  }

  public void switchToFrame(String name) {
    driver.switchTo().frame(name);
  }

  public void switchToFrame(int index) {
    driver.switchTo().frame(index);
  }

  public void quit() {
    driver.quit();
  }
}