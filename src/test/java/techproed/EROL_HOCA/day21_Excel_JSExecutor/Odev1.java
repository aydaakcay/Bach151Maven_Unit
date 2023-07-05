package techproed.EROL_HOCA.day21_Excel_JSExecutor;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Odev1 {



   /*
    ODEV1
    1.satirdaki 2.hucreye gidelim ve yazdiralim
    1.satirdaki 2.hucreyi bir string degiskene atayalim ve  yazdiralim
    2.satir 4.cell'in afganistan'in baskenti oldugunu test  edelim
    Satir sayisini bulalim
    Fiziki olarak kullanilan satir sayisini bulun
    Ingilizce Ulke isimleri ve baskentleri bir map olarak  kaydedelim
 */

    @Test
    public void test01() throws IOException {



        FileInputStream fis = new FileInputStream("src/test/java/techproed/Resources/ulkeler.xlsx");

        Workbook workbook = WorkbookFactory.create(fis);

       // 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString());



        //  1.satirdaki 2.hucreyi bir string degiskene atayalim ve  yazdiralim
        String birinciSatirikincihücre =workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(birinciSatirikincihücre);



        // 2.satir 4.cell'in afganistan'in baskenti oldugunu test  edelim
        String ikinciSatirdorduncüHücre = workbook.getSheet("sayfa1").getRow(1).getCell(3).toString();
        Assert.assertEquals("Kabil",ikinciSatirdorduncüHücre);


        // Satir sayisini bulalim
        int satirSayisi = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(satirSayisi);  // 190


        // Fiziki olarak kullanilan satir sayisini bulun
        int kullanilanSatirSayisi = workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println(kullanilanSatirSayisi); // 191


        // Ingilizce Ulke isimleri ve baskentleri bir map olarak  kaydedelim
        Map<String,String>  isimBaskent = new LinkedHashMap<>();
        for (int i=0 ; i<workbook.getSheet("Sayfa1").getLastRowNum()+1 ; i++){

            if (workbook.getSheet("Sayfa1").getRow(i)!= null ){
                String ulke = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
                String baskent = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
                isimBaskent.put(ulke,baskent +"\n");
            }

        }

        System.out.println(isimBaskent);



    }
}
