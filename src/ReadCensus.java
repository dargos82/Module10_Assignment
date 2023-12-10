import java.io.*;

/** class ReadCensus contains the objects, variables, and arrays needed to open, read, and output
 * a new file. 
 * 
 * @authors George Haralampopulos and David Blossom
 */
public class ReadCensus 
{
   /** main()
    * This method creates the File objects, calls PrintWriter(), BufferedWriter(), FileWriter(),
    * BufferedReader(), FileReader() and holds the variables and arrays to read, store, and write
    * data.
    * 
    *  @param fileName
    *  @param outputFileName
    *  @param file
    *  @param outputFile
    *  @param population
    *  @param childPopulation
    *  @param childPovertyPopulation
    *  @param fileOutput
    *  @param fileInput
    *  @param record
    *  @param strStateId
    *  @param stateId
    *  @param strDistrictPop
    *  @param districtPop
    *  @param strDistrictChildPop
    *  @param districtChildPop
    *  @param strDistrictChildPovertyPop
    *  @param districtChildPovertyPop
    *  @param calcPCP
    *  @param printStateId
    */
   public static void main(String[] args) throws IOException
   {      
      
      //Variables for command-line parameters
      String fileName = args[0]; //get String from command-line input
      String outputFileName = args[1]; //get String from command-line input
      
      File file = new File( fileName );  //create new File object for input file
      File outputFile = new File( outputFileName ); //create new File object for output file
      
      //create arrays to hold data from the input file
      int[] population = new int[56]; 
      int[] childPopulation = new int[56];
      int[] childPovertyPopulation = new int[56];
      
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
                
         } //end while loop
         
         //iterate through arrays to get values and write to output file
         for(int i = 0; i <= 55; i++)
         {
            if(population[i] != 0) //logic not to write rows without any data; prevent divide by zero
            {   
               //calculate the percentage of children in poverty
               float calcPCP = (100 * ((float) (childPovertyPopulation[i]) / childPopulation[i]));
               int printStateId = i + 1;
               
               //write selected data to output file
               fileOutput.printf( "   %02d    %,11d  %,16d  %,24d  %15.2f %n", printStateId, population[i], 
                     childPopulation[i], childPovertyPopulation[i], calcPCP);
            } //end if statement
         } //end for loop
  
      } catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
      
      fileInput.close();
      fileOutput.close();

   } //end main()
   
} //end class ReadCensus
