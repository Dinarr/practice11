package testNGsamples;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTask {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void iframePractice() {

        driver.get("http://practice.cybertekschool.com/iframe");
        WebElement innerIframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(innerIframe);

       String actualText = driver.findElement(By.xpath("//body[@id='tinymce']")).getText();
       String expectedText = "Your content goes here.";
       Assert.assertEquals(actualText,expectedText, "Inside text is not matching.");

        driver.switchTo().parentFrame();

        String actualHeaderText = driver.findElement(By.xpath("//h3")).getText();
        String expectedHeaderText = "An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertTrue(actualHeaderText.equals(expectedHeaderText), "Header text is not matching!!!");


        driver.getWindowHandle();
        for(String window: driver.getWindowHandles()){
            driver.switchTo().window(window);
        }
    }



}
