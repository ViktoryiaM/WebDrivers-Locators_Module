package Task.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CloudEstimateResultsPage {
  private WebDriver driver;

  public CloudEstimateResultsPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getVMClass() {
    return driver.findElement(By.xpath("//*[@id='compute']/descendant::div[contains(text(),'VM class')]")).getText();
  }

  public String getInstanceType() {
    return driver.findElement(By.xpath("//*[@id='compute']/descendant::div[contains(text(),'Instance type')]")).getText();
  }

  public String getRegion() {
    return driver.findElement(By.xpath("//*[@id='compute']/descendant::div[contains(text(),'Region:')]")).getText();
  }

  public String getLocalSSD() {
    return driver.findElement(By.xpath("//*[@id='compute']/descendant::div[contains(text(),'Local SSD:')]")).getText();
  }

  public String getCommitmentTerm() {
    return driver.findElement(By.xpath("//*[@id='compute']/descendant::div[contains(text(),'Commitment term:')]")).getText();
  }

  public String getTotalMonthCost() {
    return driver.findElement(By.xpath("//*[@id='resultBlock']/descendant::b[contains(text(),'Total Estimated Cost:')]")).getText();
  }

}
