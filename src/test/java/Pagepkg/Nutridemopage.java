package Pagepkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Nutridemopage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@id='customer_login_link']/span")
    WebElement signinbutton;

    @FindBy(xpath = "//*[@id=\"dropdown-customer\"]/div[2]/div/form/div[1]/div[3]/input")
    WebElement Login;

    @FindBy(xpath = "//*[@id=\"dropdown-customer\"]/div[2]/div/form/div[2]/a")
    WebElement createaccount;

    @FindBy(xpath = "//*[@id=\"first_name\"]")
    WebElement fname;

    @FindBy(xpath = "//*[@id=\"last_name\"]")
    WebElement lname;
    
    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement emilid;
    
    @FindBy(xpath ="//*[@id=\"create_password\"]")
    WebElement pwd;

    @FindBy(xpath = "//*[@id=\"create_customer\"]/div[5]/input")
    WebElement submit;

    public Nutridemopage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void signin() {
        signinbutton.click();
    }


    public void setValues(String email, String password) {
        // Explicitly wait for the Sign In button
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(signinbutton));
        signInButton.click();

        // Explicitly wait for the email input field
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dropdown-customer\"]/div[2]/div/form/div[1]/div[1]/input")));
        emailInput.sendKeys(email);

        // Explicitly wait for the password input field
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dropdown-customer\"]/div[2]/div/form/div[1]/div[2]/input")));
        passwordInput.sendKeys(password);

        // Explicitly wait for the Submit button and click
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dropdown-customer\"]/div[2]/div/form/div[1]/div[3]/input")));
        submitButton.click();

        // Rest of your code
    }



    public void newuser() {
        createaccount.click();
        fname.sendKeys("Athi");
        lname.sendKeys("Raj");
        emilid.sendKeys("kathira554@gmail.com");
        pwd.sendKeys("tiBzm98QSnTimYx");
        submit.click();
        driver.navigate().back();
    }

    public void login() {
        Login.click();
        driver.navigate().back();
    }
}

