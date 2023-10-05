package day_excelOtomasyonu;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_readExcel {

    @Test
    public void Test01() throws IOException {

        //2.sayfaya gidin kullanilan en son satirin 24.satir oldugunu satir oldugunu test edin

        String dosyaYolu="src/test/java/day_excelOtomasyonu/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        Sheet sayfa2= workbook.getSheet("Sayfa2");

        int expectedSatirSayisi=24;
        int actualSatirSayisi=sayfa2.getLastRowNum()+1;
        Assert.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        //fiziki kullanilan satir sayisinin 8 oldugunu test edin

        int expectedFizikiSatirSayisi=8;
        int actualFizikiSatirSayisi=sayfa2.getPhysicalNumberOfRows();

        Assert.assertEquals(expectedFizikiSatirSayisi,actualFizikiSatirSayisi);


        // olmayan satir veya sutun numarasi yazdirmaya calissak

        // System.out.println(sayfa2.getRow(30).getCell(1)); NullPointerException
        System.out.println(sayfa2.getRow(5).getCell(10)); // null
    }
}
