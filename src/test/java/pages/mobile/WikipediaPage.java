package pages.mobile;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WikipediaPage extends MobilePage {

    private final By searchContainer = By.id("org.wikipedia.alpha:id/search_container");
    private final By searchInput = By.id("org.wikipedia.alpha:id/search_src_text");

    public WikipediaPage(AndroidDriver driver) {
        super(driver);
    }

    public void openSearch() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(searchContainer)).click();
        } catch (Exception e) {
            System.out.println("Элемент не найден, кликаю в зону поиска...");
            tapAt(400, 220);
            try { Thread.sleep(1500); } catch (InterruptedException ignored) {}
        }
    }

    public void enterSearchQuery(String query) {
        typeText(searchInput, query);
    }

    public void clickFirstResult() {
        tapAt(540, 550);
    }
}