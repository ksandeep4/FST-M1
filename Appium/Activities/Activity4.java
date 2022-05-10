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
import java.util.concurrent.TimeUnit;

public class Activity4 {

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
        caps.setCapability("appPackage", "com.android.contacts");
        caps.setCapability("appActivity", ".activities.PeopleActivity");
        caps.setCapability("noReset", true);

        //Set Appium server URL
        URL remoteURL=new URL("http://localhost:4723/wd/hub");
        //Initializing AndroidDriver
        driver=new AndroidDriver<MobileElement>(remoteURL, caps);
        wait = new WebDriverWait(driver, 10);

    }
    @Test
    public void newContact() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Find the new contact button and click it
        driver.findElementById("com.android.contacts:id/floating_action_button").click();
        //Fill the details
        driver.findElementByXPath("//android.widget.EditText[@text='First name']").sendKeys("Aaditya");
        driver.findElementByXPath("//android.widget.EditText[@text='Last name']").sendKeys("Varma");
        driver.findElementByXPath("//android.widget.EditText[@text='Phone']").sendKeys("999148292");
        //Click on Save
        driver.findElementById("com.android.contacts:id/editor_menu_save_button").click();
        //Wait for the contact to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.android.contacts:id/toolbar_parent")));
        //Assertion
        MobileElement elem=driver.findElementById("com.android.contacts:id/toolbar_parent");
        Assert.assertTrue(elem.isDisplayed());

        String contactName=driver.findElementById("com.android.contacts:id/large_title").getText();
        Assert.assertEquals(contactName, "Aaditya Varma");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
