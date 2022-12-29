package myTests;

import org.junit.*;

public class Test09 {
    int p1=60;
    int p2=66;
    int p3=70;
    //Emekli yaşı 65 olduguna göre
    //P2 2'nin emekli olabileceğini test edin
    //p1'in emekli olamayacagını test edelim
    //p3'ün emekli olamayacagını test edelim

    @Test
    public void test01(){
        //P2 2'nin emekli olabileceğini test edin
        Assert.assertTrue(p2>=65);
    }
    @Test
    public void test02(){
        //p1'in emekli olamayacagını test edelim
        Assert.assertFalse(p1>=65);
    }
    @Test
    public void test03(){
        //p3'ün emekli olamayacagını test edelim
        Assert.assertFalse("Girilen Yas 65'den küçük olmadıgından emekli olabilir",p3>65);
    }
}
