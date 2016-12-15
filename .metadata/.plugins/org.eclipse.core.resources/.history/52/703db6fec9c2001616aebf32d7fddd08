package day12;

import java.io.IOException;
import java.math.BigInteger;

public class D12Q1 {

	public static int minSteps = 0;

	public static void main(String[] args) throws IOException {
		int max = 45;
		int targetX = 31;
		int targetY = 39;
		int magicNumber = 1358;
		char[][] map = new char[max][max];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (i == targetX && j == targetY) {
					map[j][i] = 'X';
				} else if (i == 1 && j == 1) {
					map[j][i] = 'S';
				} else if (isWall(i, j, magicNumber, map))
					map[j][i] = '#';
				else
					map[j][i] = ' ';
			}
		}
		// printMap(map);

		traverseMap(map, 1, 1, 1);

		System.out.println("Final Min Steps: " + minSteps);
		printMap(map);
	}

	private static char[][] traverseMap(char[][] map, int x, int y, int count) {
		if ((x + 1 < map.length && map[x + 1][y] == 'X')
				|| (y + 1 < map.length && map[x][y + 1] == 'X')
				|| (x > 0 && map[x - 1][y] == 'X')
				|| (y > 0 && map[x][y - 1] == 'X')) {
			System.out.println("Found!!! " + count);
			if (minSteps == 0 || count < minSteps) {
				minSteps = count;
			}
			printMap(map);
			return map;
		}

		System.out.println(count + " " + x + "," + y);
		System.out.println("Trying Down?");
		int newX = x + 1;
		int newY = y;
		if (newX < map.length && map[newX][newY] == ' ') {
			System.out.println("Going Down " + map[newX][newY]);
			// can move Down
			char[][] input = map.clone();
			input[newX][newY] = '.';
			char[][] out = traverseMap(input, newX, newY, count+1);
			map[newX][newY]=' ';
		}
		
		newX = x;
		newY = y +1;
		System.out.println("Trying Right?");
		if (newY < map.length && map[newX][newY] == ' ') {
			System.out.println(newX + "," + y + ": Right " + map[newX][newY]);
			// can move Right
			char[][] input = map.clone();
			input[newX][newY] = '.';
			char[][] out = traverseMap(input, newX, newY, count+1);
			map[newX][newY]=' ';
		}
		
		newX = x-1;
		newY = y;
		System.out.println("Trying Up?");
		if (newX > 0 && map[newX][newY] == ' ') {
			// can move Up
			System.out.println(newX + "," + newY + ": Up " + map[newX][newY]);
			char[][] input = map.clone();
			input[newX][newY] = '.';
			char[][] out = traverseMap(input, newX, newY, count+1);
			map[newX][newY]=' ';
		}
		newX = x;
		newY = y-1;
		System.out.println("Trying Down?");
		if (newY > 0 && map[newX][newY] == ' ') {
			// can move Left
			System.out.println(newX + "," + newY + ": Left " + map[newX][newY]);
			char[][] input = map.clone();
			input[newX][newY] = '.';
			char[][] out = traverseMap(input, newX, newY, count+1);
			map[newX][newY]=' ';
		}
		System.out.println("pop " + count + " " + x + "," + y);
		return map;
	}

	private static boolean isWall(int x, int y, Integer magicNumber,
			char[][] map) {
		long val = (x * x) + (3 * x) + (2 * x * y) + y + (y * y);
		val += magicNumber;
		String bits = BigInteger.valueOf(val).toString(2);
		int count = 0;
		while (bits.contains("1")) {
			bits = bits.replaceFirst("1", "");
			count++;
		}
		return !(count % 2 == 0);
	}

	private static void printMap(char[][] map) {
		// print header.
		String h1 = "   ", h2 = "   ";
		for (int h = 0; h < map.length; h++) {
			if (h % 10 != 0) {
				h1 += " ";
			} else {
				h1 += (h + "").charAt(0);
			}
			h2 += h % 10;
		}
		h1 = "";
		h2 = "";
		System.out.println(h1);
		System.out.println(h2);
		for (int i = 0; i < map.length; i++) {
			// System.out.print(String.format("%1$02d ", i));
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
