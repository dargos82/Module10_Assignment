import java.io.*;
import java.util.Scanner;

public class ReadCensus 

{

   public static void main(String[] args) throws FileNotFoundException 
   {
      State s = new State();
      
      File file = new File("/Users/davidblossomii/Desktop/EN605201/Module 10/"
				+ "SmallAreaIncomePovertyEstData v2.txt");
      Scanner scan = new Scanner(file);
		
      while( scan.hasNextLine() )
      {
         int stateId = scan.nextInt();
         
         for(scan.nextInt() == stateId; )
      }
		
      String newFileName = "Census_Report.txt";
      File outputFile = new File( newFileName );
		
      if( outputFile.exists() );
      {
         System.out.println( "File already exists.  Program ending." );
         System.exit(1);
      }
   }
   
   private int stateId;

}
