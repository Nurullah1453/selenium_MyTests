package day03_seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Test16 {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Add products to cart
    5. Click 'Cart' button
    6. Verify that cart page is displayed
    7. Click Proceed To Checkout
    8. Click 'Register / Login' button
    9. Fill all details in Signup and create account
    10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
    11. Verify ' Logged in as username' at top
    12.Click 'Cart' button
    13. Click 'Proceed To Checkout' button
    14. Verify Address Details and Review Your Order
    15. Enter description in comment text area and click 'Place Order'
    16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
    17. Click 'Pay and Confirm Order' button
    18. Verify success message 'Your order has been placed successfully!'
    19. Click 'Delete Account' button
    20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
     */
    WebDriver driver;
    @Before
    public void setUp(){
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void test(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //4. Add products to cart
        driver.findElement(By.xpath("(//*[text()='Add to cart'])[1]")).click();

        //5. Click 'Cart' button
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();

        //6. Verify that cart page is displayed
        String expectedUrl="view_cart";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        //7. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();

        // 8. Click 'Register / Login' button
        driver.findElement(By.xpath("//*[text()='Register / Login']")).click();

        //9. Fill all details in Signup and create account
        Actions actions=new Actions(driver);
        WebElement name=driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        name.click();
        name.sendKeys("Nurullah");
        WebElement mail= driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        mail.click();
        mail.sendKeys("test16@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        driver.findElement(By.xpath("//input[@value='Mr']")).click();
        WebElement pass=driver.findElement(By.id("password"));
        pass.sendKeys("123123");
        driver.findElement(By.xpath("//select[@id='days']")).sendKeys("19");
        driver.findElement(By.xpath("//select[@id='months']")).sendKeys("May");
        driver.findElement(By.xpath("//select[@id='years']")).sendKeys("1997");
        driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
        driver.findElement(By.id("first_name")).sendKeys("Vfor");
        driver.findElement(By.id("last_name")).sendKeys("Vandetta");
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("asdas");
        driver.findElement(By.id("address1")).sendKeys("Kocaeli");
        driver.findElement(By.id("country")).sendKeys("United States");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("asda");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Kocaeli");
        driver.findElement(By.id("zipcode")).sendKeys("4564");
        driver.findElement(By.id("mobile_number")).sendKeys("054545646");
        WebElement createButton =driver.findElement(By.xpath("//button[text()='Create Account']"));
        createButton.click();
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();

        //11. Verify ' Logged in as username' at top
        WebElement kullanıcıAdı=driver.findElement(By.xpath(" //*[text()=' Logged in as ']"));
        Assert.assertTrue(kullanıcıAdı.isDisplayed());

        //12.Click 'Cart' button
        driver.findElement(By.xpath("(//*[@href='/view_cart'])[1]")).click();

        //13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();

        //14. Verify Address Details and Review Your Order
        WebElement adressDetails= driver.findElement(By.xpath("//h2[text()='Address Details']"));
        Assert.assertTrue(adressDetails.isDisplayed());

        //15. Enter description in comment text area and click 'Place Order'
        WebElement message= driver.findElement(By.xpath("//*[@name='message']"));
        message.click();
        message.sendKeys("I'm a QA tester.");
        driver.findElement(By.xpath("//a[text()='Place Order']")).click();

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@data-qa='name-on-card']")).sendKeys("adasda");
        driver.findElement(By.xpath("//input[@data-qa='card-number']")).sendKeys("564654654654");
        driver.findElement(By.xpath("//input[@data-qa='cvc']")).sendKeys("021");
        driver.findElement(By.xpath("//input[@data-qa='expiry-month']")).sendKeys("12");
        driver.findElement(By.xpath("//input[@data-qa='expiry-year']")).sendKeys("2024");

        //17. Click 'Pay and Confirm Order' button
        driver.findElement(By.id("submit")).click();

        //18. Verify success message 'Your order has been placed successfully!'
        WebElement yos= driver.findElement(By.xpath("//p[text()='Congratulations! Your order has been confirmed!']"));
        Assert.assertTrue(yos.isDisplayed());

        //19. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[text()=' Delete Account']")).click();

        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement deleted= driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        Assert.assertTrue(deleted.isDisplayed());

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
