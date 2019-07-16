package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SmartBearOrderVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //calling method
        SmartBearLink.loginToSmartBear(driver);

        //find and click on "View all orders"
        WebElement inputViewAllOrders = driver.findElement(By.linkText("View all orders"));
        inputViewAllOrders.click();

        //finding a customer named Susan
        WebElement date = driver.findElement(By.xpath("//td[.='Susan McLaren']/../td[5]"));

        //getting date's text and check it with expected result
        String dateText = date.getText();

        if(dateText.equals("01/05/2010")){
            System.out.println("Susan date verification Passed!");
        }else{
            System.out.println("Susan date verification Failed!!!");
        }


    }
}
