/**
 * You have a basketball hoop and someone says that you can play 1 of 2 games 
 * Game #1: You get one shot to make the hoop
 * Game #2: You get three shots and you have to make 2 of 3 shots
 * If p is the probability of making a particular shot, for which values of p should you pick
 * one game or the other?
 * 
 * My notes:
 * 1. this is a probability question, need solve an in-equation
 * 2. for game 1 the probability to win is just p
 *    for game 2 the probability to win is: 
 *    	p*p*p (three hits) + 3*(p*p*(1-p)) (two hits and one miss)
 *    solve the inequation got when 0<p<0.5 choose game 1, when 0.5<p<1, choose game 2
 */
package careercup;

/**
 * @author X. Shen
 * 
 */
public class Ch10_1BasketBallGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double p;
		p = StdIn.readDouble();
		double p1, p2;
		p1 = p;
		p2 = p * p * p + 3 * p * p * (1 - p);
		String s = p2 > p1 ? " 2 " : " 1 ";
		System.out.println("Choose game: " + s);

	}

}
