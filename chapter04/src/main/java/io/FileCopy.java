package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {

	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = new FileInputStream("hello.png");
			os = new FileOutputStream("hello.copy.png");
			
			int data = -1;
			while((data = is.read()) != -1) {
				os.write(data);;
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found: " + e);
		} catch (IOException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (is != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}

}
