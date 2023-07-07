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

        //ÖDEV
        extentReport("Chrome", "Raporun Raporu");

        //C01_WebTables class'ı için aldığımız rapora gidelim
        driver.get(" testOutput/extentReports/extentReport_07_10_46_01072023.html");
        extentTest.info("Rapora gidildi...");

        //Başlığın Extent Report olduğunu test edelim
        Assert.assertEquals("Extent Report", driver.getTitle());
        extentTest.info("Başlığın Extent Report olduğunu test edildi");

        //Rapor temasını dark yapalım
        driver.findElement(By.id("theme-selector")).click();
        extentTest.info("Rapor temasi dark yapildi");

        //Dashboard bölümüne gidip tabloyu yazdırınız
        driver.findElement(By.xpath("//*[@class='waves-effect']")).click();
        WebElement table = driver.findElement(By.xpath("(//table)[3]"));
        System.out.println(table.getText());
        extentTest.info("dashboard bolumundeki tablo yazdirildi.");

        //Tester'ın "Emre" olduğunu doğrulayalım
        WebElement actualData = driver.findElement(By.xpath("(//table)[3]//tr[3]//td[2]"));
        String actualData1 = actualData.getText();
        String expectedData = "Emre";
        Assert.assertEquals(expectedData, actualData1);
        extentTest.info("Tester'ın Emre olduğu doğrulandi.");

        //Sayfayı kapatalım
        extentTest.info("Sayfa kapatildi");
        extentReports.flush();
    }
}