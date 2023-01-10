package AutomationExerciseTestlerim;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AutomationExerciseTest11 extends TestBase {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Click on 'Products' button
    4. Verify user is navigated to ALL PRODUCTS page successfully
    5. Enter product name in search input and click search button
    6. Verify 'SEARCHED PRODUCTS' is visible
    7. Verify all the products related to search are visible
    8. Add those products to cart
    9. Click 'Cart' button and verify that products are visible in cart
    10. Click 'Signup / Login' button and submit login details
    11. Again, go to Cart page
    12. Verify that those products are visible in cart after login as well
     */

    @Test
    public void test(){

        //2. Navigate to url 'http://automationexercise.com'
       driver.navigate().to("http://automationexercise.com");

       //3. Click on 'Products' button
       driver.findElement(By.xpath("//*[@class='material-icons card_travel']")).click();

       //4. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allPro= driver.findElement(By.xpath("//h2[text()='All Products']"));
        String actualYazı= allPro.getText();
        String expectedYazı="ALL PRODUCTS";

        assertEquals(actualYazı,expectedYazı);

        //5. Enter product name in search input and click search button
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='search_product']"));
        Actions actions=new Actions(driver);
        actions.sendKeys(aramaKutusu,"Blue Top").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        ReusableMethod.bekle(2);

        //6. Verify 'SEARCHED PRODUCTS' is visible
        //7. Verify all the products related to search are visible
        WebElement siparis= driver.findElement(By.xpath("//div[@class='features_items']"));
        assertTrue(siparis.isDisplayed());

        //8. Add those products to cart
        driver.findElement(By.xpath("(//a[text()='Add to cart'])[1]")).click();
        ReusableMethod.bekle(3);

        //9. Click 'Cart' button and verify that products are visible in cart
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();

        WebElement proceedCard= driver.findElement(By.xpath("//*[text()='Proceed To Checkout']"));

        assertTrue(proceedCard.isDisplayed());

        //10. Click 'Signup / Login' button and submit login details
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        WebElement name= driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
        actions.click(name).sendKeys("nurullah").sendKeys(Keys.TAB).sendKeys("testerQAnuru@gmail.com")
                        .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        ReusableMethod.bekle(2);

        driver.findElement(By.id("id_gender1")).click();
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("123123")
                .sendKeys(Keys.TAB)
                .sendKeys("11")
                .sendKeys(Keys.TAB)
                .sendKeys("June")
                .sendKeys(Keys.TAB)
                .sendKeys("1997")
                .sendKeys(Keys.TAB)
                .click()
                .sendKeys(Keys.TAB)
                .click()
                .sendKeys(Keys.TAB)
                .sendKeys("Nurullah")
                .sendKeys(Keys.TAB)
                .sendKeys("Test")
                .sendKeys(Keys.TAB)
                .sendKeys("WiseQuarter")
                .sendKeys(Keys.TAB)
                .sendKeys("Türkiye")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("United States")
                .sendKeys(Keys.TAB)
                .sendKeys("Test")
                .sendKeys(Keys.TAB)
                .sendKeys("Kocaeli")
                .sendKeys(Keys.TAB)
                .sendKeys("414141")
                .sendKeys(Keys.TAB)
                .sendKeys("555546464")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        // 11. Again, go to Cart page
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();

        //12. Verify that those products are visible in cart after login as well
        WebElement urun= driver.findElement(By.xpath("//*[text()='Blue Top']"));
        assertTrue(urun.isDisplayed());

        ReusableMethod.bekle(3);
    }
}
