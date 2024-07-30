package utils;

import driver.DriverManager;
import enums.Swipe;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Actions {

    public static void enter(By ele, String context) {
        DriverManager.driver.get().findElement(ele).sendKeys(context);
    }

    public static void scrollToElement(By ele) {
        WebElement element = DriverManager.driver.get().findElement(ele);
        ((JavascriptExecutor) DriverManager.driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static String getText(By ele) {
        return DriverManager.driver.get().findElement(ele).getText();
    }

    public static void select(By eleSelect, String valueOption) {
        scrollToElement(eleSelect);
        Select select = new Select(DriverManager.driver.get().findElement(eleSelect));
        select.selectByVisibleText(valueOption);
    }

    public static boolean isDisplay(By ele) {
        List<WebElement> tabs = DriverManager.driver.get().findElements(ele);
        return !tabs.isEmpty() && tabs.get(0).isDisplayed();
    }

    public static void click(By ele) {
        waitElementToBevisibility(ele,20).click();
    }

    public static void swipe(Swipe direction) {
        int startX, startY, endX, endY;
        int width = DriverManager.getDriver().manage().window().getSize().width;
        int height = DriverManager.getDriver().manage().window().getSize().height;

        switch (direction.getSwipeValue().toLowerCase()) {
            case "up":
                startX = width / 2;
                startY = (int) (height * 0.8);
                endX = width / 2;
                endY = (int) (height * 0);
                break;
            case "down":
                startX = width / 2;
                startY = (int) (height * 0.2);
                endX = width / 2;
                endY = (int) (height * 0.8);
                break;
            case "left":
                startX = (int) (width * 0.8);
                startY = height / 2;
                endX = (int) (width * 0.2);
                endY = height / 2;
                break;
            case "right":
                startX = (int) (width * 0.2);
                startY = height / 2;
                endX = (int) (width * 0.8);
                endY = height / 2;
                break;
            default:
                throw new IllegalArgumentException("Invalid swipe direction: " + direction);
        }

        new TouchAction<>((PerformsTouchActions) DriverManager.getDriver())
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }

    public static WebElement waitElementToBevisibility(By ele, int second) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(second));
        return wait.until(ExpectedConditions.visibilityOf(DriverManager.getDriver().findElement(ele)));
    }

}