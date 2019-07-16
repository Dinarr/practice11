package data;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Config;
import utilities.Driver;


import java.io.IOException;


public class TestData {

    @Test
    public void m() throws IOException {
//        Properties p = new Properties();
//        String path = "configuration.properties";
//        FileInputStream file = new FileInputStream(path);
//        p.load(file);
//        System.out.println(p.getProperty("username"));
//        System.out.println(p.getProperty("password"));
//        System.out.println(p.getProperty("color"));
//        System.out.println(p.getProperty("size"));

        Driver.getDriver().get("https://www.google.com/");
       WebElement search = Driver.getDriver().findElement(By.name("q"));
       search.sendKeys(Config.getProperty("search")+ Keys.ENTER);



    }
}
