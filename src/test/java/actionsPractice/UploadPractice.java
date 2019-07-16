package actionsPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class UploadPractice {

    @Test
    public void uploadTest() throws InterruptedException {

        Driver.getDriver().get("http://practice.cybertekschool.com/upload");

        WebElement chooseFileInput = Driver.getDriver().findElement(By.id("file-upload"));
        Thread.sleep(1500);
        chooseFileInput.sendKeys("/Users/dinash/Desktop/Dinara/BM2P56 (1).jpg");
        Thread.sleep(1500);
        WebElement upload = Driver.getDriver().findElement(By.id("file-submit"));
        upload.click();

        WebElement uploadedFolderBox = Driver.getDriver().findElement(By.id("uploaded-files"));
        String expectedFileName = "BM2P56 (1).jpg";
        String actualFileName = uploadedFolderBox.getText();
        Assert.assertEquals(expectedFileName,actualFileName);

    }
}
