package techproed.EROL_HOCA.day21_Excel_JSExecutor;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_ExcelWrite {
    @Test
    public void Test01() throws IOException {

          /*
        Bir "NÜFUS" sütunu oluşturup
        başkent nüfuslarını excel doyasına yazınız:
        (D.C: 712816, Paris: 2161000, London: 8982000, Ankara: 5663000 ...)

    */
          /*
        -->Bir hucreye veri ekleyebilmek icin belirtmis oldugumuz satirdan sonra
        hangi hucreye(cell) ekleme yapacaksak
        createCell(cell numarasi) methodu ile cell icine eklenecek veri icin
         setCellValue() methodu kullanarak istedigimiz
        veriyi ekleyebiliriz
         */

        FileInputStream fis =  new FileInputStream("src/test/java/techproed/Resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        workbook.getSheet("Sheet1").getRow(0).createCell(2).setCellValue("NÜFUS");
        workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue(712816);
        workbook.getSheet("Sheet1").getRow(2).createCell(2).setCellValue(216100);
        workbook.getSheet("Sheet1").getRow(3).createCell(2).setCellValue(899200);
        workbook.getSheet("Sheet1").getRow(4).createCell(2).setCellValue(566300);

          /*
    Excel'e veri ekleme işleminden sonra FileOutputStream ile eklediğimiz verileri
     workbook objesi ile
    write() methodu kullanarak kaydederiz.
    Bu şekilde excel'e veriler kaydedilmiş olur.
    Sonra yapacağımız farklı işlemlerde hata almamamız için
    fos(FileOutStream).close() ve workbook.close() methodlarıyla
    yaptığımız işlemleri kaydedip sonlandırmış oluruz.
     */


        /*
        fis ile verileri ekledikten sonra fos ile dosyaya kaydederiz
         */


        FileOutputStream fos = new FileOutputStream("src/test/java/techproed/Resources/Capitals.xlsx");
        workbook.write(fos);
        fos.close();
        workbook.close();

   }

   /*
    ODEV1
    1.satirdaki 2.hucreye gidelim ve yazdiralim
    1.satirdaki 2.hucreyi bir string degiskene atayalim ve  yazdiralim
    2.satir 4.cell'in afganistan'in baskenti oldugunu test  edelim
    Satir sayisini bulalim
    Fiziki olarak kullanilan satir sayisini bulun
    Ingilizce Ulke isimleri ve baskentleri bir map olarak  kaydedelim
 */
    /*
    ODEV2
    Yeni bir test method olusturalim writeExcelTest()
    Adimlari takip ederek 1.satira kadar gidelim
    5.hucreye yeni bir cell olusturalim
    Olusturdugumuz hucreye "Nufus" yazdiralim
    2.satir nufus kolonuna 1500000 yazdiralim
    10.satir nufus kolonuna 250000 yazdiralim
    15.satir nufus kolonuna 54000 yazdiralim
    Dosyayi kaydedelim
    Dosyayi kapatalim
 */



}
