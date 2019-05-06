package mercurydemo1;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
	public WebDriver driver;

  @Test(priority=1,description="Verify that valid user1 able to login into Mercury Tours application by using valid username and password")
  public void loginwithValiddetails()
  {
	  
		  System.out.println("In loginwithValiddetails under Test");
		  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap1");
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword1");
		  driver.findElement(By.xpath("//input[@name='login']")).click();
		  System.out.println("User is able to login into Mercurytours succesfully");
	  }
	  
	  
	  @Test(priority=2,description="Verify that valid user2 able to login into Mercury Tours application by using valid username and password")
	  public void loginwithvaliduser2()
	  {
		  System.out.println("In loginwithvaliduser2 under Test2");
		  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap2");
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword2");
		  driver.findElement(By.xpath("//input[@name='login']")).click();
		  WebDriverWait wait=new WebDriverWait(driver,15);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")));
		  boolean flag=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	      System.out.println("Flight Finder image is displayed for user2");
	      driver.findElement(By.linkText("SIGN-OFF")).click();
	      System.out.println("User is able to login into Mercurytours succesfully");
	  }
	  
	  @Test(priority=3,description="Verify that valid user3 able to login into Mercury Tours application by using valid username and password")
	  public void loginwithvaliduser3()
	  {
		  System.out.println("In loginwithvaliduser3 method under Test3 ");
		  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap3");
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword3");
		  driver.findElement(By.xpath("//input[@name='login']")).click();
		  WebDriverWait wait=new WebDriverWait(driver,15);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")));
		  boolean flag=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	      System.out.println("Flight Finder image is displayed for user3");
	      driver.findElement(By.linkText("SIGN-OFF")).click();
	      System.out.println("User is able to login into Mercurytours succesfully");
	  }
	  
	  
 
  
  @BeforeMethod
  public void getAllCookies() {
	  Set<Cookie> c=driver.manage().getCookies();
			  for(Cookie co:c)
			  {
				  System.out.println(co.getName());
			  }
	  
  }

  @AfterMethod
 // public void captureScreenShot() throws IOException 
  //{
	//  System.out.println("In captureScreenShot method under AfterMethod");
	//  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//  FileUtils.copyFileToDirectory(src, new File("F:\\Suvidya_data\\Java_Selenium_Practice\\TestngDatadrivenDemo1\\Screenshots\\"));
  //}


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void maximizeBrowser() 
  {
	  System.out.println("In maximizeBrowser method under BeforeClass");
	  driver.manage().window().maximize();

  }
  @AfterClass
  public void deleteAllcookies() 
  {
	  System.out.println("In deleteAllcookies method under AfterClass");
	  driver.manage().deleteAllCookies();
  }



  @BeforeTest
  public void enterApplicationURL() 
  {
	  System.out.println("In enterApplicationURL method under BeforeTest");
	  driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	  System.out.println("Application url is entered successfully");
  }

  @AfterTest
  public void dbConnectionclosed() 
  {
	  System.out.println("In dbConnectionclosed method under AfterTest");
  }


  @BeforeSuite
  public void openBrowser() 
  {
	  System.out.println("In openBrowser method under BeforeSuite");
	  System.setProperty("webdriver.chrome.driver","E:\\selenim jar\\chromedriver.exe");
	  driver = new ChromeDriver();
	  System.out.println("Chrome browser is opened successfully");
  }

  @AfterSuite
  public void closeBrowser() 
  {
	  System.out.println("In closeBrowser method under AfterSuite");
	  driver.close();
  }



}
