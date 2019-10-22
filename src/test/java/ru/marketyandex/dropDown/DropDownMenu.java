package ru.marketyandex;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.marketyandex.dropDown.DropDownPage;

import javax.swing.*;
import javax.swing.text.html.parser.Element;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class DropDownMenu extends WebDriverSettings {



    @Test
public void dropDown ()  {
        //driver initialization
        DropDownPage dropDownPage = PageFactory.initElements(driver,DropDownPage.class);
        dropDownPage.open();
        dropDownPage.browserSettings();

        //find all categories
        WebElement AllCategory = driver.findElement(By.xpath("//div[@class='n-w-tab__control b-zone b-spy-events i-bem n-w-tab__control_js_inited']"));
        AllCategory.click();

        //wait for element load

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='n-w-tabs__tabs-column']//div[11]")));
        driver.findElement(By.xpath("//div[@class='n-w-tabs__tabs-column']//div[11]//a[1]"));

        //move cursor to menu
        Actions action  = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//div[@class='n-w-tabs__tabs-column']//div[11]//a[1]")));
        action.perform();


        //enter options
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='n-w-tab__content-container n-w-tab__content-container_interaction_hover-navigation-menu b-zone b-spy-visible i-bem n-w-tab__content-container_uid_41064796 n-w-tab__content-container_js_inited b-spy-visible_js_inited n-w-tab__content-container_shown_yes b-zone_js_inited']']//div[1]//a[4]")));
        driver.findElement(By.xpath("//div[@class='n-w-tab__content-container n-w-tab__content-container_interaction_hover-navigation-menu b-zone b-spy-visible i-bem n-w-tab__content-container_uid_41064796 n-w-tab__content-container_js_inited b-spy-visible_js_inited n-w-tab__content-container_shown_yes b-zone_js_inited']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("glpricefrom")));
        driver.findElement(By.id("glpricefrom")).sendKeys("50");
        driver.findElement(By.id("glpriceto")).sendKeys("150");
        driver.findElement(By.xpath("//fieldset[@class='_2qWuY12N6f']//li[1]//div[1]//label[1]//div[1]//span[1]")).click();
        // WHISKAS driver.findElement(By.xpath("//span[contains(text(),'Whiskas')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Beaphar')]")).click();//if whiskas out
        driver.manage().timeouts().pageLoadTimeout(4,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@id='product-158327379']")).click();
        driver.manage().timeouts().pageLoadTimeout(4,TimeUnit.SECONDS);


        //move to  first element
        driver.findElements(By.xpath("//a[contains(text(),'Beaphar')]")).get(0).click();
        driver.manage().timeouts().pageLoadTimeout(4,TimeUnit.SECONDS);

         //click compare +return
            driver.findElement(By.className("n-user-lists_type_compare")).click();
        driver.navigate().back();

        //switch manufacturer+move to second element
        driver.findElement(By.xpath("//span[contains(text(),'Beaphar')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Dreamies')]")).click();
        driver.manage().timeouts().pageLoadTimeout(3,TimeUnit.SECONDS);
        driver.findElements(By.xpath("//span[contains(text(),'Dreamies')]")).get(1).click();
        driver.manage().timeouts().pageLoadTimeout(4,TimeUnit.SECONDS);

        //click compare + move to compare page
            driver.findElement(By.className("n-user-lists_type_compare")).click();
            driver.findElement(By.xpath("//a[@class='link header2-menu__item header2-menu__item_type_compare i-bem link_js_inited']")).click();

            //assert names
        String textFromStep5 = driver.findElement(By.xpath("//span[contains(text(),'Beaphar')]")).getText();
        String textFromStep8 = driver.findElement(By.xpath("//span[contains(text(),'Dreamies')]")).getText();
        String textFromComparision1 = driver.findElement(By.xpath("//div[@class='n-compare-cell n-compare-cell_product_208533675 n-compare-cell-draggable i-bem n-compare-cell_js_inited n-compare-cell_mode_last']")).getText();
        String textFromComparision2 = driver.findElement(By.xpath("//div[@class='n-compare-cell n-compare-cell_product_158327383 n-compare-cell-draggable i-bem n-compare-cell_js_inited']")).getText();
            Assert.assertEquals(textFromStep5,textFromComparision1);
            Assert.assertEquals(textFromStep8,textFromComparision2);

            //assert prices
            String priceFromStep5 = driver.findElement(By.xpath("//div[@class='n-compare-cell n-compare-cell_product_158327383']")).getText();
            String priceFromStep8 = driver.findElement(By.xpath("//div[@class='n-compare-cell n-compare-cell_product_208533675']")).getText();
            float floatPriceFromStep5 = Float.parseFloat(priceFromStep5);
            //System.out.println(floatPriceFromStep5);-проверка
            float floatPriceFromStep8 = Float.parseFloat(priceFromStep8);
            //System.out.println(floatPriceFromStep8);-проверка
            float fullprice = floatPriceFromStep5 + floatPriceFromStep8;
              if (fullprice <= 300.0) {
                      System.out.println("Общая сумма меньше 300 рублей.");
              }
              else {
                      System.out.println("Общая сумма превышает 300 рублей.");
              }
    }
}
