package LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {
    public static void main(String[] args) {

        //Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        //And now use this to visit the website
        driver.get("https://alchemy.hguy.co/lms");

        //Find the heading text using cssselector
        WebElement cssLocator = driver.findElement(By.cssSelector("#menu-item-1507 > a"));
        System.out.println("Text in element: " + cssLocator.getText());

        //Click on MyAccount
        cssLocator.click();

        //Check the title of the page
        String title = driver.getTitle();
        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Find the login button using cssselector
        WebElement csslogin = driver.findElement(By.cssSelector("#uagb-column-e9d225cb-cee9-4e02-a12d-073d5f051e91 > div.uagb-column__inner-wrap > div.learndash-wrapper > a"));
        System.out.println("Text in element: " + csslogin.getText());

        //Click on login button
        csslogin.click();

        //find username and password to send input
        WebElement username = driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"user_pass\"]"));

        username.sendKeys("root");
        password.sendKeys("pa$$w0rd");

        //Find the login button using cssselector and click on login button
        WebElement submit = driver.findElement(By.cssSelector("#wp-submit"));

        //Click on login button
        submit.click();

        //Close the browser
        driver.close();
    }
}
