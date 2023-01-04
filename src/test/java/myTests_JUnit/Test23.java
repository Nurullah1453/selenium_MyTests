package myTests_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;
import utilities.TestBase;

public class Test23 extends TestBase {

     /*
    1- https://demoqa.com/droppable adresine gidelim
    2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
     */

    @Test
    public void test(){

        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        // 2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions=new Actions(driver);

        WebElement dragMe= driver.findElement(By.xpath("//div[text()='Drag me']"));
        WebElement dropMe= driver.findElement(By.xpath("(//p[text()='Drop here'])[1]"));

        actions.dragAndDrop(dragMe,dropMe).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String actualYazı=driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
        String expectedYazı="Dropped!";

        Assert.assertEquals(actualYazı,expectedYazı);

        ReusableMethod.bekle(3);
    }
}
