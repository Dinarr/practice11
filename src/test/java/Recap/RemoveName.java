package Recap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import test.SmartBearLink;
import utilities.TestBase;

public class RemoveName extends TestBase {

    public static void removeName(WebDriver driver, String name){

        String word = "word";
        String sentence = "//xpath"+word+"rest of the xpath";

        WebElement nameCheckBox = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='"+name+"']/../td[1]"));

        nameCheckBox.click();

        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
    }

    @Test
    public void smartTest(){

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
      SmartBearLink.loginToSmartBear(driver);

        removeName(driver, "Steve Johns");

    }
}

