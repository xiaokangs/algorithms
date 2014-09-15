package leetCode;

/***************************
 * 
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * @author X. Shen
 * 
 */

public class SingleNumberII {
	
    public int singleNumber(int[] A) {
        if (A == null || A.length % 3 != 1)
            throw new IllegalArgumentException();
        // solution using three color quick sorting
        return singleNumberHelper(A, 0, A.length - 1);
    }
    
    private int singleNumberHelper(int[] A, int lo, int hi) {
        // base case: if only one element
        if (lo == hi)
            return A[lo];
        int N = hi - lo;
        // pick a pivot element
        int r = (int) (Math.random() * N) + lo;
        swap(A, lo, r);
        // three way sorting
        int lt = lo, i = lo, gt = hi, pivot = A[lo];
        while (i <= gt) {
            if (A[i] == pivot) {
                i++;
            } else if (A[i] < pivot) {
                swap(A, i, lt);
                lt++;
                i++;
            } else {
                swap(A, i, gt);
                gt--;
            }
        }
        // case the single element on the left side of A[lo]
        if (lt % 3 == 1) {
            return singleNumberHelper(A, lo, lt - 1);
        } else if ((gt + 1) % 3 == 0) {
            return singleNumberHelper(A, gt + 1, hi);
        } else {
            return A[lt];
        }
    }    
    
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
	
    public int singleNumberThree(int[] A) {
        if (A == null || A.length % 3 != 1)
            throw new IllegalArgumentException();
        // solution using three operation with binary operation
        int one = 0, two = 0, three = 0;
        for (int i = 0; i < A.length; i++) {
            two |= (one & A[i]);
            one ^= A[i];
            three = ~(one & two);
            one &= three;
            two &= three;
        }
        return one;
    }

	public int singleNumberBitsbybit(int[] A) {
		if (A == null || A.length % 3 != 1)
			throw new IllegalArgumentException();
		// solution using three color quick sorting
		// or use bit operation, sum bit by bit, then modular by 3
		// take the remainder
		int result = 0;
		for (int i = 0; i < 32; i++) {
			int count = 0;
			for (int j = 0; j < A.length; j++) {
				count += ((A[j] >> i) & 1);
			}
			count = count % 3;
			result += count * (1 << i);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] A = { -2, -2, 1, 1, -3, 1, -3, -3, -4, -2 };
		SingleNumberII s = new SingleNumberII();
		System.out.println(s.singleNumberThree(A));
	}

}
