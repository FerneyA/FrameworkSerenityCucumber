package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class BasePage extends PageObject {

    private WebDriver driver;
    By spinCCLA = By.className(".ant-spin");

    public BasePage() {
        this.driver = super.getDriver();
    }

    public void visit(String url) {
        driver.get(url);
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public String getText(WebElement webElement) {
        return webElement.getText();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }

    public void typeWithTab(String inputText, By locator) throws InterruptedException {
        WebElement webElement = driver.findElement(locator);
        webElement.clear();
        int lengthValue = webElement.getAttribute("value").toCharArray().length;
        for (int i = 0; i < lengthValue; i++) {
            webElement.sendKeys(Keys.BACK_SPACE);
        }
        webElement.sendKeys(inputText);
        Thread.sleep(2000);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public WebElement fluentWait(final By locator) {
        // Waiting 50 seconds for an element to be present on the page, checking
        // for its presence once every 5 seconds.
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        return wait.until(driver -> driver.findElement(locator));
    }

    public void webDriverWait(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement explicitWaitVisibilityOfElement(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement explicitWaitElementToBeClickable(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public Boolean explicitWaitTextToBePresentInElement(By locator, String text) {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public void waitInvisibilityOfSpin() {
        try {
            WebElement spin = findElement(spinCCLA);
            while (spin.isDisplayed()) {
                waitInvisibilityOfSpin();
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            e.getMessage();
        }
    }

    public void performScrollDown(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement webElement = driver.findElement(locator);
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void performScrollDownBottomPage() {
        JavascriptExecutor js = (JavascriptExecutor) super.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void selectOptionDown(By locator, String searchText) {
        WebElement webElement = driver.findElement(locator);
        webElement.click();
        List<WebElement> options = webElement.findElements(By.tagName("li"));
        for (WebElement option : options)
        {
            if (option.getText().equals(searchText))
            {
                option.sendKeys(Keys.ENTER);
                break;
            }
        }
    }

    public void selectOptionDropDown(By locator, String value) throws InterruptedException {
        WebElement dropDown = driver.findElement(locator);
        explicitWaitElementToBeClickable(locator);
        dropDown.click();
        Thread.sleep(2000);
        dropDown.findElement(By.xpath("//ul[contains(@class, 'ant-select-dropdown-menu')]/li[text()='" + value + "']")).click();
    }

    public void actionsClick(By locator) {
        WebElement webElement = findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().build().perform();
    }

    public void uploadFile(By locator, String path) throws AWTException {
        driver.findElement(locator).sendKeys(path);
        Robot rb = new Robot();
        StringSelection str = new StringSelection(System.getProperty("user.dir") + "\\test-data\\document_id\\" + path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        // release Contol+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }
}
