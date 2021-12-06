package Task.test;

import Task.page.CloudHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HurtMePlentyTest {
  private CloudHomePage homePage;

  @BeforeTest
  public void initialize() throws InterruptedException {
    homePage = new CloudHomePage(new ChromeDriver());
    homePage.navigateTo("https://cloud.google.com/");
    homePage.waitTillElementUpload(10, By.name("q"));
    homePage.getElement(By.name("q")).sendKeys("Google Cloud Platform Pricing Calculator\n");
    homePage.waitTillElementUpload(10, By.xpath("//b[text()='Google Cloud Platform Pricing Calculator']/parent::a"));
    homePage.getElement(By.xpath("//b[text()='Google Cloud Platform Pricing Calculator']/parent::a")).click();
    homePage.waitTillElementUpload(10, By.xpath("//iframe[contains(@name,'goog_')]"));
    homePage.switchToFrame(0);
    homePage.waitTillElementUpload(10, By.xpath("//iframe[@id='myFrame']"));
    homePage.switchToFrame("myFrame");
    homePage.getElement(By.xpath("//div[@title='Compute Engine']/ancestor::md-tab-item")).click();
    homePage.getElement(By.name("quantity")).sendKeys("4");
    homePage.getElement(By.xpath("//*[@id='select_88']")).click();

//    "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS" is not represented in dropdown

    homePage.getElement(By.xpath("//*[contains(text(),'Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)')]/ancestor::md-option")).click();
    homePage.getElement(By.xpath("//*[@id='select_92']")).click();
    homePage.getElement(By.xpath("//*[@id='select_option_90']")).click();
    homePage.getElement(By.xpath("//*[@id='select_100']")).click();
    Thread.sleep(1000);
    homePage.getElement(By.xpath("//*[contains(text(),'N1')]/ancestor::md-option")).click();
    homePage.getElement(By.xpath("//*[@id='select_102']")).click();
    Thread.sleep(1000);
    homePage.getElement(By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")).click();
    homePage.getElement(By.xpath("//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")).click();
    homePage.waitTillElementUpload(10, By.xpath("//*[@id='select_451']"));
    homePage.getElement(By.xpath("//*[@id='select_451']")).click();
    Thread.sleep(1000);
    homePage.getElement(By.xpath("//div[contains(text(),'NVIDIA Tesla V100')]/ancestor::md-option")).click();
    Thread.sleep(1000);
    homePage.getElement(By.xpath("//*[@id='select_453']")).click();
    Thread.sleep(1000);
    homePage.getElement(By.xpath("//*[@id='select_container_454']/descendant::div[contains(text(),'1')]/ancestor::md-option")).click();
    homePage.getElement(By.xpath("//*[@id='select_413']")).click();
    Thread.sleep(1000);
    homePage.getElement(By.xpath("//div[contains(text(),'2x375 GB')]/ancestor::md-option")).click();
    homePage.getElement(By.xpath("//*[@id='select_108']")).click();
    Thread.sleep(1000);

//    I will use Taiwan (asia-east1) option because when Frankfurt is chosen then NVIDIA Tesla V100 option is unavailable and dropdown was cleared out

    homePage.getElement(By.xpath("//*[@id='select_container_109']/descendant::div[contains(text(),'Taiwan (asia-east1)')]/ancestor::md-option")).click();
    homePage.getElement(By.xpath("//*[@id='select_115']")).click();
    Thread.sleep(1000);
    homePage.getElement(By.xpath("//*[@id='select_container_116']/descendant::div[contains(text(),'1 Year')]/ancestor::md-option")).click();
    homePage.getElement(By.xpath("//*[contains(text(),'Add to Estimate')]")).click();

  }

  @AfterTest
  public void finalize() {
    homePage.quit();
  }

  @Test
  public void vmClassValueCheck() {
    WebElement vmClassResult = homePage.getElement(By.xpath("//*[@id='compute']/descendant::div[contains(text(),'VM class')]"));
    Assert.assertEquals(vmClassResult.getText(), "VM class: regular");
  }

  @Test
  public void instanceTypeValueCheck() {
    WebElement instanceTypeResult = homePage.getElement(By.xpath("//*[@id='compute']/descendant::div[contains(text(),'Instance type')]"));
    Assert.assertTrue(instanceTypeResult.getText().startsWith("Instance type: n1-standard-8"), "Text is not correct!");
  }

  @Test
  public void regionValueCheck() {
    WebElement regionResult = homePage.getElement(By.xpath("//*[@id='compute']/descendant::div[contains(text(),'Region:')]"));
    Assert.assertEquals(regionResult.getText(), "Region: Taiwan");
  }

  @Test
  public void localSSDValueCheck() {
    WebElement localSSDResult = homePage.getElement(By.xpath("//*[@id='compute']/descendant::div[contains(text(),'Local SSD:')]"));
    Assert.assertTrue(localSSDResult.getText().startsWith("Local SSD: 2x375 GiB"), "Local SSD is incorrect!");
  }

  @Test
  public void commitmentTermValueCheck() {
    WebElement commitmentTermResult = homePage.getElement(By.xpath("//*[@id='compute']/descendant::div[contains(text(),'Commitment term:')]"));
    Assert.assertEquals(commitmentTermResult.getText(), "Commitment term: 1 Year", "Commitment term is incorrect!");
  }

  @Test
  public void totalMonthCostValueCheck() {
    WebElement totalMonthCostResult = homePage.getElement(By.xpath("//*[@id='resultBlock']/descendant::b[contains(text(),'Total Estimated Cost:')]"));
    Assert.assertEquals(totalMonthCostResult.getText(), "Total Estimated Cost: USD 5,523.47 per 1 month", "Total Estimated Cost is incorrect!");
  }
}