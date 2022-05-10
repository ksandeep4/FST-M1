package activities;

public class Activity1 {
    public static void main(String[] args)
    {
        // //create new instance of the car
        Car toyota = new Car();
        // set values
        toyota.make = 2014;
        toyota.color = "Black";
        toyota.transmission = "Manual";

        //Using Car class method
        toyota.displayCharacterstics();
        toyota.accelerate();
        toyota.brake();
    }
}