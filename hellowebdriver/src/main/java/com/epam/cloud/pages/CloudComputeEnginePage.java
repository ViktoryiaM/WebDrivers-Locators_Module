package com.epam.cloud.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CloudComputeEnginePage {
  private WebDriver driver;
  public static final String AVOCADOS_FRAME1 = "//iframe[contains(@name,'goog_')]";
  public static final String AVOCADOS_FRAME2 = "//iframe[@id='myFrame']";
  public static final String AVOCADOS_FRAME3 = "myFrame";
  public static final String AVOCADOS_XPATH4 = "//div[@title='Compute Engine']/ancestor::md-tab-item";
  public static final String AVOCADOS_VALUE5 = "quantity";
  public static final String AVOCADOS_ID6 = "select_88";
  public static final String AVOCADOS_XPATH7 = "//*[contains(text(),'%s')]/ancestor::md-option";
  public static final String AVOCADOS_ID8 = "select_92";
  public static final String AVOCADOS_ID9 = "select_option_90";
  public static final String AVOCADOS_ID10 = "select_100";
  public static final String AVOCADOS_XPATH11 = "//*[contains(text(),'%s')]/ancestor::md-option";
  public static final String AVOCADOS_ID12 = "select_102";
  public static final String AVOCADOS_VALUE13 = "//md-option[@value='%s']";
  public static final String AVOCADOS_XPATH14 = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']";
  public static final String AVOCADOS_ID15 = "select_451";
  public static final String AVOCADOS_XPATH16 = "//div[contains(text(),'%s')]/ancestor::md-option";
  public static final String AVOCADOS_ID17 = "select_453";
  public static final String AVOCADOS_XPATH18 = "//*[@id='select_container_454']/descendant::div[contains(text(),'%s')]/ancestor::md-option";
  public static final String AVOCADOS_ID19 = "select_413";
  public static final String AVOCADOS_XPATH20 = "//div[contains(text(),'%s')]/ancestor::md-option";
  public static final String AVOCADOS_ID21 = "select_108";
  public static final String AVOCADOS_XPATH22 = "//*[@id='select_container_109']/descendant::div[contains(text(),'%s')]/ancestor::md-option";
  public static final String AVOCADOS_ID23 = "select_115";
  public static final String AVOCADOS_XPATH24 = "//*[@id='select_container_116']/descendant::div[contains(text(),'%s')]/ancestor::md-option";
  public static final String AVOCADOS_XPATH25 = "//*[contains(text(),'Add to Estimate')]";


  public CloudComputeEnginePage(WebDriver driver) {
    this.driver = driver;
  }

  public CloudComputeEnginePage openComputeEngineTab() {
    this.waitTillElementUpload(10, By.xpath(AVOCADOS_FRAME1));
    this.switchToFrame(0);
    this.waitTillElementUpload(10, By.xpath(AVOCADOS_FRAME2));
    this.switchToFrame(AVOCADOS_FRAME3);
    this.getElement(By.xpath(AVOCADOS_XPATH4)).click();
    return this;
  }

  public CloudComputeEnginePage setNumberOfInstances(int numberOfInstances) {
    this.getElement(By.name(AVOCADOS_VALUE5)).sendKeys(String.valueOf(numberOfInstances));
    return this;
  }

  public CloudComputeEnginePage setOperatingSystem(String operatingSystem) {
    this.getElement(By.id(AVOCADOS_ID6)).click();
    this.getElement(By.xpath(String.format(AVOCADOS_XPATH7, operatingSystem))).click();
    return this;
  }

  public CloudComputeEnginePage setMachineClass() {
    this.getElement(By.id(AVOCADOS_ID8)).click();
    this.getElement(By.id(AVOCADOS_ID9)).click();
    return this;
  }

  public CloudComputeEnginePage setSeries(String series) {
    this.getElement(By.id(AVOCADOS_ID10)).click();
    this.getElement(By.xpath(String.format(AVOCADOS_XPATH11, series))).click();
    return this;
  }

  public CloudComputeEnginePage setMachineType(String value) {
    this.getElement(By.id(AVOCADOS_ID12)).click();
    this.getElement(By.xpath(String.format(AVOCADOS_VALUE13, value))).click();
    return this;
  }

  public CloudComputeEnginePage checkAddGPUs() {
    this.getElement(By.xpath(AVOCADOS_XPATH14)).click();
    return this;
  }

  public CloudComputeEnginePage setGPUType(String GPUType) {
    this.waitTillElementUpload(10, By.id(AVOCADOS_ID15));
    this.getElement(By.id(AVOCADOS_ID15)).click();
    this.getElement(By.xpath(String.format(AVOCADOS_XPATH16, GPUType))).click();
    return this;
  }

  public CloudComputeEnginePage setNumberOfGPUs(int numberOfGPUs) {
    this.getElement(By.id(AVOCADOS_ID17)).click();
    this.getElement(By.xpath(String.format(AVOCADOS_XPATH18, String.valueOf(numberOfGPUs)))).click();
    return this;
  }

  public CloudComputeEnginePage setLocalSSD(String localSSD) {
    this.getElement(By.id(AVOCADOS_ID19)).click();
    this.getElement(By.xpath(String.format(AVOCADOS_XPATH20, localSSD))).click();
    return this;
  }

  public CloudComputeEnginePage setDatacenterLocation(String datacenterLocation) {
    this.getElement(By.id(AVOCADOS_ID21)).click();
    this.getElement(By.xpath(String.format(AVOCADOS_XPATH22, datacenterLocation))).click();
    return this;
  }

  public CloudComputeEnginePage setCommittedUsage(String committedUsage) {
    this.getElement(By.id(AVOCADOS_ID23)).click();
    this.getElement(By.xpath(String.format(AVOCADOS_XPATH24, committedUsage))).click();
    return this;
  }

  public CloudEstimateResultsPage clickAddToEstimate() {
    this.getElement(By.xpath(AVOCADOS_XPATH25)).click();
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
