package techproed.BURAKHOCA.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.BURAKHOCA.utilities.TestBase;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;



public class C02_FileDownload extends TestBase {


    @Test
    public void test01() {

        //"https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        bekle(2);

        File silinecekDosya = new File("C:\\Users\\Lenovo\\Downloads\\b10 all test cases, code.docx");
        silinecekDosya.delete();
        /*
        Eğer localinizden otomasyon ile bir dosya silmek için
        File clasında obje oluşrurup dosya yolumuzu içine yerleştiririz.
        Ve ouşturduğumuz obje ile delete metodunu kullanarak o dosyayı silebiliriz.
        Bunu yapma sebebimiz test class'ımızı çalıştırdığımızda, her çalıştırmada
        yeni bir dosya indireceği için orda ki ( Yani indirilenlerdeki) dosya kalabalığını önlemiş oluruz
        Aynı zamanda doğrulama yaparken işimizi garantiye almış oluruz.

        Aynı isimde birden fazla dosya indirmiş olsakta her indirilenin yanına index vereceği için
        ve bizim ilk indirdiğimiz o klasörün içinde bulamayacağı için her zaman ilk dosyanın
        varlığını böylelikle test etmiş oluruz
         */



        //"b10 all test cases" dosyasını indirin
        WebElement indirilecekDosya = driver.findElement(By.xpath("//a[text()='b10 all test cases, code.docx']"));
        indirilecekDosya.click();

        bekle(3);



        // Dosyanın başarıyla indirilip indirilmediğini test edin.


        /*
        dosyanın, bilgisayarımda dowloads'a basarıyla indirilip indirilmedigini
        java ile test edecegim.
        cünkü selenium, web sayfalarını test eder.
        Selenium, benim bilgisayarımdaki dowloads'a müdahele edemez.
         */


        //      "C:\Users\BURAK           \Downloads\b10 all test cases, code.docx"
        // Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\BURAK\\Downloads\\b10 all test cases, code.docx")));


        // daha dinamik hale getirelim
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\b10 all test cases, code.docx";

        String dosyaYolu = farkliKisim + ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }








}