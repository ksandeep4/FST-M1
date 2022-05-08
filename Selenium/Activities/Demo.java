package Activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo {
 public static void main(String[] args) throws Exception {
     WebDriver driver = new FirefoxDriver();

     //open the browser
     driver.get("https://google.com");

     //close the browser
     driver.close();
 }
}
