import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Login {
    @Test
   public void  testOpenBrowser(){
// try t0 get the dependecies

        WebDriver driver;
        String baseUrl  = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();
//        ChromeOptions opt = new ChromeOptions();
//        try
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // get the url
        driver.get(baseUrl);
    }

}
