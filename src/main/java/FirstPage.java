import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class FirstPage extends BasePage {

    public static final By textSearch = By.cssSelector("[type='text']");
    public static final By btnAra = By.cssSelector("[class='SearchBoxOld-buttonContainer']");
    public static final By checkboxCokDegerlendirilenler=By.xpath("//*[@id=\"SortingBox\"]/div/div/div/div/div[2]/div/div[1]/a[4]/label");
    public static final By siralama =By.id("SortingBox");

    public FirstPage(WebDriver driver){
        super(driver);
    }

    public FirstPage openHepsiBuradaWebSitesi(){
        driver.get("https://www.hepsiburada.com/ ");
        log.info("hepsi burada web sitesi açılır");
        return this;
    }

    public FirstPage urunAra(String urun) {
        String expectedTitle = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle,"hata");
        log.info("sayfa kontrolü yapılır");

        sendKey(textSearch,urun);
        log.info(urun + "araması yapılır");

        click(btnAra);
        log.info("ara butonu tıklanır");
        return this;
    }

    public FirstPage siralamaOlcutuSec() throws InterruptedException {
        FluentWait waitFluent = new FluentWait(driver);
        waitFluent.withTimeout(5000, TimeUnit.MILLISECONDS);
        waitFluent.pollingEvery(1000,TimeUnit.MILLISECONDS);
        waitFluent.ignoring(NoSuchElementException.class);
        waitFluent.until(ExpectedConditions.elementToBeClickable(siralama));

        //Thread.sleep(2000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SortingBox")));
        //wait.until(ExpectedConditions.elementToBeClickable(By.id("SortingBox")));

        click(siralama);
        click(checkboxCokDegerlendirilenler);
        log.info("sıralama ölçütü olarak Çok değerlendirilenler seçilir");

        String expectedTitle = "Bilgisayar - Hepsiburada";
        String actualTitle= driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle,actualTitle,"hata");
        log.info("sayfa kontrolü yapılır");
        return this;
    }
}
