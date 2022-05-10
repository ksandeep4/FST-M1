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

public class GoalActivity1 {
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
    public void createToDoList() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Go the URL
        driver.get("https://www.training-support.net/selenium");

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingForward().scrollIntoView(textContains(\"To-Do List\"))")));
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingForward().scrollIntoView(textContains(\"To-Do List\"))")).click();

        //Strike the default task
        driver.findElementByXPath("//android.view.View[@text='Add more tasks to this list.']").click();
        //Find the input field on the page
        WebElement element=driver.findElementByXPath("//android.view.View/android.view.View/android.view.View/android.widget.EditText");
        //Add the first task
        element.sendKeys("Add tasks to list");
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.Button[@text='Add Task']")));
        //Click on add task
        driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
        //Add the second task
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.Button[@text='Add Task']")));
        element.sendKeys("Get number of tasks");

        //Click on add task
        driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
        //Add the third task

        element.sendKeys("Clear the list");
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.Button[@text='Add Task']")));
        //Click on add task
        driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
        //Strike the tasks
        driver.findElementByXPath("//android.view.View[@text='Add tasks to list']").click();
        driver.findElementByXPath("//android.view.View[@text='Get number of tasks']").click();
        driver.findElementByXPath("//android.view.View[@text='Clear the list']").click();
        //Clearing the list
        WebElement clearElem=driver.findElementByXPath("//android.view.View[4]/android.view.View[3]/android.view.View[2]");
        clearElem.click();
        //Add Assertions
        String cl=clearElem.getText();
        Assert.assertEquals(cl, " Clear List");

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
