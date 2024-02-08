package Pagepkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Signoutpage {
    WebDriver driver;

    //@FindBy(xpath="//*[@id=\"customer_logout_link\"]/span")
   // WebElement signout;

    public Signoutpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    


    public void signout() {
        try { WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"customer_logout_link\"]/span")));
        WebElement signout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='customer_logout_link']/span")));
            signout.click();

           
        } catch (Exception e) {
            // Handle exceptions, print error messages, or log them
            System.out.println("Error during signout: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
