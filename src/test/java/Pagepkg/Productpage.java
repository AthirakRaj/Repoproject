package Pagepkg;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Productpage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//nav/ul/li[5]/a/span[1]/b")
    private WebElement categories;

    @FindBy(xpath = "//*[@id='section-16340344685e233710']/div/div[2]/div/div/div/div[2]/div/div/div[1]/div[1]/a/span/img")
    private WebElement item;

    @FindBy(xpath = "//*[@id='product-add-to-cart']")
    private WebElement addCart;

    public Productpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void navigateToCategories() {
        // Navigate forward to the categories
        driver.navigate().forward();
        // Click on categories
        categories.click();
    }

    public void clickAllGiftItems() {
        // Click on categories
        categories.click();
    }

    public void product() {
        try {
            // Wait for the item element to be present
            WebElement itemElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='section-16340344685e233710']/div/div[2]/div/div/div/div[2]/div/div/div[1]/div[1]/a/span/img")));

            // Click the item
            itemElement.click();
        } catch (Exception e) {
            // Handle the case where the element is not found
            e.printStackTrace();
        }
    }

    public void addToCart() {
        // Add to cart
        addCart.click();
    }

    public void buyCart() {
        WebElement buyButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"product-add-to-cart\"]")));

        // Scroll to the element before clicking it
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buyButton);

        try {
            // Click the element
            buyButton.click();
        } catch (Exception e) {
            // Handle any exceptions related to clicking, if needed
            e.printStackTrace();
        }
    }

    public void navigateBack() {
        // Navigate back again
        driver.navigate().back();
    }
    public void completeShoppingFlow() throws InterruptedException {
        navigateToCategories();
        clickAllGiftItems();
        product();
        addToCart();
        buyCart();
        navigateBack();
    }

  
}