package tests.day15;

import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_pozitifLogin {
    @Test
    public void pozitiflogintesti(){

/*
PositiveTest
1- https://www.testotomasyonu.com/ anasayfasina gidin
2- account linkine basin
3- Kullanici email'i olarak “wise@gmail.com”girin
4- Kullanici sifresi olarak “12345” girin
5- Login butonuna basarak login olun
6- Basarili olarak giris yapilabildigini test edin
 */




        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
                testOtomasyonuPage.accountLinki.click();
                testOtomasyonuPage.emailKutusu.sendKeys("toGecerliEmail");
                testOtomasyonuPage.passwordKutusu.sendKeys("toGecerliPassword");
                testOtomasyonuPage.aramaKutusu.sendKeys("toAranacakKelime");
        ReusableMethods.bekle(2);
        testOtomasyonuPage.loginButonu.click();
                Driver.closeDriver();

    }
}
