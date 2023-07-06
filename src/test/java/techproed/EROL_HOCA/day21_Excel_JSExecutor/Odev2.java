package techproed.EROL_HOCA.day21_Excel_JSExecutor;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Odev2 {


    @Test
    public void writeExcelTest() throws IOException {


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

        FileInputStream fis = new FileInputStream("src/test/java/techproed/BURAKHOCA/Resources/ulkeler.xlsx");

        Workbook workbook = WorkbookFactory.create(fis);

        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("NUFUS");
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("1500000");
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue("250000");
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue("54000");

        FileOutputStream fos = new FileOutputStream("src/test/java/techproed/BURAKHOCA/Resources/ulkeler.xlsx");
        workbook.write(fos);
        fos.close();
        workbook.close();



    }
}
