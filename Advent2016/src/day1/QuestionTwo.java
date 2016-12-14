package day1;

import java.util.HashSet;
import java.util.Set;

public class QuestionTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dir current = Dir.N;
		int northSouth = 0;// going north increases, south decreases
		int eastWest = 0; // going east increases, west decreases
		int ix = 0;
		Set<String> locations = new HashSet<String>();

		while (ix < args.length) {
			char turn = args[ix].charAt(0);
			String num = args[ix].substring(1);
			num = num.replaceAll(",","");
			int distance = Integer.parseInt(num);
			int oldSize = 0;			
			ix++;
			current = Dir.getDir(current, turn);
			switch (current) {
			case N:
				while(distance >0){
					northSouth ++;
					distance --;
					locations.add(northSouth + ", " + eastWest);
					if(locations.size() == oldSize){
						int dist = Math.abs(northSouth) + Math.abs(eastWest);
						System.out.println("Answer: " + dist);
						return;
					}
					oldSize = locations.size();
					
				}
				break;
			case E:
				while(distance >0){
					eastWest  ++;
					distance --;	
					locations.add(northSouth + ", " + eastWest);
					if(locations.size() == oldSize){
						int dist = Math.abs(northSouth) + Math.abs(eastWest);
						System.out.println("Answer: " + dist);
						return;
					}
					oldSize = locations.size();				
				}

				break;
			case S:
				while(distance >0){
					northSouth --;
					distance --;		
					locations.add(northSouth + ", " + eastWest);
					if(locations.size() == oldSize){
						int dist = Math.abs(northSouth) + Math.abs(eastWest);
						System.out.println("Answer: " + dist);
						return;
					}
					oldSize = locations.size();			
				}
				break;
			case W:
				while(distance >0){
					eastWest  --;
					distance --;		
					locations.add(northSouth + ", " + eastWest);
					if(locations.size() == oldSize){
						int dist = Math.abs(northSouth) + Math.abs(eastWest);
						System.out.println("Answer: " + dist);
						return;
					}
					oldSize = locations.size();			
				}
				break;
			}
			
		}
		
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
