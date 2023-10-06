package day14_writeExcel_ScreenShot_JsExecuter;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilites.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_getScreenShot_TumSayfa extends TestBase {

    @Test
    public void tumSayfaScreenShot() throws IOException {
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");


        // Nutella icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // Sonuclarin Nutella icerdigini test edin
        WebElement sonucYaziElementi =
                 driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedIcerik = "Nutella";
        String actualIcerıkYazisi = sonucYaziElementi.getText();

        Assert.assertTrue(actualIcerıkYazisi.contains(expectedIcerik));


        // rapor icin sayfanin fotografini cekin
        // 1.adim TakeScreenshot objesi olusturma

        TakesScreenshot tss= (TakesScreenshot) driver;

        // 2.adim fotografi kaydedecegimiz dosyayi olusturalim, dosya yolunu yazalim

        File tumSayfaScreenShot=new File("target/screenShots/tumSayfaScreenShot.jpg");

        // 3.adim bir gecici dosya olusturup buna tss objesi ile cektigimiz fotografi kaydedelim

        File geciciResim=tss.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici resmi asil dosyaya kopyalayalim

        FileUtils.copyFile(geciciResim,tumSayfaScreenShot);



        bekle(5);


    }
}
