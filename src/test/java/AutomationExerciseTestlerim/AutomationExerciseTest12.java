package AutomationExerciseTestlerim;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AutomationExerciseTest12 extends TestBase {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Click on 'Products' button
    4. Verify user is navigated to ALL PRODUCTS page successfully
    5. Click on 'View Product' button
    6. Verify 'Write Your Review' is visible
    7. Enter name, email and review
    8. Click 'Submit' button
    9. Verify success message 'Thank you for your review.'
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

        //5. Click on 'View Product' button
        driver.findElement(By.xpath("(//a[text()='View Product'])[1]")).click();

        //6. Verify 'Write Your Review' is visible
        WebElement writeYourReviewText= driver.findElement(By.xpath("//*[text()='Write Your Review']"));

        assertTrue(writeYourReviewText.isDisplayed());

        //7. Enter name, email and review
        //8. Click 'Submit' button
        Actions actions=new Actions(driver);
        WebElement name= driver.findElement(By.xpath("//input[@id='name']"));
        actions.click(name)
                .sendKeys("Nurullah")
                .sendKeys(Keys.TAB)
                .sendKeys("test299@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("Hello I'm automatin tester....")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        //9. Verify success message 'Thank you for your review.'
        WebElement message= driver.findElement(By.xpath("//*[text()='Thank you for your review.']"));

        assertTrue(message.isDisplayed());

    }
}
