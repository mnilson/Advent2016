package day1;

public class QuestionOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dir current = Dir.N;
		int northSouth = 0;// going north increases, south decreases
		int eastWest = 0; // going east increases, west decreases
		int ix = 0;

		while (ix < args.length) {
			char turn = args[ix].charAt(0);
			String num = args[ix].substring(1);
			num = num.replaceAll(",","");
			int distance = Integer.parseInt(num);
			ix++;
			System.out.print(current + " " + northSouth + ", " + eastWest + " " + turn + num + " = ");
			current = Dir.getDir(current, turn);
			switch (current) {
			case N:
				northSouth += distance;
				break;
			case E:
				eastWest += distance;
				break;
			case S:
				northSouth -= distance;
				break;
			case W:
				eastWest -= distance;
				break;
			}
			System.out.println(current + ": " + northSouth + ", " + eastWest);
			
		}
		int distance = Math.abs(northSouth) + Math.abs(eastWest);
		System.out.println("Answer: " + distance);
	}

	public enum Dir {
		N, E, S, W;

		public static Dir getDir(Dir current, char turn) {
			int ix = current.ordinal();
			if (turn == 'R') {
				if (ix == 3) {
					return Dir.values()[0];
				}
				return Dir.values()[ix + 1];
			}
			if (ix == 0) {
				return Dir.values()[3];
			}
			return Dir.values()[ix - 1];
		}
	}

}
