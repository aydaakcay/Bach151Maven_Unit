package techproed.BURAKHOCA.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import techproed.BURAKHOCA.utilities.TestBase;

public class TestBaseDemo extends TestBase {


    @Test
    public void name() {

        //techphroeducation sayfasına gidiniz
        driver.get("https://techproeducation.com");


        //Baslıgın "Bootcamp  " /expected title / içerdiğini test ediniz
        String actualTitle =driver.getTitle();
        String expectedTitle ="Bootcamp";

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
}
