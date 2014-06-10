/**
 * In the classic problem of the Towers of Hanoi, you have 3 rods and N disks of different 
 * sizes which can slide onto any tower   The puzzle starts with disks sorted in ascending 
 * order of size from top to bottom (e g , each disk sits on top of an even larger one)  You 
 * have the following constraints: 
 * (A) Only one disk can be moved at a time 
 * (B) A disk is slid off the top of one rod onto the next rod 
 * (C) A disk can only be placed on top of a larger disk 
 * Write a program to move the disks from the first rod to the last using Stacks
 * 
 *  1. use recursion can solve this problem more efficiently
 *  
 *  2. explicitly using stacks, remove recursion
 *  	Here write the recursive version first
 *  
 */
package careercup;

import java.util.Stack;

/**
 * @author Xiaokang
 * 
 */
public class Ch3_4HanoiTower {
	private static Stack<Integer> a, b, c;

	// move n plates from stack a to stack b
	public static void move(Stack<Integer> a, Stack<Integer> b,
			Stack<Integer> c, int n) {
		// base case, only move one plate
		if (n == 1)
			b.push(a.pop());
		else {
			// move from a rod to c rod n-1 plates, b as an intermediate rod
			move(a, c, b, n - 1);
			// move from a rod to b rod 1 plates, c as an intermediate rod
			move(a, b, c, 1);
			// move the remaining n-1 plates from c to b, a as an intermediate
			// rod
			move(c, b, a, n - 1);
		}
	}

	/**
	 * @param args
	 * 
	 *            args[0]: disk number N
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		a = new Stack<Integer>();
		b = new Stack<Integer>();
		c = new Stack<Integer>();
		for (int i = 10; i > 0; i--) {
			a.push(i);
		}
		System.out.println(a);

		move(a, b, c, 9);

		System.out.println(b);

	}

}
