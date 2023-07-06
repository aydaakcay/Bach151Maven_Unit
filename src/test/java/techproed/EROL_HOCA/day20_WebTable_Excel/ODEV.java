package techproed.EROL_HOCA.day20_WebTable_Excel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
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

        extentReport("Chrome","Test Raporunun Testi");


        //C03_WebTables class'ı için aldığımız rapora gidelim
        //NOT:driver.get("testOutput/extentReports/extentReport_09_53_35_26062023.html")

        extentTest = extentReports.createTest("Extend Raport","Test Raporu");
        driver.get("C:\\Users\\Lenovo\\IdeaProjects\\Bach151Maven_Unit\\testOutput\\extentReports\\extentReport_07_10_46_01072023.html");
        extentTest.info("Rapora Gidildi " );

        bekle(2);



        //Başlığın Extent Report olduğunu test edelim
        String actual= driver.getTitle();
        String expected="testReport";
        Assert.assertEquals(expected, actual);


        //Assert.assertEquals("Extend Rapor",driver.getTitle()); Böylede doğrulama yapılabilir



        //Rapor temasını dark yapalım
        driver.findElement(By.xpath("//*[text()='desktop_windows']")).click();




        //Dashboard bölümüne gidip tabloyu yazdırınız
        driver.findElement(By.xpath("(//*[text()='track_changes'])[1]")).click();
        WebElement tablo =driver.findElement(By.xpath("//*[@id=\"dashboard-view\"]/div/div[3]/div[6]"));
        System.out.println(tablo.getText());




    }
}
