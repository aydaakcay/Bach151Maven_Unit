package techproed.EROL_HOCA.day09_DROPdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Odev1 {


    /*
     ●https://the-internet.herokuapp.com/dropdown adresine gidin.
 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
 4.Tüm dropdown değerleri(value) yazdırın
 5.Dropdown'un boyutunu bulun, Dropdown'da 4 öğe varsa konsolda True , degilse
 False yazdırın.
      */
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void test01() {
        WebElement ddm=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        //
        // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> secenekler =select.getOptions();
        for (WebElement w:secenekler) {
            System.out.println(w.getText());

        }


        //5.Dropdown'un boyutunu bulun, Dropdown'da 4 öğe varsa konsolda True , degilse
        Assert.assertFalse(4==secenekler.size());
        System.out.println("False");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}