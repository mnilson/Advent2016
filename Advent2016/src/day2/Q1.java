package day2;

public class Q1 {
	public static void main(String[] args) {
		int current = 5;
		int ix = 0;
		
		char letter = ' ';
		while (ix < args.length) {
			String dirs = args[ix++];
//			System.out.println(dirs);
			char[] letters = dirs.toCharArray();
			int cix = 0;
			while (cix < letters.length) {
				letter = letters[cix++];

				if (letter == 'U') {
					if (current >= 4) {
						current -= 3;
					}
				} else if (letter == 'D') {
					if (current <= 6) {
						current += 3;
					}
				} else if (letter == 'L') {
					if (current % 3 != 1) {
						current -= 1;
					}
				} else if (letter == 'R') {
					if (current % 3 != 0) {
						current += 1;
					}
				}
			}
			System.out.print(current +"");
		}
	}
}
