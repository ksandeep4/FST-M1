package activities;

import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args)
    {
        //Create a HashMap Object.
        HashMap <Integer,String> hm = new HashMap<Integer,String> ();
        //Add Key , value pairs to given HashMap object.
        hm.put(1,"Violet");
        hm.put(2,"Indigo");
        hm.put(3,"Blue");
        hm.put(4,"Green");
        hm.put(5,"Yellow");
        //Print the original HashMap
        System.out.println("The original HashMap is : " + hm);
        hm.remove(2);
        //Print the HashMap after removing an item.
        System.out.println("After removing an element is : " + hm);
        //verify if an element exists in the HashMap
        if(hm.containsValue("Green"))
        {
            System.out.println("Green Color is available in the given HashMap.");
        }
        else
        {
            System.out.println("Green Color is not available in the given HashMap.");
        }
        //Print the sie of the given HashMap.
        System.out.println("The number of pairs in the given HashMap is : " + hm.size());
    }
}
