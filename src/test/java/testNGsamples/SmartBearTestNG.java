package testNGsamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
import test.SmartBearLink;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTestNG {

    WebDriver driver;

    @BeforeClass

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void deleteAll(){

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearLink.loginToSmartBear(driver);

        List<WebElement> allCheckboxes = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[1]"));

        for(WebElement checkbox : allCheckboxes){
            checkbox.click();
            //Assert.assertTrue(checkbox.isSelected());
        }

//        for(int i=0; i<allCheckboxes.size(); i++){
//            allCheckboxes.get(i).click();
//        }

        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();

        WebElement message = driver.findElement(By.id("ctl00_MainContent_orderMessage"));

        Assert.assertTrue(message.isDisplayed(), "The message is not displayed.");

    }
}
