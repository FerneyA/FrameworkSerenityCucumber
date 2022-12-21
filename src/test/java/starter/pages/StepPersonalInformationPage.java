package starter.pages;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class StepPersonalInformationPage extends BasePage {

    By inputCIDocument = By.cssSelector("input[id='serialNumber']");
    By inputAddress = By.cssSelector("input[id='address.street']");
    By inputStreetNumberPf1 = By.cssSelector("input[id='address.number']");
    By inputPhonePf1 = By.cssSelector("input[id='phone']");
    By inputEmailPf1 = By.cssSelector("input[id='email']");
    By downRegion = By.xpath("//div[@id='address.region']/div/span");
    By downCommune = By.xpath("//div[@id='address.commune']/div/span");
    By downBank = By.xpath("//div[@id='bankAccount.bank']/div/span");
    By downAccountType = By.xpath("//div[@id='bankAccount.type']/div/span");
    By inputAccountNumber = By.cssSelector("input[id='bankAccount.number']");
    By btnContinue = By.xpath("//*[@id='root']/section/main/div[4]/button");
    By btnSaveDataAndContinuePf1 = By.xpath("//span[text()='Guardar Datos y Continuar']/parent::button");

    @Step
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

    @Step
    public void updateBankData(String bank, String accountType, String accountNumber) throws InterruptedException {
        performScrollDownBottomPage();
        Thread.sleep(2000);
        selectOptionDropDown(downBank, bank);
        selectOptionDropDown(downAccountType, accountType);
        type(accountNumber, inputAccountNumber);
        Thread.sleep(2000);
        click(btnContinue);
    }

    @Step
    public void updatePersonalInformationPf1(String ciDocument, String address, String region, String commune, String streetNumber, String email, String phone) throws InterruptedException {
        waitInvisibilityOfSpin();
        fluentWait(inputEmailPf1);
        typeWithTab(ciDocument, inputCIDocument);
        typeWithTab(email, inputEmailPf1);
        typeWithTab(phone, inputPhonePf1);
        typeWithTab(address, inputAddress);
        typeWithTab(streetNumber, inputStreetNumberPf1);
        selectOptionDropDown(downRegion, region);
        Thread.sleep(1000);
        selectOptionDropDown(downCommune, commune);
    }

    @Step
    public void updateBankDataPf1(String bank, String accountType, String accountNumber) throws InterruptedException {
        performScrollDownBottomPage();
        Thread.sleep(1000);
        selectOptionDropDown(downBank, bank);
        selectOptionDropDown(downAccountType, accountType);
        typeWithTab(accountNumber, inputAccountNumber);
        Thread.sleep(1000);
        click(btnSaveDataAndContinuePf1);
    }
}
