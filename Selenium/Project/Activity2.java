package LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) {

        //Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        //And now use this to visit the website
        driver.get("https://alchemy.hguy.co/lms");

        //Find the heading text using className()
        WebElement classNameLocator = driver.findElement(By.className("uagb-ifb-title"));
        System.out.println("Text in element: " + classNameLocator.getText());

        //Close the browser
        driver.close();
    }
}