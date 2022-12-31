package myTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;
import utilities.TestBase;

import java.util.Set;

public class Test22 extends TestBase {
     /*
    1- Yeni bir class olusturalim: MouseActions1
    2- https://the-internet.herokuapp.com/context_menu sitesine gidin
    3- Cizili alan uzerinde sag click yapin
    4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
    5- Tamam diyerek alert’i kapatalim
    6- Elemental Selenium linkine tiklayalim
    7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
     */

    @Test

    public void test(){

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapin
        Actions actions=new Actions(driver);

        WebElement alan= driver.findElement(By.id("hot-spot"));
        actions.contextClick(alan).perform();

        // 4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String actualAlert=driver.switchTo().alert().getText();
        String expectedAlert="You selected a context menu";

        Assert.assertEquals(actualAlert,expectedAlert);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        String ilkSayfaWHD= driver.getWindowHandle();

        //  6- Elemental Selenium linkine tiklayalim
        WebElement elementalSeleniumLink= driver.findElement(By.linkText("Elemental Selenium"));
        elementalSeleniumLink.click();

        // 7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        Set<String>ikiSayfanınWHD=driver.getWindowHandles();
        String ikinciSayfaWHD="";

        for (String eachWHD:ikiSayfanınWHD
             ) {
            if (!eachWHD.equals(ilkSayfaWHD)){
                ikinciSayfaWHD=eachWHD;
            }
        }
        driver.switchTo().window(ikinciSayfaWHD);

        String expectedYazı="Elemental Selenium";
        String actualYazı=driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(expectedYazı,actualYazı);

        ReusableMethod.bekle(3);

    }
}
