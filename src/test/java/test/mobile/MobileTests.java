package test.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.mobile.WikipediaPage;
import java.net.MalformedURLException;
import java.net.URL;

public class MobileTests {
    private AndroidDriver driver;
    private WikipediaPage wikiPage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("39271FDJH009MB");
        options.setAppPackage("org.wikipedia.alpha");
        options.setAppActivity("org.wikipedia.main.MainActivity");
        options.setAutomationName("UiAutomator2");
        options.setNoReset(true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        wikiPage = new WikipediaPage(driver);
    }

    @Test
    public void testWikipediaSearchAndScroll() {
        wikiPage.openSearch();
        wikiPage.enterSearchQuery("Appium");
        wikiPage.clickFirstResult();
        wikiPage.scrollDown();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}