/*Najera Ericka
Lab Assignment #1 
9/6/18
*/

package calories;

// these imports are to make the program find the file and create a scanner object
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calories {

    public static void main(String[] args)
        throws FileNotFoundException {
        //the scanner object is created along with 3 arrays to store the values for each meal
        
        Scanner s = new Scanner(new File("/Users/erickanajera/Desktop/CS/input.txt"));
            int[] breakfast = new int[7];
            int[] lunch = new int[7];
            int[] dinner= new int[7];
            int[] total = new int [7];
             
            // the counter is created to initiate a while loop
            int c =0;
         try{   
             //the while loop has the condition that as long as the input file has a next line to continue the loop
        while (s.hasNextLine()){
            
            //a string is created to store each line that is read on the while loop
            String line = s.nextLine();
            //an array is created place the words seperated by a space into each element
            String[] allSplits= line.split(" ");
            
            //while the scanner is going through the array, it places each element into each meal array
                
              breakfast[c] = Integer.parseInt(allSplits[0]);
              lunch[c]=Integer.parseInt(allSplits[1]);
              dinner[c]=Integer.parseInt(allSplits[2]);
              
              
          
        c++;
        }
        // this contidion is to produce an error statement if the input file has too many lines of less
         
         if(c>7 || c<7){
             System.out.print("There are not 7 lines");
             System.exit(0);
         }
         }
         // this catch statement is to return an error when there are not 3 numbers for each line
         
         //error message
         catch(Exception e){
            System.out.println("Error:There are not 3 numbers on each line or 7 lines " );
        System.exit(0); 
            
         }
            
        
        
        

        //i printed the arrays to give a better understanding to the person using this program
        
        //print the arrays
        System.out.println("Breakfast:");
        for(int i=0; i<7;i++){
        System.out.print(breakfast[i]+" ");}
        System.out.println();
        
        System.out.println("Lunch:");
        for(int i=0; i<7;i++){
        System.out.print(lunch[i]+" ");}
        System.out.println();
        
        System.out.println("Dinner:");
        for(int i=0; i<7;i++){
        System.out.print(dinner[i]+" ");}
        System.out.println();
        
        //total calories  
        
        // this for loop creates an array and each element is the sum of all the calories
        for(int i = 0; i<7; i++){
            total[i]= breakfast[i]+lunch[i]+dinner[i];

        }
        // this prints out the total calories for each day
       System.out.println("The total calories for each day:");
       System.out.println("  Monday are "+ total[0]);
       System.out.println("  Tuesday are "+ total[1]);
       System.out.println("  Wednesday are "+ total[2]);
       System.out.println("  Thursday are "+ total[3]);
       System.out.println("  Friday are "+ total[4]);
       System.out.println("  Saturday are "+ total[5]);
       System.out.println("  Sunday are "+ total[6]);
       
       //required calories
       
       // this for loop goes through the array of all the calories and checks if thy are less than 2250
       for(int i = 0; i<7; i++){
       if(total[i]<2250){
           int more = 2250-total[i];
           
           // the if statements are to link the calories with the days
           if(i==0){
             System.out.println("*Monday requires " +more+ " more calories");  
               
           }
           if(i==1){
             System.out.println("*Tuesday requires " +more+ " more calories");  
               
           }
           if(i==2){
             System.out.println("*Wednesday requires " +more+ " more calories");  
               
           }
           if(i==3){
             System.out.println("*Thursday requires " +more+ " more calories");  
               
           }
           if(i==4){
             System.out.println("*Friday requires " +more+ " more calories");  
               
           }
           if(i==5){
             System.out.println("*Saturday requires " +more+ " more calories");  
               
           }
           if(i==6){
             System.out.println("*Sunday requires " +more+ " more calories");  
               
           }
           

            
        }
       
       }
       //average
       
       // initiated the variables for the totals per meal
        int tb=0;
        int tl=0;
        int td=0;
        // this foor loop is to go through each meal array and add them to their respective variable
        for(int i = 0; i<7; i++){
   
         tb =tb+ breakfast[i];
         tl= tl+lunch[i];
         td= td+dinner[i];
        
        }
        // then take each total an divide by 7 to get th average
  
        int avgB = tb / 7;
       int avgL = tl / 7;
        int avgD = td /7;
        
        //this prints the average per meal
      System.out.println("The average calories consumed per meal are:");
      System.out.println(" - Breakfast are "+ avgB);
      System.out.println(" - Lunch are "+ avgL);
      System.out.println(" - Dinner are "+ avgD);
        
}  
}
