package Practise;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class P02 {

    @BeforeClass
    public void setUp(){
        System.out.println("tüm testler calisiyor");
    }
    @Test
    public void wise(){
        Driver.getDriver().get(ConfigReader.getProperty("toWiseUrl"));
    }
    @AfterClass
    public void tearDown(){
        System.out.println("calistirilabilecek tüm testler");
    }
}
