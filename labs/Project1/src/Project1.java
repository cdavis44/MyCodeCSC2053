
//@author Clay Davis
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;

public class Project1 {

	static int wordCount = 0;

	// instance variable to track
	public static void letterFrequency(String text) {
		HashMap<Character, Integer> letterFrequency = new HashMap<Character, Integer>();
		char[] strArray = text.toCharArray();
		for (char c : strArray) {
			if (letterFrequency.containsKey(c) && Character.isLetter(c)) {

				// If char is present in charCountMap,
				// incrementing it's count by 1
				letterFrequency.put(c, letterFrequency.get(c) + 1);
			} else if (Character.isLetter(c) && Character.isLowerCase(c)) {

				// If char is not present in charCountMap,
				// putting this char to charCountMap with 1 as it's value
				letterFrequency.put(c, 1);
			}
		}

		int count = 0;
		for (Map.Entry entry : sortLetterByValue(letterFrequency).entrySet()) {
			if (count < 10) {
				System.out.println("Letter " + entry.getKey() + " Frequency: " + entry.getValue());
				count++;
			}
		}

	}

	public static void wordFrequency(String text) {

		ArrayList<String> fileLines = new ArrayList<>();
		HashMap<String, Integer> wordFrequency = new HashMap<String, Integer>();
		Scanner scanner = new Scanner(text);
		while (scanner.hasNext()) {
			fileLines.add(scanner.nextLine());
		}

		for (String line : fileLines) {
			Scanner scan = new Scanner(line);
			while (scan.hasNext()) {
				// this will read the line and separate out each word
				scan.useDelimiter("[^a-zA-Z']");
				String word = scan.next();
				word = word.toLowerCase();
				// replace all leading apostrophes
				word = word.replaceAll("^'+", "");
				// replace all trailing apostrophes
				word = word.replaceAll("'+$", "");
				/* now you have a word to put in your map */
				// Note: Make sure to check for empty String
				// don't put an empty string in the map
				if (word.equals("cat"))
					wordCount++;
				if (wordFrequency.containsKey(word))
					wordFrequency.put(word, wordFrequency.get(word) + 1);

				else if (!word.equals(""))
					wordFrequency.put(word, 1);
			}

		}

		int count = 0;
		// count is used to limit the printed map entries to never exceed 10
		for (Map.Entry entry : sortWordByValue(wordFrequency).entrySet()) {
			if (count < 10) {
				System.out.println("Word: " + entry.getKey() + " Frequency: " + entry.getValue());
				count++;
			}
		}

	}

	public static void wordFrequencyStopList(String text, String stopList) {
		ArrayList<String> fileLines = new ArrayList<String>();
		ArrayList<String> stopListList = new ArrayList<String>();
		// arraylist of stoplist words
		HashMap<String, Integer> wordFrequency = new HashMap<String, Integer>();
		Scanner scanner = new Scanner(text);

		while (scanner.hasNext()) {
			fileLines.add(scanner.nextLine());
		}

		scanner = new Scanner(stopList);

		while (scanner.hasNext()) {
			stopListList.add(scanner.next());
		}

		for (String line : fileLines) {
			Scanner scan = new Scanner(line);

			while (scan.hasNext()) {
				// this will read the line and separate out each word
				scan.useDelimiter("[^a-zA-Z']");
				String word = scan.next();
				word = word.toLowerCase();
				// replace all leading apostrophes
				word = word.replaceAll("^'+", "");
				// replace all trailing apostrophes
				word = word.replaceAll("'+$", "");
				/* now you have a word to put in your map */
				// Note: Make sure to check for empty String
				// don't put an empty string in the map

				if (wordFrequency.containsKey(word))
					wordFrequency.put(word, wordFrequency.get(word) + 1);

				else if (!word.equals("") && !stopListList.contains(word))
					wordFrequency.put(word, 1);
			}

		}

		int count = 0;
		// count is used to limit the printed map entries to never exceed 10
		for (Map.Entry entry : sortWordByValue(wordFrequency).entrySet()) {
			if (count < 10) {
				System.out.println("Word: " + entry.getKey() + " Frequency: " + entry.getValue());
				count++;
			}
		}

	}

	public static HashMap<Character, Integer> sortLetterByValue(HashMap<Character, Integer> hm) {
		// Create a list from elements of HashMap
		List<Map.Entry<Character, Integer>> list = new LinkedList<Map.Entry<Character, Integer>>(hm.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
			public int compare(Map.Entry<Character, Integer> o2, Map.Entry<Character, Integer> o1) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// put data from sorted list into hashmap
		HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>();
		for (Map.Entry<Character, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

	public static HashMap<String, Integer> sortWordByValue(HashMap<String, Integer> hm) {
		// Create a list from elements of HashMap
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o2, Map.Entry<String, Integer> o1) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// put data from sorted list into hashmap
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

	public static int getWordCount() {
		return wordCount;
		// gets wordCount instance variable
	}
}
