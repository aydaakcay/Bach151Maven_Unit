package techproed.EROL_HOCA.day11_Iframe_WindowHandle;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.EROL_HOCA.utilities.TestBase;

public class C02_IFrame_Odev {

    public class Odev2 extends TestBase {
        @Test
        public void name() {
            // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
            driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis");
            // ikinci emojiye tıklayın
            driver.switchTo().frame(driver.findElement(By.xpath("(//iframe)[2]")));
            driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]"));

            // İkinci emoji öğelerini yazdırınız
            System.out.println(driver.findElement(By.xpath("//div[@class='mdl-tabs__panel is-active']")).getText());


            // Parent iframe e geri donun
            driver.switchTo().parentFrame();

            // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
            WebElement form1= driver.findElement(By.cssSelector("[id=text]"));
            form1.sendKeys("esen" + Keys.TAB,"yunus"+Keys.TAB,"bahadir"+Keys.TAB,"yunus"+Keys.TAB,
                    "yunus"+Keys.TAB,"yunus"+Keys.TAB,"yunus"+Keys.TAB,"yunus"+Keys.TAB,"yunus"+Keys.TAB,
                    "yunus"+Keys.TAB,"yunus"+Keys.TAB,Keys.ENTER);

            // Apply button a basiniz


        }

    }
}
