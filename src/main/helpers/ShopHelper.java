package main.helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




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

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]") public WebElement id1; //first jacket
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[2]") public WebElement id2; //second jacket
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[3]") public WebElement id3; //etc
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[4]") public WebElement id4;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]") public WebElement id5;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[6]") public WebElement id6;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[7]") public WebElement id7;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[8]") public WebElement id8;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[9]") public WebElement id9;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[10]") public WebElement id10;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[11]") public WebElement id11;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[12]") public WebElement id12;
}
