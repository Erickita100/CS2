/* Najera Ericka
CS 2401 
LAB 5
*/
public class LinkedList { 
     Box head; 
     Box iterator;
    
LinkedList(){}

/* Add b as the last node of the linked list.*/

void addNode(Box b){
      Box temp =b;
      //if the head is nonexistent then it makes that box the head
      if(head==null){
          head = temp;
          iterator= head;
      }else{
          //if not then it goes until the last box in the linkedlist and adds it to the linked list
          temp.next = null;
          Box last = head;
          while(last.next!=null){
              last= last.next;
          }
          last.next = temp;
          iterator = last.next;
      }
            
  }

/* Insert b in position pos. If insertion is successful * return true, otherwise return false.
*/
boolean insertNode(Box b, int pos){
      boolean insertion = false;
      if(pos<0|| head==null){
          insertion = false;
      }
      if(pos==0){
          //if the pos is zero then we add the box b and make the head the tail
      Box tail = head;
      head = b;
      head.next = tail;
    insertion = true;
    }
    Box temp = head;
    //if not then it goes to the postion that we want to insert
    for(int i=1; i<pos && temp.next != null;i++){
        temp=temp.next;
    }
    //we save the first part and last part of the linked list
    // then we add the box b to the tail of the first part then we add the tail to the tail of the first part
        Box first = head;
        Box last = temp;
        temp = b;
        temp.next = last;
        head.next = temp;
        insertion = true;
    
    return insertion;
  }

/**Print width, height, length, and volume of each of the boxes in * this linked list. */
void printAllBoxes(){
       //if the head is null the box does not exist
       if(head==null){
           System.out.println("Index is not existent");
       }
      try{ Box temp = head;
      //the counter keeps track of which box we are in then goes through the while loop 
      //if the counter is equal to the index it prints that specific box along with all the values it has.
       int counter = 0;
       System.out.println("The order of the boxes is");
       while (temp!=null){
           
               System.out.print("Box index "+counter+ " width: "+ temp.getWidth()+ " height: "+temp.getHeight()+ " length: "+ temp.getLength());
               System.out.println(" volume: " + temp.getVolume());
               
               //then keeps gping through the linked list
               temp= temp.next;
               counter ++;
           }
       }
      
      //this try and catch statement is to avoid looking for an index that does not exist in the linkedlist
      catch(Exception e){
          System.out.println("The box is nonexistent");
      }
      System.out.println();
  }

/** Remove the box in position pos. Return true if removal * is successful, otherwise return false.*/
boolean removeNode(int pos){
    boolean removal = false;
      if(pos<0|| head==null){
          removal = false;
      }
      //if the pos is zero we just get rid of the head
      if(pos==0){
    head = head.next;
    removal = true;
    }
    Box temp = head;
    //if not then we go to the box before the one we want to remove using a for loop
    for(int i=1; i<pos && temp.next != null;i++){
        temp=temp.next;
    }
    //then we simply skip that box and go straight to the other one
    if(temp.next!=null){
    temp.next = temp.next.next;
     removal = true;
    }
    return removal;
  }




/** Return the box in position pos. Return null when pos is * invalid.*/
Box getBox(int pos){
        //if the index is -1 the box does not exist
       if(pos<0){
           return null;
       }
      
      Box temp = head;
      Box found = null;
      //the counter keeps track of which box we are in then goes through the while loop 
      //if the counter is equal to the index it prints that specific box along with all the values it has.
       int counter = 0;
       while (temp!=null){
           if(counter == pos){
               found = temp;
           }
               //if not it keeps checking the linked list
               temp= temp.next;
               counter ++;
           
       }
      
      return found;
  }

/**Print width, height, length, and volume of each of the boxes in * this linked list in reverse order.*/
void printReverse(){
    if(head==null){
        System.out.println("There are no boxes");
    }
    // i saved the head to the temp
    int counter = 0;
    Box temp = head;
    // then the prev box with the head data
    Box prev = new Box(head.getWidth(),head.getHeight(),head.getLength());
    Box reverse = prev;
    //the reverse linked list is the previous one
    temp = temp.next;
    counter++;
    while(temp!=null){
        //here we go through the head linked list then we add that next box as the head of the reverse linked list
        reverse = new Box(temp.getWidth(),temp.getHeight(),temp.getLength());
        reverse.next= prev;
        prev = reverse;
        temp= temp.next;
        counter++;
    }
    int index = counter;
    // here we simply print the linked list using a for loop then make the index go down to print the corresponding index
    System.out.println("The reverse order of the boxes is");
    while(reverse!=null){
        System.out.println("Box index " +index+" width: "+reverse.getWidth()+" height: "+reverse.getHeight()+" length: "+reverse.getLength());
        reverse = reverse.next;
        index--;
    }
    System.out.println();

}


void initiateIterator(){
    //this is equal to the head because to go through it we need to be at the beginning
iterator = head;
}

/**
* Return the box in the current iterator position. */
Box getNextBox(){
    //this returns the next box making it iterator.next
    iterator = iterator.next;
      return iterator;
  }


}
