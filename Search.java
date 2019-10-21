/*Ericka Najera
LAB 7
CS 2401
*/

import static java.lang.System.nanoTime;
import java.util.Arrays;

public class Search {
    public static void main(String[] args) {
        
        //here i create an array with the testing size of the array
        double[] firstArray = new double[10000];
        //here i call the createArray method to initiate random values
        createArray(firstArray);
        totalAverage(firstArray,10000);
        
         //this repeats for each test size of the arrays
                
        double[] secondArray = new double[40000];
        createArray(secondArray); 
        totalAverage(secondArray,40000);
        
                
        double[] thirdArray = new double[160000];
        createArray(thirdArray); 
        totalAverage(thirdArray , 160000);
       
        
        double[] fourthArray = new double[640000];
        createArray(fourthArray); 
        totalAverage(fourthArray,640000);
        
        
        double[] fifthArray = new double[1280000];
        createArray(fifthArray); 
        totalAverage(fifthArray, 1280000);

      
    }
        //here i call both the linear and binary methods and print the average time each took
        public static void totalAverage(double[] array, int size){
            //this is to save the total average
        long linAverage = 0;
        long binAverage = 0;
        //runs it 30 times with different searchees but both programs
        for(int i=0; i<30;i++){
            //this will create a new one every test of the 30
             int searchee =(int) Math.floor(Math.random() * Math.floor(array.length));
             //then i call the average method of each
             linAverage = linAverage + linearAverage(array,searchee);
             binAverage = binAverage + binaryAverage(array ,searchee);
        }
        //here i divide both by 30 to get the average
        linAverage =linAverage /30 ;
        //this converts the nano seconds to seconds
        double linSeconds = (double)linAverage / 1_000_000_000.0;
        binAverage = binAverage/30;
        double binSeconds = (double)binAverage / 1_000_000_000.0;
        //i print the results
        System.out.println("Linear Test ("+ size+ ") elements "+ linSeconds +" seconds or " + linAverage+" nanoseconds");
        System.out.println("Binary Test ("+ size+ ") elements "+binSeconds+" seconds or " + binAverage+" nanoseconds");
        
        System.out.println();
        }
       
    
        
    public static long linearAverage(double[] array, int searchee){
        //here i create a long to save the time the test took
        long average = 0;
        //here i record the time in nano sine millis was giving me zero
            long start = nanoTime();
            //here i save the number of the index for no reason just to test
            //i call the linear search method with the random index searchee
            int linear = linearSearch(array,array[searchee]);
            //i recorded the time
            long finish = nanoTime();
            //here i add to the average the subtracted time to find the actual time the method took to run
            average = finish - start;
         
        
        //after i subtracted the times i return the value
        return average;
    }
     public static long binaryAverage(double[] array, int searchee){
         //here i create a long to save the average all tests took
        long average = 0;
         //here i record the time in nano sine millis was giving me zero
            long start = nanoTime();
            //here i save the number of the index for no reason just to test
            //i call the binary search method with the random index searchee
            int binary = binarySearch(array,array[searchee]);
             //i recorded the time
            long finish = nanoTime();
            //here i add to the average the subtracted time to find the actual time the method took to run
            average = finish - start;
        
        //after the time is subracted i return the value
 
        return average;
    }
    
    public static void createArray(double[] array){
        //this for loop goes through each element of the array and makes it a random number
        for(int i=0; i<array.length;i++){
            array[i] = Math.random();
             
        }
        //here i make the array sorted
      Arrays.sort(array);
      
    } 
    public static int linearSearch(double[] array, double number){
        //the for loop goes through the array
        
        for(int i=0;i<array.length;i++){
            //if the number is the one we are looking for it returns the index
            if(array[i]==number){
                
                return i;
            }
        }
        //if the number is not found we return -1
       
        return -1;
        
    }
    public static int binarySearch(double[] array, double number){
        //here i save the first element and the last
        int left = 0; 
        int right = array.length - 1; 
        // as long as the left sid is not equal to the right we keep goind
        while (left <= right) 
        { 
            //here i get the middle index of the array
            int mid = left + (right-left)/2; 
  
            // i check if number is the middle element
            //is yes i return the middle
            if (array[mid] == number) 
                return mid; 
  
            // if the number is greater than the middle we forget the left side and make the left the middle
            if (array[mid] < number) 
                left = mid + 1; 
  
            // if the number is smaller we forget the right side and make the middle the last element
            else
                right= mid - 1; 
        } 
  
        // if the number is not found -1 is returned
        return -1; 
    }
    
}
