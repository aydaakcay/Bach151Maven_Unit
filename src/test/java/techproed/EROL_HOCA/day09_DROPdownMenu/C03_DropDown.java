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

public class C03_DropDown {


WebDriver driver;
    @Before
    public void setUp()  {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test01() {

        //programing languages dropdownm'den istediğiniz 4 seceneği seciniz
        WebElement diller = driver.findElement(By.xpath("(//select)[6]"));
        Select select = new Select(diller);
        select.selectByIndex(0);
        select.selectByIndex(2);
        select.selectByIndex(3);
        select.selectByIndex(4);

        //Eger sadece secili olan option'lari yani secenekleri yazdirmak istersek
        select.getAllSelectedOptions().forEach(w-> System.out.println(w.getText()));//--> Lamnda ile


        System.out.println("************************************");
        // For ile
        for (WebElement e: select.getAllSelectedOptions()){
            System.out.println(e.getText());
        }


        //Seçeneklerden 4 tane seçtiğimizi doğrulayalım
        Assert.assertEquals(4,select.getAllSelectedOptions().size());



        //Sectigimiz seceneklerden ilkini yazdiralim, ilk seceneğin "Java" oldugunu doğrulayalım
        System.out.println("*************************************");
        System.out.println("Seçilen seceneklerden ilki :" +select.getFirstSelectedOption().getText());
        Assert.assertEquals("Java",select.getFirstSelectedOption().getText());

        bekle(3);



        // Seçtiğimiz seceneklerden hepsini kaldırmak için
        select.deselectAll();



        //sendKeys() methodu ile istediğimiz bir seçeneği gönderelim
      //   diller.sendKeys("C#");
        bekle(3);



        //visibleText olarak secim yapacağımız bir method oluşturup
        // programming languages ddm den bir secenek secelim
        selectVisibleText(diller,"Java");
        bekle(2);



        //Index  olarak secim yapacağımız bir method oluşturup
        // programming languages ddm den bir secenek secelim
        selectIndex(diller,2);
        bekle(2);



        //Value  olarak secim yapacağımız bir method oluşturup
        // programming languages ddm den bir secenek secelim
        selectValue(diller,"js");
        bekle(3);

    }



    @After
    public void tearDown() throws Exception {
        bekle(3);
        driver.close();
    }



    public void selectVisibleText(WebElement ddm,String text){
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }

    public void selectIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }


    public void selectValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }



    public  void  bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    }

