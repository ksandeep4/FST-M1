package activities;

public class Activity7 {
    public static void main(String[] args)
    {
        //create a new instance of the  mountain bike.
        MountainBike mb = new MountainBike(3,0,25);
        //print the mountain bike's description.
        System.out.println(mb.bicycleDescription());
        //speed up the mountain bike.
        mb.speedUp(25);
        //applying brakes on mountain bike.
        mb.applyBrake(10);
    }
}
