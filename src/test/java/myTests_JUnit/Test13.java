package myTests_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test13 {
    /*
    Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    a. Verilen web sayfasına gidin.
       https://facebook.com
    b. Cookies’i kabul edin
    c. Create an account buton’una basin
    d. Radio button elementlerini locate edin ve size uygun olani secin
     */
    WebDriver driver;
    @Before
    public void setUp(){
        //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test() throws InterruptedException {
        //a. Verilen web sayfasına gidin.
        driver.get("https://facebook.com");
        //c. Create an account buton’una basin
        WebElement creatButon= driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        creatButon.click();
        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
        Thread.sleep(3000);

    }


}
