package HerokuappTestlerim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class HerokuappTest02 {
    /*

    ● https://the-internet.herokuapp.com/windows adresine gidin.
    ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    ● Click Here butonuna basın.
    ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    ● Sayfadaki textin “New Window” olduğunu doğrulayın.
    ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
     */

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test(){

        // ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualText=driver.findElement(By.tagName("h3")).getText();
        String expectedText="Opening a new window";

        Assert.assertEquals(actualText,expectedText);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle= driver.getTitle();
        String expectedTitle="The Internet";
        String ilkSayfaHandleDegeri=driver.getWindowHandle();

        Assert.assertEquals(actualTitle,expectedTitle);

        //  ● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        /*
         Kontrolsuz acilan tab'a gecis yapmak icin
         1- ilk sayfada iken o sayfanin WHD alip kaydedin
         2- 2.sayfa acildiktan sonra getWindowhandles() kullanarak
            acik olan tum sayfalarin WH degerlerini bir Set olarak kaydedin
         3- su anda elimizde 2 elementli bir Set var,
            elementlerden bir tanesi 1.sayfanin WHD
            1.sayfanin WHD'ine esit olmayan ise 2.sayfanin WHD olur
         4- bu sekilde 2.sayfanin WHD elde edildikten sonra
            WHD'leri kullanilarak sayfalar arasinda gecis yapilabilir
         */


        Set<String> tumWindowHandleDegerler =driver.getWindowHandles();

        String ikinciSayfaWhd="";
        for (String eachWhd:tumWindowHandleDegerler
             ) {
            if (!eachWhd.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaWhd=eachWhd;
            }
        }



        // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciSayfaWhd);
        String actualNewText= driver.getTitle();
        String expectedNewText="New Window";

        Assert.assertEquals(actualNewText,expectedNewText);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String expectedYeniSayfaYazı="New Window";
        String actualYeniSayfaYazı=driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expectedYeniSayfaYazı,actualYeniSayfaYazı);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaHandleDegeri);
        expectedTitle="The Internet";
        actualTitle=driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
    }

}
