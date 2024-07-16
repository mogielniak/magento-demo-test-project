package main.pages;

import main.helpers.ShopHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenJacket extends ShopHelper {



    @Override
    public WebElement getProductElement(int id) {
        return switch (id) {
            case 1 -> id1;
            case 2 -> id2;
            case 3 -> id3;
            case 4 -> id4;
            case 5 -> id5;
            case 6 -> id6;
            case 7 -> id7;
            case 8 -> id8;
            case 9 -> id9;
            case 10 -> id10;
            case 11 -> id11;
            case 12 -> id12;
            default -> throw new IllegalArgumentException("Invalid Color");
        };
    }
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]") private WebElement id1; //first jacket
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[2]") private WebElement id2; //second jacket
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[3]") private WebElement id3; //etc
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[4]") private WebElement id4;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]") private WebElement id5;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[6]") private WebElement id6;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[7]") private WebElement id7;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[8]") private WebElement id8;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[9]") private WebElement id9;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[10]") private WebElement id10;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[11]") private WebElement id11;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[12]") private WebElement id12;
}