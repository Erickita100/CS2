
/* Najera Ericka
CS 2401 
LAB 3
*/



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {

    
    public static void main(String[] args) throws FileNotFoundException{
        
        //this reads the file and creates an array of object to store the information
       
   Scanner s = new Scanner(new File("input.txt"));
   
        Package[] box = new Package[6];
            
            
         try{
             int i =0;
            while (s.hasNextLine()){
            
            //a string is created to store each line that is read on the while loop
            String line = s.nextLine();
            //an array is created place the words seperated by a space into each element
            String[] allSplits= line.split(" ");
            
            //while the scanner is going through the array, it places each element into the package array
              double width = Double.parseDouble(allSplits[0]);
              
              double height = Double.parseDouble(allSplits[1]);
       
              double length = Double.parseDouble(allSplits[2]);
              
              //each varible is saved and plugged into the constructor to create an object in each array
             
                 box[i] = new Package(width,height,length);
                 i++;
            }
          }
         //this catches the error as well if there are not 3 numbers on each line
          catch(Exception e){
           System.out.println("Error:There are not 3 numbers on each line or 6 rows " );
           System.exit(0); 
            
         }
         
       //here i called each of the methods and plugged in the array of objects
     
     largestPackage(box);
     cubic(box);
     printReport(box);
     avgVol(box);
       
       
        
    }
    //this largest method i created the counter and a double for the largest volume
    //the for loop i started at one because i set the double to the first element already
    //i check if the volume of package i is bigger than the one saved in the double and save the index of that box
    static void largestPackage(Package[] box){
        int index =0;
        double largest = box[0].getVolume();
        for (int i =1; i<box.length;i++){
            if(largest < box[i].getVolume()){
                largest = box[i].getVolume();
                index =i;
            }
        }
        System.out.println("The largest package is index "+index);
     System.out.println("with a width of "+ box[index].getWidth()+ " height of "+ box[index].getHeight()+" and a length of "+box[index].getLength());
    }
    
    //this method checks if the package is cubic or not then adds one to the isCube or notCube variable
    
    static void cubic(Package[] box){
        int isCube = 0;
        int notCube =0;
        for(int i =0;i<box.length;i++){
            if(box[i].isCube()==true){
               isCube++; 
            }
            else{
                notCube++;
            }
        }
        System.out.println("There are "+ isCube +" cubic packages and "+notCube+ " not cubic packages" );
        
       
    }
    //this method prints a report of all the packages index and dimenstions
    //the for loop a goes thorugh each box at goes through all the getters since its private
    static void printReport(Package[] box){
        for(int i =0;i<box.length;i++){
            System.out.println("Package index "+i);
            System.out.println("width: "+ box[i].getWidth()+ " height: "+ box[i].getHeight()+" length: "+box[i].getLength());
        }
    }
    
    // this method goes back to the checking if the isCube method is true for each package
    //if it is cube then in adds the volume into the average variable then adds to the counter to see how much to divide it by
    static void avgVol(Package[] box){
        double average = 0;
        int count =0;
        for(int i =0;i<box.length;i++){
            if(box[i].isCube()==true){
               average= average + box[i].getVolume();
               count ++;
            }
        }
        average= average/count;
        System.out.println("The average volume of cubic packages is "+average);
    }
    
}
