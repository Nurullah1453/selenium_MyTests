package AutomationExerciseTestlerim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationExerciseTest07 {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Add products to cart
    5. Click 'Cart' button
    6. Verify that cart page is displayed
    7. Click 'X' button corresponding to particular product
    8. Verify that product is removed from the cart
     */
    WebDriver driver;

    @Before
    public void setUp(){
        // 1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage= driver.findElement(By.xpath("(//span[text()='Automation'])[1]"));
        Assert.assertTrue(homePage.isDisplayed());

        // 4. Add products to cart
        driver.findElement(By.xpath("(//*[text()='Add to cart'])[1]")).click();

        //5. Click 'Cart' button
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();

        //6. Verify that cart page is displayed
        String actualUrl=driver.getCurrentUrl();
        String expectedKelime="view_cart";

        Assert.assertTrue(actualUrl.contains(expectedKelime));

        //7. Click 'X' button corresponding to particular product
        driver.findElement(By.className("cart_quantity_delete")).click();

        //8. Verify that product is removed from the cart
        WebElement bs=driver.findElement(By.xpath("//*[text()='Cart is empty!']"));
        Assert.assertTrue(bs.isDisplayed());
    }
}
