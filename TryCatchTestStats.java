/*
 Lina Breunlin
CIS 1633 AA Java
November 9, 2019
Program reads test score data from an input file and then outputs statistics to an outputfile
Test Data

Input (file name)             Output (count, total, max, min, avg)                    Passed?
testscores.txt                  29, 2043, 100, 25, 70.00                                Y
empty.txt                       0, 0, 0, 0, 0                                           Y
myscores.txt                    error. file not found                                   Y                                          
 */
package trycatchteststats;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class TryCatchTestStats {

    public static void main(String[] args) {
    
    //declare variables
    String inputFileName;
    String outputFileName;
    
    //prompt user for name of input file
    Scanner inScreen = new Scanner (System.in);
    
    System.out.println ("Please enter the input file name:");
    
    inputFileName = inScreen.next();
    
    System.out.println ("Please enter the output file name: ");
    
    outputFileName = inScreen.next();
    
    File inputFile = new File(inputFileName);
    
    try
    {
       //scanner object and printwriter for reading and writing to files
        Scanner inputFileObject = new Scanner(inputFile);
        
        PrintWriter outputFileObject = new PrintWriter(outputFileName);
        
        fileProcess (inputFileObject, outputFileObject);
        
        inputFileObject.close();
        
        outputFileObject.close();
    }
    
    catch (FileNotFoundException e)
    {
        //give error message for file not found exception
        System.out.println("Error. File not Found.");           
    }
        
   
    }
    
    /*
        @param inFile = input file
        @param outFile = output file
    */
   
    public static void fileProcess (Scanner inFile, PrintWriter outFile)
    {
     //declare variables
       int score = 0;
       int classTotal = 0;
       int classCount = 0;
       double classAvg = 0;
       int classMax = 0;
       int classMin = 100;
       
       //declare constants
       final int MAX_SCORE = 100;
       
          // while (inFile.hasNextInt())  
            while (inFile.hasNextInt())
  
             {
                //read test scores from the input file
               //score = inFile.nextInt();
            
                     
                 
                     score = inFile.nextInt();
                 
                      
                    if ((score >=0 ) && (score <= MAX_SCORE))
                    {
                      classTotal = classTotal + score;
                      
                      classCount = classCount + 1;
                      
                        if (score > classMax)
                        {
                            // if this score is greater than the current max score it becomes the max score and all the others get tested against it
                            classMax = score;
                        }
                        if (score < classMin)
                        {
                            //if this score is less than the current min score it becomes the min score and the others get tested agaisnt it
                            classMin = score;
                        }
                      
                    }
                 
             }
            if (classCount == 0)
                {
                    classMin = 0;

                    classMax = 0;

                    classAvg = 0;

                    classTotal = 0;

                }
            else
                {
                    classAvg = classTotal/classCount;  
                }
            
            outFile.println();
            
            outFile.println("Number of processed test scores: "  + classCount);
            
            outFile.println ("Sum of test scores: " + classTotal);
            
            outFile.println ("Highest test score: " + classMax);
            
            outFile.println ("Lowest test scores: " + classMin);
            
            outFile.printf ("Average test scores: " + "%,.2f",classAvg);
            
            
    
       }
       
       
       
        
        
        
    }
    
    
    
    

