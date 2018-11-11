package ru.kos.sl;

import com.google.common.base.Function;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SKBMethodTest {
    private WebDriver webDriver;

    public SKBMethodTest() {
        System.setProperty("webdriver.chrome.driver", "E:\\Belka\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.23.0-win64\\geckodriver.exe");
//        webDriver = new FirefoxDriver();
    }

    @Когда("^пользователь на странице (.*)$")
    public void пользовательНаСтранице(String arg1) {
        webDriver.get(arg1);
    }

    @Тогда("^вводим в поле \"([^\"]*)\" \"([^\"]*)\"$")
    public void вводимВПоле(String arg1, String text) {
        waitForLoad(webDriver);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        WebElement firstNameTd = webDriver.findElement(By.xpath("//*[contains(text(), 'First Name:')]"));
        WebElement siblingTd = firstNameTd.findElement(By.xpath("following-sibling::*"));
        WebElement input = siblingTd.findElement(By.xpath(".//*"));
        input.sendKeys("lajdakjdkasjd");
    }

    private void waitForLoad(WebDriver webDriver) {
        new WebDriverWait(webDriver, 10).until(new Function<WebDriver, Object>() {
            @Override
            public Object apply(WebDriver input) {
                return !input.findElements(By.xpath("//*[contains(text(), 'Contact Info')]")).isEmpty();
            }
        });
    }

}
