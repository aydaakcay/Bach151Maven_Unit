package techproed.EROL_HOCA.day09_DROPdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Odev2 {


    /*
    ●https://www.amazon.com/ adresine gidin.
-Test 1
Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
oldugunu test edin

     */
    WebDriver driver;
    Select select;
    WebElement ddm;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
        ddm=driver.findElement(By.id("searchDropdownBox"));
        select = new Select(ddm);

    }
    @Test
    public void test01() {


        List<WebElement> kategoriler=select.getOptions();
        System.out.println(kategoriler.size());
        Assert.assertFalse(kategoriler.size()==45);
    }
    /*
    -Test 2
1.Kategori menusunden Books secenegini secin
2.Arama kutusuna Java yazin ve aratin
3.Bulunan sonuc sayisini yazdirin
4.Sonucun Java kelimesini icerdigini test edin
     */

    @Test
    public void test02() throws InterruptedException {
        select.selectByIndex(5);
        Thread.sleep(2000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        WebElement sonucYazisi =driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String [] sonucSayisi= sonucYazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi :"+sonucSayisi[3]);
        Assert.assertTrue(sonucYazisi.getText().contains("Java"));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
