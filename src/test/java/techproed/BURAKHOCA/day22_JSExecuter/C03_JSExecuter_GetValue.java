package techproed.BURAKHOCA.day22_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.BURAKHOCA.utilities.TestBase;

public class C03_JSExecuter_GetValue extends TestBase {

    @Test
    public void test1() {
        //  https://www.carettahotel.com/ sayfasına gidiniz
        driver.get("https://www.carettahotel.com");
        bekle(1);
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        bekle(2);
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();


        //check-in date kismini JS ile locate edin
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement date = (WebElement) js.executeScript("return document.getElementById('checkin_date')");


        /*
        CSS SELECTOR KULLANARAK'DA LOCATE ALINABİLİR

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement date = (WebElement) js.executeScript("return document.querySelector(\"input[id='checkin_date']\")");
         */



        /*
        Eger bir web sayfasinda webelementler olusturulurken JS kullanilmissa, normal olarak
        locate almakta zorlanabiliriz. Bu gibi durumlarda JSExecutor kullanarak webelementi locate edebiliriz
         */


      //  EGER HTML KODLARINDA SCRIPT ATTRIBUTU VARSA O HTML KODLAR JS ILE YAZILMISTIR. BU DURUMDA
       // JSEXECUTER ILE ISLEM YAPMALYIZ





        // Check-in Date kısmına 5/25/2023   tarihini yazınız
        date.clear();
        date.sendKeys("5/25/2023");





        // Check-In Date kısmının değerini yazdırın
        String valueAttribute = (String) js.executeScript("return document.getElementById('checkin_date').value");

        System.out.println(valueAttribute);

    }
}
