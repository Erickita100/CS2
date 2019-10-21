/* Najera Ericka
CS 2401 
LAB 5
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {

    
    public static void main(String[] args) throws FileNotFoundException{
       
        //here i created my linkedlist by sending it to the readFile method
        LinkedList myLL = new LinkedList();
        
        myLL = readFile("/Users/erickanajera/Desktop/CS/input.txt", myLL);
        
        //this calls the methods to print in order and reverse
         myLL.printAllBoxes();
        myLL.printReverse();
        
       //this calls the smallest box method
       smallestBox(myLL);
       System.out.println();
       
       //this calls the largest box method
       largestBox(myLL);
       System.out.println();
       
       //this prints how many cubic boxes there are
       System.out.println("There are "+ cubicBoxes(myLL) + " cubic boxes");
       System.out.println();
       //this saves the box that we will removed
        Box removed = myLL.getBox(2);
        
        //we removed box index 2
        myLL.removeNode(2);
        //then prints the linked box after removing
        System.out.println("Linked list after removing box index 2");
        myLL.printAllBoxes();
        
        //this inserts the same box we removed.
        System.out.println("Linked list after inserting box index 2");
        if(myLL.insertNode(removed,2)==true){
        myLL.printAllBoxes();
        }
        else{
            System.out.println("Insertion was incomplete");
        }
        
    }
    
    //this method is to read the file using a try and catch
    static LinkedList readFile(String fileName, LinkedList myLL) throws FileNotFoundException{
         
         Scanner s = new Scanner(new File(fileName));
         
            //this trys and catches the error of not having 3 numbers for the variables
            //this read the file and saves the data into a array
         try{
             
            while (s.hasNextLine()){
            
            String line = s.nextLine();
           
            String[] allSplits= line.split(" ");
            
           
              double width = Double.parseDouble(allSplits[0]);
              double height = Double.parseDouble(allSplits[1]);
              double length = Double.parseDouble(allSplits[2]); 
        //here i created a box with that lines data
               Box temp =  new Box(width,height,length);
     //if the head is nonexistent then that box becomes the head
               if(myLL.head == null){
                    myLL.head=temp;
               }
               else{
                   //if there is already a head then we just simply use the add node method to add it to the linked list
                    myLL.addNode(temp);
                    
               }   
            }
            
          }
         //this catches the error as well if there are not 3 numbers on each line
          catch(Exception e){
           System.out.println("Error:There are not 3 numbers on each line  " );
           System.exit(0); 
            
         }
         return myLL;
        
        }
   
   static void smallestBox(LinkedList myLL){
       //if head doesnt exist it prints there are no boxes
       if(myLL.head==null){
           System.out.println("There are no boxes");
       }
       //the counter is to keep track of the indexes
       //the index is to save the index of the smallest
       
       int counter =0;
       int index =0;
       //this is to compare it to the other values
       double min = myLL.head.getVolume();
       
       myLL.initiateIterator();
       //this temp is to make the temp the iterator
         Box temp = myLL.iterator;
         Box minBox= myLL.head;
         //the minBox is to save the data of the smallest box
             while(temp!= null){
                 if(temp.getVolume()<min){
                   //if the next box is smaller then in saves the index, the volume and the data of the box
                   index = counter;
                   min = temp.getVolume();
                   minBox = temp;
                 }
                 //then it keeps cheking for the smallest
                 temp = myLL.getNextBox();
                 counter++;
                 
             }
             //this simply prints the result
             System.out.println("The smallest box is index:"+index);
                   System.out.println("Width:"+minBox.getWidth()+" Height: "+minBox.getHeight()+" length: "+minBox.getLength()+" Volume: "+minBox.getVolume());
                 
       
   }

   //this method does the same but returns the index of the largest box
   //everything is the same just the if condition is greater than to check if the volume is bigger
   static void largestBox(LinkedList myLL){
      //if head doesnt exist it prints there are no boxes
       if(myLL.head==null){
           System.out.println("There are no boxes");
       }
       //the counter is to keep track of the indexes
       //the index is to save the index of the smallest
       
       int counter =0;
       int index =0;
        //this is to compare it to the other values
       double max = myLL.head.getVolume();
       
       myLL.initiateIterator();
        //this temp is to make the temp the iterator
         Box temp = myLL.iterator;
         //the minBox is to save the data of the largest box
         Box maxBox= myLL.head;
             while(temp!= null){
                 if(temp.getVolume()>max){
                      //if the next box is larger then in saves the index, the volume and the data of the box
                   index = counter;
                   max = temp.getVolume();
                   maxBox = temp;
                 }
                 //then it keeps cheking for the largest
                 temp = myLL.getNextBox();
                 counter++;
                 
             }
             //this simply prints the result
             System.out.println("The largest box is index:"+index);
                   System.out.println("Width:"+maxBox.getWidth()+" Height: "+maxBox.getHeight()+" length: "+maxBox.getLength()+" Volume: "+maxBox.getVolume());
         
   }
   
           
   //this method returns the number of cubic boxes in the linked list
   static int cubicBoxes(LinkedList myLL){
       //this keeps count of how many boxes there are
       int cubes = 0;
       
       Box temp = myLL.head;
       myLL.initiateIterator();
       //it goes through the while loop and checks is the isCube method in the class is true then adds one to the counter for cubes
       while(temp!= null){
           if(temp.isCube()==true){
               cubes++;
           }
           //this goes to the next box
             temp = myLL.getNextBox();
           
       }
       return cubes;
   }
  
 
   }
    
    
