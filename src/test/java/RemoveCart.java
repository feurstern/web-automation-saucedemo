import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RemoveCart {
    @Test
    public void  addRandomCart(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";


        String getUsernameDOM  = "user-name";
        String getPasswordDOM = "password";
        String getButtonLoginDOM = "login-button";
        String[] getCartDButtonDOM = {
                "add-to-cart-sauce-labs-backpack",
                "add-to-cart-sauce-labs-bolt-t-shirt",
                "add-to-cart-sauce-labs-onesie",
        };
        String[] removeCartDOM = {
                "remove-sauce-labs-backpack",
                "remove-sauce-labs-bolt-t-shirt",
                "remove-sauce-labs-onesie"
        };

        int cartLength = getCartDButtonDOM.length;
        int removeCartLength = removeCartDOM.length;

        String username = "standard_user";
        String password = "secret_sauce";


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(baseUrl);

        WebElement usernameField = driver.findElement(By.id(getUsernameDOM));
        WebElement passwordField = driver.findElement(By.id(getPasswordDOM));
        WebElement loginButton = driver.findElement(By.id(getButtonLoginDOM));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        loginButton.click();
        for( int i =0; i< cartLength; i++){
            WebElement cartButton = driver.findElement(By.id(getCartDButtonDOM[i]));

            cartButton.click();
        }

        for( int i =0; i< removeCartLength; i++){
            WebElement removeCartButton = driver.findElement(By.id(removeCartDOM[i]));

            removeCartButton.click();
        }


        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }


    }

}
