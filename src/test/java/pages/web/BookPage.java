package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BookPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Локаторы
    private By loginLink = By.linkText("Login");
    private By tagLink = By.linkText("love");
    private By logo = By.cssSelector("h1 a");
    private By nextButton = By.cssSelector(".next a");
    private By firstQuoteText = By.className("text");

    public BookPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://quotes.toscrape.com/");
    }

    public void clickTag() {
        wait.until(ExpectedConditions.elementToBeClickable(tagLink)).click();
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }

    public void clickLogo() {
        wait.until(ExpectedConditions.elementToBeClickable(logo)).click();
    }

    public void clickNext() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    public String getFirstQuote() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstQuoteText)).getText();
    }

    public boolean isTitleCorrect(String expected) {
        return driver.getTitle().contains(expected);
    }
}