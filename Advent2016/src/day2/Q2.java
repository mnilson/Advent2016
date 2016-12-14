package day2;

public class Q2 {

	public static void main(String[] args) {
		keypad current = keypad.FIVE;
		int ix = 0;

		char letter = ' ';
		while (ix < args.length) {
			String dirs = args[ix++];
			// System.out.println(dirs);
			char[] letters = dirs.toCharArray();
			int cix = 0;
			while (cix < letters.length) {
				letter = letters[cix++];
				//System.out.print(current + " " + letter + "=");
				current = keypad.move(letter, current);
				//System.out.println(current);
			}
			System.err.print(current + "");
		}
	}

	public static enum keypad {
		ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN(
				"7"), EIGHT("8"), NINE("9"), A("A"), B("B"), C("C"), D("D");
		private String val;

		private keypad(String val) {
			this.val = val;
		}
		
		public String toString(){
			return this.val;
		}

		public static keypad move(char dir, keypad current) {
			keypad result = current;
			if (dir == 'U') {
				if (current == FIVE || current == TWO || current == ONE
						|| current == FOUR || current == NINE) {
					return current;
				}
				if (current == D) {
					return B;
				}
				if (current == THREE) {
					return ONE;
				}
				return keypad.values()[current.ordinal() - 4];
			} else if (dir == 'D') {
				if (current == FIVE || current == A || current == D
						|| current == C || current == NINE) {
					return current;
				}
				if (current == ONE) {
					return THREE;
				}
				if (current == B) {
					return D;
				}
				return keypad.values()[current.ordinal() + 4];

			} else if (dir == 'L') {
				if (current == ONE || current == TWO || current == FIVE
						|| current == A || current == D) {
					return current;
				}
				return keypad.values()[current.ordinal() - 1];

			} else if (dir == 'R') {
				if (current == ONE || current == FOUR || current == NINE
						|| current == C || current == D) {
					return current;
				}
				return keypad.values()[current.ordinal() + 1];
			}
			return result;
		}

		public keypad getValue(char i) {
			switch (i) {
			case '1':
				return ONE;
			case '2':
				return TWO;
			case '3':
				return THREE;
			case '4':
				return FOUR;
			case '5':
				return FIVE;
			case '6':
				return SIX;
			case '7':
				return SEVEN;
			case '8':
				return EIGHT;
			case '9':
				return NINE;
			case 'A':
				return A;
			case 'B':
				return B;
			case 'C':
				return C;
			case 'D':
				return D;
			}
			throw new IllegalArgumentException(i + "");
		}
	}
}
