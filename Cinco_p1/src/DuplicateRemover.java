import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

//Create a utility class called DuplicateRemover.
public class DuplicateRemover {
    /*Create an instance method called remove that takes a single parameter called dataFile
    (representing the path to a text file) and uses a Set of Strings to eliminate duplicate words from dataFile.
     */
    // The unique words should be stored in an instance variable called uniqueWords.
    public Set<String> uniqueWords;

    public void remove(String dataFile) throws FileNotFoundException { //throws for the Scanner sc

        uniqueWords = new HashSet<String>(); //HashSet stores information
        String word;
        Scanner sc = new Scanner(new File(dataFile)); //check Figure 11.5.3: Reading a varying amount of data from a file. for scanner to get input from the file
        while (sc.hasNext()) {
            word = sc.next(); //to get words
            uniqueWords.add(word); //adds to the string
        }
        sc.close();
    }

    /*Create an instance method called write that takes a single parameter called outputFile
    (representing the path to a text file) and writes the words contained in uniqueWords to the file pointed to by outputFile.
     The output file should be overwritten if it already exists, and created if it does not exist.
     */
    public void write(String outputFile) throws IOException { //throws for the fw.write
        try {
            FileWriter fw = new FileWriter(outputFile); //used to write character-oriented data to a file
            String wordString = String.join(" ", uniqueWords); //to convert the array to words
            fw.write(wordString); //write wordstring into file
            fw.close(); //close for efficiency
        } catch (Exception e) {
            System.out.println("Could not open file " + outputFile + " for writing");
        }
    }
}
