package testNGTests;

import org.testng.annotations.Test;

public class DemoOne {
    @Test
    public void tc1() {
        System.out.println("I am in first tc from DemoOne class");
    }

    @Test
    public void tc2()
    {
        System.out.println("I am in second tc from DemoOne class");

    }
}