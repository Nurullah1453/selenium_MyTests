package day04_seleniumPractice;

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

public class Test18 {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that categories are visible on left side bar
    4. Click on 'Women' category
    5. Click on any category link under 'Women' category, for example: Dress
    6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
    7. On left side bar, click on any sub-category link of 'Men' category
    8. Verify that user is navigated to that category page
     */
    WebDriver driver;

    @Before
    public void setUp(){
        // 1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that categories are visible on left side bar
        WebElement categories= driver.findElement(By.xpath("//h2[text()='Category']"));
        Assert.assertTrue(categories.isDisplayed());

        //4. Click on 'Women' category
        WebElement womenButon= driver.findElement(By.xpath("(//*[@class='badge pull-right'])[1]"));
        womenButon.click();


        //5. Click on any category link under 'Women' category, for example: Dress
        WebElement dress= driver.findElement(By.xpath("(//*[text()='Dress '])[1]"));
        dress.click();

        //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        WebElement womenDress=driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(womenDress.isDisplayed());
        Thread.sleep(3000);

        //7. On left side bar, click on any sub-category link of 'Men' category
        WebElement menButon= driver.findElement(By.xpath("(//*[@class='badge pull-right'])[2]"));
        menButon.click();
        driver.findElement(By.xpath("//*[text()='Tshirts ']")).click();

        //8. Verify that user is navigated to that category page
        WebElement manCategory= driver.findElement(By.xpath("//*[text()='Men - Tshirts Products']"));
        Assert.assertTrue(manCategory.isDisplayed());

    }
}
