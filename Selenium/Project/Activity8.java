package LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8 {
    public static void main(String[] args) {

        //Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        //And now use this to visit the website
        driver.get("https://alchemy.hguy.co/lms");

        //Find the heading text using cssselector
        WebElement contact = driver.findElement(By.cssSelector("#menu-item-1506 > a"));

        //Click on MyAccount
        contact.click();

        //find contact form , fill details and submit
        WebElement fullName = driver.findElement(By.cssSelector("#wpforms-8-field_0"));
        fullName.sendKeys("James");
        WebElement email = driver.findElement(By.xpath("//*[@id=\"wpforms-8-field_1\"]"));
        email.sendKeys("name@xyz.com");
        WebElement subject = driver.findElement(By.xpath("//*[@id=\"wpforms-8-field_3\"]"));
        subject.sendKeys("Regarding Test");
        WebElement message = driver.findElement(By.xpath("//*[@id=\"wpforms-8-field_2\"]"));
        message.sendKeys("Message to test success");
/*
        fullName.sendKeys("name");
        email.sendKeys("name@xyz.com");
        subject.sendKeys("Regarding Test");
        message.sendKeys("Message to test success");*/

        //Find the login button using cssselector and click on login button
        WebElement submit = driver.findElement(By.cssSelector("#wpforms-submit-8"));

        //Click on login button
        submit.click();

        WebElement successMsg = driver.findElement(By.cssSelector("#wpforms-confirmation-8 > p"));
        System.out.println("Final Message is: " + successMsg.getText());

        //Close the browser
        driver.close();

    }
}
