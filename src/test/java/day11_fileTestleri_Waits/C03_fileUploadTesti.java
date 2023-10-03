package day11_fileTestleri_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilites.TestBase;

public class C03_fileUploadTesti extends TestBase {
        /*
            insan olarak dosya secimi icin
            chooseFile butonuna bastiktan sonra
            acilan windows dosya penceresinden
            istedigimiz dosyayi secip yukleriz.
            Selenium'da otomasyon ile bu islemi yapmak icin
            chooseFile butonu locate edilip,
            bu webelement'e sendKeys(yuklenecekDosyaninDosyaYolu); yapilir
         */

    @Test
    public void test01(){

        // 1.https://the-internet.herokuapp.com/upload adresine gidelim
        // 2.chooseFile butonuna basalim
        // 3.text.txt dosyayi secelim.



        driver.get("https://the-internet.herokuapp.com/upload");
       WebElement uploadElementi= driver.findElement(By.id("file-upload"));
       String dinamikDosyaYolu=System.getProperty("user.dir")+"/src/test/java/day11_fileTestleri_Waits/text.txt";
       uploadElementi.sendKeys(dinamikDosyaYolu);

       // 4.Upload butonuna basalim.
       driver.findElement(By.id("file-submit")).click();

        // 5.“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadedElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedElementi.isDisplayed());


    }
}
