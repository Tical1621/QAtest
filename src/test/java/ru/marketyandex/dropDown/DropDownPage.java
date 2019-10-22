package ru.marketyandex.dropDown;

import org.openqa.selenium.WebDriver;

public class DropDownPage {

    WebDriver driver;

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://market.yandex.ru");
    }
    public void browserSettings(){
        driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();

    }
}

