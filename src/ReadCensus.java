import java.io.*;
import java.util.Scanner;

public class ReadCensus {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("/Users/davidblossomii/Desktop/EN605201/Module 10/"
				+ "SmallAreaIncomePovertyEstData v2.txt");
		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine())
		{
			System.out.println(scan.nextLine());
		}
		
		

	}

}
