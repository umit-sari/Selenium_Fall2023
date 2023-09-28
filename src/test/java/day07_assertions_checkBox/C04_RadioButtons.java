package day07_assertions_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_RadioButtons {
    /*
    Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    a. Verilen web sayfasına gidin.
     https://facebook.com
    b. Cookies’i kabul edin
    c. Create an account buton’una basin
    d. Radio button elementlerini locate edin ve size uygun olani secin
    e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
     */
    WebDriver driver;

    @Before
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://facebook.com");
    }

    @After
    public void teardown() {
      driver.close();
    }

   // @Test
   // public void cookiesTest(){}// bende cookies cıkmadı


   @Test
   public void radioButtonTest(){
      // Create an account buton’una basin
      driver.findElement(By.xpath("/a[@data-testid='open-registration-form-button']"));

       //  d. Radio button elementlerini locate edin ve size uygun olani secin
       WebElement femaleRadioB = driver.findElement(By.xpath("(//input[@*='_8esa'])[1]"));
       WebElement maleRadioB =   driver.findElement(By.xpath("(//input[@*='_8esa'])[2]"));
       WebElement customRadioB = driver.findElement(By.xpath("(//input[@*='_8esa'])[3]"));
       maleRadioB.click();
       //  e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
       Assert.assertTrue(maleRadioB.isSelected()
               && !femaleRadioB.isSelected()
               && !customRadioB.isSelected());
   }
}

