package activities;

public class Bicycle implements BicycleParts, BicycleOperations{
    int gears=0;
    int speed=0;
    //Constructor for Bicycle.
    public Bicycle(int gears, int speed) {
        this.gears=gears;
        this.speed=speed;
    }
    //Applying the brakes on bicycle.
    public void applyBrake(int decrement)
    {
        this.speed-=decrement;
        System.out.println("Current speed is : " + speed);
    }
    //Speed up the bicycle.
    public void speedUp(int increment)
    {
        this.speed+=increment;
        System.out.println("Current speed is : " + speed);
    }
    //Get the Bicycle description.
    public String bicycleDescription()
    {
        return("Bicycle : No of gears are : " + gears + " and speed is :  " + speed);
    }
}
