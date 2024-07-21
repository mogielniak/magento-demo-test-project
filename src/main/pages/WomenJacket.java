package main.pages;

import main.helpers.ShopHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenJacket extends ShopHelper {



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
            default -> throw new IllegalArgumentException("Invalid id");
        };
    }


    }
