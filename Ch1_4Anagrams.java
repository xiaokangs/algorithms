/**
 * Write a method to decide if two strings are anagrams or not 
 * 
 * My notes:
 * Change to char array and then sort the array
 * IndexCounting for the two strings
 * 
 * Additional:  only consider A-Z a-z or 0-9 or including punctuation
 * Ignore upper or lower case
 * 
 * "William Shakespeare" and "I am a weakish speller" are  anagrams. 
 * 
 */
package careercup;

/**
 * @author Xiaokang 05-19-2014
 */

public class Ch1_4Anagrams {
	private static final int R = 256; // A-Z a-z

	private static boolean isAnagram(String s1, String s2) {

		String str1 = s1.toUpperCase();
		String str2 = s2.toUpperCase();
		int[] count1 = new int[R];
		int[] count2 = new int[R];
		for (int i = 0; i < str1.length(); i++) {
			count1[str1.charAt(i)]++;
		}
		for (int i = 0; i < str2.length(); i++) {
			count2[str2.charAt(i)]++;
		}

		// only consider A-Z, ignore punctuation
		for (int i = 65; i < 91; i++) {
			if (count1[i] != count2[i])
				return false;
		}
		return true;
	}

	/**
	 * @param args
	 *            args[0]: string1; args[1]: string2
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (isAnagram(args[0], args[1]))
			System.out.println(" \"" + args[0] + "\" and \"" + args[1]
					+ "\" are " + " anagrams. ");
		else
			System.out.println(" \"" + args[0] + "\" and \"" + args[1]
					+ "\" aren't " + " anagrams. ");
	}

}
