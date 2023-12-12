package tests.day17_testNGReports_dataProvided;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class dataproviderKullanimi extends TestBaseRapor {


    @Test
    public void cokluAramaTesti() {
        /*
            Bugune kadar ogrendigimiz yontemlerle
            birden fazla eleman icin test yapmak istedigimizde
            elemanlari bir array'e atayip
            for loop ile testleri yapmak istedik

            ANCAK, ilk failed olan urunde
            assertion exception firlatip calismayi durdurdu
            geriye kalan urunlerin var olup olmadigini kontrol etmedi
         */
        extentTest=extentReports.createTest("data provider Test","belirlenen urun icin arama yapilabilmeli");

        String[] aranacakUrunler = {"phone", "java", "dress", "nutella", "chair", "tea"};
        String arananUrun;
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        int actualUrunSayisi;

        for (int i = 0; i < aranacakUrunler.length; i++) {

            arananUrun = aranacakUrunler[i];

            // testotomasyonu anasayfaya gidin
            Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
            extentTest.info("kullanici testotomasyonu sayfasina gidebilmeli");


            // verilen urun listesindeki tum urunler icin arama yapip
            extentTest.info("verilen urun listesindeki tum urunler icin arama yapabil,#meli");
            // urun listesi : phone, java, dress, nutella, chair, tea
            testOtomasyonuPage.aramaKutusu.sendKeys(arananUrun + Keys.ENTER);
            extentTest.info("verilen listesindeki "+arananUrun+" icin arama yapar");
            ReusableMethods.bekle(1);
            // her bir urun icin arama yapildiginda sonuc bulunabildigini test edin

            actualUrunSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
            Assert.assertTrue(actualUrunSayisi > 0);
            extentTest.pass(arananUrun +" icin arama yapildiginda sonuc bulunabildigini test eder");
        }
        }



    @DataProvider
    public static Object[][] aranacakUrünlerDataProvider() {

        String[] [] aranacakUrunler = {{"phone"}, {"java"}, {"dress"}, {"nutella"}, {"chair"}, {"tea"}};



        return aranacakUrunler;
    }


   @Test(dataProvider = "aranacakUrünlerDataProvider")
    public void dataProviderIleCokluAramaTesti(String arananUrun){

        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
       testOtomasyonuPage.aramaKutusu.sendKeys(arananUrun + Keys.ENTER);

       // her bir urun icin arama yapildiginda sonuc bulunabildigini test edin

      int actualUrunSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
       Assert.assertTrue(actualUrunSayisi > 0);

   }

   }


