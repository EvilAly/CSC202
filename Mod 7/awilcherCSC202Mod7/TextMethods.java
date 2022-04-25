package awilcherCSC202Mod7;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextMethods {

	public static List<String> readInWords() {
		List<String> temp = new ArrayList<>();

		// get file location
		String file = FileLoc.pickLocRead();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
		} catch (IOException ioe) {
			System.out.println("File not found. Try again.");
			file = FileLoc.pickLocRead();
		}

		// read in each word and add to List
		String line;
		try {
			line = in.readLine();

			while (line != null) {
				line = line.toLowerCase();
				line = line.replaceAll("\\p{Punct}", " ");
				StringTokenizer st = new StringTokenizer(line, " ");
				while (st.hasMoreTokens()) {
					// Read a record from the file.
					String word = st.nextToken();

					temp.add(word);
				}
				line = in.readLine();

			}
		} catch (IOException e1) {

			e1.printStackTrace();
		}

		return temp;
	}

	public static void normalizeText(List<String> text) {
		String word;
		for (int i = 0; i < text.size(); i++) {
			word = text.remove(i);
			if (word.contains("\\p<Punct}")) {
				// this line was borrowed from
				// https://www.delftstack.com/howto/java/how-to-remove-punctuation-from-string-in-java/
				word = word.replaceAll("\\p{Punct}", "");
				word = word.replaceAll("- ", "");
				word = word.toLowerCase();
			}
			text.add(i, word);

		}
	}

	public static Map<String, Integer> mapText(List<String> text) {
		Map<String, Integer> count = new HashMap<String, Integer>();
		// normalizeText(text);

		for (String word : text) {

			if (count.containsKey(word)) {
				int num = count.get(word);
				count.put(word, num + 1);
			} else
				count.put(word, 1);
		}
		return count;

	}

	public static void uniqueWords(List<String> text) {
		// normalizeText(text);
		Map<String, Integer> counted = mapText(text);
		System.out.println("There are " + counted.size() + " unique words in your text.");

	}

	public static void wordTable(List<String> text) {
		// normalizeText(text);
		TreeMap<Integer, Integer> wordLen = new TreeMap<Integer, Integer>();

		for (String word : text) {
			int len = word.length();
			if (wordLen.containsKey(len)) {
				int num = wordLen.get(len);
				wordLen.put(len, num + 1);
			} else
				wordLen.put(len, 1);
		}

		Set<Integer> count = wordLen.keySet();

		for (Integer key : count) {
			System.out.println("There are " + wordLen.get(key) + " words with " + key + " character(s).");
		}

	}

	public static void searchCount(List<String> text) {
		Scanner s = new Scanner(System.in);
		System.out.println("\nWhat word would you like to search for?");
		String search = s.nextLine().toLowerCase();

		int count = 0;
		for (String word : text) {
			if (search.equals(word)) {
				count++;
			}
		}

		if (count == 0) {
			System.out.println(search + " does not appear in the text.");
		} else {
			System.out.println(search + " appears in the text " + count + " times.");
		}

	}

	public static void topTen(List<String> text) {
		Map<String, Integer> counted = mapText(text);
		ArrayList<Words> words = new ArrayList<Words>();

		Set<String> keys = counted.keySet();
		for (String key : keys) {
			Words w = new Words(key, counted.get(key));
			words.add(w);
		}

		// this code was borrowed from
		// https://algorithms.tutorialhorizon.com/override-list-collections-sort-method/
		Collections.sort(words, new Comparator<Words>() {
			@Override
			public int compare(Words w1, Words w2) {
				return -(w1.getValue() - w2.getValue());
			}
		});

		System.out.println("The top 10 words used are:");
		int print = 0;
		while (print < 10) {
			System.out.println(words.get(print).toString());
			;
			print++;

		}

	}

	public static List<String> readInLines() {
		List<String> temp = new ArrayList<>();

		// get file location
		String file = FileLoc.pickLocRead();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
		} catch (IOException ioe) {
			System.out.println("File not found. Try again.");
			file = FileLoc.pickLocRead();
		}

		// read in each word and add to List
		String line;
		try {
			line = in.readLine();
			while (line != null) {

				temp.add(line);
				line = in.readLine();
			}
		} catch (

		IOException e1) {

			e1.printStackTrace();
		}

		return temp;

	}

	public static void applyCipher() {
		Map<Character, Character> cipher = createCipher();

		System.out.println("\nTo start, we need a fresh instance of your text.");
		List<String> text = readInLines();
		List<String> encrypt = new ArrayList<String>();
		String oldLine;
		Character code;
		Character value;
		for (int i = 0; i < text.size(); i++) {
			oldLine = text.get(i);
			String newLine = "";
			if (!oldLine.isBlank()) {
				for (int j = 0; j < oldLine.length(); j++) {
					code = oldLine.charAt(j);
					if (cipher.containsKey(code)) {
						value = cipher.get(code);
						newLine = newLine + value;
					} else {
						newLine = newLine + code;
					}

				}
			} else {
				newLine = oldLine;
			}

			encrypt.add(newLine);
		}

		System.out.println("\nThe first 30 lines of this encrypted text are as follows:");
		for (int i = 0; i < 30; i++) {
			System.out.println(encrypt.get(i));
		}

		writeCipherFile(cipher);

		writeEncryptedFile(encrypt);

	}

	public static void writeCipherFile(Map<Character, Character> map) {
		System.err.println("\nNow let's save your CIPHER file so it can be saved later.");

		String filename = FileLoc.pickLocOut();

		File file = new File(filename);

		// Open the file.
		PrintWriter outputFile = null;
		try {
			outputFile = new PrintWriter(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		// Get data and write it to the file.
		Set<Character> keys = map.keySet();
		for (Character key : keys) {
			String line = key + "|" + map.get(key);

			// Write the name to the file.
			outputFile.println(line);
		}

		// Close the file.
		outputFile.close();
		System.out.println("Cipher Key has been written to the file.");

	}

	public static void writeEncryptedFile(List<String> text) {
		System.err.println("\nNow we'll save your ENCRYPTED text.");

		String filename = FileLoc.pickLocOut();

		File file = new File(filename);

		// Open the file.
		PrintWriter outputFile = null;
		try {
			outputFile = new PrintWriter(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		// Get data and write it to the file.
		for (String line : text) {

			// Write the name to the file.
			outputFile.println(line);
		}

		// Close the file.
		outputFile.close();
		System.out.println("Encrypted text has been written to the file.");

	}

	public static Map<Character, Character> createCipher() {
		Map<Character, Character> cipher = new TreeMap<Character, Character>();
		ArrayList<Integer> randInts = new ArrayList<Integer>();

		// create array for random values
		for (int i = 65; i < 91; i++) {
			randInts.add(i);
		}
		for (int i = 97; i < 123; i++) {
			randInts.add(i);
		}

		Collections.shuffle(randInts);

		int alcount = 0;
		for (int i = 0; i < 58; i++) {
			int num = 65 + i;
			if (num > 90 && num < 97) {
				continue;
			} else {
				char key = (char) num;
				char value = (char) ((int) (randInts.get(alcount)));
				alcount++;
				cipher.put(key, value);
			}
		}

		return cipher;
	}

	public static void decrypt() {
		List<String> encrypted = new ArrayList<String>();
		System.err.println("\nFirst, we need to read in the encrypted file.\n");
		encrypted = readInLines();

		System.err.println("Now, we need to read in the code to decrypt the file.\n");
		Map<Character, Character> key = readInCode();

		List<String> text = new ArrayList<String>();
		String oldLine;
		Character code;
		Character value;
		for (int i = 0; i < encrypted.size(); i++) {
			oldLine = encrypted.get(i);
			String newLine = "";
			if (!oldLine.isBlank()) {
				for (int j = 0; j < oldLine.length(); j++) {
					code = oldLine.charAt(j);
					if (key.containsKey(code)) {
						value = key.get(code);
						newLine = newLine + value;
					} else {
						newLine = newLine + code;
					}

				}
			} else {
				newLine = oldLine;
			}

			text.add(newLine);
		}

		System.out.println("\nThe first 30 lines of the decrypted text are as follows:");
		for (int i = 0; i < 30; i++) {
			System.out.println(text.get(i));
		}

	}

	public static Map<Character, Character> readInCode() {
		Map<Character, Character> temp = new HashMap<Character, Character>();

		// get file location
		String file = FileLoc.pickLocRead();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
		} catch (IOException ioe) {
			System.out.println("File not found. Try again.");
			file = FileLoc.pickLocRead();
		}

		// read in each word and add to List
		String line;
		try {
			line = in.readLine();

			while (line != null) {
				StringTokenizer st = new StringTokenizer(line, "|");
				char original = st.nextToken().charAt(0);
				char change = st.nextToken().charAt(0);

				temp.put(change, original);
				line = in.readLine();
			}

		} catch (

		IOException e1) {
			e1.printStackTrace();
		}

		return temp;
	}

}
