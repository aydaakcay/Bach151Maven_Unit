package techproed.EROL_HOCA.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.EROL_HOCA.utilities.TestBase;

public class C02_Actions_DragDrop extends TestBase {
    @Test
    public void test01() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");



        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım


        /*
        drag ve drop webelementleri iframe icinde oldugu icin iframe'e gecis yapmaliyiz
         */
        driver.switchTo().frame(0);


        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();
        /*
            Eğer bir hareketli webelementi tutup başka bir webelementin üzerene bırakmak istersek
         sürüklemek istediğimiz we'tin locatini alıp üzerine bırakacağımız we'tin locate'ini de alarak
         dragAndDrop(kaynak,hedef) methodu ile işlemi gerçekleştirebiliriz
         */


    }


    @Test
    public void test02() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
    /*
    drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
     */
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag). //--> Bu method ile WebE'e mouse ile basılı tuttuk
                moveToElement(drop). //--> Bu method ile basılı tuttugumuz WebE'i diger WeE'iin üzerine götürdük
                release(). //--> Bu method ile basılı tuttugumuz WebE'i serbest bıraktık
                perform(); //--> İşlemi sonlandırdık
    }


    @Test
    public void test03() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");


        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
    /*
    drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
     */
        driver.switchTo().frame(0);

        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);

        actions.clickAndHold(drag).
                moveByOffset(155,28).//-->Belirtmiş olduğumuz kordinatlara we'ti taşır
                release().perform();
    }
}