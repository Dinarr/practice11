package actionsPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class DragAndDropPractice  extends TestBase {

    @Test
    public void dragAndDrop() throws InterruptedException {

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement smallSirqle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigSircle = Driver.getDriver().findElement(By.id("droptarget"));

        Thread.sleep(1000);
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(smallSirqle,bigSircle).perform();

       // actions.clickAndHold(smallSirqle).moveToElement(bigSircle).perform();

        String expectedText = "You did great!";
        String actualText = bigSircle.getText();

        Assert.assertEquals(actualText, expectedText);



    }
}
