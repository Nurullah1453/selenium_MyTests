package myTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test03 {
    /* ...Exercise3...
    go to url : https://www.techlistic.com/p/selenium-practice-form.html
    fill the firstname
    fill the lastname
    check the gender
    check the experience
    fill the date
    choose your profession -> Automation Tester
    choose your tool -> Selenium Webdriver
    choose your continent -> Europa
    choose your command  -> Browser Commands
    click submit button
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
    public static void tearDown() throws InterruptedException {

        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        //go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().deleteAllCookies();
        //fill the firstname
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Nurullah");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("V");
        driver.findElement(By.xpath("//input[@value='Male']")).click();
        driver.findElement(By.id("exp-0")).click();
        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("24-12-2022");
        driver.findElement(By.xpath("//input[@id='profession-1']")).click();
        driver.findElement(By.xpath("//input[@id='tool-2']")).click();
        driver.findElement(By.xpath("//*[@id='continents']")).sendKeys("Europe");
        driver.findElement(By.xpath("//option[. = 'Browser Commands']")).click();


    }
}
