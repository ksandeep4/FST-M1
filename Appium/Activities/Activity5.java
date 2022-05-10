package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
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

public class Activity5 {

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
        caps.setCapability("appPackage", "com.google.android.apps.messaging");
        caps.setCapability("appActivity", ".ui.ConversationListActivity");
        caps.setCapability("noReset", true);

        //Set Appium server URL
        URL remoteURL=new URL("http://localhost:4723/wd/hub");
        //Initializing AndroidDriver
        driver=new AndroidDriver<MobileElement>(remoteURL, caps);
        wait = new WebDriverWait(driver, 10);

    }
    @Test
    public void textMessage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click on create new message
        driver.findElementById("com.google.android.apps.messaging:id/start_new_conversation_button").click();
        //Type you phone number
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.messaging:id/recipient_text_view")));
        driver.findElementById("com.google.android.apps.messaging:id/recipient_text_view").sendKeys("9652184666");
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));

        //Locate the message input field and type the message
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.messaging:id/compose_message_text")));
        driver.findElementById("com.google.android.apps.messaging:id/compose_message_text").sendKeys("Hello from Appium");
        //Click on send button
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.messaging:id/send_message_button_icon")));
        driver.findElementById("com.google.android.apps.messaging:id/send_message_button_icon").click();

        //Assertion
        String sentMessage=driver.findElementById("com.google.android.apps.messaging:id/message_text").getText();
        Assert.assertEquals(sentMessage, "Hello from Appium");
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}