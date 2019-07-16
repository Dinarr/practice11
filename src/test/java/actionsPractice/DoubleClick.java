package actionsPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.Driver;

public class DoubleClick {

    Actions actions;

    @Test
    public void doubleClickTest() throws InterruptedException {
        Driver.getDriver().get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");
        WebElement puff = Driver.getDriver().findElement(By.id("puff_header"));

        actions = new Actions(Driver.getDriver());
        actions.doubleClick(puff).perform();
        Thread.sleep(1500);
        Assert.assertTrue(!puff.isDisplayed());
       // Assert.assertFalse(puff.isDisplayed());
    }

    @Test
    public void doubleClickText() throws InterruptedException {
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        Driver.getDriver().switchTo().frame("iframeResult");
        WebElement clickText = Driver.getDriver().findElement(By.id("demo"));

        Thread.sleep(1000);
        actions = new Actions(Driver.getDriver());
        actions.doubleClick(clickText).perform();

        System.out.println("Attribute value of style: " + clickText.getAttribute("style"));
        Assert.assertTrue(clickText.getAttribute("style").contains("red"));


    }
}
