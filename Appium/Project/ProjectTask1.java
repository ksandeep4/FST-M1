package project;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ProjectTask1 {

    //Declare AndroidDriver
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Set desired capabilities
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel4Emulator");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        //Set Appium server URL
        URL remoteURL=new URL("http://localhost:4723/wd/hub");
        //Initializing AndroidDriver
        driver=new AndroidDriver<MobileElement>(remoteURL, caps);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @Test(priority=0)
    public void addTask() {

        //Click for creating a new task
        driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();

        //Click on new task
        MobileElement element=driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
        element.click();
        //Adding new tasks
        element.sendKeys("Complete Activity with Google Task");
        //Saving the task
        driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();

    }
    @Test(priority=1)
    public void addSecondTask() {

        //Click for creating a new task
        driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
        //Click on new task
        MobileElement element2=driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
        element2.click();
        //Adding new tasks
        element2.sendKeys("Complete Activity with Google Keep");
        //Saving the task
        driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
    }
    @Test(priority=2)
    public void addThirdTask() throws IllegalStateException {
        //Click for creating a new task
        driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
        //Click on new task
        MobileElement element3=driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
        element3.click();
        //Adding new tasks
        element3.sendKeys("Complete the second Activity Google Keep");
        //Saving the task
        driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();

        //Assert to check if the tasks have been added
        MobileElement e1=driver.findElementByXPath("//android.widget.TextView[@text='Complete the second Activity Google Keep']");
        String el1=e1.getText();
        Assert.assertEquals(el1,"Complete the second Activity Google Keep" );
        MobileElement e2=driver.findElementByXPath("//android.widget.TextView[@text='Complete Activity with Google Keep']");
        String el2=e2.getText();
        Assert.assertEquals(el2,"Complete Activity with Google Keep" );
        MobileElement e3=driver.findElementByXPath("//android.widget.TextView[@text='Complete Activity with Google Task']");
        String el3=e3.getText();
        Assert.assertEquals(el3,"Complete Activity with Google Task" );


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
