package day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D8Q2 {

	public static void main(String[] args) throws IOException {
		URL url = ClassLoader.getSystemClassLoader().getResource("day7/input.txt");
		BufferedReader br = new BufferedReader(new FileReader(url.getFile()));
		int success = 0;
		String arg = br.readLine();
		input: while (arg!= null) {
			
			arg = br.readLine();
		}
			br.close();
	}
}
