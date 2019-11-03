import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.*;

//Create a utility class called DuplicateRemover.
public class DuplicateCounter {
    /*Create a class called DuplicateCounter. Create an instance method called count that takes a single parameter called dataFile
    (representing the path to a text file) and uses a Map of Strings to count how many times each word occurs in dataFile.
     */
    // The counts should be stored in an instance variable called wordCounter.
    private Map<String,Integer> wordCounter;

    public void count(String dataFile) throws FileNotFoundException { //throws for the Scanner sc

        wordCounter = new HashMap <String,Integer> ();
        String word;
        Scanner sc = new Scanner(new File(dataFile)); // the set will only store unique words
        while(sc.hasNext()) {
            word=sc.next();
            if (wordCounter.containsKey(word)) {
                wordCounter.put(word, wordCounter.get(word) + 1);
            }
            else {
                wordCounter.put(word, 1);
            }
        }
        sc.close();

    }

    /*Create an instance method called write that takes a single parameter called outputFile (representing the path to a text file)
    and writes the contents of wordCounter to the file pointed to by outputFile. The output file should be overwritten if it already
    exists, and created if it does not exist.
     */
    public void write(String outputFile) throws IOException { //throws for the fw.write
        FileWriter fw=new FileWriter(new File(outputFile));
        for (Map.Entry<String, Integer> entry : wordCounter.entrySet())
            fw.write(entry.getKey() + " " + entry.getValue()+"\n");

        fw.write("words in the file :"+wordCounter+"\n");
        fw.close();
        }
    }

