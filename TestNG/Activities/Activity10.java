package testNGTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity10 {
    WebDriver driver;
    Actions builder;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        builder = new Actions(driver);

        //Open browser
        driver.get("https://www.training-support.net/selenium/sliders");
    }

    @Test(priority=0)
    public void sliderToMiddleTest() throws InterruptedException {
        //Find slider
        WebElement slider = driver.findElement(By.id("slider"));
        //Clicking on the slider element moves it to the middle
        Thread.sleep(3000);
        slider.click();
        Thread.sleep(3000);
        builder.clickAndHold(slider).moveByOffset(1, 0).release().build().perform();

        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Mid value: " + volumeLevel);

        Assert.assertEquals(volumeLevel, "51");
    }

    @Test(priority=1)
    public void sliderToMaxTest() throws InterruptedException {
        //Find slider
        WebElement slider = driver.findElement(By.id("slider"));

        Thread.sleep(3000);
        //Drag the slider
        builder.clickAndHold(slider).moveByOffset(75, 0).release().build().perform();
        Thread.sleep(3000);
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Max value: " + volumeLevel);

        Assert.assertEquals(volumeLevel, "97");
    }

    @Test(priority=2)
    public void sliderToMinTest() throws InterruptedException {
        //Find slider
        WebElement slider = driver.findElement(By.id("slider"));
        //Drag the slider
        Thread.sleep(3000);
        builder.clickAndHold(slider).moveByOffset(-75, 0).release().build().perform();
        Thread.sleep(3000);

        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Min value: " + volumeLevel);

        Assert.assertEquals(volumeLevel, "3");
    }

    @Test(priority=3)
    public void sliderTo30Test() throws InterruptedException {
        //Find slider
        WebElement slider = driver.findElement(By.id("slider"));
        //Drag the slider
        Thread.sleep(3000);
        builder.clickAndHold(slider).moveByOffset(-30, 0).release().build().perform();
        Thread.sleep(3000);

        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Min value: " + volumeLevel);

        Assert.assertEquals(volumeLevel, "31");
    }

    @Test(priority=4)
    public void sliderTo80Test() throws InterruptedException {
        //Find slider
        WebElement slider = driver.findElement(By.id("slider"));
        //Drag the slider
        Thread.sleep(3000);
        builder.clickAndHold(slider).moveByOffset(45, 0).release().build().perform();
        Thread.sleep(3000);

        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Min value: " + volumeLevel);

        Assert.assertEquals(volumeLevel, "78");
    }

    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }
}