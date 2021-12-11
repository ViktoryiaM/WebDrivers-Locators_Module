package com.epam.cloud.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CloudEstimateResultsPage {
  private WebDriver driver;
  public static final String AVOCADOS_XPATH1 = "//*[@id='compute']/descendant::div[contains(text(),'VM class')]";
  public static final String AVOCADOS_XPATH2 = "//*[@id='compute']/descendant::div[contains(text(),'Instance type')]";
  public static final String AVOCADOS_XPATH3 = "//*[@id='compute']/descendant::div[contains(text(),'Region:')]";
  public static final String AVOCADOS_XPATH4 = "//*[@id='compute']/descendant::div[contains(text(),'Local SSD:')]";
  public static final String AVOCADOS_XPATH5 = "//*[@id='compute']/descendant::div[contains(text(),'Commitment term:')]";
  public static final String AVOCADOS_XPATH6 = "//*[@id='resultBlock']/descendant::b[contains(text(),'Total Estimated Cost:')]";

  public CloudEstimateResultsPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getVMClass() {
    return driver.findElement(By.xpath(AVOCADOS_XPATH1)).getText();
  }

  public String getInstanceType() {
    return driver.findElement(By.xpath(AVOCADOS_XPATH2)).getText();
  }

  public String getRegion() {
    return driver.findElement(By.xpath(AVOCADOS_XPATH3)).getText();
  }

  public String getLocalSSD() {
    return driver.findElement(By.xpath(AVOCADOS_XPATH4)).getText();
  }

  public String getCommitmentTerm() {
    return driver.findElement(By.xpath(AVOCADOS_XPATH5)).getText();
  }

  public String getTotalMonthCost() {
    return driver.findElement(By.xpath(AVOCADOS_XPATH6)).getText();
  }

}
