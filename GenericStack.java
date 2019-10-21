
/* Ericka Najera 
LAB 8
CS 2401
*/

public class GenericStack {
    //the top is private 
    private Node top;
    
    //constructor that will simply create an empty stack 
    public GenericStack(){
        top = null;

    }
    //if the top is null therefore the stack is empty
    public boolean isEmpty(){
        return (top==null);
    }
    //this receives an object then the top will be a new node and send the current top to the next node
    public void push(Object newItem){
        top = new Node(newItem, top);
    }
    //pops the top element
    public Object pop(){
        //if the stack is empty then it cant pop anything
        if(isEmpty()){
            System.out.println("Trying to pop when stack is empty");
            return null;
        }
        else{
            //else we create a new node to save the top
            Node temp = top;
            //then the top will be the next node
            top = top.next;
            //then we return the info of the temp node we created
            return temp.info;
        }
    }
    //this will make all of the stack empty 
    public void popAll(){
        top=null;
    }
    //this will return the top without deleting anything
    public Object peek(){
        if(isEmpty()){
            //if the stack if empty null is returned
            System.out.println("Trying to peek when stack is empty");
            return null;
        }
        else{
            //else we return the info of the top node.
            return top.info;
        }
    }
    
}