package testNGsamples;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

    }

    @Test
    public void clickAlert() throws InterruptedException {
        WebElement jsAlerts = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        jsAlerts.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        alert.accept();
        String actualText = driver.findElement(By.id("result")).getText();
        String expectedText = "You successfuly clicked an alert";
        Assert.assertEquals(actualText,expectedText, "Text in first doesn't match!");

    }
        @Test(priority = 1)
        public void alert1 () throws InterruptedException {
            WebElement secAlert = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]"));
            secAlert.click();
            Alert alert = driver.switchTo().alert();
            Thread.sleep(1000);
            alert.accept();
            String actualText = driver.findElement(By.id("result")).getText();
            String expectedText = "You clicked: Ok";
            Assert.assertTrue(actualText.equals(expectedText), "Text in second test doesn't match.");

        }

        @Test(priority = 2)
    public void alert3() throws InterruptedException{
        WebElement lastAlert = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]"));
        lastAlert.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        alert.sendKeys("Hello");
        alert.accept();
            String actualText = driver.findElement(By.id("result")).getText();
            String expectedText = "You entered: Hello";
            Assert.assertEquals(actualText,expectedText, "Text in third doesn't match!");


        }

        @AfterMethod
    public void closeBrow(){

        driver.close();

        }
    }
