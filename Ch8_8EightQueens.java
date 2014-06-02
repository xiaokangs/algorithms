/**
 * Write an algorithm to print all ways of arranging eight queens on a chess board so 
 * that none of them share the same row, column or diagonal 
 * 
 * 
 * 1. if chose one position for the first row, then the question reduce to a 7X7 board
 *    which may have some restrictions. but, there is no solution for a 2X2 board, it 
 *    seems that the question should be reduce to a 7X8 problem 
 *    
 * 2. built an available matrix for each position. in each step, need make a copy of the 
 *    original matrix, therefore, the original matrix will not change and can continue to 
 *    explore next a few possible positions
 * 
 */
package careercup;

/**
 * @author X. Shen
 * 
 */
public class Ch8_8EightQueens {
	private static final int N = 8; // constant N = 8

	public static int ways() {
		int count = 0;
		boolean[][] board = new boolean[N][N]; // false: position is available
											   // true: position is restricted
		for (int i = 0; i < N; i++) {
			count += checkNextLine(board, 0, i);
		}
		return count;
	}


	public static int checkNextLine(boolean[][] board, int row, int column) {
		int result = 0;
		boolean[][] copy = copy(board);
		// update the board for this choice of position
		int nextRow = row + 1;
		for (int i = nextRow; i < N; i++)
			copy[i][column] = true;
		// update the previous rows as well
		for (int i = 0; i < row; i++)
			copy[i][column] = true;

		// diagonal case
		// down right diagonal direction
		int nextColumn = column + 1;
		for (int i = nextRow, j = nextColumn; i < N && j < N; i++, j++) {
			copy[i][j] = true;
		}
		// down left diagonal direction
		for (int i = nextRow, j = nextColumn - 2; i < N && j >= 0; i++, j--) {
			copy[i][j] = true;
		}

		// base case: enter the last row and there is an available position
		if (row == N - 1) {
			for (int i = 0; i < N; i++) {
				if (!copy[N - 1][i]) {
					printBoard(copy);
					return 1;
				}
			}
			return 0;
		}
		for (int i = 0; i < N; i++) {
			if (!copy[nextRow][i]) {
				result += checkNextLine(copy, nextRow, i);
			}
		}
		return result;
	}

	// make a new boolean copy
	private static boolean[][] copy(boolean[][] board) {
		boolean[][] copy = new boolean[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				copy[i][j] = board[i][j];
		return copy;
	}

	// print board
	public static void printBoard(boolean[][] board) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!board[i][j])
					System.out.print("Q" + "\t");
				else
					System.out.print("X" + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] board = new boolean[N][N];
		printBoard(board);
		System.out.println(ways());
	}

}
