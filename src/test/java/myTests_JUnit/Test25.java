package myTests_JUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test25 extends TestBase {

    @Before
    public void beforeTest(){
        driver.get(" http://www.bestbuy.com");
    }


    @Test
    public void titleTest(){
        //  http://www.bestbuy.com 'a gidin,


        //  Sayfa basliginin "Best" icerdigini(contains) dogrulayin
        String actualsayfaBaslıgı= driver.getTitle();
        String expectedKelime="Best";

        Assert.assertTrue(actualsayfaBaslıgı.contains(expectedKelime));
    }

    @Test
    public void logoTest(){
        //  Ayrica Relative Locator kullanarak;
        //      logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin
        WebElement bestBuyLogo= driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));

        Assert.assertTrue(bestBuyLogo.isDisplayed());
    }

    @Test
    public void mexicoLinkTest(){
        //  Ayrica Relative Locator kullanarak;
        //      mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin
        WebElement mexicoLink= driver.findElement(By.xpath("(//img[@alt='Mexico'])[1]"));

        Assert.assertTrue(mexicoLink.isDisplayed());

    }




}
