package activities;

public class Activity4 {
    public static void main(String[]args) {
        //Initialize the arrary.
        int intArr[] = {4, 3, 2, 10, 12, 1, 5, 6};
        //Find the length of the array to be used while running the loops.
        int len = intArr.length;
        //Declare key element and i, j variables.
        int key;
        int i,j;
        //Print the set of numbers before sorting.
        for (i = 0; i < len; i++)
            System.out.println(intArr[i]);
        //Apply the insertion sort logic to sort the given array of integers.
        for (i = 1; i < len; i++) {
            //Take a number.
            key = intArr[i];
            //If the given number is less than the number with which it is compared, move it to left,
            //if not to the right.
            for (j = i-1; (j >= 0)&&(key>intArr[j]);j--)
                intArr[j+1] = intArr[j];
            intArr[j+1]=key;
        }
        //Print the set of numbers after sorting.
        for (i = 0; i < len; i++)
            System.out.println(intArr[i]);
    }
}
