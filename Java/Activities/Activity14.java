package activities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Activity14 {
    public static void main(String[] args) throws IOException
    {
        try
        {
            File file = new File("C:\\Users\\Administrator\\IdeaProjects\\FSTB33-Java\\src\\main\\java\\org\\example\\newfile.txt");
            boolean fStatus = file.createNewFile();
            if(fStatus) {
                System.out.println("File created successfully!");
            } else {
                System.out.println("File already exists at this path.");
            }
            //Get the file object.
            File fileUtil = FileUtils.getFile("C:\\Users\\Administrator\\IdeaProjects\\FSTB33-Java\\src\\main\\java\\org\\example\\newfile.txt");
            //Read the file.
            System.out.println("Contents of the given file are : " + FileUtils.readFileToString(fileUtil,"UTF-8"));
            //Create a directory.
            File destDir = new File("resources");
            //Copy the file to the directory.
            FileUtils.copyFileToDirectory(file,destDir);
            //Get the file from new directory.
            File newFile = FileUtils.getFile(destDir,"newfile.txt");
            //Copy the content of the file to a string.
            String newFileData = FileUtils.readFileToString(newFile,"UTF-8");
            //Print the copied content.
            System.out.println("Data in new file is : " + newFileData);

        }catch(IOException errMessage)
        {
            System.out.println("IO Exception occurred.");
        }
    }
}
