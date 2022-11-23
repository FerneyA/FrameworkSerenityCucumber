package main.java.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class BasePage {

    private WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
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

    public void typeWithTab(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
        driver.findElement(locator).sendKeys(Keys.TAB);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void clearTextField(By locator) {
        driver.findElement(locator).clear();
    }

    public WebElement fluentWait(final By locator) {
        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 5 seconds.
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        WebElement webElement = wait.until(driver -> driver.findElement(locator));
        return webElement;
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

    public void performScrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    public void selectDropDown(By locator) {
        WebElement webElement = driver.findElement(locator);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", webElement);
    }

    public void selectOptionDown(By locator, String searchText) {
        WebElement webElement = driver.findElement(locator);
        webElement.click();
        List<WebElement> options = webElement.findElements(By.tagName("li"));
        for (WebElement option : options)
        {
            if (option.getText().equals(searchText))
            {
                option.click();
                break;
            }
        }
    }

    public void selectDropDown3(By locator, String value) throws InterruptedException {
        WebElement dropDown = driver.findElement(locator);
        dropDown.click();
        dropDown.findElement(By.xpath("//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']/li[text()='" + value + "']")).click();
    }
}
