package testNGsamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.SmartBearLink;


import java.util.concurrent.TimeUnit;

public class SmartBearTestNG3 {

    WebDriver driver;

    @BeforeClass

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void openBrow(){

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearLink.loginToSmartBear(driver);
    }
    @Test
    public void deleteOrder(){

        WebElement singleName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl03_OrderSelector']"));
        singleName.click();
        WebElement deleteButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteButton.click();
        WebElement mark = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl03_OrderSelector']"));
        Assert.assertTrue(mark.isDisplayed(), "The name is displayed!");


        }

        /*Open browser and login to Smartbear
         software
         2.Click to edit button from the rightfor “Steve Johns”
         3.Change name to “Michael Jordan”
         4.Click Update5.Assert “Micheal Jordan” is in the list
         */


      @Test
    public void editOrder(){

          WebElement clickBotton = driver.findElement(By.xpath("(//input[@type='image'])[3]"));
          clickBotton.click();
          WebElement editName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
          editName.clear();
          editName.sendKeys("Micheal Jordan");
          WebElement updateButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton"));
          updateButton.click();
          WebElement michael = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl04_OrderSelector']"));
          Assert.assertTrue(michael.isDisplayed(), "Michael Jordan is not displayed!");


      }


}
