package myTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test34 extends TestBase {

    @Test
    public void test(){

        //https://the-internet.herokuapp.com/upload adresine gidin
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalım
        //Yüklemek istediğimiz dosyayı seçelim

        /*
        Bu görevi yapabilmek için chooseFile butonuna basıldıgında açılan bilgisayarımızdaki file
        dosyalarını click yapabilmemiz gerekir. Ancak selenium bilgisayarımızdaki dosyaları click yapamaz
        Bunun yerine şöyle bir çözüm üretilmiştir.
        1.Adım: chooseFile butonunu locate yapalım
        2.Adım: Upload edilecek dosyanın dosya yolunu oluşturun
        3.Adım: chooseFile butonuna sendKeys ile dosya yolunu gönderin
         */

        WebElement chooseFileButton=driver.findElement(By.id("file-upload"));

        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\MerhabaJava.docx";

        chooseFileButton.sendKeys(dosyaYolu);


        //Upload butonuna basalım
        driver.findElement(By.id("file-submit")).click();


        //"File Upload!" textinin göründüğünü test edelim
        WebElement actualText= driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        Assert.assertTrue(actualText.isDisplayed());
    }
}
