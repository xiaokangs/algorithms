/**
 * You are given two sorted arrays, A and B, and A has a large enough buffer at the end 
 * to hold B  Write a method to merge B into A in sorted order 
 * 
 * Notes:
 * 1. Merge from the end of the two arrays. 
 * 
 */
package careercup;

/**
 * @author X. Shen
 * 
 */
public class Ch9_1MergeTwoSortedArray {

	public static void merge(int[] A, int[] B) {
		int M = A.length;
		int N = B.length;
		int i = M - N - 1, j = N - 1;
		while (i >= 0 && j >= 0) {
			if (A[i] >= B[j]) {
				A[i+j+1] = A[i]; 
				i--;
			}
			else {
				A[i+j+1] = B[j];
				j--;
			}
		}
		// copy the remaining B array to the front of the A
		if (j >= 0) {
			while (j >= 0) {
				A[j] = B[j];
				j--;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[40];
		int[] B = new int[20];
		for (int i = 0; i < 20; i++) {
			A[i] = i * i;
			B[i] = (1 << i);
		}
		for (int i = 0; i < 40; i++)
			System.out.println(i + ": " + A[i]);

		for (int i = 0; i < 20; i++)
			System.out.println(i + ": " + B[i]);
		
		merge(A, B);
		for (int i = 0; i < 40; i++)
			System.out.println(i + ": " + A[i]);

	}

}
