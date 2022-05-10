package activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args){
        ArrayList<String> myList = new ArrayList<String>();
        //Add the elements to the list.
        myList.add("Orange");
        myList.add("Apple");
        myList.add("Mango");
        myList.add("Pineapples");
        myList.add("Grapes");
        //print the list
        for (String str : myList)
        {
            System.out.println(str);
        }
        //print the third element in the list.
        System.out.println("The third element in the list is : " + myList.get(2));
        System.out.println("Is Pineapple is in list: " + myList.contains("Pineapples"));
        System.out.println("Size of ArrayList: " + myList.size());
        myList.remove("Grapes");
        System.out.println("New Size of ArrayList: " + myList.size());
    }
}
