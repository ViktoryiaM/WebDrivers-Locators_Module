package com.epam.cloud.cases;

import com.epam.cloud.pages.CloudComputeEnginePage;
import com.epam.cloud.pages.CloudEstimateResultsPage;
import com.epam.cloud.pages.CloudHomePage;
import com.epam.cloud.pages.CloudSearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HurtMePlentyTest {

  @Test
  public void testComputeEngineCalculator() throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    CloudHomePage homePage = new CloudHomePage(driver);
    CloudSearchResultsPage searchResultsPage = homePage
        .openPage()
        .search("Google Cloud Platform Pricing Calculator");
    CloudComputeEnginePage computeEnginePage = searchResultsPage.openComputeEnginePage();
    CloudEstimateResultsPage estimateResultsPage = computeEnginePage
        .openComputeEngineTab()
        .setNumberOfInstances(4)
        .setOperatingSystem("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)") // "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS" is not represented in dropdown
        .setMachineClass()
        .setSeries("N1")
        .setMachineType("CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8")
        .checkAddGPUs()
        .setGPUType("NVIDIA Tesla V100")
        .setNumberOfGPUs(1)
        .setLocalSSD("2x375 GB")
        .setDatacenterLocation("Taiwan (asia-east1)") // I will use Taiwan (asia-east1) option because when Frankfurt is chosen then NVIDIA Tesla V100 option is unavailable and dropdown was cleared out
        .setCommittedUsage("1 Year")
        .clickAddToEstimate();

    SoftAssert softAssert = new SoftAssert();

    softAssert.assertEquals(estimateResultsPage.getVMClass(), "VM class: regular");
    softAssert.assertTrue(estimateResultsPage.getInstanceType().startsWith("Instance type: n1-standard-8"), "Text is not correct!");
    softAssert.assertEquals(estimateResultsPage.getRegion(), "Region: Taiwan");
    softAssert.assertTrue(estimateResultsPage.getLocalSSD().startsWith("Local SSD: 2x375 GiB"), "Local SSD is incorrect!");
    softAssert.assertEquals(estimateResultsPage.getCommitmentTerm(), "Commitment term: 1 Year", "Commitment term is incorrect!");
    softAssert.assertEquals(estimateResultsPage.getTotalMonthCost(), "Total Estimated Cost: USD 5,523.47 per 1 month", "Total Estimated Cost is incorrect!");

    softAssert.assertAll();

    driver.quit();
  }
}