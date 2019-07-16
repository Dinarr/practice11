package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;
// Amazon departments dropdown
//default value
// 1.Go to amazon.com
//  2.Verify default value for
//  departments dropdown in searchboxExpected:
//   All Departments
public class DropdownAmazon {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://amazon.com");
        WebElement departments =  driver.findElement(By.name("url"));

        Select dep = new Select(departments);
        String s = dep.getFirstSelectedOption().getText();
        System.out.println(s);
    }
}
