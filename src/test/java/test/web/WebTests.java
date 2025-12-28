package test.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.web.BookPage;

public class WebTests {
    WebDriver driver;
    BookPage bookPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        bookPage = new BookPage(driver);
    }

    @Test(priority = 1)
    public void testMainPageTitle() {
        bookPage.open();
        Assert.assertTrue(bookPage.isTitleCorrect("Quotes"), "Заголовок неверный!");
    }

    @Test(priority = 2)
    public void testTagNavigation() {
        bookPage.clickTag();
        Assert.assertTrue(driver.getCurrentUrl().contains("/tag/love"));
    }

    @Test(priority = 3)
    public void testLoginPath() {
        bookPage.clickLogin();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test(priority = 4)
    public void testReturnToHome() {
        bookPage.clickLogo();
        Assert.assertEquals(driver.getCurrentUrl(), "https://quotes.toscrape.com/");
    }

    @Test(priority = 5)
    public void testPagination() {
        bookPage.open();
        bookPage.clickNext();
        Assert.assertTrue(driver.getCurrentUrl().contains("page/2/"));
    }

    @Test(priority = 6)
    public void testQuoteIsPresent() {
        bookPage.open();
        Assert.assertFalse(bookPage.getFirstQuote().isEmpty(), "Цитата не загрузилась!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}