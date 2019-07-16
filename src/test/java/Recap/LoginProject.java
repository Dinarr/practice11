package Recap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class LoginProject  extends TestBase {


    @Test
    public void checkForUser(){

        Driver.getDriver().get("http://54.148.96.210/web/login");
        WebElement login = Driver.getDriver().findElement(By.xpath("//input[@name='login']"));
        login.sendKeys("in_s_user5@info.com");
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Wdf4ssa52");
        WebElement button = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        button.click();


        WebElement userIcon = Driver.getDriver().findElement(By.xpath("//img[@class='img-circle oe_topbar_avatar']"));
        userIcon.click();
        Assert.assertTrue(userIcon.isDisplayed());
        WebElement documentVerify = Driver.getDriver().findElement(By.linkText("Documentation"));
        documentVerify.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Odoo"));
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("window.scrollBy(0,2000);");


    }

}
