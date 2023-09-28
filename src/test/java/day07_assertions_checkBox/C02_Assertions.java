package day07_assertions_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertions {

    static WebDriver driver;


    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");

    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void titleTesti(){

        String exceptedTitle="YouTube";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(exceptedTitle,actualTitle);
    }

    @Test
    public void imageTest(){
        WebElement logoElementi=driver.findElement(By.xpath("(//div[@class='style-scope ytd-topbar-logo-renderer'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }
    @Test
    public void searchBoxTest(){
        WebElement searchBoxElementi= driver.findElement(By.xpath("//input[@name='search_query']"));
        Assert.assertTrue(searchBoxElementi.isEnabled());
    }




}
