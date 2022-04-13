package LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 {
    public static void main(String[] args) {

        //Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        //And now use this to visit the website
        driver.get("https://alchemy.hguy.co/lms");

        //Find the heading text using className()
        WebElement cssLocator = driver.findElement(By.cssSelector("#menu-item-1507 > a"));
        System.out.println("Text in element: " + cssLocator.getText());

        //Click on MyAccount
        cssLocator.click();

        //Check the title of the page
        String title = driver.getTitle();
        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Close the browser
        driver.close();
    }
}

