package activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args)
    {
        //Creating a HashSet.
        HashSet<String> hs = new HashSet<String>();
        //Adding elements to HashSet.
        hs.add("Apples");
        hs.add("Oranges");
        hs.add("Grapes");
        hs.add("Mangoes");
        hs.add("Bananas");
        hs.add("Pineapples");
        //Printing the HashSet before update.
        System.out.println("Printing the HashSet before update: " + hs);
        //Removing a particular element from the HashSet.
        hs.remove("Mangoes");
        //Remove an element if available otherwise print a message.
        if(hs.remove("Pears"))
        {
            System.out.println("Element does not exist");
        }
        else
        {
            System.out.println("Element is removed.");
        }
        //Search for an element.
        if(hs.contains("Apples"))
        {
            System.out.println("Apples is found in the given HashSet.");
        }
        else
        {
            System.out.println("Apples is not found in the given HashSet.");
        }
        //Printing the HashSet after update.
        System.out.println("Printing the HashSet after update: " + hs);
    }
}
