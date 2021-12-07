package Task.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CloudComputeEnginePage {
  private WebDriver driver;

  public CloudComputeEnginePage(WebDriver driver) {
    this.driver = driver;
  }

  public CloudComputeEnginePage openComputeEngineTab() {
    this.waitTillElementUpload(10, By.xpath("//iframe[contains(@name,'goog_')]"));
    this.switchToFrame(0);
    this.waitTillElementUpload(10, By.xpath("//iframe[@id='myFrame']"));
    this.switchToFrame("myFrame");
    this.getElement(By.xpath("//div[@title='Compute Engine']/ancestor::md-tab-item")).click();
    return this;
  }

  public CloudComputeEnginePage setNumberOfInstances(int numberOfInstances) {
    this.getElement(By.name("quantity")).sendKeys(String.valueOf(numberOfInstances));
    return this;
  }

  public CloudComputeEnginePage setOperatingSystem(String operatingSystem) {
    this.getElement(By.id("select_88")).click();
    this.getElement(By.xpath("//*[contains(text(),'" + operatingSystem + "')]/ancestor::md-option")).click();
    return this;
  }

  public CloudComputeEnginePage setMachineClass() {
    this.getElement(By.id("select_92")).click();
    this.getElement(By.id("select_option_90")).click();
    return this;
  }

  public CloudComputeEnginePage setSeries(String series) throws InterruptedException {
    this.getElement(By.id("select_100")).click();
    Thread.sleep(1000);
    this.getElement(By.xpath("//*[contains(text(),'" + series + "')]/ancestor::md-option")).click();
    return this;
  }

  public CloudComputeEnginePage setMachineType(String value) throws InterruptedException {
    this.getElement(By.id("select_102")).click();
    Thread.sleep(1000);
    this.getElement(By.xpath("//md-option[@value='" + value + "']")).click();
    return this;
  }

  public CloudComputeEnginePage checkAddGPUs() {
    this.getElement(By.xpath("//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")).click();
    return this;
  }

  public CloudComputeEnginePage setGPUType(String GPUType) throws InterruptedException {
    this.waitTillElementUpload(10, By.xpath("//*[@id='select_451']"));
    this.getElement(By.id("select_451")).click();
    Thread.sleep(1000);
    this.getElement(By.xpath("//div[contains(text(),'" + GPUType + "')]/ancestor::md-option")).click();
    return this;
  }

  public CloudComputeEnginePage setNumberOfGPUs(int numberOfGPUs) throws InterruptedException {
    Thread.sleep(1000);
    this.getElement(By.id("select_453")).click();
    Thread.sleep(1000);
    this.getElement(By.xpath("//*[@id='select_container_454']/descendant::div[contains(text(),'" + String.valueOf(numberOfGPUs) + "')]/ancestor::md-option")).click();
    return this;
  }

  public CloudComputeEnginePage setLocalSSD(String localSSD) throws InterruptedException {
    this.getElement(By.id("select_413")).click();
    Thread.sleep(1000);
    this.getElement(By.xpath("//div[contains(text(),'" + localSSD + "')]/ancestor::md-option")).click();
    return this;
  }

  public CloudComputeEnginePage setDatacenterLocation(String datacenterLocation) throws InterruptedException {
    this.getElement(By.id("select_108")).click();
    Thread.sleep(1000);
    this.getElement(By.xpath("//*[@id='select_container_109']/descendant::div[contains(text(),'" + datacenterLocation + "')]/ancestor::md-option")).click();
    return this;
  }

  public CloudComputeEnginePage setCommittedUsage(String committedUsage) throws InterruptedException {
    this.getElement(By.id("select_115")).click();
    Thread.sleep(1000);
    this.getElement(By.xpath("//*[@id='select_container_116']/descendant::div[contains(text(),'" + committedUsage + "')]/ancestor::md-option")).click();
    return this;
  }

  public CloudEstimateResultsPage clickAddToEstimate() {
    this.getElement(By.xpath("//*[contains(text(),'Add to Estimate')]")).click();
    return new CloudEstimateResultsPage(driver);
  }

  private void switchToFrame(String name) {
    driver.switchTo().frame(name);
  }

  private void switchToFrame(int index) {
    driver.switchTo().frame(index);
  }

  private void waitTillElementUpload(int seconds, By by) {
    new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.presenceOfElementLocated(by));
  }

  private WebElement getElement(By by) {
    return driver.findElement(by);
  }
}
