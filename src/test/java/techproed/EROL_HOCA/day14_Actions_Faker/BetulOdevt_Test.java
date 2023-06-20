package techproed.EROL_HOCA.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.EROL_HOCA.utilities.TestBase;

public class BetulOdevt_Test extends TestBase {



        @Test
        public void test() throws InterruptedException {


            //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
            driver.get("http://webdriveruniversity.com/Actions");


            //2- Hover over  Me First" kutusunun ustune gelin
            WebElement frm= driver.findElement(By.xpath("//div[@class='thumbnail']"));
            WebElement homf= driver.findElement(By.xpath("//button[@class='dropbtn']"));
            homf.click();


            //3- Link 1" e tiklayin
            WebElement link1=driver.findElement(By.xpath("(//a[@class='list-alert'])[1]"));
            link1.click();

            bekle(3);

            //4- Popup mesajini yazdirin
            System.out.println("Popup yazısı: " + driver.switchTo().alert().getText());

            bekle(2);

            //5- Popup'i tamam diyerek kapatin
            acceptAlert();

            bekle(3);


            //6- “Click and hold" kutusuna basili tutun
            WebElement cah= driver.findElement(By.id("click-box"));
            Actions actions=new Actions(driver);
            actions.clickAndHold(cah).perform();

            bekle(3);

            //7-“Click and hold" kutusunda cikan yaziyi yazdirin
            System.out.println("cah = " + cah.getText());


            // 8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
            WebElement dcm= driver.findElement(By.xpath("//div[@class='div-double-click']"));
            Actions action=new Actions(driver);
            action.doubleClick(dcm).perform();

        }
    }





