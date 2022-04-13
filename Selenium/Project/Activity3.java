package LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {

        //Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        //And now use this to visit the website
        driver.get("https://alchemy.hguy.co/lms");

        //Find the heading text using className()
        WebElement cssLocator = driver.findElement(By.cssSelector("#uagb-infobox-f08ebab0-fbf1-40ec-9b2a-c9feeb3d4810 > div > div > div > div.uagb-ifb-title-wrap > h3"));
        System.out.println("Text in element: " + cssLocator.getText());

        //Close the browser
        //driver.close();

           }
}
