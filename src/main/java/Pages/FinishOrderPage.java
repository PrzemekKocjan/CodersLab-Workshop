package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinishOrderPage
{
    public static WebDriver driver;



    public FinishOrderPage(WebDriver driver){

        this.driver = driver;
    }

    public void finishOrder() throws InterruptedException {

        WebElement continueAddressOrder = driver.findElement(By.xpath("//*[@id='checkout-addresses-step']/div/div/form/div[2]/button"));
        continueAddressOrder.click();

        WebElement pretaShopClick = driver.findElement(By.id("delivery_option_1"));
        pretaShopClick.isSelected();
        System.out.println("preta shipping selected");
        Thread.sleep(1000);

        WebElement continueShippingOrder = driver.findElement(By.xpath("//*[@id='js-delivery']/button"));
        continueShippingOrder.click();
        Thread.sleep(1000);

        WebElement payByCheck = driver.findElement(By.id("payment-option-1"));
        payByCheck.click();
        WebElement termsAndConditions = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        termsAndConditions.click();
        WebElement orderWithObligation = driver.findElement(By.xpath("//*[@id='payment-confirmation']/div[1]/button"));
        orderWithObligation.click();
    }

}
