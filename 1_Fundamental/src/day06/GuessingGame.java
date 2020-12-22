package day06;
import java.util.Scanner;
public class GuessingGame {
	
	public static void main(String[] args) {
		int count = 0;
		int[] result = null;
		char[] input = null;
		System.out.println("Welcome to the Guessing Game!");
		System.out.print("Please input the number of the character: ");
		Scanner scan = new Scanner(System.in);
		int level = scan.nextInt();				
		char[] ans = generate(level);
		while(true) {
			System.out.print("Guessing here: ");
			String s = scan.next().trim().toUpperCase();
			
			if (s.equals("EXIT")) {
				System.out.println("残念ながら、まだ今度遊びましょうね！");
				break;
			}
			if (s.equals("CHEAT")) {
				System.out.println(ans);
				continue;
			}
			input = s.toCharArray();	
			result = check(ans, input);
			if (result[1] == ans.length) {
				int score = 100 * ans.length - 10 * count;
				System.out.println("正解ですね！おめでとうございます！あなたの分数は " + score + " です！");
				break;
			} else {
				count++;
				System.out.println("Guessing Game> the number of the right char: " + result[0]						
						+ " The number of the right position: " + result[1] + "\n"
						+ "Try time: " + count + ", input exit to exit");
			}
		}		
		scan.close();
	}

	public static char[] generate(int len) {
		if (len <= 0 || len > 26) return null;
		char[] letters = {'A', 'B', 'C','D','E','F','G','H','I','J','K','L',
				'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
		};
		char[] chs = new char[len];
		boolean[] flags = new boolean[letters.length];
		for (int i = 0; i < len; ++i) {
			int index;
			do {
				index = (int)(Math.random() * letters.length);				
			} while(flags[index]);
			chs[i] = letters[index];
			flags[index] = true;
		}
		return chs;
	}
	
	public static int[] check(char[] chs, char[] input) {
		int[] res = new int[2]; // res[1] = number of right pos, res[0] = number of right char 
		if (input.length != chs.length) return res;
		for (int i = 0; i < chs.length; ++i) {
			for(int j = 0; j < input.length; ++j) {
				if (chs[i] == input[j]) {
					res[0]++;
					if (i == j) res[1]++;
					break;
				}
			}
		}
		return res;
	}
}
