package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;

    public Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        passengers = new ArrayList<>();
    }
    public void onBoard(String passenger)
    {
        //Add passenger to the list of passengers.
        passengers.add(passenger);
    }
    public Date takeOff()
    {
        // record the last time that plane took off
        this.lastTimeTookOf = new Date();
        return lastTimeTookOf;
    }
    public void land()
    {
        //record the plane's landing time.
        this.lastTimeLanded = new Date();
        this.passengers.clear();
    }
    public Date getLastTimeLanded()
    {
        // get the last time plane has landed.
        return this.lastTimeLanded;
    }

    public List<String> getPassengers() {
        //get the list of passenges who boarded the plane.
        return passengers;
    }
}