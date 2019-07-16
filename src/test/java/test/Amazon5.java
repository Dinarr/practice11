package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Amazon5 {
    /* Create void method verifyDepartmentDropdown.
    This method should accept WebDriver object and String(option).
    Method will select given option and verifies if it’s selected
    */
    public static void main(String[] args) {

    }

    public static void verifyDepartmentDropdown(WebDriver driver, String option){
        WebElement department = driver.findElement(By.name("url"));
        Select newS = new Select(department);
      //  option  = newS.selectByVisibleText().getText();


    }
}
