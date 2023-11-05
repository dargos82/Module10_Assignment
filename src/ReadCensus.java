import java.io.*;

public class ReadCensus 
{
   
   public static void main(String[] args) throws IOException
   {      
      //State s = new State();
      
      //Variables for command-line parameters
      String fileName = args[0];
      String outputFileName = args[1];
      int numberOfRecords = Integer.parseInt(args[2]);
      
      File file = new File( fileName );  //create new File object for input file
      File outputFile = new File( outputFileName ); //create new File object for output file
      int[] population = new int[56];
      //float[] population = new float[56];
      int[] childPopulation = new int[56];
      int[] childPovertyPopulation = new int[56];
      //float calcPCP = 0;
      //float[] percentChildPoverty = new float[56];
      
      //create output file with header info
      PrintWriter fileOutput = new PrintWriter( new BufferedWriter( new FileWriter( outputFile, true) ) );

      fileOutput.println("State     " + "Population  " + "Child Population  " + "Child Poverty Population  " +
                       "% Child Poverty");
      fileOutput.println("-----     " + "----------  " + "----------------  " + "------------------------  " +
                       "---------------");
      
      //initialize variables
      BufferedReader fileInput = null;
      String record = null;
      
      try
      {
         fileInput = new BufferedReader( new FileReader( file ) );
         
         while( ( record = fileInput.readLine() ) !=  null)
         {
           
            String strStateId = record.substring(0, 3);
            int stateId = Integer.parseInt( strStateId.trim() );
            
            String strDistrictPop = record.substring(83, 91);
            int districtPop = Integer.parseInt( strDistrictPop.trim() );
            
            String strDistrictChildPop = record.substring(92, 100);
            int districtChildPop = Integer.parseInt( strDistrictChildPop.trim() );
            
            String strDistrictChildPovertyPop = record.substring(101, 109);
            int districtChildPovertyPop = Integer.parseInt( strDistrictChildPovertyPop.trim() );
            
            population[stateId - 1] +=  districtPop;
            childPopulation[stateId - 1] += districtChildPop;
            childPovertyPopulation[stateId - 1] += districtChildPovertyPop;
                
         }

         for(int i = 0; i <= 55; i++)
         {
            if(population[i] != 0)
            {
               float calcPCP = (100 * ((float) (childPovertyPopulation[i]) / childPopulation[i]));
               int printStateId = i + 1;
               
               fileOutput.printf( "   %02d    %,11d  %,16d  %,24d  %15.2f %n", printStateId, population[i], 
                     childPopulation[i], childPovertyPopulation[i], calcPCP);
            }
         }
  
      } catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
      
      fileInput.close();
      fileOutput.close();

   }
   
}
