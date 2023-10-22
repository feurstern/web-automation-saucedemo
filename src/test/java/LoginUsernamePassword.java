import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginUsernamePassword {
    @Test
    public void testValidationLogin(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        String getUsenameDOM  = "user-name";
        String getPasswordDOM = "password";
        String getButtonLoginDOM = "login-button";

        String username = "standard_user";
        String password = "secret_sauce";

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(baseUrl);

        WebElement usernameField = driver.findElement(By.id(getUsenameDOM));
        WebElement passwordField = driver.findElement(By.id(getPasswordDOM));
        WebElement loginButton = driver.findElement(By.id(getButtonLoginDOM));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        loginButton.click();

        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

    }

}
