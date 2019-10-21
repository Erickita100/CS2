/*Ericka Najera
Lab 9
CS 2401
*/
public class Queue{
    //here i chnaged the queue size to 5
    private int QUEUE_SIZE = 5; 
    private Object[] items; 
    private int front, back, count;

    //this constructor makes an array of the queue size
    //and sets the variables to zero
    public Queue() {
        items = new Object[QUEUE_SIZE]; 
        front = 0;
        back = QUEUE_SIZE -1;
        count =0;
    }
    
    //return a boolean if the queue is empty
    public boolean isEmpty(){
        return count == 0;
    }
    //if the queue size is the same as the number of elements in the array
    public boolean isFull(){
        return count == QUEUE_SIZE;
    }
    //this add an element to the array
    public void enqueue(Object newItem){
        //if it not full then the back goes the next space in the order of the queue
        if(!isFull()){
           back = (back+1)% QUEUE_SIZE;
           //this inserts the item at the back
           items[back]= newItem;
           //adds one to the count
           count++;
           return;
        }
        else{
            //if the queue is full
           System.out.println("Queue is full. Doubling the size.");
           //the queue size becomes double
           QUEUE_SIZE = QUEUE_SIZE*2;
           //i created a temp array with the new queue size
           Object[] temp = new Object[QUEUE_SIZE];
           //and save the front to another temp
           int frontTemp = front;
           //this for loop adds the items in the front variable to the temp array
           for(int i=0;i<items.length;i++){
              temp[i]=items[frontTemp];
              //then front temo increments according to the last queue size
              frontTemp = (frontTemp+1)% items.length;
             
           }
           //here front increments one to get the new open space
           frontTemp++;
          // the temp array becomes the new items array
           items = temp;
           //front becomes zero
           front = 0;
           //back changes according the front temp
           back = (frontTemp+1)% QUEUE_SIZE;
           //then it adds the new item to that open space
           items[back]= newItem;
           //increments count again
           count++;
           System.out.println("New max. size is:" +items.length);
           System.out.println("Entered the new item.");
       }
    }
    //this dequeue an element of the array
    public Object dequeue(){
        //if it is not empty then it deletes the first element of the 
        if (!isEmpty()){
            //it saves the item at the front
            Object queueFront = items[front];
            //then front becomes the next item in the queue
            front = (front+1) % QUEUE_SIZE; 
            //count goes minus one
            count--;
        return queueFront;
        }else
            //if it is empty it simply return a statement
        System.out.println("Trying to dequeue from empty queue");
        return null;
    }
    //this will create a new item array then it sets all to zero
    public void dequeueAll(){
        items = new Object[QUEUE_SIZE]; 
        front = 0;
        back = QUEUE_SIZE -1;
        count =0;   
    }
    //this method will return the first element but wont delete it
    public Object peek(){
        //if it is not empty then it will return the item at front
        if (!isEmpty()) {
          return items[front];
        }else
            //if it is then it will print a statement
            System.out.println("Trying to peek with empty queue"); 
        return null;
    }
    //this returns the size if the queue
    public int size(){
        //return the count variable
        return count;
    }
}



