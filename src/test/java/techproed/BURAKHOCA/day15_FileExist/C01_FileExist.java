package techproed.BURAKHOCA.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist {


    @Test
    public void fileExist() {



        System.out.println(System.getProperty("user.dir"));  //  C:\Users\BURAK\IdeaProjects\B151MavenJUnit
        // bana icinde oldugum projenin dosya yolunu(path) verir.


        System.out.println(System.getProperty("user.home"));  // C:\Users\BURAK
        // herkesin bilgisayarında farklı olan kısmı verir.



        // SORU:
        // Desktop(masaustu)'da bir text dosyası olusturun



        // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin

        /*
        dosyanın,bilgisayarımda destop'da olup olmadıgını
        Java ile test edecegim.
        cunku selenium, web sayfalarını test eder.
        Selenium, benim bilgisayarımdaki desktop'a mudahele edemez
         */


       // C:\Users\Lenovo\Desktop
      Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\Lenovo\\Desktop")));
        // exist --> Mevcut mu ??




        // Ko.dumuzu daha dinamik hale getirelim
        // "C:\Users\Lenova" herkesin bilg. farklı olan kısmı alalım
        String farkliKisim = System.getProperty("user.home");

        String ortakKisim ="\\Desktop\\selenyum.txt";

        String dosyaYolu = farkliKisim + ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));




    }
}