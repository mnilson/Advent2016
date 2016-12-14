package day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D7Q2 {

	public static void main(String[] args) throws IOException {
		URL url = ClassLoader.getSystemClassLoader().getResource("day7/input.txt");
		BufferedReader br = new BufferedReader(new FileReader(url.getFile()));
		int success = 0;
		String arg = br.readLine();
		input: while (arg!= null) {
			System.out.println("Parsing: " + arg);
			StringTokenizer st = new StringTokenizer(arg, "[]");
			List<String> hypernets = new ArrayList<String>();
			List<String> supernets = new ArrayList<String>();
			while(st.hasMoreElements()){
				String current = st.nextToken();
				if(arg.indexOf(current) == 0 || arg.charAt(arg.indexOf(current)-1) == ']'){
					// not a hypernet sequence.
					supernets.add(current);
				}else{
					hypernets.add(current);
				}
			}
			List<String> abas = new ArrayList<String>();
			for(String supernet : supernets){
				abas.addAll(findAbas(supernet));
			}
			
			for(String aba : abas){
				if(containsBab(hypernets, aba)){
					success++;
					arg = br.readLine();
					System.out.println(" Pass");
					continue input;
				}
			}
			
			arg = br.readLine();
			System.out.println(" Fail");
		}

		System.out.println("Success: " + success);
		br.close();
	}

	private static List<String> findAbas(String input) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < input.length() - 2; i++) {
			String substr = input.substring(i, i + 3);
			char[] chars = substr.toCharArray();
			if (chars[0] == chars[2] && chars[0] != chars[1]) {
				result.add(new String(chars));
			}
		}

		return result;
	}
	
	private static Boolean containsBab(List<String> inputs, String aba){
		
		char a = aba.charAt(0);
		char b = aba.charAt(1);
		for(String input : inputs){
			char[] chars =  input.toCharArray();
			for(int i = 0; i<input.length()-2;i++){
				if(chars[i] == b && chars[i+1] == a && chars[i+2]==b ){
					return true;
				}
			}
		}
		
		return false;
	}
}
