package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Cart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    String getUsenameDOM  = "user-name";
    String getPasswordDOM = "password";
    String getButtonLoginDOM = "login-button";

    String username = "standard_user";
    String password = "secret_sauce";
    String wrongPassword = "naziincolour123";

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


    @Given("Add Product to cart")
    public  void addRemoveProduct(){
        driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
        driver.get(baseUrl);
        String loginPageDOM = driver.findElement(By.xpath("//h2[[contains(text(),'Swag Labs'")).getText();
        Assert.assertEquals(loginPageDOM, "Swag Labs");

        driver.findElement(By.id(getUsenameDOM)).sendKeys(username);
        driver.findElement(By.id(getPasswordDOM)).sendKeys(password);

        driver.findElement(By.xpath("//button[@type='submit]")).click();



    }

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        driver.get(baseUrl);
    }

    @When("User enters username and password")
    public void userEntersUsernameAndPassword() {
        driver.findElement(By.id(getUsenameDOM)).sendKeys(username);
    }

    @And("Clicks on login button")
    public void clicksOnLoginButton() {
        driver.findElement(By.xpath("//button[@type='submit]")).click();
    }

    @And("User should be redirected to the products page")
    public void userShouldBeRedirectedToTheProductsPage() {
        driver.findElement(By.xpath("//div[contains(text(), 'product')]"));
        String productDOM = driver.findElement(By.xpath("//div[contains(text(), 'add-to-cart]/preceding-sibling::at"));
        Assert.assertEquals(productDOM, "products");
    }

    @And("user select the product")
    public void userSelectTheProduct() {
        for( int i =0; i< cartLength; i++){
            WebElement cartButton = driver.findElement(By.id(getCartDButtonDOM[i]));

            cartButton.click();
        }
    }

    @Then("Cart should contain the added product")
    public void cartShouldContainTheAddedProduct() {
        driver.findElement(By.xpath("//div[contains(text(), 'shopping_cart_link')]"));
        String nazi = driver.findElement(By.xpath("//div[contains(text(), 'shopping_cart_link]/preceding-sibling::at"));
        Assert.assertEquals(nazi, "products");
    }

    @And("The user click remove button")
    public void theUserClickRemoveButton() {
        for( int i =0; i< removeCartLength; i++){
            WebElement removeCartButton = driver.findElement(By.id(removeCartDOM[i]));

            removeCartButton.click();
        }
    }

    @Then("Cart should not contain the removed product")
    public void cartShouldNotContainTheRemovedProduct() {
        driver.findElement(By.xpath("//div[contains(text(), 'shopping_cart_link')]"));
        String nazi = driver.findElement(By.xpath("//div[contains(text(), 'shopping_cart_link]/preceding-sibling::at"));
        Assert.assertEquals(nazi, "products");

    }
}
