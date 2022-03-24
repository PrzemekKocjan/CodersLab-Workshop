package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartOptions {
    private static WebDriver driver;

    public CartOptions(WebDriver driver){

        this.driver = driver;
    }


    public void addToCartBtn(){
        WebElement addToCart = driver.findElement(By.xpath("//*[@id='add-to-cart-or-refresh']/div[2]/div/div[2]/button"));
        addToCart.click();
    }

    public void proceedToCheckoutBtn(){
        WebElement checkOutBtn = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        checkOutBtn.click();

    }
}
