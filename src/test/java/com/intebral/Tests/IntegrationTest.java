package com.intebral.Tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IntegrationTest {

	 WebDriver driver;
     String baseURL, nodeURL;

	@BeforeTest
     public void setUp() throws MalformedURLException {
		System.out.println("getClass "+this.getClass());  
		System.out.println("System.getProperty(testSuite) "+System.getProperty("testSuite")); 
		System.out.println("System.getProperty(testSuite) "+System.getProperty("surefire.suiteXmlFiles")); 

		 baseURL = "http://34.69.19.204:9999/MyDevPipeLine/";
         nodeURL = "http://35.200.150.252:4444/wd/hub";
         DesiredCapabilities capability = DesiredCapabilities.chrome();
         capability.setBrowserName("chrome");
         capability.setPlatform(Platform.LINUX);
         driver = new RemoteWebDriver(new URL(nodeURL), capability);
         
     }

     @AfterTest
     public void afterTest() {
         driver.quit();
     }
     @Test
     public void sampleTest() {
         driver.get(baseURL);
         System.out.println("driver.getTitle() "+driver.getTitle()); 
         System.out.println("driver.getTitle().contains(\"DevOps Registration Form\") "+driver.getTitle().contains("DevOps Registration Form")); 
         if (driver.getTitle().contains("DevOps Registration Form")) {
             AssertJUnit.assertTrue( "DevOps Registration Form", true);
         } else {
             AssertJUnit.assertTrue("Failed: DevOps Registration Form",false );
         }

     }



}