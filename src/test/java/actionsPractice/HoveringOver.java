package actionsPractice;

import gherkin.lexer.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class HoveringOver  extends TestBase {

    @Test
    public void amazonHover(){

        Driver.getDriver().get("https://www.amazon.com/");

        //1 - we locate a web element
        WebElement signInLink = Driver.getDriver().findElement((By.id("nav-link-accountList")));

        //2 - we create the instance of Actions class
        Actions actions = new Actions(Driver.getDriver());

        //3 - we just use the actions object to call any method from Actions class
        actions.moveToElement(signInLink).perform();

    }

    @Test
    public void hoverPractice() throws InterruptedException {
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");

        WebElement user1 = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[1]"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[2]"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[3]"));


        WebElement user1N = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement user2N = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement user3N = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));

        Actions actions = new Actions(Driver.getDriver());
        Thread.sleep(1500);
        actions.moveToElement(user1).perform();
        Assert.assertTrue(user1N.isDisplayed());
        Thread.sleep(1500);
        actions.moveToElement(user2).perform();
        Assert.assertTrue(user2N.isDisplayed());
        Thread.sleep(1500);
        actions.moveToElement(user3).perform();
        Assert.assertTrue(user3N.isDisplayed());

    }
}
