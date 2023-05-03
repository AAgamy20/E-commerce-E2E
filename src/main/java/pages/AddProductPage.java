package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Helper;
import utils.Logger;
import utils.UiActions;

import java.util.List;

public class AddProductPage {

    WebDriver driver;

    By uploadImageBtn = By.xpath("//input[@name='file']");
    By productTitleField = By.xpath("//input[@name='title']");
    By productDescField = By.xpath("//input[@name='description']");
    By productPriceField = By.xpath("//input[@name='price']");
    By createProductBtn = By.xpath("//button[@type=\"submit\"]");







    public AddProductPage(WebDriver driver) {
        this.driver = driver;
    }


    public void fillProductDetails(String imagePath , String productName,String productDesc ,String productPrice){

        UiActions.type(driver,productTitleField,productName);
        UiActions.type(driver,productDescField,productDesc);
        driver.findElement(productPriceField).sendKeys(Keys.BACK_SPACE);
        UiActions.type(driver,productPriceField,productPrice);
        driver.findElement(uploadImageBtn).sendKeys(imagePath);

    }
    public void editProductName( String editedName){
        //delete the existing data
        UiActions.click(driver,productTitleField);
        WebElement  productNameElem = driver.findElement(productTitleField);
        while (!productNameElem.getAttribute("value").isEmpty()) {
            productNameElem.sendKeys(Keys.BACK_SPACE);
        }
       // Actions a = new Actions(driver);
        driver.findElement(productPriceField).clear();
        //fill with the new data
        UiActions.type(driver,productTitleField,editedName);

    }
    public void clickCreateProduct(){
        UiActions.click(driver,createProductBtn);
    }
    public void clickSaveProduct(){
        UiActions.click(driver,createProductBtn);
    }
}
