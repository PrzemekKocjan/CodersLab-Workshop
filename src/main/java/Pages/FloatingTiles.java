package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FloatingTiles {
    private static WebDriver driver;


    public FloatingTiles(WebDriver driver){
        this.driver = driver;
    }

    public void clickHummingSweaterTile(){
        WebElement hummingSweaterTile = driver.findElement(By.xpath("//*[@id='js-product-list']/div[1]/article[1]/div/div[1]/h2"));
        hummingSweaterTile.click();
    }

    public void setupSweaterOrder(){
        WebElement size = driver.findElement(By.xpath("//*[@id='group_1']"));
        size.sendKeys("M");
        WebElement quantity = driver.findElement(By.xpath("//*[@id='quantity_wanted']"));
        quantity.sendKeys("5");

    }
}

