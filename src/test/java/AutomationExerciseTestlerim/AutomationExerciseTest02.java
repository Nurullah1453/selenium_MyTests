package AutomationExerciseTestlerim;

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

public class AutomationExerciseTest02 {
    /*
     1. Launch browser
     2. Navigate to url 'http://automationexercise.com'
     3. Verify that home page is visible successfully
     4. Click on 'Signup / Login' button
     5. Verify 'Login to your account' is visible
     6. Enter incorrect email address and password
     7. Click 'login' button
     8. Verify error 'Your email or password is incorrect!' is visiblee
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
    public void test(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement anaSayfa=driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(anaSayfa.isDisplayed());
        //4. Click on 'Signup / Login' button
        WebElement signupButton= driver.findElement(By.xpath("//*[text()=' Signup / Login']"));
        signupButton.click();
        //5. Verify 'Login to your account' is visible
        WebElement loginY=driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginY.isDisplayed());
        // 6. Enter incorrect email address and password
        WebElement mail= driver.findElement(By.xpath("(//input[@type='email'])[1]"));
        mail.sendKeys("ajshd@gmail.com");
        WebElement pass= driver.findElement(By.xpath("(//input[@type='password'])[1]"));
        pass.sendKeys("546468486");
        //7. Click 'login' button
        WebElement loginButton= driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        loginButton.click();
        //8. Verify error 'Your email or password is incorrect!' is visible
        WebElement error=driver.findElement(By.xpath("//*[@style='color: red;']"));
        Assert.assertTrue(error.isDisplayed());
    }
}
