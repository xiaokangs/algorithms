package leetC;

import java.util.*;

/********************
 * 
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26
 * 
 * Given an encoded message containing digits, determine the total number of
 * ways to decode it.
 * 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
 * "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 * 
 * @author X. Shen
 * 
 */

public class DecodeWays {

	public int numDecodings(String s) {
		if (s == null)
			throw new IllegalArgumentException();
		// assume s is always integers
		if (s.length() == 0 || s.length() == 1 && s.charAt(0) != '0')
			return 1;
		if (s.length() == 1 && s.charAt(0) == '0')
			return 0;
		int N = s.length();
		int[] fibArray = new int[N + 1];
		fibArray[0] = 1;
		fibArray[1] = 1;
		for (int i = 2; i < N + 1; i++) {
			fibArray[i] = fibArray[i - 2] + fibArray[i - 1];
		}
		List<Integer> sep = new ArrayList<Integer>();
		int i = 0, count = 1;
		while (i < N) {
			if (s.charAt(i) == '0')
				return 0;
			while (i < N - 1 && validNum(s.substring(i, i + 2))) {
				i++;
				count++;
			}
			if (s.charAt(i) == '0')
				count -= 2;
			sep.add(count);
			i++;
			count = 1;
		}
		int ways = 1;
		for (Integer x : sep) {
			ways *= fibArray[x];
		}
		return ways;
	}

	private boolean validNum(String s) {
		int n = (s.charAt(0) - 48) * 10 + s.charAt(1) - 48;
		return n > 9 && n < 27;
	}

	/************
	 * public int numDecodings(String s) { if (s == null) throw new
	 * IllegalArgumentException(); // assume s is always valid, for example s
	 * can't be "0" if (s.length() == 0 || s.length() == 1) return 1; int N =
	 * s.length(); // write recursive version, which may be timely costy return
	 * numDecodings(s, 0, N - 1); }
	 * 
	 * private int numDecodings(String s, int start, int end) { // base case,
	 * reach end if (start > end) return 1; if (start == end) { if
	 * (s.charAt(start) == '0') { return 0; } else { return 1; } } int i =
	 * toNum(s.substring(start, start + 2)); if (i > 9 && i < 27) { return
	 * numDecodings(s, start + 1, end) + numDecodings(s, start + 2, end); } if
	 * (s.charAt(start) == '0') return 0; return numDecodings(s, start + 1,
	 * end); }
	 * 
	 * private int toNum(String s) { return (s.charAt(0) - 48) * 10 +
	 * s.charAt(1) - 48; }
	 *************/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeWays d = new DecodeWays();
		String s = "111111";
		System.out.println(d.numDecodings(s));

	}

}
