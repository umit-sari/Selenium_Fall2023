package day06_notations_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilites.ReusableMethods;

import java.time.Duration;

public class C01_BeforeAfterNotasyonlari {

    // 3 test method'u olusturup asagidaki gorevleri
    // bagimsiz olarak calisabilecek sekilde olusturun
    // 1- Amazon anasayfaya gidip, url'in amazon icerdigini test edin,sayfayi kapatin
    // 2- Wisequarter anasayfaya gidip, title'in Wise icerdigini test edin,sayfayi kapatin
    // 3- Youtube anasayfaya gidip, title'in best icermedigini test edin,sayfayi kapatin

    WebDriver driver;
public void setup(){

    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}




@Test
public  void amazonTest(){
    // 1- Amazon anasayfaya gidip, url'in amazon icerdigini test edin,sayfayi kapatin

  //  WebDriverManager.chromedriver().setup();
  //  WebDriver driver=new ChromeDriver();
  //  driver.manage().window().maximize();
  //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
     setup();
    driver.get("https://www.amazon.com");
    String exceptedIcerik="amazon";
    String actualUrl=driver.getCurrentUrl();
    if (actualUrl.contains(exceptedIcerik)){

        System.out.println("amazon testi passed");
    }else{
        System.out.println("amazon testi failed");
    }
    ReusableMethods.bekle(2);
    driver.close();


}
@Test
    public void wiseTest(){
    setup();
    driver.get("https://www.wisequarter.com");

    String exceptedTitle="Wise";
    String actualTitle=driver.getTitle();
    if (actualTitle.contains(exceptedTitle)){

        System.out.println("Wise testi passed");
    }else{
        System.out.println("Wise testi failed");
    }
    ReusableMethods.bekle(2);
    driver.close();
}
@Test
    public void youtubeTest(){
    setup();
    String unExceptedTitle="Best";
    String actualTitle=driver.getTitle();
    if (actualTitle.contains(unExceptedTitle)){

        System.out.println("Youtube testi passed");
    }else{
        System.out.println("Youtube testi failed");
    }
    ReusableMethods.bekle(2);
    driver.close();

}

}
