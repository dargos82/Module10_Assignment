import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCensus 
{
   //public ArrayList<Float> population = new ArrayList<Float>();
   //public ArrayList<Float> childPopulation = new ArrayList<Float>();
   //public ArrayList<Float> childPovertyPopulation = new ArrayList<Float>();
   
   public static void main(String[] args) throws IOException
   {
      State s = new State();
      ArrayList<Integer> population = new ArrayList<Integer>();
      ArrayList<Integer> childPopulation = new ArrayList<Integer>();
      ArrayList<Integer> childPovertyPopulation = new ArrayList<Integer>();
      
      Scanner input = new Scanner(System.in);
      
      System.out.print( "Filename (include path and .txt): "); //input file
      String fileName = input.nextLine();
      System.out.print( "\nOutput filename: "); //output file
      String outputFileName = input.nextLine();
      System.out.print( "\nNumber of records: "); //# of records
      int numberOfRecords = input.nextInt();
      
      File file = new File( fileName );  //create new File object
      
      BufferedReader fileInput = null;
      String record = null;
      
      try
      {
         fileInput = new BufferedReader( new FileReader( file ) );
         
         while( ( record = fileInput.readLine() ) !=  null)
         {
            //int stateId = Integer.parseInt(record.substring(1, 3));
            String strStateId = record.substring(0, 3);
            int stateId = Integer.parseInt(strStateId.trim() );
            //float districtId = Float.parseFloat( record.substring(4, 9) );
            //String districtName = record.substring(10, 82);
            String strDistrictPop = record.substring(83, 91);
            int districtPop = Integer.parseInt( strDistrictPop.trim() );
            population.add(districtPop); //add districtPop value to ArrayList
            String strDistrictChildPop = record.substring(92, 100);
            int districtChildPop = Integer.parseInt( strDistrictChildPop.trim());
            childPopulation.add(districtChildPop);
            String strDistrictChildPovertyPop = record.substring(101, 109);
            int districtChildPovertyPop = Integer.parseInt( strDistrictChildPovertyPop.trim());
            childPovertyPopulation.add(districtChildPovertyPop);
            //String dataTag = record.substring(110, 131);
            
            System.out.print( stateId );
            System.out.print( "\t" + districtPop );
            System.out.print( "\t" + districtChildPop );
            System.out.println( "\t" + districtChildPovertyPop );
            
         }
         fileInput.close();
         
      } catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
      
      
      /*Integer sumPopulation[] = new Integer[population.size()]; //create new array
      sumPopulation = population.toArray(sumPopulation); //convert ArrayList to array
      
      int totalPop = 0;
      
      for(int i : sumPopulation) //iterate through array
      {
         totalPop += i; //sum population values
      }
      
      System.out.println( "total pop: " + totalPop );*/
      
   }
   
   //private int stateId;

}
