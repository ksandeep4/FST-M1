package LMS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ActivityOne {
    public static void main(String[] args) {

        //Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        //And now use this to visit the website
        driver.get("https://alchemy.hguy.co/lms");

        //Check the title of the page
        String title = driver.getTitle();
        //System.out.println("Page title is: " + title);

        //assertEquals(title,"Alchemy LMS – An LMS Application");
        if(title == "Alchemy LMS – An LMS Application") {
            System.out.println("Page title is: " + title);
        } else {
            System.out.println("Title not match");
        }
    }
}
/*
        //Objects.equals("Alchemy LMS – An LMS Application",
        //driver.getTitle());
        //Print the title of the page

        //  "Alchemy LMS – An LMS Application".contentEquals(driver.getTitle());
        //System.out.println("Page title is: " + title);

        // Assert.assertEquals("Alchemy LMS – An LMS Application",title);
        //Close the browser
        //driver.close();
    }

    public static void assertEquals(String title, String s) {
        s="Alchemy LMS – An LMS Application""

     }
}
 */