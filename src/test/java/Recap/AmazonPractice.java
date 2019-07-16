package Recap;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class AmazonPractice  extends TestBase {

    // goes to amazon.com;
    // checks if sign in functionality works as expected;
    // sends valid credentials to email and password boxes
    // everything should go smooth and login

    @Test
    public void signIn() throws InterruptedException {
        Driver.getDriver().get("https://amazon.com");
        WebElement yourAmazon = Driver.getDriver().findElement(By.id("nav-your-amazon"));
        yourAmazon.click();
        Thread.sleep(1500);
        WebElement email = Driver.getDriver().findElement(By.xpath("//input[@id='ap_email']"));
        email.sendKeys("di.otonova@gmail.com");
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@id='ap_password']"));
        password.sendKeys("Insurgent94");
        Thread.sleep(1500);
        WebElement signInButton = Driver.getDriver().findElement(By.xpath("//input[@id='signInSubmit']"));
        signInButton.click();

    }

    //signs in
    //clicks on Recommended for you button
    //checks for title if it's matching

    @Test
    public void recommendedForYou() throws InterruptedException {

        signIn();
        WebElement recommendedForYou = Driver.getDriver().findElement(By.xpath("(//span[@class='nav-a-content'])[3]"));
        recommendedForYou.click();
        Thread.sleep(1500);
        String expectedTitle = "Your Amazon.com";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
       // Driver.getDriver().close();
    }

    @Test
    public void negativeScenario() throws InterruptedException {
        //goes to amazon
        //finds sign in button
        //puts wrong input
        //it shouldn't allow to sign in with wrong credentials
        //displays Error message

        Driver.getDriver().get("https://amazon.com");
        WebElement yourAmazon = Driver.getDriver().findElement(By.id("nav-your-amazon"));
        yourAmazon.click();
        Thread.sleep(1500);
        WebElement email1 = Driver.getDriver().findElement(By.xpath("//input[@id='ap_email']"));
        email1.sendKeys("fhjsd1234");
        WebElement password1 = Driver.getDriver().findElement(By.xpath("//input[@id='ap_password']"));
        password1.sendKeys("&53e*hds");
        Thread.sleep(1500);
        WebElement signInButton = Driver.getDriver().findElement(By.xpath("//input[@id='signInSubmit']"));
        signInButton.click();
       // Driver.getDriver().close();

   }
}
