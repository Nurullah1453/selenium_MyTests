package myTests_JUnit;

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

public class Test07 {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Test Cases' button
    5. Verify user is navigated to test cases page successfully
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
        WebElement homePage= driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click on 'Test Cases' button
        WebElement testCases= driver.findElement(By.xpath("(//a[@href='/test_cases'])[1]"));
        testCases.click();
        //5. Verify user is navigated to test cases page successfully
        WebElement testcas= driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(testCases.isDisplayed());

    }
}
