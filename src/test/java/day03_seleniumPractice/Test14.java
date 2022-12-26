package day03_seleniumPractice;

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

public class Test14 {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Products' button
    5. Verify user is navigated to ALL PRODUCTS page successfully
    6. The products list is visible
    7. Click on 'View Product' of first product
    8. User is landed to product detail page
    9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        // 1. Launch browser
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
        WebElement homePage= driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Products' button
        WebElement productsButton= driver.findElement(By.xpath("//i[@style='font-size: 16px;']"));
        productsButton.click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        //6. The products list is visible
        WebElement allProductPate= driver.findElement(By.xpath("//h2[text()='All Products']"));
        Assert.assertTrue(allProductPate.isDisplayed());

        //7. Click on 'View Product' of first product
        WebElement firstProduct= driver.findElement(By.xpath("(//a[text()='View Product'])[1]"));
        firstProduct.click();

        //8. User is landed to product detail page
        String actualKelime= driver.getCurrentUrl();
        String expectedKelime="product_details";
        Assert.assertTrue(actualKelime.contains(expectedKelime));


        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        WebElement productName= driver.findElement(By.xpath("//h2[text()='Blue Top']"));
        Assert.assertTrue(productName.isDisplayed());
        WebElement category= driver.findElement(By.xpath("//*[text()='Category: Women > Tops']"));
        Assert.assertTrue(category.isDisplayed());
        WebElement price= driver.findElement(By.xpath("//*[text()='Rs. 500']"));
        Assert.assertTrue(price.isDisplayed());
        WebElement availability= driver.findElement(By.xpath("//*[text()='Availability:']"));
        Assert.assertTrue(availability.isDisplayed());
        WebElement condition= driver.findElement(By.xpath("//*[text()='Condition:']"));
        Assert.assertTrue(condition.isDisplayed());
        WebElement brand= driver.findElement(By.xpath("//*[text()='Brand:']"));
        Assert.assertTrue(brand.isDisplayed());

    }
}
