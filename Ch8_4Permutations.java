/**
 * Write a method to compute all permutations of a string 
 * 
 * My Notes:
 * 1. how many permutations:  n! if all distinctive
 * 2. how to take care the duplicated case? 
 *    only swap with different characters
 * 3. still divide and conquer? not consider duplicate case first, 
 *      not a good solution, abcd bacd abdc badc dcab dcba cdba cdab 
 *      only 4X2 = 8 combinations
 * 4. char array, and use index in recurse call
 * 5. for duplicated chars, the number of permutations would be n!/(c1!c2!...), in which
 *    c1 is the number of character 1, etc.
 *  
 */
package careercup;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author X. Shen
 *
 */
public class Ch8_4Permutations {
	private ArrayList<String> permutations;
	int N;
	
	public Ch8_4Permutations(char[] s) {
		permutations = new ArrayList<String>(); 
		if (s == null) {
			N = 0; 
			return; 
		}
		N = s.length;
		if (N == 0) {
			permutations.add(s.toString()); // have an empty string
			return; 
		}
		char[] copy = copyString(s, N);
		permutateRemoveDup(copy, 0);
	}
	
	// this method don't avoid the duplicated strings
	private void permutate(char[] s, int start) { 
		// base case, char array only have one character
		if (start == N - 1) { // the char array go to the last character
			permutations.add(new String(s));
			return;
		}
		
		// other cases, still have more than one characters
		for (int i = start; i < N; i++) {
			// make a copy of the string
			char[] copy = copyString(s, N);
			swap(copy, start, i);
			permutate(copy, start+1);
		}
	}

	// this method avoid duplicated Strings
	private void permutateRemoveDup(char[] s, int start) {
		// just operate on the passing array
		// base case, char array only have one character
		
		if (start == N - 1) { // the method call to the last character
			permutations.add(new String(s));
			return;
		}
		TreeSet<Character> set = new TreeSet<Character>(); // alternative implementation: use a boolean array
		// other cases, still have more than one characters
		for (int i = start; i < N; i++) {
			// make a copy of the string
			if (!set.contains(s[i])) { // key point here, if the letter appeared at the position
										// do not swap the letter to the position again
				set.add(s[i]);
				char[] copy = copyString(s, N);
				swap(copy, start, i);
				permutateRemoveDup(copy, start + 1);
			}
			
		}
	}
	
	// deep copy string
	private char[] copyString(char[] s, int length) {
		char[] copy = new char[length];
		for (int i = 0; i < length; i++) {
			copy[i] = s[i];
		}
		return copy;
	}
	
	// swap the char at position i with the char at position j
	private void swap(char[] s, int i, int j) {
		if (i == j)
			return;
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}
	
	public int size() {
		return permutations.size();
	}
	
	public void printAll() {
		for (String s : permutations) 
			System.out.println(s);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] s = args[0].toCharArray();
		Ch8_4Permutations test = new Ch8_4Permutations(s);
		System.out.println(test.N);
		System.out.println(test.size());
		test.printAll();
		
	}

}
