package activities;

// Mountain bike extends Bicyle
public class MountainBike extends Bicycle{
    //add a new member for seat height.
    public int seatHeight;
    //Constructor for Mountain bike.
    public MountainBike(int gears, int speed, int seatHeight)
    {
        super(gears,speed);
        this.seatHeight=seatHeight;
    }
    //Set the seat height for mountain bike.
    public void setSeatHeight(int  newHeight)
    {
        this.seatHeight = newHeight;
    }
    //Fetch the description of the moutain bike bicycle.
    public String bicycleDescription()
    {
        return("Mountain Bike details are : " + "\n" + "Gears : " + gears + "\n" + "Speed : " + speed + "\n" + "seatHeight : " + seatHeight + "\n");
    }
}
