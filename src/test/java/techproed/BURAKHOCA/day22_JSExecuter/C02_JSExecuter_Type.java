package techproed.BURAKHOCA.day22_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.BURAKHOCA.utilities.TestBase;

public class C02_JSExecuter_Type extends TestBase {

        // https://techproeducation.com sayfasına gidin
        // Arama kutusuna "QA" yazıp aratın


    @Test
    public void TypeTest() {

        // https://techproeducation.com sayfasına gidin
        driver.get("https://techproeducation.com");

        bekle(3);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click(); // Reklamı kapattık



        // Arama kutusuna "QA" yazıp aratın

          // **********  1. YOL ********
       WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']"));
       // JavascriptExecutor js = (JavascriptExecutor) driver;
       // js.executeScript("arguments[0].value='QA'",aramaKutusu);

        sendKeysJS(aramaKutusu,"QA"); // Method kullanarakta QA yazdırabildik

        aramaKutusu.submit(); // Arama kutusuna enter yaptırdık



        /*

        //    /*   **********  2. YOL ********
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','QA')",aramaKutusu);
                                     // Value atrubütüne QA yi kalıcı olarak set ettik. Atadık


         */
    }
}
