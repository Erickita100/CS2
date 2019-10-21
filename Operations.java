/*Ericka Najera
LAB 6
CS 2401*/
import java.util.Random;

public class Operations {
    
public static void main(String[] args){
    
StringNode L=new StringNode("0"+getRandString(2+(int)(Math.random()*5))); 
StringNode temp = L;
for (int i=1; i<=9;i++){
temp.next=new StringNode(i+getRandString(2+(int)(Math.random()*5)));
temp=temp.next; }
System.out.println("All Strings in the list:"); 
printMyList(L);
System.out.println();
boolean b = isListInOrder(L); 
System.out.println("List is ordered: "+b);
System.out.println();
System.out.println("Count of k-length strings"); 
System.out.println("k\tNo. of Strings with length k"); 
for (int k=0; k<7; k++){
System.out.println(k+"\t"+countKLenghthStrings(L, k)); }
System.out.println();
System.out.println("Longest String="+longestStringOfMyList(L)); 
System.out.println();
System.out.println("Length="+lengthOfMyList(L));
System.out.println();
L=reverseMyList(L);
System.out.println("All string in the reversed list:"); 
printMyList(L);
System.out.println();
System.out.println("Remove a given String");
StringNode LL=removeAStringFromMyList(L, L.next.next.head);
System.out.println("All strings in the new list:"); 
printMyList(LL);
System.out.println();
System.out.println("All strings in the previous list:"); 
printMyList(L);
System.out.println();
System.out.println("Insert a string in a position of the new list:"); 
LL=insertAStringIntoMyList(LL, "Hello world", 3);
printMyList(LL);
System.out.println();
b = isListInOrder(L); 
System.out.println("List is ordered: "+b);
System.out.println();
LL=insertAStringIntoMyList(LL, "ABBA", 3); 
LL=insertAStringIntoMyList(LL, "DoGeeseSeeGod", 3);
System.out.println("Palindrome: ABBA ");
System.out.println("Palindrome: DoGeeseSeeGod");
int c = countPalindromes(LL); 
System.out.println("Found "+c+" palindromes.");

}
static int getRandomNumber(int min, int max){
    //this method simply returns a random number between the max and min values provided
    return (int)(Math.random()*((max-min)+1))+min;
}

static String getRandString(int length) {
    //the alphabet variable is to give only possible chars to be the alphabet
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //here i save the length of the sample space
    int N = alphabet.length();
    //this empty string is to save the chars in order to return a new string
    String save = "";
    //this will generate a random selection
    Random r = new Random();
    // this for loop is to get continue getting a random char until the length of the string is completed
    for (int i = 0; i < length; i++) {
        //i picked a random char in the alphabet and added it to the empty string.
        save = save + alphabet.charAt(r.nextInt(N));
    }
    return save;
 }
/* Write a recursive method to print all the strings in separate lines. This method cannot contain any loop (that is, uses of for, while, do while are prohibited).
*/
public static void printMyList(StringNode m){
    //if the node is not null then it prints that string
    if(m!=null){
        System.out.println(m.head);
    //recurision is called but with the next string in the node
        printMyList(m.next);
}
}

/* Write a recursive method to retrieve the number of strings that are longer than the length provided in the parameter. This method cannot contain any loop (that is, uses of for, while, do while are prohibited).
*/
public static int countKLenghthStrings (StringNode m, int k){
//base string: if m is null then there a no more strings
    if(m==null){
        return 0;   
    }
//if the length if the string is not equal to k then we send 0 and use recursion but with the next string
    else if(m.head.length()!=k){
            
        return 0+ countKLenghthStrings (m.next, k);
    }
//if it is equal to the length then we add one and call the recursion with the next string
        return 1+ countKLenghthStrings (m.next, k);
    //adding one each time will return the int of the number of string equal to k
}
// Write a recursive method to retrieve the largest String from the list. Assume that there is at least one String in the given list when the method is called from the main function. This method cannot contain any loop (that is, uses of for, while, do while are prohibited).

public static String longestStringOfMyList (StringNode m){
    //the base case will return the head when there are no more nodes to compare it with
    if (m.next == null) {
        return m.head;
    }
    else {
        //this creates a new string wil the value of the recursion with the next node
        String max = longestStringOfMyList(m.next);
        //if the length of that head is smaller than the max then we keep the max
        if(m.head.length()< max.length()) {
            return max;
        }
        //if it is bigger than we return the head
        else 
            return m.head;
    }
}

/* Write a recursive method to compute the length of a list.
This method cannot contain any loop (that is, uses of for, while, do while are prohibited).
*/
public static int lengthOfMyList (StringNode m){
    //base case: when we reach the last node we return 0
    if(m==null){
        return 0;
    }
    //if not then we send the next node but add one
    //adding one will keep adding one for everytime there is a new node
    else
        return 1+ lengthOfMyList (m.next);
           
 }

/* Write a recursive method named reverseMyList that will reverse a given linked list m. Return the head of the reversed linked list. It is fine if you need to modify the given linked list to obtain the reversed one. */
public static StringNode reverseMyList (StringNode m){
     ///the base case: if the next node is empty then the head would simply return
     
    if(m==null || m.next == null)
        return m;
    //another node list created and calls for recursion sending the next node which is reverse
    StringNode reverse = reverseMyList(m.next);
    //here it keeps making the given head †he last node of the array making it reverse
    m.next.next = m;
    m.next= null;
    
    //it returns the reversed node list
    return reverse;
  
}
/* Write a recursive method to remove the first occurrence of a specific String from a list. As an example, if your list initially contains
AA BB CC DD BB KK and if your removee is BB, the returned list should contain AA CC DD BB KK after the removal. Return a new head. You must make sure that the parameter list m remains intact after returning the new list to the main method. This method cannot contain any loop (that is, uses of for, while, do-while are prohibited).
*/

public static StringNode removeAStringFromMyList(StringNode m, String removee){
    //here i created a new StringNode to send back
    //i used the this constructor beacause i needed to send the next node as well
    StringNode node = new StringNode(m.head,m.next);
   
    if(node.head==null){
        return node;
    }
    //if the head is the one we need to delete
    //we return the next node
    else if(removee.equals(node.head)){ 
        return node.next;
    } 
    //if not then we send the next node to the recursion saving it to the next element
    //returning the head will save the entire node
    
    else {  
        node.next = removeAStringFromMyList(node.next,removee);
        //returning m will return the head of the node
        return  node;
    }
   
}

/* Write a recursive method to insert a String (insertee) into a specific position of a list. Positions start from 0 (that is, the position of
the head of a list is 0). This method cannot contain any loop (that is, uses of for, while, do-while are prohibited).
*/
public static StringNode insertAStringIntoMyList(StringNode m, String insertee, int position){
    //if the linkedlist is at the index of the position then it creates a new node with the insertee
    // then it adds the rest of the linked list to m
        if (position == 0) {
            StringNode node = new StringNode();
            node.head = insertee;
            node.next = m;
            return node;
        }
           //if its not then it does recursion to the next element in the linked list
         m.next = insertAStringIntoMyList(m.next, insertee, position - 1);
        return m;
}
   
    
 
/* Write a recursive method to verify if the strings are lexicographically ordered in a linked list. Return true if they are ordered, false otherwise. This method cannot contain any loop (that is, uses of for, while, do-while are prohibited).
*/
public static boolean isListInOrder(StringNode m){
    //if the linked list is null or smaller than 3 it returns true
    if(m== null || m.next==null){
        return true;
    } 
    //here i converted the first char in each string to an ASCII values
        int value1 = m.head.charAt(0);
        int value2  = m.next.head.charAt(0);
    //here i checked if the first letter is bigger than the next string's first letter
    //returning false and stop checking
    if(value1>value2){
        return false;
            }
    else {
        //if its true than we send the next element to check
        return isListInOrder(m.next);
        }
 }
//Write a recursive method that will count how many strings of a given linked list are palindromes. The method must call another recursive
//method named isPalindrome to verify if a String is a palindrome, or
//not. Palindrome checks must NOT be case-sensitive. Neither countPalindromes nor isPalindrome may contain loops (that is, uses of for, while, do-while are prohibited).
//*/
public static int countPalindromes(StringNode m){
    //when  it hits the last element then it terminates and returns 0
    if(m==null)
        return 0;
    else{
        //this checks if the string is true in the isPalindrome method
        if(isPalindrome(m.head)==true)
            //it adds one if it is true
            return 1 + countPalindromes(m.next);
            //if not then it sends the next element without adding anything
        return countPalindromes(m.next);
        
    }
    
}
public static boolean isPalindrome(String s){
    //the base case if the length of that string is less than one then the recursion returns
    if(s.length()<=1)
        return true;
    //if the first char does NOT equal the same last char then it returns false
    else if(Character.toLowerCase(s.charAt(0)) != Character.toLowerCase(s.charAt(s.length()-1))) 
        return false;
    //is yes then we send the string without the first and last char since we already checked it
    else
        return isPalindrome(s.substring(1,s.length()-1));

}
}

