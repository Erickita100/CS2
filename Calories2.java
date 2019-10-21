/* Najera Ericka
lab assignment 2 part 2
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calories2 {

    public static void main(String[] args) throws FileNotFoundException{
       
        Scanner s = new Scanner(new File("input2.txt"));
           int[][] calories = new int[7][];
            
            int c =0;
         
            while (s.hasNextLine()){
            
            //a string is created to store each line that is read on the while loop
            String line = s.nextLine();
            //an array is created place the words seperated by a space into each element
            String[] allSplits= line.split(" ");
            //this initializes each row with the length of each line
            calories[c]=new int[allSplits.length];
             for(int i=0; i<allSplits.length;i++){
            //this for loop places each element into the array
             calories[c][i] = Integer.parseInt(allSplits[i]);
            
             }
            c++;
            }
            //this is to prevent an error if more or less lines are inputed
            if(c>7 || c<7){
             System.out.print("There are not 7 lines");
             System.exit(0);
            }
        
        //i called the methods
        
         averagePerDay(calories);
         averagePerMeal(calories);
         
         
         int[] x = {1,2,3,4};
         int[] y = x;
          x = new int[2];
          for(int i = 0; i<x.length; i++){
           System.out.print(x[i]+" ");
         
          
        }
         
        
    }
    static void averagePerDay(int[][] calories){
         double[] averages = new double [7];
            int count = 0;
            //these for loops is to get the the sum of the columns
        for(int r=0; r<calories.length;r++){
            int sum = 0;
            for(int c=0;c<calories[r].length;c++){
              sum = sum + calories[r][c]; 
              
            }
            //at the end of the inside loop i save the sum into its respective array space
            averages[count] = sum;
            count++;
        }
        //while this for loop divides all the elements by the length of each row to get the average
         for(int i = 0; i<averages.length; i++){
             averages[i] =averages[i]/calories[i].length;
         
          
        }
        //i printed the results
       System.out.println("The average calories for each day are:");
       System.out.println("  Monday are "+ averages[0]);
       System.out.println("  Tuesday are "+ averages[1]);
       System.out.println("  Wednesday are "+ averages[2]);
       System.out.println("  Thursday are "+ averages[3]);
       System.out.println("  Friday are "+ averages[4]);
       System.out.println("  Saturday are "+ averages[5]);
       System.out.println("  Sunday are "+ averages[6]);
       
       
        
       
    }
    static int lengthOfLongestRow(int[][] calories){
    //i created this to separate the method of the longest row
        int len = calories[0].length;
        for(int i =0; i<calories.length;i++){
            if(calories[i].length>len){
                len = calories[i].length;
            }
        }
        return len;
    }
    static void averagePerMeal(int[][] calories){
        int len = lengthOfLongestRow(calories);
        //one array is to save the sum of each column
        // the int array is to count how many meals have been added into each slot
            double[] meals = new double [len]; 
            int [] counter = new int[len];
            
            //these for loops is to get the the sum of the columns
        for(int r=0; r<calories.length;r++){
            
            
           for(int c=0;c<calories[r].length;c++){
              meals[c]= meals[c]+calories[r][c];
              counter[c]= counter[c]+1;
              
              
            }
          
        }
        //while this for loop divides all the elements to get the average
         for(int i = 0; i<meals.length; i++){
         //each slot of the sum is divided by each of the counter array since each meal had different number of entries
         //it was the only was to know how many additions happened in each sum
             meals[i] = meals[i]/counter[i];
             int count= i+1;
             //i printed the results
            System.out.println("The average of meal "+count+ " is " + meals[i]);
        }
         
       
        
        
    }
}
