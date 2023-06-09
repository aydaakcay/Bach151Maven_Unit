package techproed.EROL_HOCA.day09_DROPdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev4_LMSSayfası {

    //BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
    //Before methodunda http://www.google.com adresine gidin
    //Üç farklı test methodu ile;
    //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
    //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
    //After method'u ile başlıkları yazdırınız
    //AfterClass ile browser'ı kapatınız


     static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Before
    public void setUp() throws Exception {
        driver.get("http://www.google.com");
    }


    @Test
    public void test01() {

        //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin

        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id = 'APjFqb']"));
        aramaKutusu.sendKeys("The God Father", Keys.ENTER);
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id ='result-stats']"));
        String [] sonucSayisi = sonucYazisi.getText().split(" ");
        System.out.println("The God Father Sayısı :" +sonucSayisi[1]);

    }


    @Test
    public void test02() throws InterruptedException {

        //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin

        driver.findElement(By.id("APjFqb")).sendKeys("Lord of the Rings", Keys.ENTER);
        Thread.sleep(2000);
        driver.navigate().refresh();
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String [] arrayListOfSonucYazisi = sonucYazisi.getText().split(" ");
        System.out.println("Lord of the Ring Sayisi : " + arrayListOfSonucYazisi[1]);


    }


    @Test
    public void test03() throws InterruptedException {

        //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Kill Bill",Keys.ENTER);
        Thread.sleep(2000);
        driver.navigate().refresh();
        WebElement sonucYazisi =driver.findElement(By.xpath("//div[@id= 'result-stats']"));
        String [] killBill = sonucYazisi.getText().split(" ");
        System.out.println("Kill Bill Sayisi :" +killBill[1]);

    }

    @After
    public void tearDown() throws Exception {
        System.out.println(driver.getTitle());
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }
}

