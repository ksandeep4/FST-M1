package project;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
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

public class GoalActivity3 {
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
    }

    @Test(priority=0)
    public void popups() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Go the URL
        driver.get("https://www.training-support.net/selenium");
        driver.findElement(MobileBy.xpath("//android.widget.Button[contains(@text,'Get Started!')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingForward().scrollIntoView(textContains(\"Popups\"))")));
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingForward().scrollIntoView(textContains(\"Popups\"))")).click();
        //Click the Sign In Button
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[4]/android.widget.Button")));
        driver.findElementByXPath("//android.view.View[4]/android.widget.Button").click();
        //Find the Username field
        WebElement userName=driver.findElementByXPath("//android.view.View/android.widget.EditText[1]");
        //Find the password field
        WebElement passWord=driver.findElementByXPath("//android.view.View/android.widget.EditText[2]");
        //Enter credentials
        userName.sendKeys("admin");
        passWord.sendKeys("password");
        //Click on the Login Button
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.Button[@text='Log in']")));
        driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();

    }
    @Test(priority=1)
    public void validCred() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Go the URL
        driver.get("https://www.training-support.net/selenium");
        driver.findElement(MobileBy.xpath("//android.widget.Button[contains(@text,'Get Started!')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingForward().scrollIntoView(textContains(\"Popups\"))")));
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingForward().scrollIntoView(textContains(\"Popups\"))")).click();
        //Click the Sign In Button
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[4]/android.widget.Button")));
        driver.findElementByXPath("//android.view.View[4]/android.widget.Button").click();
        //Enter username credentials
        driver.findElementByXPath("//android.view.View/android.widget.EditText[1]").sendKeys("admin");
        //Enter password credentials
        driver.findElementByXPath("//android.view.View/android.widget.EditText[2]").sendKeys("password");
        //Click on the Login Button
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.Button[@text='Log in']")));
        driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
        //Validate the message popup
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@text='Welcome Back, admin']")));
        MobileElement valid=driver.findElementByXPath("//android.view.View[@text='Welcome Back, admin']");
        String val= valid.getText();
        System.out.println("The Valid credentials message is: "+ val);
        Assert.assertEquals(val, "Welcome Back, admin");

    }
    @Test(priority=2)
    public void invalidCred() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Go the URL
        driver.get("https://www.training-support.net/selenium");
        driver.findElement(MobileBy.xpath("//android.widget.Button[contains(@text,'Get Started!')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingForward().scrollIntoView(textContains(\"Popups\"))")));
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingForward().scrollIntoView(textContains(\"Popups\"))")).click();
        //Click the Sign In Button
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[4]/android.widget.Button")));
        driver.findElementByXPath("//android.view.View[4]/android.widget.Button").click();
        //Enter username credentials
        driver.findElementByXPath("//android.view.View/android.widget.EditText[1]").sendKeys("Bhavani");
        //Enter password credentials
        driver.findElementByXPath("//android.view.View/android.widget.EditText[2]").sendKeys("password567");
        //Click on the Login Button
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.Button[@text='Log in']")));
        driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
        //Validate the message popup
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@text='Invalid Credentials']")));
        MobileElement invalid=driver.findElementByXPath("//android.view.View[@text='Invalid Credentials']");
        String inv= invalid.getText();
        System.out.println("The Valid credentials message is: "+ inv);
        Assert.assertEquals(inv, "Invalid Credentials");

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}