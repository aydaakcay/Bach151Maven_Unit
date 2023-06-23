package techproed.EROL_HOCA.day18ScreenShot;

import org.junit.Test;
import techproed.EROL_HOCA.utilities.TestBase;

public class C03_TumSayfaResmi extends TestBase {

    @Test
    public void test01() {

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        bekle(2);

        //Ve ekran görüntüsünü alalım
        tumSayfaResmi();



    }
}
