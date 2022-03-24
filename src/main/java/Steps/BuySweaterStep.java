package Steps;

import Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;


public class BuySweaterStep {

    WebDriver driver;

    @Given("User on mystore-testlab.coderslab homePage")
    public void userOnMystoreTestlabCoderslabHomePage() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl");

    }

    @Then("User logs in with existing account {string}{string}")
    public void userLogsInWithExistingAccount(String login, String passwd) {
        LogInUserPage logInUserPage = new LogInUserPage(driver);
        logInUserPage.clickOnSignIn();
        logInUserPage.insertEmail(login);
        logInUserPage.insertPasswd(passwd);
        logInUserPage.clickSignInButton();
    }

    @Then("User types Hummingbird Printed Sweater in searchfield")
    public void userTypesHummingbirdPrintedSweaterInSearchfield() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.insertSearchField();
    }

    @And("User clicks Hummingbird Printed Sweater floating tile")
    public void userClicksHummingbirdPrintedSweaterFloatingTile() {
        FloatingTiles floatingTiles = new FloatingTiles(driver);
        floatingTiles.clickHummingSweaterTile();
    }

    @Then("User sets up the order")
    public void userSetsUpTheOrder() {
        FloatingTiles floatingTiles = new FloatingTiles(driver);
        floatingTiles.setupSweaterOrder();
        CartOptions cartOptions = new CartOptions(driver);
        cartOptions.addToCartBtn();
        cartOptions.proceedToCheckoutBtn();
        cartOptions.proceedToCheckoutBtn();
    }


    @Then("User confirms address {string}{string}{string}{string}{string}{string}")
    public void userConfirmsAddress(String alias, String address, String city, String postCode, String country, String phone) {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        String addressDelivery = myAccountPage.getDeliveryAddress();
        System.out.println(addressDelivery);
        Assert.assertTrue(addressDelivery.contains(alias));
        Assert.assertTrue(addressDelivery.contains(address));
        Assert.assertTrue(addressDelivery.contains(city));
        Assert.assertTrue(addressDelivery.contains(postCode));
        Assert.assertTrue(addressDelivery.contains(country));
        Assert.assertTrue(addressDelivery.contains(phone));
    }

    @Then("User proceed with order completion")
    public void userProceedWithOrderCompletion() throws InterruptedException, IOException {
        FinishOrderPage finishOrderPage = new FinishOrderPage(driver);
        finishOrderPage.finishOrder();

        Screenshot screenshot = new AShot().takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), "png",
                new File("C:\\Users\\przem\\Desktop\\Screenshot_selenium\\Fullpgscreenshot.png"));


    }
}
