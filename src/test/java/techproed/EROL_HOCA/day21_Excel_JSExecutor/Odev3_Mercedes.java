package techproed.EROL_HOCA.day21_Excel_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.EROL_HOCA.utilities.TestBase;

public class Odev3_Mercedes extends TestBase {


   // sayfaya gidin cerezi kapatin
   //  https://www.mercedes-benz.com.tr/?group=all&subgroup=see-all&view=BODYTYPE


    @Test
    public void Test01() {
        //sayfaya gidin cerezi kapoatin
        //https://www.mercedes-benz.com.tr/?group=all&subgroup=see-all&view=BODYTYPE

        driver.get("https://www.mercedes-benz.com.tr/?group=all&subgroup=see-all&view=BODYTYPE");

        //kisa yol
        bekle(3);

        WebElement kapatma = driver.findElement(By.className("hydrated"));
        kapatma.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER);


        // 2. Yol
        


    }
}