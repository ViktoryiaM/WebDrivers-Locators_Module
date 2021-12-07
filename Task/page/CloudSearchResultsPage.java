package Task.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CloudSearchResultsPage {
  private WebDriver driver;

  public CloudSearchResultsPage(WebDriver driver) {
    this.driver = driver;
  }

  public CloudComputeEnginePage openComputeEnginePage(){
    this.waitTillElementUpload(10, By.xpath("//b[text()='Google Cloud Platform Pricing Calculator']/parent::a"));
    this.getElement(By.xpath("//b[text()='Google Cloud Platform Pricing Calculator']/parent::a")).click();
    return new CloudComputeEnginePage(driver);
  }

  private void waitTillElementUpload(int seconds, By by) {
    new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.presenceOfElementLocated(by));
  }

  private WebElement getElement(By by) {
    return driver.findElement(by);
  }
}
