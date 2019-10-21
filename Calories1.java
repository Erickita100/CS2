/*Ericka Najera
lab assignment 2 part 2
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calories1 {

    public static void main(String[] args) throws FileNotFoundException{
       
        Scanner s = new Scanner(new File("input1.txt"));
           int[][] calories = new int[7][3];
            
            int c =0;
         try{
            while (s.hasNextLine()){
            
            //a string is created to store each line that is read on the while loop
            String line = s.nextLine();
            //an array is created place the words seperated by a space into each element
            String[] allSplits= line.split(" ");
            
            //while the scanner is going through the array, it places each element into the calorie array
               
              calories[c][0] = Integer.parseInt(allSplits[0]);
              
              calories[c][1] = Integer.parseInt(allSplits[1]);
             
              calories[c][2] = Integer.parseInt(allSplits[2]);
            
            c++;
            }
            //this is to prevent an error if more or less lines are inputed
            if(c>7 || c<7){
             System.out.print("There are not 7 lines");
             System.exit(0);
         }
           }
         //this catches the error as well if there are not 3 numbers on each line
           catch(Exception e){
            System.out.println("Error:There are not 3 numbers on each line or 7 lines " );
        System.exit(0); 
            
         }
         
         totalCalPerDay(calories);
         averagePerDay(calories);
         averagePerMeal(calories);
         maxPerDay (calories);
         maxPerMeal(calories);
        
    }
    static void totalCalPerDay(int[][] calories){
        //an int array is created to store the totals of each day
       int[] total = new int[7];
       //this for loop is to add all the element of the array and store them into the array
       for(int i = 0; i<calories.length; i++){
            total[i]= calories[i][0]+calories[i][1]+calories[i][2];
        }
       //this prints the result by each array position
       System.out.println("The total calories for each day are:");
       System.out.println("  Monday are "+ total[0]);
       System.out.println("  Tuesday are "+ total[1]);
       System.out.println("  Wednesday are "+ total[2]);
       System.out.println("  Thursday are "+ total[3]);
       System.out.println("  Friday are "+ total[4]);
       System.out.println("  Saturday are "+ total[5]);
       System.out.println("  Sunday are "+ total[6]);
      
    }
    static void averagePerDay(int[][] calories){
        int[] averages = new int[7];
        
        //this foor loop adds all the elements of the rows and then divides by three to get the average
       for(int i = 0; i<calories.length; i++){
            averages[i]= calories[i][0]+calories[i][1]+calories[i][2];
        }
       for(int i = 0; i<averages.length; i++){
             averages[i] =averages[i] / 3;
            
        }
      System.out.println("The average calories for each day are:");
       System.out.println("  Monday are "+ averages[0]);
       System.out.println("  Tuesday are "+ averages[1]);
       System.out.println("  Wednesday are "+ averages[2]);
       System.out.println("  Thursday are "+ averages[3]);
       System.out.println("  Friday are "+ averages[4]);
       System.out.println("  Saturday are "+ averages[5]);
       System.out.println("  Sunday are "+ averages[6]);
       
    }
    static void averagePerMeal(int[][] calories){
            int[] meals = new int [3]; 
            int[] avgMeals = new int [3];
            int count = 0;
            //these for loops is to get the the sum of the columns
        for(int c=0; c<calories[0].length;c++){
            int sum = 0;
           
            
            for(int r=0;r<calories.length;r++){
              sum = sum +calories[r][c]; 
              
            }
            meals[count] = sum;
            count++;
        }
        //while this for loop divides all the elements to get the average
         for(int i = 0; i<meals.length; i++){
             avgMeals[i] =meals[i]/7;
            
        }
         System.out.println("The average calories for each meal are:");
       System.out.println("  Breakfact are "+ avgMeals[0]);
       System.out.println("  Lunch are "+ avgMeals[1]);
       System.out.println("  Dinner are "+ avgMeals[2]);
       
        
        
    }
    static void maxPerDay (int[][] calories){
        int[] maxCals = new int[7];
        int count =0;
        //these for loop along with the if statement is to check the rows and save the biggest number
        
       for(int r = 0; r<calories.length; r++){
           int max=0;
            for(int c=0;c<calories[0].length;c++){
                if(max< calories[r][c]){
                    max = calories[r][c];
                    
                }
            }
            //then i save the biggest number at the end to the maxCals array
            maxCals[count] = max;
            count++;
       }
        
       System.out.println("The maximum calories for each day are:");
       System.out.println("  Monday are "+ maxCals[0]);
       System.out.println("  Tuesday are "+ maxCals[1]);
       System.out.println("  Wednesday are "+ maxCals[2]);
       System.out.println("  Thursday are "+ maxCals[3]);
       System.out.println("  Friday are "+ maxCals[4]);
       System.out.println("  Saturday are "+ maxCals[5]);
       System.out.println("  Sunday are "+ maxCals[6]);
    }
    static void maxPerMeal(int[][] calories){
        int[] maxCals = new int [3]; 
            int count = 0;
            //this for loop checks the columns and saves the biggest number to the max int
        for(int c=0; c<calories[0].length;c++){
            int max = 0;
           
            
            for(int r=0;r<calories.length;r++){
                if(max<calories[r][c])
              max = calories[r][c]; 
              
            }
            //this saves the biggest number to the maxCals array
            maxCals[count] = max;
            count++;
        }
        System.out.println("The maximum calories for each meal are:");
       System.out.println("  Breakfast are "+ maxCals[0]);
       System.out.println("  Lunch are "+ maxCals[1]);
       System.out.println("  Dinner are "+ maxCals[2]);
       
        
    }
    }


    
         