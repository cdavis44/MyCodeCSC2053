
//@author Clay Davis
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;

public class Project1Tester {

	public static void main(String[] args) {
		File file = new File("tom-sawyer.txt");
		String text = "";
		// try catch needed for reading in file
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				text += scan.nextLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error" + e + " found. Try again with a different file.");
			// error message
		}
		Project1 hm = new Project1();
		// instantiating Project1
		System.out.println("Top 10 Most Frequent Letters Sorted By Occurrence");
		hm.letterFrequency(text);
		System.out.println("Top 10 Most Frequent Words Sorted By Occurrence");
		hm.wordFrequency(text);
		// print statements 
		
		System.out.println("Top 10 Most Frequent Words Sorted By Occurrence (Stop List Included)");
		
		File file2 = new File("stop-list.txt");
		String stopList = "";
		// try catch needed for reading in file
		try {
			Scanner scan = new Scanner(file2);
			while (scan.hasNext()) {
				stopList += scan.nextLine() + " ";
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error" + e + " found. Try again with a different file.");
			// error message
		}

		hm.wordFrequencyStopList(text, stopList);

		System.out.println("How Many Times Is The Word 'Cat' Mentioned? " + hm.getWordCount());
		// wildcard (objective 4)
	}
}
