/**
 * Imagine a robot sitting on the upper left hand corner of an NxN grid  The robot can 
 * only move in two directions: right and down  How many possible paths are there for 
 * the robot?
 * FOLLOW UP
 * Imagine certain squares are ¡°off limits¡±, such that the robot can not step on them
 * Design an algorithm to get all possible paths for the robot
 * 
 * Notes
 * 1. Write the base case and recursive case
 * 
 * 2. Need an array to mark the "off limits" squares, need check when step right/down
 */
package careercup;

/**
 * @author X. Shen
 * 
 */
public class Ch8_2Robot {

	// return how many possible paths there will be for a i by j grid
	public static int paths(int i, int j) {
		if (i <= 0 || j <= 0)
			throw new IllegalArgumentException(
					"Wrong sizes, size must be greater than 0");
		// base case
		if (i == 1 || j == 1)
			return 1;
		// step right possible paths plus step down possible paths
		return paths(i - 1, j) + paths(i, j - 1);
	}

	// return how many possible paths there will be for a n by n grid with some
	// off limits squares, true means blocked
	// where to check the path possible, in the beginning
	public static int pathsOff(boolean[][] mark, int n, int i, int j) {
		if (i < 0 || i >= n || j < 0 || j >= n)
			throw new IllegalArgumentException(
					"Wrong arguments, indices must be greater than 0 and less than n+1");
		// base case 1
		if (mark[i][j])
			return 0; // blocked path
		// base case 2
		if (i == n - 1 && j == n - 1)
			return 1;
		int rightPaths = 0, downPaths = 0;
		// step right possible paths
		if (i < n - 1)
			rightPaths = pathsOff(mark, n, i + 1, j);
		if (j < n - 1)
			downPaths = pathsOff(mark, n, i, j + 1);
		return rightPaths + downPaths;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 10; i++)
			System.out.println(paths(i, i));

		boolean[][] mark = new boolean[10][10];
		System.out.println(pathsOff(mark, 10, 0, 0));
		mark[9][9] = true;
		System.out.println(pathsOff(mark, 10, 0, 0)); // output 0

	}

}
