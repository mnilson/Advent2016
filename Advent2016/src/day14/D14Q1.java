package day14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class D14Q1 {

	public static int time = 0;
	static List<Disc> discs = new ArrayList<Disc>();

	public static void main(String[] args) throws IOException {
		URL url = ClassLoader.getSystemClassLoader().getResource(
				"day14/input.txt");
		BufferedReader br = new BufferedReader(new FileReader(url.getFile()));
		String arg = br.readLine();
		while (arg != null) {
			StringTokenizer st = new StringTokenizer(arg);
			st.nextToken(); // Disk
			st.nextToken(); // num
			st.nextToken(); // has
			int positions = Integer.parseInt(st.nextToken());
			st.nextToken(); // positions;
			st.nextToken(); // at
			st.nextToken(); // time=0;
			st.nextToken(); // it
			st.nextToken(); // is
			st.nextToken(); // at
			st.nextToken(); // position
			String next = st.nextToken();
			int currPos = Integer
					.parseInt(next.substring(0, next.length() - 1));
			discs.add(new Disc(positions, currPos));
			arg = br.readLine();
		}
		for (Disc spin : discs) {
			System.out.println(" Disc " + discs.indexOf(spin) + " pos "
					+ spin.currentPosition);
		}

		boolean done = false;
		while (!done) {

			done = true;
			int fail = -1;
//			System.out.print(time);
			for (Disc d : discs) {
//				System.out.printf(" %02d", d.posInSecs(discs.indexOf(d) + 1));
				if (d.posInSecs(discs.indexOf(d) + 1) == 0) {
					// g2g
				} else {
					fail = discs.indexOf(d);
					done = false;
					break;
				}
			}
//			System.out.println();
//			System.out.print(time);
//			for (Disc spin : discs) {
//				System.out.printf(" %02d", spin.currentPosition);
//			}
//			System.out.println( " " + fail);
			if (done) {
				System.out.println("Earliest StartTime = " + time);
				break;
			}
			time++;
			for (Disc spin : discs) {
				spin.moveForward();
			}
//			if (time > 440895) {
//				System.out.println("Dead");
//				break;
//			}
		}

	}
}
