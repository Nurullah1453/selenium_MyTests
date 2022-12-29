package myTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Test15 {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'Products' button
    5. Hover over first product and click 'Add to cart'
    6. Click 'Continue Shopping' button
    7. Hover over second product and click 'Add to cart'
    8. Click 'View Cart' button
    9. Verify both products are added to Cart
    10. Verify their prices, quantity and total price
     */

    WebDriver driver;

    @Before
    public void setUp(){
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        Actions acc=new Actions(driver);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        String expectedKelime="Automation Exercise";
        String actualKelime= driver.getTitle();
        Assert.assertTrue(actualKelime.equals(expectedKelime));
        //4. Click 'Products' button
        WebElement productsButton= driver.findElement(By.xpath("//a[@style='color: orange;']"));
        productsButton.click();
        //5. Hover over first product and click 'Add to cart'
        WebElement firstProduct= driver.findElement(By.xpath("(//img[@alt='ecommerce website products'])[1]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(firstProduct);
        WebElement addToCard= driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]"));
        addToCard.click();
        // 6. Click 'Continue Shopping' button
        WebElement continueShop=driver.findElement(By.xpath("//*[text()='Continue Shopping']"));
        continueShop.click();
        //7. Hover over second product and click 'Add to cart'
        WebElement secondProduct= driver.findElement(By.xpath("(//img[@alt='ecommerce website products'])[2]"));
        Actions actions1=new Actions(driver);
        actions1.moveToElement(secondProduct);
        WebElement addToCard2= driver.findElement(By.xpath("//a[@data-product-id='2']"));
        addToCard2.click();
        //8. Click 'View Cart' button
        WebElement viewCart= driver.findElement(By.xpath("//*[text()='View Cart']"));
        viewCart.click();
        //9. Verify both products are added to Cart
        WebElement frst= driver.findElement(By.xpath("//*[text()='Blue Top']"));
        Assert.assertTrue(frst.isDisplayed());
        WebElement scnd=driver.findElement(By.xpath("//*[text()='Men Tshirt']"));
        Assert.assertTrue(scnd.isDisplayed());
        //10. Verify their prices, quantity and total price
        WebElement prices=driver.findElement(By.xpath("//*[@class='price']"));
        Assert.assertTrue(prices.isDisplayed());
        WebElement quantity= driver.findElement(By.xpath("//*[@class='quantity']"));
        Assert.assertTrue(quantity.isDisplayed());
        WebElement total= driver.findElement(By.xpath("//*[@class='total']"));
        Assert.assertTrue(total.isDisplayed());
        Thread.sleep(3000);
    }
}
