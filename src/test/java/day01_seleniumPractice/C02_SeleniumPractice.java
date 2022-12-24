package day01_seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_SeleniumPractice {
    /* ...Exercise2...
 1 - Driver olusturalim
 2 - Java class'imiza chromedriver.exe'yi tanitalim
 3 - Driver'in tum ekrani kaplamasini saglayalim
 4 - Driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
     söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
 5 - "https://www.otto.de" adresine gidelim
 6 - Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
 7 - Title ve url'nin "OTTO" kelimesini icerip icermedigini kontrol edelim
 8 - Ardindan "https://wisequarter.com/" adresine gidelim
 9 - Bu adresin basligini ve Url alalim ve "Quarter" kelimesini icerip icermedigini
     kontrol edelim
 10- Bir onceki web sayfamiza geri donelim
 11- Sayfayi yenileyelim
 12- Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
 13- En son adim olarak butun sayfalarimizi kapatmis olalim
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        //3 - Driver'in tum ekrani kaplamasini saglayalim
        driver.manage().window().maximize();
        // - Driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public static void tearDown(){
        //13- En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.close();
    }

    @Test
    public void test01(){
        //5 - "https://www.otto.de" adresine gidelim
        driver.navigate().to("https://www.otto.de");
        //6 -web adresinin sayfa basligini (title) ve adres (url)ini alalim
        String title=driver.getTitle();
        String url= driver.getCurrentUrl();
        //7 - Title ve url'nin "otto" kelimesini icerip icermedigini kontrol edelim
        if (title.contains("otto")){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }
        if (url.contains("otto")){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }
        //8 - Ardindan "https://wisequarter.com/" adresine gidelim
        driver.navigate().to("https://wisequarter.com/");
        //9 - Bu adresin basligini ve Url alalim ve "Quarter" kelimesini icerip icermedigini
        //kontrol edelim
        String wBaslık= driver.getTitle();
        String wUrl= driver.getCurrentUrl();
        if (wBaslık.contains("Quarter")){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }
        if (wUrl.contains("Otto")){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }
        //10- Bir onceki web sayfamiza geri donelim
        driver.navigate().back();
        //11- Sayfayi yenileyelim
        driver.navigate().refresh();
        //12- Daha sonra web sayfamiza tekrar donelim
        driver.navigate().forward();




    }
}
