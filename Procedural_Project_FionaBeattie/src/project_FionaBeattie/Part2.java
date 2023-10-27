/**
 * 
 */
package project_FionaBeattie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This is a Class for CSC1025 Project Part 2
 * 
 * @author Fiona Beattie
 *
 */
public class Part2 {

	/**
	 * This main method outputs the results of the methods created for CSC1025
	 * Project Part 2. This should be the only method to write anything to the screen
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Outputs encrypted letter
		System.out.println(shiftLetter(28, 'H'));
		System.out.println(shiftLetter(100, 'a'));
		System.out.println(shiftLetter(100, 'e'));

		// adds an empty line between method outputs
		System.out.println();

		// outputs encrypted message
		System.out.println(caesarEncrypt("Hello there!", 2));

		// outputs encrypted message
		System.out.println(caesarEncrypt("ABCDEF@", 28));

		// outputs encrypted message
		System.out.println(caesarEncrypt("Hello? 4", 104));

		// adds an empty line between method outputs
		System.out.println();

		// Outputs decrypted letter
		System.out.println(reverseLetterShift(28, 'J'));
		System.out.println(reverseLetterShift(100, 'w'));
		System.out.println(reverseLetterShift(100, 'a'));

		// adds an empty line between method outputs
		System.out.println();

		// outputs decrypted message
		System.out.println(caesarDecrypt("Jgnnq vjgtg!", 2)); // this method will take an encrypted string and decrypt
																// it back

		// outputs decrypted message
		System.out.println(caesarDecrypt("CDEFGH@", 28));

		// outputs encrypted message
		System.out.println(caesarEncrypt("Hello? 4", 104));

		// adds an empty line between method outputs
		System.out.println();

		// outputs how many times the word s appears in the given file
		System.out.println(countWordOccurrences("childrensRhyme.txt", "clock"));

		// outputs how many times the word s appears in the given file
		System.out.println(countWordOccurrences("childrensRhyme.txt", "dock"));

		// outputs how many times the word s appears in the given file
		System.out.println(countWordOccurrences("childrensRhyme.txt", "mouse"));

		// adds an empty line between method outputs
		System.out.println();

		// Creates a new file with all occurrences of an oldWord replaced with a newWord
		replaceWordOccurrences("originalFile.txt", "replaceFile.txt", "hat", "cap");

		// Creates a new file with all occurrences of an oldWord replaced with a newWord
		replaceWordOccurrences("childrensRhyme.txt", "replaceRhyme.txt", "Hickory", "Hello");

	}

	/**
	 * Method to encrypt a letter based on the number of shifts
	 * 
	 * @param shift This is the number of times the letter will be shifted
	 *              alphabetically right
	 * @param ch    This is the letter to be encrypted
	 * @return This returns the encrypted letter
	 */
	public static char shiftLetter(int shift, char ch) {

		if ((ch >= 'A') && (ch <= 'Z')) {
			int start = (int) 'A';
			int end = (int) 'Z';
			int currentPos = (int) ch;
			int newPos = start;
			int difference = end - currentPos;
			if (shift <= difference) {
				newPos = currentPos + shift;
			} else {
				newPos = start + (shift - difference - 1) % 26;/// %
			}
			return (char) newPos;
		} else if ((ch >= 'a') && (ch <= 'z')) {
			int start = (int) 'a';
			int end = (int) 'z';
			int currentPos = (int) ch;
			int newPos = start;
			int difference = end - currentPos;
			if (shift <= difference) {
				newPos = currentPos + shift;
			} else {
				newPos = start + (shift - difference - 1) % 26;/// %
			}
			return (char) newPos;
		}
		return ch;

	}

	/**
	 * Method called caesarEncrypt, which takes two parameters, s of type String and
	 * shift of type int. It should return another String value. The method should
	 * apply a Caesar Cipher to s using the right shift. Each letter should maintain
	 * the same case after it is encrypted. Only letters should be encrypted and all
	 * other characters should remain unchanged.
	 * 
	 * @param s     This is the string to be encrypted
	 * @param shift This is the number of times the letter will be shifted
	 *              alphabetically right
	 * @return This returns the encrypted string
	 */
	public static String caesarEncrypt(String s, int shift) {

		String caesarCipher = "";
		int charInt;
		char currentCharacter = ' ';

		for (int i = 0; i < s.length(); i++) {
			currentCharacter = shiftLetter(shift, (char) (s.charAt(i)));
			caesarCipher += currentCharacter;
		} // end loop

		return caesarCipher;
	}

	/**
	 * Method to decrypt a letter based on the number of shifts
	 * 
	 * @param shift This is the number of times the letter will be shifted
	 *              alphabetically left
	 * @param ch    This is the letter to be decrypted
	 * @return This returns the letter decrypted
	 */
	public static char reverseLetterShift(int shift, char ch) {

		if ((ch >= 'A') && (ch <= 'Z')) {
			int beginning = (int) 'Z';
			int finish = (int) 'A';
			int currentPosition = (int) ch;
			int newPosition = finish;
			int differenceOf = beginning - currentPosition;
			if (shift <= differenceOf) {
				newPosition = currentPosition - shift;
			} else {
				newPosition = beginning - (shift + differenceOf) % 26;/// %
			}
			return (char) newPosition;
		} else if ((ch >= 'a') && (ch <= 'z')) {
			int beginning = (int) 'z';
			int finish = (int) 'a';
			int currentPosition = (int) ch;
			int newPosition = finish;
			int differenceOf = beginning - currentPosition;
			if (shift <= differenceOf) {
				newPosition = currentPosition - shift;
			} else {
				newPosition = beginning - (shift + differenceOf) % 26;/// %
			}
			return (char) newPosition;
		}
		return ch;

	}

	/**
	 * Method called caesarDecrypt, which takes two parameters, s of type String and
	 * shift of type int. It should return another String value. The method should
	 * apply a Caesar Cipher to s using the left shift. Each letter should maintain
	 * the same case after it is decrypted.
	 * 
	 * @param s     This is the string to be decrypted
	 * @param shift This is the number of times the string will be shifted
	 *              alphabetically left
	 * @return This returns the decrypted string
	 */
	public static String caesarDecrypt(String s, int shift) {

		String textDecrypted = "";
		char currentChar = ' ';

		for (int i = 0; i < s.length(); i++) {
			currentChar = reverseLetterShift(shift, (char) (s.charAt(i)));
			textDecrypted += currentChar;
		} // end loop

		return textDecrypted;

	}

	/**
	 * Method called countWordOccurrences, which takes two parameters fileName of
	 * type String and s of type String and returns an int value. The method should
	 * return how many times the word s appears in the given file. The method should
	 * catch and throw all exceptions that are encountered.
	 * 
	 * @param fileName This is the given file to be read
	 * @param s        This will be the string word which will be searched for
	 * @return This returns the number of times that the string word is found in the
	 *         file 
	 * @throws IOException
	 */
	public static int countWordOccurrences(String fileName, String s) throws IOException {

		try {
			File file = new File(fileName); // search file for input
			FileReader filereader = new FileReader(file.getName()); // File Reader object
			BufferedReader bufferReader = new BufferedReader(filereader); // BufferedReader object

			// Initialising and declaring variables
			String[] findWord = null;
			String wordInput = s; // Input for word search
			int wordCount = 0;

			while ((s = bufferReader.readLine()) != null) { // Reads file content
				s = s.replaceAll("[0-9]", ""); // remove numbers
				s = s.replaceAll("[^a-zA-Z]+", " "); // remove special characters
				findWord = s.split(" "); // Split the word
				for (String search : findWord) {
					if (search.equalsIgnoreCase(wordInput)) { // Search for string s
						wordCount++; // if the string word is present increase the count each time
					}
				}
			}

			// close resources
			bufferReader.close();
			filereader.close();

			// return the number of times the word is found
			return wordCount;

		} catch (FileNotFoundException ex) {
			throw ex;
			// System.out.println("The file does not exist");

		} catch (IOException ex) {
			// ex.printStackTrace();
			throw ex;

		} catch (Exception ex) {
			throw ex;
			// System.out.println("Sorry, the program has encountered an error");

		} finally {

		}

	}

	/**
	 * Method called replaceWordOccurrences, which takes four parameters oldFileName
	 * of type String, newFileName of type String, oldWord of type String and
	 * newWord of type String and has no return.The method should write a new file
	 * with all occurrences of the oldWord replaced with newWord keeping the case of the
	 * first letter the oldWord when writing to the newFile.
	 * 
	 * @param oldFileName This is the original file to be read and copied
	 * @param newFileName This is the new file to be created and words replaced
	 * @param oldWord     This is the old word in the original file to be replaced
	 * @param newWord     This is the new word to replace all occurrences of the old
	 *                    word
	 * @throws IOException
	 */
	public static void replaceWordOccurrences(String oldFileName, String newFileName, String oldWord, String newWord)
			throws IOException {

		try {

			// copy file contents to another file
			File destinFile = new File(newFileName); // destination file
			FileReader fReader = new FileReader(oldFileName); // file reader object
			BufferedReader bReader = new BufferedReader(fReader); // buffer reader object

			String newFileText = "", oldFileText = "";
			while ((newFileText = bReader.readLine()) != null) {
				oldFileText += newFileText + "\r\n";
			}
			bReader.close();

			// update the first char of the search string convert to upper case
			String oldWordV2 = oldWord.toUpperCase().charAt(0) + oldWord.substring(1, oldWord.length());
			String newWordV2 = newWord.toUpperCase().charAt(0) + newWord.substring(1, newWord.length());

			// update the search string convert to lower case
			String oldWordV3 = oldWord.toLowerCase();
			String newWordV3 = newWord.toLowerCase();

			String replaceWords = "";

			FileWriter fWriter = new FileWriter(destinFile); // file writer object
			replaceWords = oldFileText.replaceAll(oldWordV2, newWordV2);
			replaceWords = replaceWords.replaceAll(oldWordV3, newWordV3);
			fWriter.write(replaceWords);

			// close resources
			fWriter.close();
			bReader.close();
		}

		catch (IOException ex) {
			throw ex;
			// ex.printStackTrace();
		} finally {

		}
	}

}
