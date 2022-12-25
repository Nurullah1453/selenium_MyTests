package day02_seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test01 {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'New User Signup!' is visible
    6. Enter name and email address
    7. Click 'Signup' button
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        //1. Launch browser
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
    public void test() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement anaSayfa=driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(anaSayfa.isDisplayed());
        //4. Click on 'Signup / Login' button
        WebElement signupButton= driver.findElement(By.xpath("//*[text()=' Signup / Login']"));
        signupButton.click();
        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignup=driver.findElement(By.className("signup-form"));
        Assert.assertTrue(newUserSignup.isDisplayed());
        //6. Enter name and email address
        WebElement name=driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
        name.sendKeys("Nurullah");
        WebElement mail= driver.findElement(By.xpath("//*[@data-qa='signup-email']"));
        mail.sendKeys("QaTestNurullah@hotmail.com");
        //7. Click 'Signup' button
        WebElement sign= driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]"));
        sign.click();
        Thread.sleep(3000);
    }
}
