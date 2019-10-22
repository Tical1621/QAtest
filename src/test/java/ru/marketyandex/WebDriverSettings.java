package ru.marketyandex;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverSettings {

    public WebDriver driver;
    public WebDriverWait wait;


        @Before
        public void setUp(){
            System.setProperty("webdriver.chrome.driver" , "C:\\Users\\User\\IdeaProjects\\TestQuestReposit-master\\driver\\chromedriver.exe");
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver , 10);
        }
        @After
        public void close(){
            driver.close();
        }
    }


