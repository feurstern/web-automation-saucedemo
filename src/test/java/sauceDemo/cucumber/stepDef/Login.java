package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    String getUsenameDOM  = "user-name";
    String getPasswordDOM = "password";
    String getButtonLoginDOM = "login-button";

    String username = "standard_user";
    String password = "secret_sauce";
    String wrongPassword = "naziincolour123";

    @Given("Open the URL")
    public void succesLoginCase(){
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


    @Given("open the url")
    public void openTheUrl() {
        driver.get(baseUrl);
    }

    @When("Input Username")
    public void inputUsername() {
        driver.findElement(By.id(getUsenameDOM)).sendKeys(username);

    }

    @And("Input Password")
    public void inputPassword() {
        driver.findElement(By.id(getPasswordDOM)).sendKeys(password);
    }

    @And("click login button")
    public void clickLoginButton() {
        driver.findElement(By.xpath("//button[@type='submit]")).click();
    }

    @Then("Redirected to Dashboard")
    public void redirectedToDashboard() {
        driver.findElement(By.xpath("//div[contains(text(), 'product')]"));
         String nazi = driver.findElement(By.xpath("//div[contains(text(), 'product]/preceding-sibling::at"));
        Assert.assertEquals(nazi, "products");

    }

    @When("Input invalid Username")
    public void inputInvalidUsername() {
        driver.findElement(By.id(getUsenameDOM)).sendKeys(username);
    }

    @And("Input invalid Password")
    public void inputInvalidPassword() {
        driver.findElement(By.id(getPasswordDOM)).sendKeys(wrongPassword);
    }

    @Then("get error messsage")
    public void getErrorMesssage() {
    }
}
