/*Ericka Najera
LAB 6
CS 2401*/


public class StringNode { 
    //these are the variables
    //since they are public we dont need getters to get the data
    public String head; 
    public StringNode next;
    
//this is an empty constructor  
StringNode(){}

//this contrustor send only the head 
StringNode(String s){
    head = s; 
}
//this contrustor creates a node with the head and also sends the next element
StringNode(String s, StringNode tail){ 
    head = s;
    next=tail;
}
}