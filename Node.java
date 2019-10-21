/* Ericka Najera 
LAB 8
CS 2401
*/

public class Node {
    //this class need the next node as well as the object with the info
    Object info;
    Node next;
    
    Node(){
        //default constructor
    }
    //this contructor receives an objects
    Node(Object info){
        this.info = info;
    }
    //this constrcutor receives an object and the next node
    Node(Object info,Node next){
        this.info = info;
        this.next = next;
    }
    
}
