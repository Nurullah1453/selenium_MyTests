package myTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;
import utilities.TestBase;

public class Test30 extends TestBase {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Scroll to bottom of page
    4. Verify 'RECOMMENDED ITEMS' are visible
    5. Click on 'Add To Cart' on Recommended product
    6. Click on 'View Cart' button
    7. Verify that product is displayed in cart page
     */

    @Test
    public void test(){

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Scroll to bottom of page
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        //4. Verify 'RECOMMENDED ITEMS' are visible
       WebElement recommed=driver.findElement(By.xpath("//h2[text()='recommended items']"));

        Assert.assertTrue(recommed.isDisplayed());

        //5. Click on 'Add To Cart' on Recommended product
        driver.findElement(By.xpath("(//a[@data-product-id='2'])[1]")).click();
        ReusableMethod.bekle(2);

        //6. Click on 'View Cart' button
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();

        //7. Verify that product is displayed in cart page
        String actualUrl = driver.getCurrentUrl();
        String expectedKelime="view_cart";

        Assert.assertTrue(actualUrl.contains(expectedKelime));
    }
}
