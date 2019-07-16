package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
/*Create	a	method	named	printNamesAndCitiesthat
takes	WebDriver	object.•
This	method	should	simply	print
all	the	names in the	List of all orders
 */

public class SmartbearLastTask {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearLink.loginToSmartBear(driver);
        List<WebElement> names = driver.findElements(By.xpath(""));


    }

    public void printNamesAndCities(){

        
    }
}
