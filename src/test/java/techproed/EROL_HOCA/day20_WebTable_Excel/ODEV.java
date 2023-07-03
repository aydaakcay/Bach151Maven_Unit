package techproed.EROL_HOCA.day20_WebTable_Excel;

import org.junit.Test;
import techproed.EROL_HOCA.utilities.TestBase;

public class ODEV  extends TestBase {


    //ÖDEV

    //C03_WebTables class'ı için aldığımız rapora gidelim
    //NOT:driver.get("testOutput/extentReports/extentReport_09_53_35_26062023.html")
    //Başlığın Extent Report olduğunu test edelim
    //Rapor temasını dark yapalım
    //Dashboard bölümüne gidip tabloyu yazdırınız
    //Tester'ın "isminiz" olduğunu doğrulayalım
    //Sayfayı kapatalım


    @Test
    public void test01() {

        //C03_WebTables class'ı için aldığımız rapora gidelim
        //NOT:driver.get("testOutput/extentReports/extentReport_09_53_35_26062023.html")

        extentReport("Chrome","Test Raporunun Testi");
        extentTest = extentReports.createTest("Extend Raport","Test Raporu");
        driver.get("testOutput/extentReports/extentReport_07_10_46_01072023.html");
        extentTest.info("Rapora Gidildi ");

        bekle(2);


        //Başlığın Extent Report olduğunu test edelim







    }
}
