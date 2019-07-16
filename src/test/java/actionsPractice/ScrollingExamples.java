package actionsPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

public class ScrollingExamples {

    Actions actions;


    @Test
    public void scrollUsingMoveTo(){
        Driver.getDriver().get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");

        WebElement footer = Driver.getDriver().findElement(By.className("footer-info-left"));
        actions = new Actions(Driver.getDriver());
        actions.moveToElement(footer).perform();

    }

    @Test
    public void scrollUsingKeys() throws InterruptedException {
        Driver.getDriver().get("https://youtube.com");

        actions = new Actions(Driver.getDriver());

        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    @Test
    public void scrollUsingJSExecutor(){
        Driver.getDriver().get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("window.scrollBy(0,2000);");

        }


}
