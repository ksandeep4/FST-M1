package activities;

public class Activity2 {
    public static void main(String[] args) {
        //Initialize
        int intArray[] = {10, 77, 10, 54, -11, 10};
        int count = 0;
        //Loop
        for (int i : intArray)
            if (i == 10) count += 10;
        if (count == 30)
            System.out.println("sum of all the 10's in the array is exactly 30.");
    }
}
