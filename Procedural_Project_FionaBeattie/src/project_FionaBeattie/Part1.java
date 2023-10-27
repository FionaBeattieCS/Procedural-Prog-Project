/**
 * 
 */
package project_FionaBeattie;

import java.util.Arrays;

/**
 * This is a Class for CSC1025 Project Part 1
 * 
 * @author Fiona Beattie
 *
 */
public class Part1 {

	/**
	 * This main method outputs the results of the methods created for CSC1025
	 * Project Part 1. This should be the only method to write anything to the screen
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// outputs true if letter is upper case
		System.out.println(isLetter('D'));
		// outputs true if letter is lower case
		System.out.println(isLetter('z'));
		// outputs false if a number is passed
		System.out.println(isLetter('5'));

		// adds an empty line between method outputs
		System.out.println();

		// outputs true if the two letters match ignoring the case
		System.out.println(isSameLetterIgnoreCase('A', 'a'));

		// outputs true if the two letters match ignoring the case
		System.out.println(isSameLetterIgnoreCase('a', 'b'));

		// outputs false if one letter and one number is passed
		System.out.println(isSameLetterIgnoreCase('h', '1'));

		// adds an empty line between methods outputs
		System.out.println();

		// outputs the result of method longestWord
		System.out.println(longestWord("hello there my number is 123456789 and my name is Allister"));

		// outputs the result of method longestWord
		System.out.println(longestWord("hello there, Allister's number is 123456789"));

		// outputs the result of method longestWord
		System.out.println(longestWord("Hello, my email address is fbeattie01@qub.ac.uk"));

		// adds an empty line between methods outputs
		System.out.println();

		// outputs the count of the different letters in a string
		System.out.println(countDifferentLetters("Hello there"));

		// outputs the count of the different letters in a string
		System.out.println(countDifferentLetters("Good bye"));

		// outputs the count of the different letters in a string
		System.out.println(countDifferentLetters("Hello here I am"));

		// adds an empty line between methods outputs
		System.out.println();

		// test the output of mostCommonLetter in string s
		System.out.println(mostCommonLetter("Hello there"));

		// test the output of mostCommonLetter in string s
		System.out.println(mostCommonLetter("Good bye"));

		// test the output of mostCommonLetter in string s
		System.out.println(mostCommonLetter("Hello look at me"));

		// adds an empty line between methods outputs
		System.out.println();

		// test the output of mostCommonLetter in string s
		System.out.println(countUniqueWords("A long long time ago, I can still remember.."));

		// test the output of mostCommonLetter in string s
		System.out.println(countUniqueWords("It was the best of times, it was the worst of times..."));

		// test the output of mostCommonLetter in string s
		System.out.println(countUniqueWords("A trip of a lifetime!"));
	}

	/**
	 * Method called isLetter, which takes a parameter ch of type char and returns a
	 * value of type boolean. If ch is a letter from a..z or A..Z then it returns
	 * true otherwise it returns false.
	 * 
	 * @param ch This is the character to be checked
	 * @return This returns a true of false boolean value
	 */
	public static boolean isLetter(char ch) {

		if ((ch >= 'A') && (ch <= 'Z') || ((ch >= 'a') && (ch <= 'z'))) {
			return true;
		}
		return false;

	}

	/**
	 * Method called isSameLetterIgnoreCase, which takes two parameters ch1 and ch2,
	 * both of type char and returns a value of type boolean. If ch1 and ch2 are the
	 * same letter then it returns true otherwise false.
	 * 
	 * @param ch1 This is the first character to be checked
	 * @param ch2 This is the second character to be checked
	 * @return This returns a true of false boolean value
	 */
	public static boolean isSameLetterIgnoreCase(char ch1, char ch2) {

		if ((ch1 >= 'A') && (ch1 <= 'Z')) {
			int asciiCode1 = ch1 + 32;
			ch1 = (char) asciiCode1;

		}

		if ((ch2 >= 'A') && (ch2 <= 'Z')) {
			int asciiCode1 = ch2 + 32;
			ch2 = (char) asciiCode1;

		}

		if (ch1 == ch2 && (ch1 >= 'a') && (ch1 <= 'z') && (ch2 >= 'a') && (ch2 <= 'z')) {
			return true;
		}

		return false;

	}

	/**
	 * Method called longestWord, which takes one parameter s of type String and
	 * returns a String value. The method should return the longest word in s. A
	 * word is considered any string of characters that are all letters separated by
	 * any non-letter.
	 * 
	 * @param s The string sentence which will be checked
	 * @return This method returns the longest string
	 */
	public static String longestWord(String s) {

		// removes numbers and special characters from the string
		s = s.replaceAll("[0-9]", "");
		s = s.replaceAll("[^a-zA-Z]+", " ");

		String myStringArray[] = s.split(" "); // Separates each word in the string s and stores it into an array

		s = myStringArray[0]; // consider the first word to be the largest in the string s

		for (String myString : myStringArray)
			if (s.length() < myString.length()) // check the length of each word in the string s
				s = myString;

		return s;

	}

	/**
	 * Method called countDifferentLetters, which takes one parameter s of type
	 * String and returns an int value. The method should return how many different
	 * letters were in s.
	 * 
	 * @param s The string sentence which will be checked to count the number of
	 *          different letters
	 * @return This method returns the count of different letters
	 */
	public static int countDifferentLetters(String s) {

		String s1 = s.toLowerCase(); // converts string s to lower case for comparison
		// System.out.println(s1); testing output

		String tempString = "";

		for (int i = 0; i < s1.length(); i++) {
			if (tempString.indexOf(s1.charAt(i)) == -1 && s1.charAt(i) != ' ') {
				tempString = tempString + s1.charAt(i);
			}
		}

		int difCount = tempString.length();

		return difCount;

	}

	/**
	 * Method called mostCommonLetter, which takes one parameter s of type String
	 * and returns a char value. The method should return the letter that occurs
	 * most often in s. If more than one letter occurs the most often then the one
	 * which is first alphabetically should be returned.
	 * 
	 * @param s The string sentence which will be checked to count the most common
	 *          letters found
	 * @return This method returns the most common letter found in the string
	 */
	public static char mostCommonLetter(String s) {

		char highestCharacter = 0;
		int highestTotal = 0;
		;

		// convert to char array
		for (int i = 0; i < s.length(); i++) {
			char item = s.charAt(i);
			int totalCharacter = 0;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					totalCharacter++;
				}
			}
			if (totalCharacter > highestTotal) { // if two letters have the same count output the highest alphabetically
				highestCharacter = s.charAt(i);
				highestTotal = totalCharacter;
			}
		}
		// System.out.println("number of repeated letters = "+highestCharacter); testing
		// output for repeated letters
		return highestCharacter;

	}// end of method

	/**
	 * Method called countUniqueWords, which takes one parameter s of type String
	 * and returns an int value. The method should return how many different words
	 * were in s.
	 * 
	 * @param s The string sentence which will be checked to count the number of
	 *          unique words
	 * @return This method returns the count of unique words in the string
	 */
	public static int countUniqueWords(String s) {

		// removes numbers and special characters from the string
		s = s.replaceAll("[0-9]", "");
		s = s.replaceAll("[^a-zA-Z]+", " ");

		String s1 = s.toLowerCase(); // converts the string to lower case for comparison
		String[] sentenceArray = s1.split(" "); // Splits the words from String s and stores it into an
												// array
		Arrays.sort(sentenceArray);
		// for (int i=0;i<sentenceArray.length;i++) { //testing for printing the array
		// System.out.println(sentenceArray[i]);
		// }

		int sameWords = 0; // stores the count of repeated words
		int uniqueWords = 0;

		// For loop to compare strings in the sentence array
		for (int i = 0; i < sentenceArray.length; i++) { // outer loop
			sameWords = 0;
			for (int j = i + 1; j < sentenceArray.length; j++) { // inner loop
				if (sentenceArray[i].equals(sentenceArray[j])) { // Checks that the strings are equal/ same
					sameWords++; // if the words found are the same increment the count
				}
			} // end of inner loop
			if (sameWords > 0) {

			} else {
				uniqueWords++;
			}

		} // end of outer loop

		// returns the number of unique words found
		return uniqueWords;
	}
}
