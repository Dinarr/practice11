package test;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SmartBearTask2 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //calling method
        SmartBearLink.loginToSmartBear(driver);

        //find "Order" and click on it
        WebElement orderLink = driver.findElement(By.linkText("Order"));
        orderLink.click();

        //select "Family album" dropdown
        WebElement productDropdown = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select selectObj = new Select(productDropdown);
        selectObj.selectByIndex(1);
        WebElement inputQuantity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        inputQuantity.sendKeys("2");

        //name generate
        WebElement inputName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        Faker faker = new Faker();
        inputName.sendKeys(faker.name().fullName());

        //street generate
        WebElement inputStreet = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        inputStreet.sendKeys(faker.address().streetName());

        //city generate
        WebElement inputCity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        inputCity.sendKeys(faker.address().cityName());

        //ZipCode generate
        WebElement inputZipcode = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        inputZipcode.sendKeys(faker.address().zipCode().replace("-",""));

        //radio visa
        WebElement visaRadioButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visaRadioButton.click();

        //card number
        WebElement inputCardNumber = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        inputCardNumber.sendKeys(faker.finance().creditCard().replace("-", ""));

        //expiration date
        WebElement inputDate = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        inputDate.sendKeys("07/19");

        //process button
        WebElement processButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();

        //success message verification
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
        String successMessageText = successMessage.getText();
         if(successMessageText.equals("New order has been successfully added.")){
             System.out.println("Success Message Verification Passed!");

        } else {
             System.out.println("Success Message Verification Failed!!!");

         }
    }
}
