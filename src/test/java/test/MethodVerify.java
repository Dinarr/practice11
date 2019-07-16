package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MethodVerify {

    /*Create	a	method	named	verifyOrder
    that takes	WebDriver	object	and	String(name).
    •This	method	should	verify	if	given	name
    exists in orders
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearLink.loginToSmartBear(driver);
        MethodVerify.printNamesAndCities(driver);

    }

    public static void verifyNames(WebDriver driver,String givenName){

       List<WebElement> allNames = driver.findElements(By.xpath
               ("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2] "));
       for(WebElement name: allNames){
           if(name.getText().equals(givenName)) {
               System.out.println(givenName + " exists in the table. Name verification PASSED!");
               return;
           }
       }
        System.out.println(givenName + " does not exist in the list. Name verification FAILED!!!");

    }

    /*Create a	method	named	printNamesAndCities
    that	takes	WebDriver	object.
    •This	method	should	simply	print
    	all	the	names	in	the
     */
    public static void printNamesAndCities(WebDriver driver){

        List<WebElement> allNames = driver.findElements(By.xpath
                ("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2] "));
        List<WebElement> allCities = driver.findElements(By.xpath
                ("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[7]"));

        for(int i = 0; i < allCities.size(); i++){
            System.out.println(allNames.get(i).getText() + " <--names,  cities--> " +
                    allCities.get(i).getText());
        }

    }

}
