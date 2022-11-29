package main.java.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalInformationPage extends BasePage {

    By inputCIDocument = By.cssSelector("input[id='serialNumber']");
    By inputAddress = By.cssSelector("input[id='address.street']");
    By downRegion = By.xpath("//div[@id='address.region']/div/span");
    By downCommune = By.xpath("//div[@id='address.commune']/div/span");
    By downBank = By.xpath("//div[@id='bankAccount.bank']/div/span");
    By downAccountType = By.xpath("//div[@id='bankAccount.type']/div/span");
    By inputAccountNumber = By.cssSelector("input[id='bankAccount.number']");
    By btnContinue = By.xpath("//*[@id='root']/section/main/div[4]/button");

    public PersonalInformationPage(WebDriver driver) {
        super(driver);
    }

    public void updatePersonalInformation(String ciDocument, String address, String region, String commune) throws InterruptedException {
        Thread.sleep(20000);
        waitInvisibilityOfSpin();
        explicitWaitElementToBeClickable(inputCIDocument);
        typeWithTab(ciDocument, inputCIDocument);
        typeWithTab(address, inputAddress);
        selectOptionDropDown(downRegion, region);
        Thread.sleep(4000);
        selectOptionDropDown(downCommune, commune);
    }

    public void updateBankData(String bank, String accountType, String accountNumber) throws InterruptedException {
        performScrollDownBottomPage();
        Thread.sleep(2000);
        selectOptionDropDown(downBank, bank);
        selectOptionDropDown(downAccountType, accountType);
        type(accountNumber, inputAccountNumber);
        Thread.sleep(2000);
        click(btnContinue);
    }
}
