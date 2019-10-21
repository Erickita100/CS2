
/* Najera Ericka
CS 2401 
LAB 4
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {

    
    public static void main(String[] args) throws FileNotFoundException{
        
    //here i created the box object 
    //then called the method to read the file
       
       Box head = null;
       head =readFile(head,"input.txt");
       
       
       //here i printed all of the information needed by calling the methods 
   System.out.println("The smallest box is:");
   //i printed the smallest box by calling the smallestBox method to get the index then sent the index to print that exact box
   printBox(head,smallestBox(head));
   System.out.println();
   
   System.out.println("The largest box is:");
   //i printed the largest box by calling the largestBox method to get the index then sent the index to print that exact box
   printBox(head,largestBox(head));
   System.out.println();
   
   //here i just printed the number return by the cubicBoxes method
   System.out.println("There are "+ cubicBoxes(head)+" cubic boxes.");
   System.out.println();
  
   //this calls the largest cube method and then calls the print methos to print that box
   System.out.println("The largest cubic box is");
  printBox(head,largestCubicBox(head));
  System.out.println();
  
  //this calls the smallest cube method and then calls the print methos to print that box
  System.out.println("The smallest cubic box is");
  printBox(head,smallestCubicBox(head));
  System.out.println();
  
   //this printed the volumes of all the linked list
   printVolumes(head);
    System.out.println();
    
    // this printed only the volumes of the cubic boxes
   printCubeVolumes(head);
    System.out.println();
    
    
    
    }
    
    //this method is to read the file using a try and catch
    static Box readFile(Box head, String fileName) throws FileNotFoundException{
            Scanner s = new Scanner(new File(fileName));
            
         try{
             //this while loop is to keep reading the file and keep creating box objects
            while (s.hasNextLine()){
                //a temp box is created
              Box temp=new Box();
            //a string is created to store each line that is read on the while loop
            String line = s.nextLine();
            //an array is created place the words seperated by a space into each element
            String[] allSplits= line.split(" ");
            
            //while the scanner is going through the array, it places each element into the package array
              double width = Double.parseDouble(allSplits[0]);
              temp.setWidth(width);
              
              double height = Double.parseDouble(allSplits[1]);
              temp.setHeight(height);
              
              double length = Double.parseDouble(allSplits[2]); 
              temp.setLength(length);
              
              //this checks is a head exists or it has no values
              //if it is it creates that box as the head
               if(head == null){
                    head = temp;
               }
               //if not then it looks for the last element in the head linked list
               else{
                temp.next=null;
                Box last = head;
                     while(last.next!= null){
                        last = last.next;
                     }
                //this goes to the next box in the linkedlist and makes that box the new on in the linkedlist
                last.next = temp;
               }
              
                  
            }
            
          }
         //this catches the error as well if there are not 3 numbers on each line
          catch(Exception e){
           System.out.println("Error:There are not 3 numbers on each line  " );
           System.exit(0); 
            
         }
         return head;
        
        }
   
    
   //this  method is to return the index of the smallest box
   static int smallestBox(Box head){
       //if head doesnt exist it return -1
       if(head==null){
           return -1;
       }
       //i saved the first box volume to start comparing
       //the int for the index of the smallest box and a counter to keep track of the indexes
       
       double min = head.getVolume();
       int minBox =0;
       head = head.next;
       int counter =1;
       //this while loop goes through the linked list and compares the volumes of the boxes.
       while(head!= null){
           if(head.getVolume()< min){
               min = head.getVolume();
               minBox = counter;
           }
           
               head = head.next;
               counter++;
           
       }
     return minBox;
   }
   //this method does the same but returns the index of the largest box
   //everything is the same just the if condition is greater than to check if the volume is bigger
   static int largestBox(Box head){
       if(head==null){
           return -1;
       }
       double max = head.getVolume();
       int maxBox =0;
       head = head.next;
       int counter =1;
       while(head!= null){
           if(head.getVolume()> max){
               max = head.getVolume();
               maxBox = counter;
           }
           
               head = head.next;
               counter++;
           
       }
     return maxBox;
       
   }
   //this method prints a specfic box in a linked list according to its index
   static void printBox(Box head, int index){
       //if the index is -1 the box does not exist
       if(index==-1){
           System.out.println("Index is not existent");
       }
      try{ Box temp = head;
      //the counter keeps track of which box we are in then goes through the while loop 
      //if the counter is equal to the index it prints that specific box along with all the values it has.
       int counter = 0;
       while (head!=null){
           if(counter == index){
               System.out.print("Box index "+index+ " width: "+ temp.getWidth()+ " height: "+temp.getHeight()+ " length: "+ temp.getLength());
               System.out.println(" volume: " + temp.getVolume());
               break;
           }
           else {
               //if not it keeps checking the linked list
               temp= temp.next;
               counter ++;
           }
       }
      }
      //this try and catch statement is to avoid looking for an index that does not exist in the linkedlist
      catch(Exception e){
          System.out.println("The box is nonexistent");
      }
       
   }
   //this method returns the number of cubic boxes in the linked list
   static int cubicBoxes(Box head){
       int cubes = 0;
       //it goes through the while loop and checks is the isCube method in the class is true then adds one to the counter for cubes
       while(head!= null){
           if(head.isCube()==true){
               cubes++;
               head = head.next;
           }
           else{
               head = head.next;
           }
       }
       return cubes;
   }
   //this method simply prints all the volumes according to their boxes in order
  static void printVolumes(Box head){
      //the while loop goes through the linked list and prints the volume along with the counter
       Box temp = head;
       int counter = 0;
       while (temp!=null){
           
               System.out.println("Box number "+counter+ " has a volume of  "+ temp.getVolume());
               temp= temp.next;
               counter ++;
           
       }
       
      
  }
  //this method simply prints the volumes of the cubic boxes
  static void printCubeVolumes(Box head){
      Box temp = head;
      int counter = 0;
      //it goes through of the while loop and checks once again if the isCube method is true
      //then prints the volume if it true
      while(temp!=null){
          if(temp.isCube()==true){
              System.out.println("Cubic box number " + counter+ " is "+ temp.getVolume());
              
          }
          temp = temp.next;
          counter++;
          
      }
  }
  static int smallestCubicBox(Box head){
     //if head doesnt exist it return -1
       if(head==null){
           return -1;
       }
       //i saved the first box volume to start comparing
       //the int for the index of the smallest box and a counter to keep track of the indexes
       
      double min = Double.MAX_VALUE;
       int minBox =0;
       int counter =0;
       //this while loop goes through the linked list and compares the volumes of the boxes.
       while(head!= null){
           if(head.getVolume()< min && head.isCube() ==true){
               min = head.getVolume();
               minBox = counter;
           }
           
               head = head.next;
               counter++;
           
       }
     return minBox; 
  }
  static int largestCubicBox(Box head){
      if(head==null){
           return -1;
       }
       double max = Double.MIN_VALUE;
       int maxBox =0;
       
       int counter =0;
       while(head!= null){
           if(head.getVolume()> max && head.isCube() ==true){
               max = head.getVolume();
               maxBox = counter;
           }
           
               head = head.next;
               counter++;
           
       }
     return maxBox;
  }
   }
    
    
