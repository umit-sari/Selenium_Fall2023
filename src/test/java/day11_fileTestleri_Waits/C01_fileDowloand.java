package day11_fileTestleri_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilites.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C01_fileDowloand extends TestBase {
    // \Kullanıcılar\ümit\Masaüstü\logo.jpg

    @Test
    public void test01(){

        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[text()='logo.jpg']")).click();
        bekle(5);

        String dosyaYolu="/Users/ümit/Desktop/logo.jpg";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }
}
