package day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GoogleTest {
    String https="https://www.";
    public WebDriver driver;
    // ilgili kurulumlari tamamlayalim
    // Kullanici https://www.google.com adresine gider
    // Kullanici cookies i kabul eder
    // Arama Kutusuna karsilastirma yapmak istedigi para birimlerini girer
    // Para birimlerinin karsilastirmasini alir
    // Karsilastirilacak olan para biriminin 1.5 den kucuk oldugu test edilir

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @Test
    public void googlerTest() throws InterruptedException {
        driver.get(https+"google.com");
        // cookies
        driver.findElement(By.xpath("//div[text()='Alle akzeptieren']")).click();

        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@class='gLFyf']"));

        aramaKutusu.sendKeys("euro vs dollar"+ Keys.ENTER);

        Thread.sleep(2000);

        String  sonucYazisi=driver.findElement(By.xpath("//span[@class='DFlfde SwHCTb']")).getText();


       double actualsonucYaz =Double.parseDouble(sonucYazisi);
       double expectedSonuc=1.5;

        Assert.assertTrue(actualsonucYaz<expectedSonuc);

    }

    @After
    public void tearDown(){
        driver.close();
    }

}
