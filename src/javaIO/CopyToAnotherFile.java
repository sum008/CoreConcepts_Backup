package javaIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyToAnotherFile {

	public static void main(String[] args) {

		try (FileInputStream istream = new FileInputStream(
				"C:\\Users\\sk464\\Documents\\WS\\core_concepts\\src\\javaIO\\source.txt");
				FileOutputStream ostream = new FileOutputStream(
						"C:\\Users\\sk464\\Documents\\WS\\core_concepts\\src\\javaIO\\dest.txt");) {

			int i = 0;
			while (i < istream.available()) {
				int ascii = istream.read();
				char ch = String.valueOf((char) ascii).toLowerCase().charAt(0);
				ostream.write(ch);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
