package day01_seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test01 {
    /*...Exercise1...
    Create chrome driver
    Maximize the window
    Open google home page https://www.google.com/.
    On the same class, Navigate to amazon home page https://www.amazon.com/
    Navigate back to google
    Navigate forward to amazon
    Refresh the page
    Close/Quit the browser
    And last step : print "All Ok" on console
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
        //Open google home page https://www.google.com/.
        driver.get("https://www.google.com");
        //On the same class, Navigate to amazon home page https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");
        //Navigate back to google
        driver.navigate().back();
        //Navigate forward to amazon
        driver.navigate().forward();
        //Refresh the page
        driver.navigate().refresh();
        //And last step : print "All Ok" on console
        System.out.println("All Ok");
    }
}
