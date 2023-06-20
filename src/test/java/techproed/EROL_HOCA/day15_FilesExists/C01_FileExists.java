package techproed.EROL_HOCA.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExists {


    @Test
    public void test01() {

        /*
        Bir websitesini test ettigimizde dowload islemi yapildigi zaman
        dosyanin bilgisayarimiza inip inmedigini kontrol etmek
    yani bilgisayarimizdaki herhangi bir dosyanin varligini dogrulayabilmek icin;
    Files class'indan exists() methodunu kullanarak parametre olarak
    ==> Paths.get(dosyayolu)
     methodunu kullanarak  dosyanin varligini test edebiliriz.
     ==> Files.exists(Paths.get(dosyayolu)
    Dolayisiyla bu isleme baslamadan once dosya varligini test edecegimiz dosyanin yolunu
     String bir degiskene  assign ederiz.
         */

        String dosyaYolu = "C:/Users/Lenovo/Desktop/ODEV2.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));//-->Dosya varsa True yoksa False döner
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void test02() {
        String dosyaYolu = "C:/Users/Lenovo/Desktop/Selenyum.txt";
        //--> "C" den once ve en sondaki çift tırnaktan önce /" olmayacak
        System.out.println(Files.exists(Paths.get(dosyaYolu)));//-->Dosya varsa True yoksa False döner
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void test03() throws InterruptedException {
    /*
        Bir server'da farkli işlerim sistemleri ile aynı anda dosya varlığını test etmek istediğimiz zaman,
    daha dinamik olması açısından System.getProperty("os.name") bu şekilde işletim sistemi alır
    her işletim sistemin kullanıcı yolu farklı olacağından System.getProperty("user.home")
    bilgisayarımızdaki kullanıcı yolunu bu şekilde String bir değişkene farklıYol ismiyle System.getProperty("user.home")
    atayarak herseferinde farklı yolları almayla uğraşmamış oluruz. Dosya diyelimki masaüstünde ve her işletim
    sisteminde bize aynı yolu vereceği için bunuda ortakYol olarak bir String'e assing ederiz
     */

        /*

        NOT:
        Windows10 surumlerinden once ki surumler icin pratik olarak
    dosya yolu almak istersek yolunu almak istedigimiz
    dosyanin uzerine gelip shift+sag click basarak
    yol olarak kopyala secenegi ile dosya yolunu kopyalayabiliriz
         */



        //-->Dosya yolumuz : ""C:\Users\Lenovo\Desktop\deneme.txt""
        String farkliYol = "";
        String isletimSistemiAdi = System.getProperty("os.name");//-->İşletim sistemimizin adını verir
        System.out.println(isletimSistemiAdi);
        System.out.println(System.getProperty("user.home"));//-->Bilgisayarımızdaki kullanıcı yolunu verir
        if (isletimSistemiAdi.contains("Win")){
            farkliYol = System.getProperty("user.home");//-->Windows 10/-->C:\Users\Lenovo
        }else if (isletimSistemiAdi.contains("mac")){
            farkliYol = "/Users/aycapolatkamali";//-->Mac işletim sistemi yolu
        }
        String ortakYol = "/Desktop/ODEV2.txt";
        String dosyaYolu = farkliYol+ortakYol;
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        try {
            Files.delete(Paths.get(dosyaYolu));//-->Bu şekilde belirtmiş olduğumuz dosyayı sileriz
        } catch (IOException e) {
            System.out.println("Dosya bulunamadı");
        }
        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu)));//-->Sildiğimiz için assertFalse kullandık

        Thread.sleep(3000);
        //Sildiğimiz dosya isminde yeni bir dosya oluşturalım
        try {
            Files.createFile(Paths.get(dosyaYolu));//-->Belirtmiş olduğumuz dosyayı oluşturduk
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    /*
        Her seferinde test ettiğimiz sayfada download işlemi yapılıyorsa gereksiz dosya kalabalığını önlemek için
    yukardaki delete işlemini kullanabiliriz
     */

    }

    @Test
    public void test04() {
        /*
            Yukarıdaki methodlarda bilgisayarımızdaki dosya yolunun varlığını Files.exists()methoduyla test etmiştik
        Aynı işlemi aşağıdaki örnekteki gibi File class'ından obje oluşturarak da yapabiliriz.
         */
        String dosyaYolu = "C:/Users/Lenovo/OneDrive/Masaüstü/sen.txt";
        File file = new File(dosyaYolu);
        System.out.println(file.exists());
        Assert.assertTrue(file.exists());
        file.delete();
    }
}







