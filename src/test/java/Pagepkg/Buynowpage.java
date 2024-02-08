package Pagepkg;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Buynowpage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"add-to-cart-form\"]/div[4]/div[2]/div/div/div/button[1]")
    private WebElement checkoutButton;

    public Buynowpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void clickCheckout() {
        try {
            WebElement checkoutButtonElement = wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));

            // Scroll to the element before clicking it
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",checkoutButtonElement);

            // Click the Checkout button
            checkoutButtonElement.click();
        } catch (Exception e) {
            // Handle any exceptions related to clicking, if needed
            e.printStackTrace();
        }
    }

    // Add more methods for interacting with elements on the Buy Now page as needed

    public void completeBuyNowFlow() {
        clickCheckout();
        // Add additional steps for the Buy Now flow if needed
    }
}

