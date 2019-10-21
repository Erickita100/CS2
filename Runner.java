/*Ericka Najera
Lab 9
CS 2401
*/
public class Runner {

    public static void main(String[] args) {
        
        //here i created new queue
       Queue q = new Queue();
       //this for loop is to input 5 random values into the queue in order to have the amount of the Queue size
      for(int i =0;i<5;i++){
           q.enqueue((int)(Math.random()*100));
       }
       
       //here i print my queue
       printQueue(q);
       System.out.println();
       
       //here i dequeue one element then i print the queue to demonstrate i removed it
       System.out.println("I am going to dequeue one element.");
       q.dequeue();
       printQueue(q);
       System.out.println();
       
       //here i reversed my queue then i printed as well
      System.out.println("I am going to reverse my Queue.");
       reverseQueue(q);
       printQueue(q);
       System.out.println();
      
       //here i enqueued the number 60 and printed it as well
       System.out.println("I am going to enqueue 60.");
       q.enqueue(60);
       printQueue(q);
       System.out.println();
        
       //here i enqueued 70 in order to test that the Queue size doubled then i printed it
       System.out.println("I am going to enqueue 70.");
       q.enqueue(70);
       printQueue(q);
       System.out.println();
       
       //here i reversed my queue once again and printed it
       System.out.println("I am going to reverse my Queue");
       reverseQueue(q);
       printQueue(q);
       System.out.println();
       
       //here i call the max number in the queue method
      System.out.println("The largest number in the queue");
      findMaxInQueue(q);
      
    }
    //this method prints the queue
    public static void printQueue(Queue q){
        System.out.println("My queue is as follows:");
        //this for loop goes while i is less than the q.size since it is how many elements in the queue
        for(int i =0; i<q.size();i++){
            //i dequeue and save this into a temp 
            Object temp = q.dequeue();
            //i print the temp
            System.out.print(temp+ " ");
            //then i enqueue it back
            q.enqueue(temp);
        }
        //since the for loop goes through the q.size it wont affect the order of the queue
        System.out.println();
        
    }
    //this method prints the max in the queue
   public static void findMaxInQueue(Queue q){
       //here i create a variable to compare to get the max
        int max = Integer.MIN_VALUE;
        //this for loop goes again for as long as the q.size
        for(int i =0; i<q.size();i++){
            //here i dequeue as well and save it into a temp
            Object temp = q.dequeue();
            //this if statement converts temp to an int and compares to the max element
            if((int)temp>max){
                //if it is bigger then the new max becomes temp
                max = (int)temp;
            }
            //after it enqueue the temp to not affect the queue
            q.enqueue(temp);
        }
        //this prints the max value
       System.out.println("The max value in the Queue is "+ max);
   }
   //this makes the queue in reverse
    public static void reverseQueue(Queue q){
        //here i create a a temp object array
        Object[] temp = new Object[q.size()];
       //here i dequeue each element and save it into the temp array
       for(int i = 0; i<temp.length;i++){
           temp[i]= q.dequeue();
       }
       //then using another for loop i enqueue each elekment from the array backwards 
       for(int j =temp.length-1;j>-1;j--){
           q.enqueue(temp[j]);
           
       }   
       
    }
}
