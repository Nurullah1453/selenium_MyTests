package myTests_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;
import utilities.TestBase;

public class Test24 extends TestBase {

       /*
    1- https://www.amazon.com/ adresine gidin
    2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
    3- “Create a list” butonuna basin
    4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
     */

    @Test
    public void test(){

        // 1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // 2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions=new Actions(driver);

        WebElement accountList= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        actions.moveToElement(accountList).perform();
        ReusableMethod.bekle(1);

        //3- “Create a list” butonuna basin
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();
        ReusableMethod.bekle(1);

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        WebElement yourList= driver.findElement(By.xpath("//div[@role='heading']"));
        String actualYazı=yourList.getText();
        String expectedYazı="Your Lists";

        Assert.assertEquals(actualYazı,expectedYazı);

        ReusableMethod.bekle(3);

    }
}
