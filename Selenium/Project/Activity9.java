package LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity9 {
    public static void main(String[] args) {

        //Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        //And now use this to visit the website
        driver.get("https://alchemy.hguy.co/lms");

        //Find the heading text using cssselector
        WebElement allCourses = driver.findElement(By.cssSelector("#menu-item-1508 > a"));

        //Click on allCourses
        allCourses.click();

        //select any course and click it
        WebElement newCourseimg = driver.findElement(By.cssSelector("#post-69 > a > img"));
        newCourseimg.click();

        WebElement newCourse = driver.findElement(By.cssSelector("#ld-expand-83 > div.ld-item-list-item-preview > a > div.ld-item-title"));
        newCourse.click();
        //Print title
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);

        //Close the browser
        driver.close();

    }
}
