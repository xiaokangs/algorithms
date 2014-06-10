/**
 * Implement the ¡°paint fill¡± function that one might see on many image editing programs
 * That is, given a screen (represented by a 2 dimensional array of Colors), a point, 
 * and a new color, fill in the surrounding area until you hit a border of that color¡¯ 
 * 
 * 1. how to avoid back track, move forward then move back? seems similar as 8-puzzle
 * 
 * 
 */
package careercup;

import java.util.Random;

/**
 * @author X. Shen
 * 
 */
public class Ch8_6PaintFill {

	public static void fill(int[][] image, int i, int j, int color) {
		int N = image.length;
		int M = image[0].length;
		if (i >= N)
			throw new IllegalArgumentException();
		if (j >= M)
			throw new IllegalArgumentException();

		image[i][j] = color;
		// fill right
		if (i < N - 1 && image[i + 1][j] != color)
			fill(image, i + 1, j, color);
		// fill left
		if (i > 0 && image[i - 1][j] != color)
			fill(image, i - 1, j, color);
		// fill right
		if (j < M - 1 && image[i][j + 1] != color)
			fill(image, i, j + 1, color);
		// fill right
		if (j > 0 && image[i][j - 1] != color)
			fill(image, i, j - 1, color);
	}

	public static void print(int[][] image, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(image[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// build a test case
		int N = 20;
		Random random = new Random();
		int[][] image = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				image[i][j] = random.nextInt(255);
			}
		int target = 100;
		for (int j = 5; j <= 15; j++) {
			image[5][j] = target;
			image[15][j] = target;
		}
		for (int i = 5; i <= 15; i++) {
			image[i][5] = target;
			image[i][15] = target;
		}
		print(image, N);
		// fill at the point (10, 10)
		fill(image, 10, 10, target);
		print(image, N);

	}

}
