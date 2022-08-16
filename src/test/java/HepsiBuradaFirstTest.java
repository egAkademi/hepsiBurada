
import org.testng.annotations.Test;

public class HepsiBuradaFirstTest extends Common{

    FirstPage firstPage;
    SecondPage secondPage;
    ThirdPage thirdPage;

    @Test
    public void hepsiBuradaFirsttest() throws InterruptedException {
        firstPage=new FirstPage(driver);
        secondPage=new SecondPage(driver);
        thirdPage = new ThirdPage(driver);

        firstPage.openHepsiBuradaWebSitesi();
        firstPage.urunAra("Bilgisayar");
        firstPage.siralamaOlcutuSec();

        secondPage.urunSec();
        secondPage.sekmeDegistirveSepeteEkle();
        secondPage.anaSekmeyeGec();
        secondPage.ekranYenile("browser");

        thirdPage.sepeteGit();
        thirdPage.urunSil();
        //todo
    }
}
