package LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {
    public static void main(String[] args) {

        //Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        //And now use this to visit the website
        driver.get("https://alchemy.hguy.co/lms");

        //Find the heading text using cssselector
        WebElement allCourses = driver.findElement(By.cssSelector("#menu-item-1508 > a"));

        //Click on allCourses
        allCourses.click();

        //Find courses and print no. of courses
        //WebElement nCourses = driver.findElement(By.id("//input[@name='entry-title']"));
        //System.out.println("The no of courses is : " + nCourses.isSelected());

        int totalLink = driver.findElements(By.xpath("//h3")).size();
        System.out.println("Total Links : " + totalLink);

        //Close the browser
        driver.close();
/*
        "//*[@id="post-69"]/div[2]/h3"
        //*[@id="post-71"]/div[2]/h3
        //*[@id="post-24042"]/div[2]/h3


        <h3 class="entry-title">Email Marketing Strategies</h3>

                <h3 class="entry-title">Email Marketing Strategies</h3>

                <h3 class="entry-title">Email Marketing Strategies</h3>*/
    }
}