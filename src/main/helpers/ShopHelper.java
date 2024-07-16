package main.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import main.helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import main.util.PageUtil;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class ShopHelper extends PageHelper{

    public abstract WebElement getProductElement(int id);

    public void selectSize(String size){
        WebElement element = switch(size){
            case"XS" -> xSmall;
            case"S"  -> small;
            case"M"  -> medium;
            case"L"  -> large;
            case"XL" -> xLarge;
            default -> throw new IllegalArgumentException("Invalid Size");
        };
        Click(element);
    }
    public void selectColor(String color){
        WebElement element = switch(color){
            case"black" -> black;
            case"blue"  -> blue;
            case"red"   -> red;
            case"white" -> white;
            case"yellow"-> yellow;
            case"pink"  -> pink;
            case"grey"  -> grey;
            case"brown" -> brown;
            case"green" -> green;
            default -> throw new IllegalArgumentException("Invalid Color");
        };
        Click(element);
    }
    public void addProductToCart(int id,String size, String color){
        WebElement product = getProductElement(id);
        Click(product);
        selectColor(color);
        selectSize(size);
        Click(addToCartButton);
    }


    @FindBy(id = "product-addtocart-button")        private WebElement addToCartButton;
    @FindBy(id="option-label-size-143-item-166")    private WebElement xSmall;
    @FindBy(id="option-label-size-143-item-167")    private WebElement small;
    @FindBy(id="option-label-size-143-item-168")    private WebElement medium;
    @FindBy(id="option-label-size-143-item-169")    private WebElement large;
    @FindBy(id="option-label-size-143-item-170")    private WebElement xLarge;

    @FindBy(id="option-label-color-93-item-49")    private WebElement black;
    @FindBy(id="option-label-color-93-item-50")    private WebElement blue;
    @FindBy(id="option-label-color-93-item-51")    private WebElement brown;
    @FindBy(id="option-label-color-93-item-52")    private WebElement grey;
    @FindBy(id="option-label-color-93-item-53")    private WebElement green;
    // @FindBy(id="option-label-color-93-item-54")    private WebElement black; idk cool guys lets just do nothing with 54 and 55 yeah that gonna be fun right!!!!!!!!not really
    // @FindBy(id="option-label-color-93-item-55")    private WebElement black; what am i supposed to do now just leave it like that?
    @FindBy(id="option-label-color-93-item-56")    private WebElement orange; // ok : (
    @FindBy(id="option-label-color-93-item-57")    private WebElement pink;
    @FindBy(id="option-label-color-93-item-58")    private WebElement red;
    @FindBy(id="option-label-color-93-item-59")    private WebElement white;
    @FindBy(id="option-label-color-93-item-60")    private WebElement yellow;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[2]/div/div/div[4]/div/div[1]/form/button") private WebElement addToCartButtonOnMainPage;
}
