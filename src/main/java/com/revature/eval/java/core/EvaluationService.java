package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		String reversed = new String();
		for(int i = string.length() - 1; i >= 0; i--) {
			reversed += string.charAt(i);
		}
		return reversed;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		String acronym = new String();
		String[] words = phrase.split("\\W");
		for(int i = 0; i < words.length; i++) {
			if(words[i].equals("")) {
				continue;
			}
			acronym += words[i].charAt(0);
		}
		return acronym.toUpperCase();
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			return (this.sideOne == this.sideThree && this.sideOne == this.sideTwo);
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			return (this.sideOne == this.sideThree || this.sideOne == this.sideTwo || 
					this.sideTwo == this.sideThree);
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			return !(this.sideOne == this.sideThree && this.sideOne == this.sideTwo);
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		int score = 0;
		char letter;
		for(int i = 0; i < string.length(); i++) {
			letter = string.toUpperCase().charAt(i);
			if(letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' ||
					letter =='U' || letter =='L' || letter == 'N' ||
					letter == 'R' || letter == 'S' || letter == 'T') {
				score += 1;
			}
			else if(letter == 'D' || letter == 'G') {
				score += 2;
			}
			else if(letter =='B' || letter=='C' || letter =='M' || letter == 'P') {
				score += 3;
			}
			else if(letter == 'F' || letter == 'H' || letter == 'V' || letter == 'W' ||
					letter == 'Y') {
				score += 4;
			}
			else if(letter == 'K') {
				score += 5;
			}
			else if(letter == 'J' || letter == 'X') {
				score += 8;
			}
			else if(letter == 'Q' || letter == 'Z') {
				score += 10;
			}
			else {
				
			}
			
		}
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		String[] numbers = string.split("\\W");
		String number = new String();
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i].equals("")) {
				continue;
			}
			number = number.concat(numbers[i]);
		}
		if(number.length() > 11 || number.split("\\d").length > 1)
		{
			throw new IllegalArgumentException();
		}
		return number;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		String words[] = string.split("\\W");
		Map<String, Integer> count = new HashMap<>();
		for(String word : words) {
			if(word.equals("")) {
				continue;
			}
			if(count.containsKey(word)) {
				count.put(word, count.get(word) + 1);
			}
			else {
				count.put(word, 1);
			}
		}
		return count;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			int index = this.sortedList.size() / 2;
			float temp;
			for(int i = 0; i < Math.ceil(Math.log(this.sortedList.size())); i++) {
				temp = index;
				if((int)t == (int)this.sortedList.get(index)) {
					return index;
				}
				else if((int)t > (int)this.sortedList.get(index)) {
					index += Math.ceil(temp/2);
				}
				else {
					index -= Math.ceil(temp/2);
				}
			}
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		if(string.contains(" ")) {
			String[] words = string.split(" ");
			for(int i = 0; i < words.length; i++) {
				while(!(words[i].charAt(0) == 'a' || words[i].charAt(0) == 'e' || words[i].charAt(0) == 'i'
						|| words[i].charAt(0) == 'o' || words[i].charAt(0) == 'u')) {
					char con = words[i].charAt(0);
					words[i] = words[i].substring(1) + con;
					if(con == 'q') {
						con = words[i].charAt(0);
						words[i] = words[i].substring(1) + con;
					}
				}
				words[i] += "ay";
			}
			String newString = "";
			for(int i = 0; i < words.length; i++) {
				newString += words[i] + " ";
			}
			string = newString.substring(0, newString.length() - 1);
		}
		else {
			while(!(string.charAt(0) == 'a' || string.charAt(0) == 'e' || string.charAt(0) == 'i'
					|| string.charAt(0) == 'o' || string.charAt(0) == 'u')) {
				char con = string.charAt(0);
				string = string.substring(1) + con;
				if(con == 'q') {
					con = string.charAt(0);
					string = string.substring(1) + con;
				}
			}
			string += "ay";
			
		}
		return string;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		int size = (int)Math.log10(input) + 1;
		int[] numbers = new int[size];
		int sum = 0;
		int temp = input;
		for(int i = 0; i < size; i++) {
			//get the last digit by getting the remainder of 10
			numbers[i] = temp % 10;
			//cut off that last digit
			temp /= 10;
		}
		
		for(int i = 0; i < size; i++) {
			sum += Math.pow(numbers[i], size);
		}
		if(sum == input) {
			return true;
		}
		return false;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		List<Long> factors = new ArrayList<Long>();
		factors.add(l);
		boolean prime = true;
		int temp = (int) (l/2);
		for(int i = 2; i <= temp; i++) {
			while(l % i == 0) {
				factors.add((long)i);
				l /= i;
				prime = false;
				
			}
		}
		if(!prime) {
			factors.remove(0);
		}
		return factors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			char newChar = ' ';
			String newString="";
			for(int i = 0; i < string.length(); i++) {
				//capital letters
				if(string.charAt(i) > 64 && string.charAt(i) < 91)
				{
					//rollover
					if(string.charAt(i) + key > 90) {
						newChar = (char) (string.charAt(i) + key - 90 + 64);
					}
					else {
						newChar = (char)(string.charAt(i) + key);
					}
				}
				//lower case letters
				else if(string.charAt(i) > 96 && string.charAt(i) < 123) {
					//rollover
					if(string.charAt(i) + key > 122) {
						newChar = (char) (string.charAt(i) + key - 122 + 96);
					}
					else {
						newChar = (char)(string.charAt(i) + key);
					}
				}
				//anything that's not a letter
				else {
					newChar = string.charAt(i);
				}
				newString += newChar;
			}
			return newString;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		int n = 1;
		int number = 3;
		boolean isPrime;
		if(i > 0) {
			//create a list of primes
			List<Integer> primes = new ArrayList();
			primes.add(2);
			while(n < i ) {
				//a number is prime if it isn't divisible by the other primes
				isPrime = true;
				for(int prime : primes) {
					if(number % prime == 0) {
						isPrime = false;
					}
				}
				if(isPrime) {
					primes.add(number);
					n++;
				}
				//no such thing as an even prime number
				number += 2;
			}
			
			return primes.get(n - 1);
		}
		return 0;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			String newString = "";
			char newChar = ' ';
			int count = 0; //counter for every 5 inserts
			string = string.toLowerCase();
			for(int i = 0; i < string.length(); i++) {
				//lower case letters
				if(string.charAt(i) > 96 && string.charAt(i) < 123) {
					newChar = (char) (123 - string.charAt(i) + 96);
					newString += newChar;
					count++;
				}
				//add numbers
				else if(string.charAt(i) > 47 && string.charAt(i) < 58) {
					newString += string.charAt(i);
					count++;
				}
				//blank spaces and punctuation
				else {
					continue;
				}
				if(count % 5 ==0) {
					newString += " ";
				}
			}
			return newString.trim();
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			String newString = "";
			char newChar = ' ';
			string = string.toLowerCase();
			for(int i = 0; i < string.length(); i++) {
				//lower case letters
				if(string.charAt(i) > 96 && string.charAt(i) < 123) {
					newChar = (char) (123 - string.charAt(i) + 96);
					newString += newChar;
				}
				//add numbers
				else if(string.charAt(i) > 47 && string.charAt(i) < 58) {
					newString += string.charAt(i);
				}
				//blank spaces and punctuation
				else {
					continue;
				}
			}
			return newString.replace(" ", "");
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		//split into just numbers
				String isbn = "";
				for(int i = 0; i < string.length() - 1; i++) {
					if(string.charAt(i) == '1' || string.charAt(i) == '2' || string.charAt(i) == '3' ||
							string.charAt(i) == '4' || string.charAt(i) == '5' || string.charAt(i) == '6' ||
							string.charAt(i) == '7' || string.charAt(i) == '8' || string.charAt(i) == '9'
							|| string.charAt(i) == '0') {
						isbn += string.charAt(i);
					}
					else if(string.charAt(i) == '-') {
						continue;
					}
					else {
						return false;
					}
				}
				//now check the check character
				int i = string.length() - 1;
				if(string.charAt(i) == '1' || string.charAt(i) == '2' || string.charAt(i) == '3' ||
						string.charAt(i) == '4' || string.charAt(i) == '5' || string.charAt(i) == '6' ||
						string.charAt(i) == '7' || string.charAt(i) == '8' || string.charAt(i) == '9'
						|| string.charAt(i) == '0' || string.charAt(i) == 'X') {
					isbn += string.charAt(i);
				}
				else {
					return false;
				}
				//check if isbn is a 10 digit number
				if(isbn.length() != 10) {
					return false;
				}
				int sum = 0;
				for(int index = 10; index > 1; index--) {
					sum += Integer.parseInt(String.valueOf(isbn.charAt(10 - index))) * index;
				}
				//add the last digit
				if(isbn.charAt(9) == 'X') {
					sum += 10;
				}
				else {
					sum += Integer.parseInt(String.valueOf(isbn.charAt(9)));
				}
				if(sum % 11 == 0) {
					return true;
				}
				return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: Ï€Î±Î½ Î³Ï�Î¬Î¼Î¼Î±, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		//get rid of white space
		string = string.replace(" ", "");
		Map<Character, Integer> letters = new HashMap();
		//will add a letter when found in the string
		//map will have a size of 26
		for(int i = 0; i < string.length(); i++) {
			if(letters.containsKey(string.charAt(i))) {
				letters.replace(string.charAt(i), letters.get(string.charAt(i) + 1));
			}  
			else {
				letters.put(string.charAt(i), 1);
			}
		}
		return letters.size() == 26;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		// we will have variables for how many seconds are in each minutes, hours, etc
		Long gigasecond = 1000000000L;
		int minute = 60;
		int hour = minute * 60;
		int day = hour * 25;
		int year = 365 * day;
		//now we convert everything to gigaseconds
		int years = 0; //there are x years in a gigasecond
		int days = 0;
		int hours = 0;
		int minutes = 0;
		int seconds = 0;
		while(gigasecond / year >= 1) {
			gigasecond /= year;
			years++;
		}
		
		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		List<Integer> numbers = new ArrayList<>();
		for(int number : set) {
			int multiple = 1;
			while(multiple * number < i) {
				if(numbers.contains(multiple * number)) {
					multiple++;
				}
				else {
					numbers.add(multiple * number);
					multiple++;
					
				}
			}
		}
		int sum = 0;
		for(int number : numbers) {
			sum += number;
		}
		
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		if(string.length() <= 1) {
			return false;
		}
		//get rid of white spaces
		string = string.replace(" ", "");
		//check for non digits
		if(string.split("\\d").length > 0) {
			return false;
		}
		int sum = 0;
		int number;
		//double the number every other time
		boolean doub = false;
		for(int i = string.length() - 1; i >= 0; i--) {
			number = Integer.parseInt(String.valueOf(string.charAt(i)));
			if(doub) {
				number *= 2;
			}
			if(number > 9) {
				number -= 9;
			}
			sum += number;	
			//if we doubled this number we don't need to double the next
			//and if we didn't double this number we need to double the next
			doub = doub ? false : true;
		}
		if(sum % 10 == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		int leftNum;
		int rightNum;
		String lNum = "";
		String rNum = "";
		int answer = 0;
		String[] numbers = string.split("\\D", 0);
		for(String number : numbers) {
			if(!number.equals("") && lNum.equals("")) {
				lNum = number;
			}
			if(!number.equals("") && !lNum.equals("")) {
				rNum = number;
			}
		}
		leftNum = Integer.parseInt(lNum);
		rightNum = Integer.parseInt(rNum);
		//check if the negative sign is there
		if(string.charAt(string.indexOf(lNum.charAt(0)) - 1) == '-')
		{
			leftNum *= -1;
			
		}
		if(string.charAt(string.indexOf(rNum.charAt(0), 9 + lNum.length()) - 1) == '-') {
			rightNum *= -1;
		}
		if(string.contains("plus")) {
			answer = leftNum + rightNum;
		}
		else if(string.contains("minus")) {
			answer = leftNum - rightNum;
		}
		else if(string.contains("multiplied")) {
			answer = leftNum * rightNum;
		}
		else if(string.contains("divided")) {
			answer = leftNum / rightNum;
		}
		else {
			
		}
		return answer;
	}

}
