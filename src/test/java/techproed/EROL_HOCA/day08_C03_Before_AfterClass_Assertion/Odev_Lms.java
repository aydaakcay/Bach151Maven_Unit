package techproed.EROL_HOCA.day08_C03_Before_AfterClass_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Odev_Lms {

    /*
    *** Aşağıdaki Task'i Junit framework'u ile yapınız
   - Before methodu ile drive'i olusturup ayarlamalari yapiniz
            - ebay sayfasına gidiniz
            * www.ebay.com
   - electronics bölümüne tıklayınız
   - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
   - Her sayfanın sayfa başlığını yazdıralım
   - After methodu ile sayfayı kapatalım

*/
    WebDriver driver;

    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.ebay.com");
    }

    @Test
    public void test01() {

        // Electronics bölümünü tıklayınız
        driver.findElement(By.xpath("(//*[@class='hl-cat-nav__js-tab'])[1]")).click();


        // Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        // driver.findElement(By.xpath("//*[@class='b-img'][1]")).click();
       List<WebElement>  resimler = driver.findElements(By.xpath("//*[contains(@width,'225')]"+"|//*[contains(@height,'225')]"));

        for (int i = 0; i < resimler.size(); i++) {

            resimler = driver.findElements(By.xpath("//*[contains(@width,'225')]"+"|//*[contains(@height,'225')]"));
            resimler.get(i).click();


        // Her sayfanın sayfa başlığını yazdıralım
            System.out.println(driver.getTitle());
            driver.navigate().back();

        }
    }


    @After
    // After methodu ile sayfayı kapatalım
    public void tearDown() throws Exception {
        driver.close();
    }
}




