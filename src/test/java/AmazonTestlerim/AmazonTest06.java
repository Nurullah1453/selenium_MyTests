package AmazonTestlerim;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class AmazonTest06 extends TestBase {

    @Test
    public void test(){

        //1.“https://www.amazon.com” adresine gidin
        driver.get("https://www.amazon.com/");
        //2.Sayfanin en altina inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        //3.Web table tum body’sini yazdirin
        WebElement tumBody= driver.findElement(By.xpath("//tbody"));


        //4.Web table’daki satir sayisinin 10 oldugunu test edin
        List<WebElement>satirlar=driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertEquals(10,satirlar.size());

        //5.Tum satirlari yazdirin
        for (WebElement eachRow:satirlar
             ) {
            System.out.println(eachRow);
        }

        //6. Web table’daki sutun sayisinin 14 olduğunu test edin
        List<WebElement>sutunlar=driver.findElements(By.xpath("//tbody/tr[1]/td"));
        Assert.assertEquals(14,sutunlar.size());

        //7. 5.sutunu yazdirin
        List<WebElement>besinciSutun=driver.findElements(By.xpath("//tbody/tr/td[5]"));
        System.out.println("=========================");
        for (WebElement eachElement:besinciSutun
             ) {
            System.out.println(eachElement.getText());
        }

        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        WebElement istenenDataElemeni = getElement(3,5);
        System.out.println(istenenDataElemeni.getText());

    }

    private WebElement getElement(int satir, int sutun) {

        String dinamikXpath="//tbody/tr["+satir+"]/td["+sutun+"]";

        WebElement istenenElement= driver.findElement(By.xpath(dinamikXpath));

        return istenenElement;
    }
}
