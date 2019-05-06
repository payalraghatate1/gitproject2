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

public class mercurydriventest {
	public WebDriver driver;
  @Test(dataProvider = "getdata")
  public void loginwithvalid(String username, String password) throws InterruptedException {
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap1");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword1");
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  WebDriverWait wait=new WebDriverWait(driver,25);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")));
	  boolean flag=driver.findElement(By.xpath("")).isDisplayed();
      System.out.println("Flight Finder image is displayed ");
      Thread.sleep(5000);
      driver.findElement(By.partialLinkText("SIGN-OFF")).click();
      System.out.println("User is able to login into Mercurytours succesfully");
      System.out.println("payal raghatate");
	  System.out.println("payal raghatate2334");
	  
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
  public void captureScreenShot() throws IOException 
  {
	  System.out.println("In captureScreenShot method under AfterMethod");
	  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFileToDirectory(src, new File("D:\\eclipse workspace\\mercurydemo\\drivenscreenshot"));
  }



  @DataProvider
  public Object[][] getdata() {
   Object[][] data=new Object[3][2];
   data[0][0]="Suvidyap1";
   data[0][1]="passwd1";
   data[1][0]="Suvidyap2";
   data[1][1]="passwd2";
   data[2][0]="Suvidyap3";
   data[2][1]="passwd3";
   return data;
    };
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("after class");
  }

  @BeforeTest
  public void enterApplicationURL() 
  {
	  System.out.println("In enterApplicationURL method under BeforeTest");
	  driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	  driver.manage().window().maximize();
	  System.out.println("Application url is entered successfully");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("after test");
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
  public void afterSuite() {
	  System.out.println("after suite class");
  }

}
