package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Random indexGen = new Random();
        int numb;
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println("Enter numbers: ");
        System.out.println("(non-integer to terminate): ");
        while(scan.hasNextInt())
        {
            numb = scan.nextInt();
            list.add(numb);
        }
        System.out.println(list);
        Integer[] nums =  list.toArray(new Integer[0]);
        //Print some elements from array at random indices.
        int index = indexGen.nextInt(nums.length);
        System.out.println("The element at index: " + index + " is : " + nums[index]);
        index = indexGen.nextInt(nums.length);
        System.out.println("The element at index: " + index + " is : " + nums[index]);
        index = indexGen.nextInt(nums.length);
        System.out.println("The element at index: " + index + " is : " + nums[index]);
        index = indexGen.nextInt(nums.length);
        System.out.println("The element at index: " + index + " is : " + nums[index]);
    }
}