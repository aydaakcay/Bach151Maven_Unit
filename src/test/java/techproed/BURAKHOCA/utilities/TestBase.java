package techproed.BURAKHOCA.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public abstract  class TestBase {

    // Bu clasa extends ettiğimiz test classlarından ulaşabiliriz.
    // TestBase class'ından obje oluşturulmasının önüne gecilmesi için abstrac yaparız


    protected WebDriver driver;

    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    public void visibleWait(WebElement element, int sayi ){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(sayi));

        wait.until(ExpectedConditions.visibilityOf(element));

    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }

    //HARD WAIT (Bekleme Methodu)
    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
