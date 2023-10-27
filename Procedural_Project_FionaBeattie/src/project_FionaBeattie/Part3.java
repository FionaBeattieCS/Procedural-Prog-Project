/**
 * 
 */
package project_FionaBeattie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This is a Class for CSC1025 Project Part 3
 * 
 * @author Fiona Beattie
 *
 */
public class Part3 {

	/**
	 * This main method outputs the results of the methods created for CSC1025
	 * Project Part 3
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// outputs the number of times the string wally is found
		System.out.println("Number of Occurrences: " + wheresWally1("Wally3.txt", "wally"));
		
		// adds an empty line between outputs
		System.out.println();

		// outputs the number of times the string wally is found
		System.out.println("Number of Occurrences: " + wheresWally1("verticallyDown.txt", "happy"));

		// adds an empty line between outputs
		System.out.println();

		// outputs the number of times the string wally is found
		System.out.println("Number of Occurrences: " + wheresWally1("WarAndPeace.txt", "wally"));
		// test result position: 66054, Num Occurrences: 9

		// adds an empty line between outputs
		System.out.println();

		// outputs the number of times the string wally is found
		System.out.println("Number of Occurrences: " + wheresWally1("WarAndPeace.txt", "java"));
		// test result position: 66054, Num occurrences 4

		// adds an empty line between outputs
		System.out.println();

		// outputs the number of times the string wally is found
		System.out.println("Number of Occurrences: " + wheresWally1("WarAndPeace.txt", "program"));
		// test result position: 66006, Num occurrences 3

		// separates the method outputs to make it easier to read
		System.out.println("*********************************************");

		// outputs the number of times the string wally is found
		System.out.println("Number of Occurrences: " + wheresWally2("diagUpDown.txt", "happy"));

		// adds an empty line between outputs
		System.out.println();

		// outputs the number of times the string wally is found
		System.out.println("Number of Occurrences: " + wheresWally2("WarAndPeaceDiag.txt", "wally"));

		// adds an empty line between outputs
		System.out.println();

		// outputs the number of times the string wally is found
		System.out.println("Number of Occurrences: " + wheresWally2("WarAndPeaceDiag.txt", "java"));
		// result position:

		System.out.println("*********************************************");

		///////////////////////////// TIMER
		///////////////////////////// CODE////////////////////////////////////////////////////////
		// starting the timer
		long beginTime = System.nanoTime();
		for (int i = 0; i < 20; i++) {
			wheresWally1("WarAndPeace.txt", "java");// invoke method
		}

		// stopping the timer
		long finishTime = System.nanoTime();
		// get difference
		long timeToCountWally = (finishTime - beginTime) / 20;
		System.out.println("Timer test: " + timeToCountWally / 1000000);

		// adds an empty line between outputs
		System.out.println();

		// starting the timer
		long beginTimer = System.nanoTime();
		for (int i = 0; i < 20; i++) {
			wheresWally2("WarAndPeaceDiag.txt", "java");// invoke method
		}

		// stopping the timer
		long finishTimer = System.nanoTime();
		// get difference
		long timeToCountWally2 = (finishTimer - beginTimer) / 20;
		System.out.println("Timer test: " + timeToCountWally2 / 1000000);

	}// end of main

	/**
	 * Method which takes two parameters fileName of type String and wally of type
	 * String and returns an int value. The method should return how many times the
	 * word wally appears in the given file when viewing the characters in the file
	 * vertically downwards rather than horizontally left-to-right. It should also
	 * write to the screen the line on which the first letter of the last occurrence
	 * of the wally string is found. The method should catch and throw all
	 * exceptions that are encountered.
	 * 
	 * @param fileName This is the given file to be read
	 * @param wally    This will be the string word which will be searched for
	 * @return This returns the number of times the string wally is found in the given file
	 * @throws IOException
	 */
	public static int wheresWally1(String fileName, String wally) throws IOException {

		// Open the File verticallyDown.txt
		File fileRead = new File(fileName); // Create search file for input
		FileReader fileReader;

		// Initialisation and Declaration of Variables
		String lineBeingRead = null;
		int numberOfLines = 0;
		int maxColumnCounter = 0;
		int wallyCount = 0;
		int firstLetterLastOccurrence = 0;

		try {

			fileReader = new FileReader(fileRead.getName());
			BufferedReader bufferReader = new BufferedReader(fileReader); // Create BufferedReader object
			lineBeingRead = bufferReader.readLine();

			// counts the number of lines being read
			while (lineBeingRead != null) {
				numberOfLines++;
				if (lineBeingRead.length() > maxColumnCounter) {
					maxColumnCounter = lineBeingRead.length();
				}
				lineBeingRead = bufferReader.readLine();
			}
		} catch (IOException ex) {
			throw ex;
			// ex.printStackTrace();
		}catch (Exception ex) {
			// TODO Auto-generated catch block
			throw ex;
		}

		// declaring the variables for the arrays
		String row = null;
		char[][] wordSearch = new char[numberOfLines][maxColumnCounter];
		int counter = 0;
		String wallyV2 = wally.toLowerCase(); // converts string to lowercase

		try {
			// Read the file
			FileReader fReader = new FileReader(fileRead.getName());
			BufferedReader bReader = new BufferedReader(fReader); // Create BufferedReader object
			row = bReader.readLine();

			while (row != null) {
				// Read and store the data in the arrays
				row = row.toLowerCase(); // converts all the file to lowercase and reads into 2d array
				for (int i = 0; i < row.length(); i++) {
					wordSearch[counter][i] = row.charAt(i);
				} // end for
				counter++;
				row = bReader.readLine();
			} // end while

			// for loops searching the array
			for (int rowCounter = 0; rowCounter < wordSearch.length - (wally.length() - 1); rowCounter++) {
				// loop through each element in the row
				for (int colCounter = 0; colCounter < wordSearch[rowCounter].length; colCounter++) {
					if (wordSearch[rowCounter][colCounter] == wallyV2.charAt(0)) {
						int currentRow = rowCounter + 1;

						for (int nextCharacter = 1; nextCharacter < wally.length(); nextCharacter++) {
							if (wordSearch[currentRow][colCounter] == wallyV2.charAt(nextCharacter)) {
								if (wallyV2.charAt(nextCharacter) == wallyV2.charAt(wally.length() - 1)
										&& (nextCharacter) == wally.length() - 1) {
									wallyCount++;
									firstLetterLastOccurrence = rowCounter + 1;
									break;
								} else {
									currentRow++;
								} // end else
							} else {
								break;
							}
						} // end for
					} // end if
				} // end for
			} // end for

			// System.out.println(wallyCount);
			System.out.println("Position of the first letter of the last occurrence: " + firstLetterLastOccurrence);

			// close resources
			bReader.close();
			fReader.close();

		} catch (FileNotFoundException ex) {
			throw ex;
			// System.out.println("The file does not exist");

		} catch (Exception ex) {
			// TODO Auto-generated catch block
			throw ex;
			// System.out.println("The given word is not present in the file");

		} finally {

		}
		// returns the number of times the string wally is found
		return wallyCount;
	}

	/**
	 * Method which takes two parameters fileName of type String and wally of type
	 * String and returns an int value. The method should return how many times the
	 * word wally appears in the given file when viewing the characters in the file
	 * diagonally up or down to the right, rather than horizontally or vertically.
	 * It should also write to the screen the line on which the first letter of the
	 * last occurrence of the wally string is found. The method should catch and
	 * throw all exceptions that are encountered.
	 * 
	 * @param fileName This is the given file to be read
	 * @param wally    This will be the string word which will be searched for
	 * @return This returns the number of times the string wally is found in the given file
	 * @throws IOException
	 */
	public static int wheresWally2(String fileName, String wally) throws IOException {

		// Open the File verticallyDown.txt
		File fileRead = new File(fileName); // Create search file for input
		FileReader fileReader;

		// Initialisation and Declaration of Variables
		String lineBeingRead = null;
		int numberOfLines = 0;
		int maxColumnCounter = 0;
		int wallyCount = 0;
		int firstLetterLastOccurrence = 0;

		try {

			fileReader = new FileReader(fileRead.getName());
			BufferedReader bufferReader = new BufferedReader(fileReader); // Create BufferedReader object
			lineBeingRead = bufferReader.readLine();

			// counts the number of lines being read
			while (lineBeingRead != null) {
				numberOfLines++;
				if (lineBeingRead.length() > maxColumnCounter) {
					maxColumnCounter = lineBeingRead.length();
				}
				lineBeingRead = bufferReader.readLine();
			}
		} catch (IOException ex) {
			throw ex;
			// ex.printStackTrace();
		}catch (Exception ex) {
			// TODO Auto-generated catch block
			throw ex;
		}

		// declaring the variables for the arrays
		String row = null;
		char[][] wordSearch = new char[numberOfLines][maxColumnCounter];
		int counter = 0;
		String wallyV2 = wally.toLowerCase(); // converts string to lowercase

		try {
			// Read the file
			FileReader fReader = new FileReader(fileRead.getName());
			BufferedReader bReader = new BufferedReader(fReader); // Create BufferedReader object
			row = bReader.readLine();

			while (row != null) {
				// Read and store the data in the arrays
				row = row.toLowerCase(); // converts all the file to lowercase and reads into 2d array
				for (int i = 0; i < row.length(); i++) {
					wordSearch[counter][i] = row.charAt(i);
				} // end for
				counter++;
				row = bReader.readLine();
			} // end while

			// for loops searching the array
			for (int rowCounter = 0; rowCounter < wordSearch.length - (wally.length() - 1); rowCounter++) {
				// loop through each element in the row
				for (int colCounter = 0; colCounter < wordSearch[rowCounter].length; colCounter++) {
					if (wordSearch[rowCounter][colCounter] == wallyV2.charAt(0)) {
						int currentRowDown = rowCounter + 1;
						int currentColDown = colCounter + 1;
						int currentRowUp = rowCounter - 1;
						int currentColUp = colCounter + 1;

						for (int nextCharacter = 1; nextCharacter < wally.length(); nextCharacter++) {
							if (wordSearch[currentRowDown][currentColDown] == wallyV2.charAt(nextCharacter)) {
								if (wallyV2.charAt(nextCharacter) == wallyV2.charAt(wally.length() - 1)
										&& (nextCharacter) == wally.length() - 1) {
									wallyCount++;
									firstLetterLastOccurrence = rowCounter + 1;
									break;
								} else {
									currentRowDown++;
									currentColDown++;
								} // end else
							} else {
								break;
							} // end else
						} // end for
						if (currentRowUp >= 0) {
							for (int nextCharacter = 1; nextCharacter < wally.length(); nextCharacter++) {
								if (wordSearch[currentRowUp][currentColUp] == wallyV2.charAt(nextCharacter)
										&& (currentRowUp >= 0)) {
									if (wallyV2.charAt(nextCharacter) == wallyV2.charAt(wally.length() - 1)
											&& (nextCharacter) == wally.length() - 1) {
										wallyCount++;
										firstLetterLastOccurrence = rowCounter + 1;
										break;
									} else {
										currentRowUp--;
										currentColUp++;
									} // end else
								} else {
									break;
								} // end else
							} // end else
						}
					} // end if
				} // end for
			} // end for

			// System.out.println(wallyCount);
			System.out.println("Position of the first letter of the last occurrence: " + firstLetterLastOccurrence);

			// close resources
			bReader.close();
			fReader.close();

		} catch (FileNotFoundException ex) {
			throw ex;
			// System.out.println("The file does not exist");

		} catch (Exception ex) {
			// TODO Auto-generated catch block
			throw ex;
			// System.out.println("The given word is not present in the file");

		} finally {

		}

		return wallyCount;
	}// end of method

}// end of class
