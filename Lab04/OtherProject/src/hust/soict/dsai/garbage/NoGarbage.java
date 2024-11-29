package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
	public static void main(String[] args) {
		String filename = "src/hust/soict/dsai/garbage/text.txt";
		byte[] inputBytes = { 0 };
		long startTime, endTime;
		String s = "";
		try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }
		startTime = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for (byte b: inputBytes) {
			sb.append((char) b);
		}
		s = sb.toString();
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}
