package practice;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Main {
	
	public static void sub(String org, String cur, int ind, int mx, List<String> arr) {
		if (ind==mx) {
			return ;
		} 
		int i=ind;
		while (i < mx) {
			sub(org, cur, i+1, mx, arr);
			cur+=org.charAt(i);
			arr.add(cur);
			i+=1;
		}
	}
	
	
	public static void main(String... args) {
		ArrayList<String> arr = new ArrayList<>();
		String org="abcdef";
		sub(org,"",0,org.length(),arr);
		
		//writing the output to file
		try(FileWriter writer = new FileWriter("C:\\Users\\sk464\\Documents\\WS\\core_concepts\\src\\practice\\result.txt");  
			BufferedWriter br = new BufferedWriter(writer)) {
			
			for (String s:arr) {
				br.write(s);
				br.write(" , ");
				br.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}