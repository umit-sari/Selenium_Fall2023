package day14_writeExcel_ScreenShot_JsExecuter;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilites.ReusableMethods;
import utilites.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_webElementScreenShot extends TestBase {

    @Test
    public void test01() throws IOException {

        driver.get("https://www.amazon.com");

        // Nutella aratalim

        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // Sonuclarin Nutella icerdigini test edin
        WebElement sonucYaziElementi =
                driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedIcerik = "Nutella";
        String actualIcerıkYazisi = sonucYaziElementi.getText();

        Assert.assertTrue(actualIcerıkYazisi.contains(expectedIcerik));

        //Rapora eklemek icin sonucun screenshot'ini alalim

        File sonucYazisiScreenShot=new File("target/screenShots/sonucYazisi.jpg");

        File geciciResim=sonucYaziElementi.getScreenshotAs(OutputType.FILE); // sadece nutella arama sonuc fotoso cektigimizden sonuc yazi elementini aldik

        FileUtils.copyFile(geciciResim,sonucYazisiScreenShot);
        ReusableMethods.webElementFotografiCek(sonucYaziElementi,"Nutella Arama");
    }
}
