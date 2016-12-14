package day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.StringTokenizer;

public class D8Q1 {
	private static int height = 6;
	private static int width = 50;

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		boolean fast = false;
		URL url = ClassLoader.getSystemClassLoader().getResource(
				"day8/input.txt");
		BufferedReader br = new BufferedReader(new FileReader(url.getFile()));
		boolean[][] screen = new boolean[width][height];

		String arg = br.readLine();
		while (arg != null) {
			System.out.println(arg);
			StringTokenizer st = new StringTokenizer(arg);
			while (st.hasMoreTokens()) {
				String token = st.nextToken();
				System.out.println(token);
				if (token.equalsIgnoreCase("rect")) {
					token = st.nextToken();
					StringTokenizer st2 = new StringTokenizer(token, "x");
					int w = Integer.parseInt(st2.nextToken());
					int h = Integer.parseInt(st2.nextToken());
					for (int i = 0; i < w; i++) {
						for (int j = 0; j < h; j++) {
							screen[i][j] = true;
						}
					}
					printScreen(screen);
				} else if (token.equalsIgnoreCase("rotate")) {
					token = st.nextToken();
					boolean row = token.equalsIgnoreCase("row");
					int rowCol = Integer.parseInt(st.nextToken().substring(2));
					st.nextToken(); // by
					int count = Integer.parseInt(st.nextToken());

					if (row) {
						// rotate the row
						for (int j = 0; j < count; j++) {
							boolean prev = screen[width - 1][rowCol];
							for (int i = 0; i < width; i++) {
								boolean temp = screen[i][rowCol];
								screen[i][rowCol] = prev;
								prev = temp;
							}
						}
						printScreen(screen);
					} else {
						// rotate the column
						for (int j = 0; j < count; j++) {
							boolean prev = screen[rowCol][height - 1];
							for (int i = 0; i < height; i++) {
								boolean temp = screen[rowCol][i];
								screen[rowCol][i] = prev;
								prev = temp;
							}
						}
						printScreen(screen);

					}

				}
			}

			if (!fast) {
				String in = scan.nextLine();
				if (in != null && in.equalsIgnoreCase("go")) {
					fast = true;
				}
			}
			arg = br.readLine();

		}
		br.close();

		int count = 0;
		for (boolean[] bs : screen) {
			for (boolean b : bs) {
				if (b)
					count++;
			}
		}
		System.out.println("Count: " + count);
	}

	public static void printScreen(boolean[][] screen) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(screen[j][i] ? "#" : ".");
			}
			System.out.println();
		}
	}
}
