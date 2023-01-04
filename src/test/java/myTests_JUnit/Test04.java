package myTests_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Test04 {
    /*..........Exercise1............
    BeforeClass ile driver'i olusturun ve class icinde static yapin
    Maximize edin ve 10 sn bekletin
    http://www.google.com adresine gidin
    arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatin
     */
    static WebDriver driver;
    //BeforeClass ile driver'i olusturun ve class icinde static yapin
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        //Maximize edin ve 10 sn bekletin
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void test01(){
        //http://www.google.com adresine gidin
        driver.get("http://www.google.com");
        //arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
        WebElement aramaKutusu =driver.findElement(By.xpath("//input[@class='gLFyf']"));
        aramaKutusu.sendKeys("The Lord of the Rings"+ Keys.ENTER);
        WebElement sonuc=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonuc.getText());

    }
    @Test
    public void test02(){

        WebElement aramaKutusu =driver.findElement(By.xpath("//input[@class='gLFyf']"));
        aramaKutusu.clear();
        //arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
        aramaKutusu.sendKeys("Brave Heart"+Keys.ENTER);
        WebElement sonuc=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonuc.getText());
    }
    @Test
    public void test03(){
        WebElement aramaKutusu =driver.findElement(By.xpath("//input[@class='gLFyf']"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("Harry Potter"+Keys.ENTER);
        WebElement sonuc=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonuc.getText());
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
