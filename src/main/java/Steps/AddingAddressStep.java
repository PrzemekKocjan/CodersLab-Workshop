package Steps;

import Pages.CreateNewAddressFormPage;
import Pages.LogInUserPage;
import Pages.MyAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Optional;
import java.util.concurrent.TimeUnit;


public class AddingAddressStep {
    WebDriver driver;


    @Given("User on mystore-testlab.coderslab homepage")
    public void userOnMystoreTestlabCoderslabHomepage() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl");
    }

    @Then("User logs in on existing account {string}{string}")
    public void userLogsInOnExistingAccount(String login, String passwd) {
        LogInUserPage logInUserPage = new LogInUserPage(driver);
        logInUserPage.clickOnSignIn();
        logInUserPage.insertEmail(login);
        logInUserPage.insertPasswd(passwd);
        logInUserPage.clickSignInButton();
    }

    @And("User clicks addresses tab")
    public void userClicksAddressesTab() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.AddFirstAddressTile();

    }


    @And("User fills up the form with {string}{string}{string}{string}{string}{string}")
    public void userFillsUpTheFormWith(String alias, String address, String city, String postCode, String country, String phone) {
        CreateNewAddressFormPage createNewAddressFormPage = new CreateNewAddressFormPage(driver);
        createNewAddressFormPage.aliasInput(alias);
        createNewAddressFormPage.addressInput(address);
        createNewAddressFormPage.cityInput(city);
        createNewAddressFormPage.postCodeInput(postCode);
        createNewAddressFormPage.countryInput(country);
        createNewAddressFormPage.phoneInput(phone);


    }


    @Then("Click save button")
    public void clickSaveButton() {
        CreateNewAddressFormPage createNewAddressFormPage = new CreateNewAddressFormPage(driver);
        createNewAddressFormPage.saveButton();
    }


    @And("Confirm address text {string}{string}{string}{string}{string}{string}")
    public void confirmAddressText(String alias, String address, String city, String postCode, String country, String phone) {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        String addressTextField = myAccountPage.getAddressFieldBox();
        System.out.println(addressTextField);
        Assert.assertTrue(addressTextField.contains(alias));
        Assert.assertTrue(addressTextField.contains(address));
        Assert.assertTrue(addressTextField.contains(city));
        Assert.assertTrue(addressTextField.contains(postCode));
        Assert.assertTrue(addressTextField.contains(country));
        Assert.assertTrue(addressTextField.contains(phone));

    }

}
