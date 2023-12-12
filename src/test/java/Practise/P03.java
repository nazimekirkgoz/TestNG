package Practise;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class P03 {
    /*
    //1 - https://www.facebook.com/ adresine gidin
//2- POM'a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
//3- Faker class'ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
//4- Basarili giris yapilamadigini test edin
     */

    @Test
    public void Amazon(){
        //1 - https://www.amazon.com/ adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("toAmazonUrl"));
        Actions actions=new Actions(Driver.getDriver());
  AmazonPage amazonPage=new AmazonPage();
        actions.moveToElement(amazonPage.konto).perform();;
        //3- “Create a list” butonuna basint
        ReusableMethods.bekle(3);

        actions.moveToElement(amazonPage.anmelden).click().perform();
        Driver.quitDriver();


}
}

