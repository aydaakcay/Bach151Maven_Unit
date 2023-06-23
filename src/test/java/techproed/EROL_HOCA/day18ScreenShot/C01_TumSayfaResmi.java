package techproed.EROL_HOCA.day18ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.EROL_HOCA.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_TumSayfaResmi extends TestBase {

    /*
        SCREENSHOT

     Selenium da tüm ekran görüntüsünü alabilmek için TakesScreenShot arayüzünden  bir obje oluşturup
    drivera eşitleriz.Arayüzler farklı olduğu için casting yaparız.ve bu oluşturduğumuz obje ile
    getScreenShotAs methodu ile sayfanın resmini alırız.Almış olduğumuz resmi  projemizde nereye kaydedeceksek
    oranın yolunu belirtiriz.

    */
    @Test
    public void test01() throws IOException {

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");



        bekle(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();



        //Ve ekran görüntüsünü alalım
        /*
        -İlk olarak SS aldığımızda nereye kaydetmek istiyorsak oranın yolunu belirtelim
        -İkinci olarak TakesScreenShot arayüzünden obje oluştururuz
        -Üçüncü olarak FileUtils class'ından copyFile() methodu ile ts objemizi kullanarak getScreenShotAs methodu ile
        dosya yolunu belirteceğiz
    */


        String dosyayolu = "src/test/java/techproed/TumSayfaResmi/screenShot.png"; // En son yazdıgımız dosya adını biz manuel yazdık
        TakesScreenshot ts = (TakesScreenshot) driver; // Altı çilince eşitle diye tıklıyoruz(Arayüzler farklı , eşitliyoruz)
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyayolu));

    }

    @Test
    public void test02() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //Ve ekran görüntüsünü alalım
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("techproed/ScreenShot/screenShot.png"));
    }


    @Test
    public void test03() throws IOException {

        /*
        Kaydettiğimiz ekran resmini her seferinde aynı dosya üzerine yazmaması için dosya isminden sonra
        String bir değişkene tarih formatı atayabiliriz.
    */

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");



        bekle(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();




        //Ve ekran görüntüsünü alalım

        /*
     SimpleDateFormat'i kullanarak yeni bir tarih formati olusturup
     bir String'e assing ederiz. Ve bunu dosya isminden once
     belirtiriz.
     */
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());

        String dosyayolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".png"; // En son yazdıgımız dosya adını biz manuel yazdık
        TakesScreenshot ts = (TakesScreenshot) driver; // Altı çilince eşitle diye tıklıyoruz(Arayüzler farklı , eşitliyoruz)
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyayolu));

    }

    @Test
    public void test04() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        bekle(2);

        //Ve ekran görüntüsünü alalım

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }


}
