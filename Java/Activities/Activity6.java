package activities;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        Plane plane = new Plane(10);
        plane.onBoard("John");
        plane.onBoard("Steve");
        plane.onBoard("Anna");
        System.out.println("Passengers onboarded are : " + plane.getPassengers());
        System.out.println("Plane took of at time: " + plane.takeOff());
        Thread.sleep(5000);
        plane.land();
        System.out.println("Plane landed at  : " + plane.getLastTimeLanded());
        System.out.println("Passengers on the plan after landing are : " + plane.getPassengers());
    }
}
