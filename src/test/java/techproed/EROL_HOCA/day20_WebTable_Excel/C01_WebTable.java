package techproed.EROL_HOCA.day20_WebTable_Excel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.EROL_HOCA.utilities.TestBase;

import java.util.List;

public class C01_WebTable extends TestBase {


    /*
   WEBTABLE;
       <table> tagı ile başlar
           <thead> başlıklar için bu tag ile devam eder
               <tr> başlıkların satırı
               <th> table head
                   <td> başlıktaki veriler
               <tbody> başlıklar altındaki verileri temsil eder
                       <tr> table row(satır)
                           <td> table data (tablodaki veri)
    */
    @Test
    public void test01() {

        extentReport("Brovser","WebTable");
        extentTest = extentReports.createTest("Web Table ","Test Raporu");


        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        extentTest.info("Sayfaya Gidildi ");


        //    Task 1 : Table1’i yazdırın
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Tablo 1");
        System.out.println(table1.getText());
        extentTest.info("Tablo1 Yazdırıldı ");


        //    Task 2 : 3. Satır verilerini yazdırın
        WebElement ucuncuSatir = driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        System.out.println("*********************************************");
        System.out.println(ucuncuSatir.getText());
        extentTest.info("3.Satır verileri Yazdırıldı ");


        //    Task 3 : Son satırın verilerini yazdırın
        WebElement sonSatir = driver.findElement(By.xpath("(//tbody)[1]//tr[last()]"));
                            // last() --> İstenilene göre son satır yada sutun bilgilerini verir.
        System.out.println("1.Tablo son satır bilgileri :" + sonSatir.getText());
        extentTest.info("Son satır verieleri yazdırıldı ");




        //    Task 4 : 5. Sütun verilerini yazdırın

        System.out.println("********************************************************************");
        WebElement besinciBaslik = driver.findElement(By.xpath("(//thead)[1]//th[5]"));
        System.out.println(besinciBaslik.getText()); //--> 5. Sütun başlığı
        List<WebElement> besinciSutun = driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
        besinciSutun.forEach(t-> System.out.println(t.getText()));
        extentTest.info("5. Sütun verileri yazdırıldı ");



        //   Task 5 : 3. Satırda ki  1. ve 2. satun bilgilerini yazdırınız
        System.out.println("****************************************************************");
        List<WebElement> ucuncuSatir1 = driver.findElements(By.xpath("(//tbody)[1]//tr[3]//td[position()>=1 and  position()<=2]"));
                                                                                        // position ile Aralık alma şekliyle xpath aldık
        ucuncuSatir1.forEach(t-> System.out.print(t.getText() + "\t"));
        extentTest.info("3. Satırda ki  1. ve 2. satun bilgileri yazdırıldı ");



        //    Task 6 : Iki parametreli bir Java metodu oluşturalım: printData
        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.
        System.out.println();
        System.out.println(printData(2, 3));
        extentTest.info("2. satır, 3. sütundaki veri yazdırıldı ");



        // 3. Satır 2. Sütun bilgisinin Jack olup olmadığını doğruların
        printData(3,2);
        String actualData = printData(3,2);
        String  expectedData = "Jack";
        Assert.assertNotEquals(expectedData,actualData);
        extentTest.fail("3. satır, 2. sütunun Jason olduğu görüldü");
        extentTest.pass("Sayfa Kapatıldı");
        extentReports.flush();

    }

    private String printData(int satir, int sutun) {
        WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr["+satir+"]//td["+sutun+"]"));
        return  satirSutun.getText();
    }



             //ÖDEV

           //C03_WebTables class'ı için aldığımız rapora gidelim
        //NOT:driver.get("testOutput/extentReports/extentReport_09_53_35_26062023.html")
        //Başlığın Extent Report olduğunu test edelim
        //Rapor temasını dark yapalım
        //Dashboard bölümüne gidip tabloyu yazdırınız
        //Tester'ın "isminiz" olduğunu doğrulayalım
        //Sayfayı kapatalım



}
