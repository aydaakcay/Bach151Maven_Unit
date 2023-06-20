package techproed.EROL_HOCA.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import techproed.EROL_HOCA.utilities.TestBase;

public class C01_Actions extends TestBase {

    @Test
    public void test01() {

        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        bekle(2);

        //sayfanin altina dogru gidelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        bekle(2);

        //sayfanin ustune dogru gidelim
        //sayfanın üstüne doğru gidelim
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();

    }

    @Test
    public void test02() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        bekle(2);

        //sayfanın en altına scroll yapalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END);

        bekle(3);

        //sayfanın en üstüne scroll yapalım

        actions.sendKeys(Keys.HOME).build().perform();
        //build() --> methodu action'ları birleştirmek için kullanılan methoddur.
        // Birden fazla oluşturduğumuz action
        //objesini birbirine bağlar
        //release()-->  methodu mouse'u serbest bırakır

        /*
        her actions dan sonra perform kullanmazsak olay cok seri gerceklesir.
        build kullandigimizda olay milisaniye icinde gerceklesir.
        araya bekle methodu koysak bile java build methodunun oldugu kisimda sayfayi asagi yaparak hizli sekilde gerceklestirir

        release() methodu kutuyu bir yerrden sürükleme veya eslestirme gibi konulari yaparken
        mouseyi cekip birakmali sorularda release() methodu kullanilir
        actionsta mouseta sürükleme islemi yapiyorsak serbest birakma islemi icin release() methodu kullanilir.

        */

    }


    @Test
    public void test03() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        bekle(3);


        //sayfanın altına doğru gidelim
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,1500).perform();

        bekle(3);

        //sayfanın üstüne doğru gidelim
        actions.scrollByAmount(0,-1500).perform();

        /*
        scrollByAmount(0,1500) kartezyen koordinat sistemi olan yatay ve düsey yönleri
        x ve y olarak adlandirdigimiz sistemde x=0 ile y=+1500 arasinda
        gidecektir. pozitif(+) yön kuzey secilmistir
         */

    }
}
