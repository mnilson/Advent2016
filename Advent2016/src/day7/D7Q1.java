package day7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.StringTokenizer;

public class D7Q1 {

	public static void main(String[] args) throws IOException {
		URL url = ClassLoader.getSystemClassLoader().getResource("day7/input.txt");
		BufferedReader br = new BufferedReader(new FileReader(url.getFile()));
		int success = 0;
		
		String arg = br.readLine();
		input: while (arg!= null) {
			System.out.print("Parsing: " + arg);
			StringTokenizer st = new StringTokenizer(arg, "[]");
			int goodOnes = 0;
			while(st.hasMoreElements()){
				String current = st.nextToken();
				if(arg.indexOf(current) == 0 || arg.charAt(arg.indexOf(current)-1) == ']'){
					// not a hypernet sequence.
					if(containsAbba(current)){
						goodOnes++;
						continue;
					}
				}else{
					// hypernet sequence
					if(containsAbba(current)){
						arg = br.readLine();
						continue input;
					}
				}
			}
			if(goodOnes > 0){
				success++;
				System.out.println(" PASS");
			}else{
				System.out.println(" FAIL");
			}
			arg = br.readLine();
		}

		System.out.println("Success: " + success);
	}

	private static Boolean containsAbba(String input) {
		for (int i = 0; i < input.length() - 3; i++) {
			String substr = input.substring(i, i + 4);
//			System.out.println(substr);
			char[] chars = substr.toCharArray();
			if (chars[0] == chars[3] && chars[1] == chars[2]
					&& chars[0] != chars[1]) {
				return true;
			}
		}

		return false;
	}
}
