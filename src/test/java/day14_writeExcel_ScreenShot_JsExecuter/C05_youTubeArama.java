package day14_writeExcel_ScreenShot_JsExecuter;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilites.ReusableMethods;
import utilites.TestBase;

public class C05_youTubeArama extends TestBase {

    @Test
    public void youtubeAramaTesti(){

        // youtube anasayfaya gidin
        driver.get("https://www.youtube.com");
        bekle(2);

        // cookies kabul edin

        //driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[14]")).click();
       // bekle(3);
        // ahmet bulutluoz icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='search']"));
        aramaKutusu.click();
        aramaKutusu.sendKeys("Ahmet Bulutluoz" + Keys.ENTER);

        // bulunan videolardan ilkinin isminde QA gectigini test edin

        WebElement ilkVideoIsmi = driver.findElement(By.xpath("(//a[@id='video-title'])[1]"));

        String expectedIcerik = "QA";
        String actualVideoIsmi= ilkVideoIsmi.getText();
        System.out.println(actualVideoIsmi);
        Assert.assertTrue(actualVideoIsmi.contains(expectedIcerik));
        // ilk video isminin fotografini cekin
       ReusableMethods.webElementFotografiCek(ilkVideoIsmi,"Ahmet youtube");


        bekle(3);

    }
}