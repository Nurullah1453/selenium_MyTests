package myTests_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;
import utilities.TestBase;

public class Test27 extends TestBase {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Contact Us' button
    5. Verify 'GET IN TOUCH' is visible
    6. Enter name, email, subject and message
    7. Upload file
    8. Click 'Submit' button
    9. Click OK button
    10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    11. Click 'Home' button and verify that landed to home page successfully
     */

    @Test
    public void test(){

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="https://automationexercise.com/";

        Assert.assertEquals(actualUrl,expectedUrl);

        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[text()=' Contact us']")).click();

        //5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouch= driver.findElement(By.xpath("//h2[text()='Get In Touch']"));

        Assert.assertTrue(getInTouch.isDisplayed());

        //6. Enter name, email, subject and message
        Actions actions=new Actions(driver);
        WebElement name=driver.findElement(By.xpath("//input[@name='name']"));
        actions.click(name)
                .sendKeys("Nurullah")
                .sendKeys(Keys.TAB)
                .sendKeys("test27@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("Otomasyon")
                .sendKeys(Keys.TAB)
                .sendKeys("Test Yapıyorum").perform();



        //7. Upload file
        WebElement dosyaSecButonu= driver.findElement(By.xpath("//input[@name='upload_file']"));

        String dosyaYolu = System.getProperty("user.home")+"\\Desktop\\Yeni Metin Belgesi.txt";

        dosyaSecButonu.sendKeys(dosyaYolu);

        // 8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@data-qa='submit-button']")).click();

        //9. Click OK button
        driver.switchTo().alert().accept();

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        String actualYazı=driver.findElement(By.xpath("(//div[text()='Success! Your details have been submitted successfully.'])[1]")).getText();
        String expectedYazı="Success! Your details have been submitted successfully.";

        Assert.assertEquals(actualYazı,expectedYazı);

        ReusableMethod.bekle(3);

        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//a[text()=' Home']")).click();

        ReusableMethod.bekle(3);

        String actualHomePageBaslık=driver.findElement(By.tagName("h2")).getText();
        String expectedHomePage="Full-Fledged practice website for Automation Engineers";

        Assert.assertTrue(actualHomePageBaslık.contains(expectedHomePage));
    }
}
