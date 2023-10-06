package day14_writeExcel_ScreenShot_JsExecuter;

import org.junit.Assert;
import org.junit.Test;
import utilites.ReusableMethods;
import utilites.TestBase;

public class C03_tumSayfaScreenShotMethoduKullanma extends TestBase {

    @Test
    public void Test01() {

        driver.get("https://www.wisequarter.com");

        String expectedUrl = "wise";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        // sonucu raorlamak icin tum sayfa screenshot alip kaydedin
        ReusableMethods.tumSayfaFotografiCek(driver, "wise");
    }

    @Test
    public void testAB() {
            driver.get("https://www.ahmetbulutluoz.com");

            String expectedUrl1 = "bulut";
            String actualUrl1 = driver.getCurrentUrl();

            Assert.assertTrue(actualUrl1.contains(expectedUrl1));
        // sonucu raorlamak icin tum sayfa screenshot alip kaydedin
            ReusableMethods.tumSayfaFotografiCek(driver, "Ab");

    }

    @Test
    public void testYouTube() {
        driver.get("https://www.youtube.com");

        String expectedUrl1 = "youtube";
        String actualUrl1 = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl1.contains(expectedUrl1));

        // sonucu raorlamak icin tum sayfa screenshot alip kaydedin
        ReusableMethods.tumSayfaFotografiCek(driver, "youtube");

    }
}
