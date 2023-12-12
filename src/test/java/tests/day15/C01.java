package tests.day15;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebuniversityPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01 {
    @Test
    public void aramatesti() {
        //1."http://webdriveruniversity.com/" adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/");
//2."Login Portal" a kadar asagi inin
        WebuniversityPage webuniversityPage=new WebuniversityPage();
        JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();
        //3."Login Portal" a tiklayin
       webuniversityPage.loginPortalLinki.click();
       //4.Diger window'a gecin
        ReusableMethods.titleIleSayfaDegistir("WebDriver|Login Portal");
        //5."username" ve  "password" kutularina rastgele deger yazdirin
        Faker faker=new Faker();
        webuniversityPage.usernameKutusu.sendKeys(faker.name().username());
        webuniversityPage.passwordKutusu.sendKeys(faker.internet().password());
        //6."login" butonuna basin
        webuniversityPage.loginButonu.click();
//7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expected="validation failed";
        String actuall=Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(actuall,expected);
//8.Ok diyerek Popup'i kapatin
Driver.getDriver().switchTo().alert().accept();

//9.Ilk sayfaya geri donun


    }








}