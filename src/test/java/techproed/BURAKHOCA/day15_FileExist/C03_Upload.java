package techproed.BURAKHOCA.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.BURAKHOCA.utilities.TestBase;

public class C03_Upload extends TestBase {

    @Test
    public void test01() {

        // masaustunde bir deneme dosyası olusturun

        // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/upload");

        bekle(2);




        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
       WebElement dosyaSec = driver.findElement(By.xpath("//input[@id='file-upload']"));

       // C:\Users\Lenovo\Desktop\deneme.txt
        String farkliKisim = System.getProperty("user.home");
        String ortakkisim = "\\Desktop\\deneme.txt";

        String dosyaYolu = farkliKisim + ortakkisim;

        dosyaSec.sendKeys(dosyaYolu);


        bekle(3);

        // 'Upload' butonuna basın
        WebElement upload = driver.findElement(By.xpath("//input[@id='file-submit']"));
        upload.click();

        bekle(3);



        // 'File Uploaded!' yazısının goruntulendigini test edin
       // WebElement yazi = driver.findElement(By.xpath("//h3"));
       WebElement fileUpload = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        Assert.assertTrue(fileUpload.isDisplayed());

    }
}
