package AnnotationsUsage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestNGClass {

    WebDriver driver;

     @BeforeClass
       public void setUp() {
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

     }

    @BeforeMethod
    public void before() {
        driver.get("https://www.redfin.com");
    }

   @Test
    public void verifyPageTitle_GetLinkSize() throws InterruptedException {
        WebElement buy = driver.findElement(By.xpath("(//a[@class = 'inheritColor'])[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(buy).build().perform();
        Thread.sleep(3000);
        driver.navigate().to("https://www.redfin.com/buy-a-home/classes-and-events");
        String expTitle = "Classes and Events";
        String pageTitle = driver.getTitle();

        if(expTitle.equals(pageTitle)){
            System.out.println("Title verification is PASSED!");
        } else {
            System.out.println("Title verification is FAILED!!!");
        }

        List<WebElement> links = driver.findElements(By.xpath("//body//a"));
        System.out.println(links.size());

        for(WebElement link: links){
            System.out.println(link.getText());
        }


    }

    @Test
    public void verifyInfoReqform_sendRequest() {

        driver.navigate().to("https://www.redfin.com/neighborhood/236951/CO/Longmont/Chicago-Colorado-Colony/real-estate/agents");
        WebElement emailBox = driver.findElement(By.xpath("//input[@name='email']"));

        emailBox.sendKeys("edward.collins@gmail.com");
        WebElement phoneBox = driver.findElement(By.xpath("//input[@class='dijitInputInner tel']"));

        phoneBox.sendKeys("777-994-2255");
        WebElement textArea = driver.findElement(By.xpath("(//textarea[@class='value dijitTextBox dijitTextArea'])[1]"));

        textArea.sendKeys("I'm interested in buying a mention in Winnetka and Evanston areas.");
        WebElement sendButton = driver.findElement(By.xpath("//button[@class='button Button large primary submitBtn v3']"));
        //sendButton.click();

    }

    @Test
    public void verifyContUsLink_findIL(){

         boolean isDisplayed = driver.findElement(By.linkText("Contact Us")).isDisplayed();
        if(isDisplayed){
            System.out.println("'Contact us' button is Displayed.");
        } else {
            System.out.println("'Contact us' button is not Displayed!!!");
        }
        WebElement contactUsButton =  driver.findElement(By.linkText("Contact Us"));
        contactUsButton.click();
        WebElement illinoisLink = driver.findElement(By.xpath("(//span[@class='heading-text'])[8]"));
        illinoisLink.click();

        WebElement givenMap = driver.findElement(By.xpath("//a[@href='https://goo.gl/maps/biQGndhouPB2']"));
        givenMap.click();

       String mapPageExpTitle = "112 S Sangamon St #400 - Google Maps";

       if(mapPageExpTitle.contains("112 S Sangamon St")){
           System.out.println("Map title verification PASSED!");
       } else {
           System.out.println("Map page title verification FAILED!!!");
       }


    }

    @AfterClass
   public void closeBrowser(){
       driver.quit();
    }


}
