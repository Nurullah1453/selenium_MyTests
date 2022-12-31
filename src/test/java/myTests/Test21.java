package myTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;
import utilities.TestBase;

import java.util.Set;

public class Test21 extends TestBase {

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
        //1- Yeni bir class olusturalim: MouseActions1
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");

        ReusableMethod.bekle(3);

        //Cizili alan uzerinde sag click yapin
        Actions action=new Actions(driver);
        WebElement ciziliAlan=driver.findElement(By.id("hot-spot"));
        action.contextClick(ciziliAlan).perform();

        ReusableMethod.bekle(3);


        // 4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlert="You selected a context menu";
        String actualAlert=driver.switchTo().alert().getText();

        Assert.assertEquals(actualAlert,expectedAlert);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        String ilkSayfaWHD= driver.getWindowHandle();

        //6- Elemental Selenium linkine tiklayalim
        WebElement seleniumLink= driver.findElement(By.linkText("Elemental Selenium"));
        seleniumLink.click();

        ////7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> ikiSayfanınWHDSeti=driver.getWindowHandles();
        String ikinciWHD="";

        for (String eachWHD:ikiSayfanınWHDSeti
        ) {
            if (!eachWHD.equals(ilkSayfaWHD)){
                ikinciWHD=eachWHD;
            }
        }

        driver.switchTo().window(ikinciWHD);

        String expectedYeniSayfaYazı="Elemental Selenium";
        String actualYeniSayfaYazı=driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(actualYeniSayfaYazı,expectedYeniSayfaYazı);

    }

}

