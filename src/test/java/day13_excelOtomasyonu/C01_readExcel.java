package day13_excelOtomasyonu;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_readExcel {

    @Test
    public void readExcelTestleri() throws IOException {

        String dosyaYolu="src/test/java/day_excelOtomasyonu/ulkeler.xlsx";

        FileInputStream fls=new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fls);

        Sheet sheet= workbook.getSheet("Sayfa1");
        Row row= sheet.getRow(3);  // 0. indeksten basliyor
        Cell cell= row.getCell(3);

        System.out.println(cell); //Cezayir

       // - 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(sheet.getRow(0).getCell(1));//Başkent (İngilizce)

        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String istenenData=sheet.getRow(0).getCell(1).toString();
        System.out.println(istenenData);// Baskent(İngilizce)


       // - 2.satir 4.cell’in afganistan’in baskenti Kabil oldugunu test edelim

        String expectedData="Kabil";
        String actualData=sheet.getRow(1).getCell(3).toString();
        Assert.assertEquals(expectedData,actualData);

       //- Satir sayisini bulalim
        System.out.println(sheet.getLastRowNum()+1);// method 190 verdi- 0 dan basladıgı icin son satirin indeks sayisini verir
        // biz satir sayisini bulmak icin 1 ekledik.

        //  - Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(sheet.getPhysicalNumberOfRows()); // direk fiziki olarak kullanılan satir sayisini yazdirir.


        //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        String ulkeIsim;
        String baskent;
        Map<String ,String> ulkelerMap= new TreeMap<>();

        for (int i = 1; i <=sheet.getLastRowNum() ; i++) {

            ulkeIsim=sheet.getRow(i).getCell(0).toString();
            baskent=sheet.getRow(i).getCell(1).toString();

            ulkelerMap.put(ulkeIsim,baskent);

        }

        // ulkeler excel'inde Canada adlı bir ulkenin oldugunu kontrol edin

        Assert.assertTrue(ulkelerMap.containsKey("Canada"));

        // ulkeler excel'inde Cuba'nin baskentinin Havana oldugunu kontrol edin

        String exteptedBaskent="Havana";

        String actualBaskent=ulkelerMap.get("Cuba");

        Assert.assertEquals(exteptedBaskent,actualBaskent);


    }
}
