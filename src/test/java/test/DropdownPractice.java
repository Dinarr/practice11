package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.Config;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownPractice {

    @Test
    public void testing(){
        System.out.println(Config.getProperty("url"));
    }



    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cybertekschool.com/dropdown");
        WebElement month = driver.findElement(By.id("month"));
        Select monthDropdown = new Select(month);
        String s = monthDropdown.getFirstSelectedOption().getText();
        System.out.println(s);
        monthDropdown.selectByIndex(1);
        Thread.sleep(3000);
        monthDropdown.selectByValue("8");
        Thread.sleep(3000);
        monthDropdown.selectByVisibleText("December");

       List<WebElement> months = monthDropdown.getOptions();
       for(WebElement m: months){
           System.out.println(m.getText());

       }
    }
}
