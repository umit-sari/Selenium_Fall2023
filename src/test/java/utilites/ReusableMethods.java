package utilites;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {
    public static void bekle(int saniye){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public static void tumSayfaFotografiCek(WebDriver driver, String resimAdi){

        // her screenshot'in benzer bir isme sahip olmasi icin
        //1- methodun cagrildigi yerden resim adi istedik
        //2- sonuna tarih ekledik 23/10/06 21:13

        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyMMddHHmm");
        String tarihEtiketi=ldt.format(formatter);

        //target/screenShots/tumSayfaScreenShot.jpg

        String dinamikDosyaYolu="target/screenShots/"+ resimAdi+ tarihEtiketi+".jpg";

        TakesScreenshot tss= (TakesScreenshot) driver; // tss objesi olusturduk

        File tumSayfaScreenShot=new File(dinamikDosyaYolu); // kaydedecegimiz yeri hazirladik

        File geciciDosya=tss.getScreenshotAs(OutputType.FILE); // gecici olarak bir dosyaya atiyoruz- direk dosyaya ekleyemiyoruz

        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenShot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static void webElementFotografiCek(WebElement webElement, String resimAdi) {

        // fotografcek methodundan farkli olarak driver yerine WebElementi ekledik.
        // Webelement ekledigimizden TakesScreenshot tss= (TakesScreenshot) driver; // tss objesini yazmadik tekrardan.

        // her screenshot'in benzer bir isme sahip olmasi icin
        //1- methodun cagrildigi yerden resim adi istedik
        //2- sonuna tarih ekledik 23/10/06 21:13

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmm");
        String tarihEtiketi = ldt.format(formatter);

        //target/screenShots/tumSayfaScreenShot.jpg

        String dinamikDosyaYolu = "target/screenShots/" + resimAdi + tarihEtiketi + ".jpg";


        File tumSayfaScreenShot = new File(dinamikDosyaYolu); // kaydedecegimiz yeri hazirladik

        File geciciDosya = webElement.getScreenshotAs(OutputType.FILE); // gecici olarak bir dosyaya atiyoruz- direk dosyaya ekleyemiyoruz

        try {
            FileUtils.copyFile(geciciDosya, tumSayfaScreenShot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
