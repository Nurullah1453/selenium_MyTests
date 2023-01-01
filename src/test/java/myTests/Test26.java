package myTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;
import utilities.TestBase;

public class Test26 extends TestBase {
    @Test
    public void test() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");


        //3. Click on 'Products' button
        driver.findElement(By.xpath("//*[@class='material-icons card_travel']")).click();

        ReusableMethod.bekle(5);

        //4. Verify that Brands are visible on left side bar
        WebElement brands= driver.findElement(By.xpath("//h2[text()='Brands']"));
        Assert.assertTrue(brands.isDisplayed());
        ReusableMethod.bekle(3);

        //5. Click on any brand name
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);
        ReusableMethod.bekle(3);
        WebElement madame= driver.findElement(By.xpath("//a[text()='Madame']"));
        madame.click();
        ReusableMethod.bekle(3);

        //6. Verify that user is navigated to brand page and brand products are displayed
        String actualTitle = driver.getTitle();
        String expectedKelime="Madame";

        Assert.assertTrue(actualTitle.contains(expectedKelime));


        //7. On left side bar, click on any other brand link
        WebElement baby= driver.findElement(By.xpath("//a[text()='Babyhug']"));
        baby.click();


        //8. Verify that user is navigated to that brand page and can see products
        String actualBaby=driver.getTitle();
        String expectedBaby="Babyhug";

        Assert.assertTrue(actualBaby.contains(expectedBaby));

    }
}
