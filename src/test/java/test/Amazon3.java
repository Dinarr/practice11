package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Amazon3 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://amazon.com");
        List<WebElement> option = driver.findElements(By.xpath("//body//option"));

        for (WebElement opt: option) {
            if(!opt.getText().isEmpty()){
                System.out.println(opt.getText());
            } else {
                System.out.println("Can't be empty");
            }
        }

    }
}
