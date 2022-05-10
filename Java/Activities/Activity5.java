package activities;

//Create an abstract class called Book.
abstract class Book {
    String title;
    //Create an abstract method setTitle.
    abstract void setTitle(String s);
    //Create a method to return title fo the book.
    String getTitle()
    {
        return(title);
    }
}
class MyBook extends Book {
    //Method to implement the abstract class defined in Book Class.
    void setTitle(String s)
    {
        title=s;
    }
}
public class Activity5
{
    public static void main(String[] args)
    {
        //Create an instance of the class MyBook.
        MyBook book1 = new MyBook();
        //Call the setTitle method.
        book1.setTitle("India, that is Bharat");
        //Use the getTitle method to print the title of the book.
        System.out.println("The title of the book is : " + book1.getTitle());
    }
}
