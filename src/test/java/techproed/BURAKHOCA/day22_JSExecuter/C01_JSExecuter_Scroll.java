package techproed.BURAKHOCA.day22_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.BURAKHOCA.utilities.TestBase;

public class C01_JSExecuter_Scroll extends TestBase {


    //  https://techproeducation.com sayfasına gidin
// "We Offer" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
// Aynı sayfada "Enroll Free" elementi görünür olacak sekilde scroll et (sayfayı kaydır)
// Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
// Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
// Sayfayi en üste scroll et (sayfayı kaydır)
// Sayfayı en alta scroll et (sayfayı kaydır)


    JavascriptExecutor js;
    @Test
    public void JSExecuter_ScrollTest()  {

        //  https://techproeducation.com sayfasına gidin
        driver.get("https://techproeducation.com");

        bekle(3);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click(); // Reklamı kapattık





        // "We Offer" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
        WebElement weOffer =  driver.findElement(By.xpath("//span[text()='we offer']"));

        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",weOffer);
        // "We Offer" elementi görünür olacak şekilde scroll et (sayfayı kaydır)

       //   scroll(weOffer); ** Testbase de yaptıgımız scroll method ilede de wepffer görünür olarak kaydırırız


        bekle(3);




        // Aynı sayfada "Enroll Free" elementi görünür olacak sekilde scroll et (sayfayı kaydır)
        WebElement enrollFree = driver.findElement(By.xpath(" //span[text()='Enroll Free Course']"));
        //js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(True);",weOffer);

        scroll(enrollFree);
        bekle(3);







        // Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
        WebElement whyUS=driver.findElement(By.xpath("(//h3[@class='title'])[7]"));
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",whyUS);

        bekle(3);





        // Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",enrollFree);
        //scroll(enrollFree); methodta kullanabiliriz

        bekle(3);





        // Sayfayi en üste scroll et (sayfayı kaydır)
       // js = (JavascriptExecutor) driver;
       // js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");


        scrollHome(); // Method kullanarak çalıştırdık





        // Sayfayı en alta scroll et (sayfayı kaydır)
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

       // scrollEnd();  Sayfayı en sona kaydıran method ile de çalıştırabiliriz

    }
}
