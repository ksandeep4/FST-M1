package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Activity6 {

    //Declare AndroidDriver
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Set desired capabilities
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel4Emulator");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        //Set Appium server URL
        URL remoteURL=new URL("http://localhost:4723/wd/hub");
        //Initializing AndroidDriver
        driver=new AndroidDriver<MobileElement>(remoteURL, caps);
        wait = new WebDriverWait(driver, 10);
        //Go the URL
        driver.get("https://www.training-support.net/selenium/lazy-loading");
    }
    @Test
    public void scrollImage() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@text='Lazy Loading']")));
        //Count the number of images shown in the page
        List<MobileElement> numberOfImg= driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
        System.out.println("The number of images in the current screen is: "+ numberOfImg.size());

        Assert.assertEquals(numberOfImg.size(), 2);
        //Scroll to Helen's post
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"helen\")")));
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"helen\")"));
        //Number of images after scrolling
        numberOfImg=driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
        System.out.println("The number of images after scrolling is: "+ numberOfImg.size());

        //Assertion after scrolling
        Assert.assertEquals(numberOfImg.size(), 2);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
