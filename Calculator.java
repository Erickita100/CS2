/* Ericka Najera 
LAB 8
CS 2401
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calculator {

    
    public static void main(String[] args) throws FileNotFoundException {
        
        //here i call the method to read the file and begin calculating each line of expression. 
            System.out.println("The input file has the following answers to the postfix expressions:");
            System.out.println();
            readFile("input.txt");
    }
    
    static void readFile(String fileName)throws FileNotFoundException {
          //here i send the file to be read into the scanner
            Scanner s = new Scanner(new File(fileName));
            //this try and catch will used to catch if the input has nothing on it
        try{
            //this counter if to keep count of each expression or lines
            int counter =0;
            //this while loop will keep going until there is no more input on the lines
            while (s.hasNextLine()){
                //for each line i created a stack to keep the expression
                GenericStack stack = new GenericStack();
                //this line saves the line into a string
                String line = s.nextLine();
                //the counter increments for each line
                counter++;
                //a string array is created with each element surrounded by a space
                String[] expression = line.split(" ");
                //this if statement will send the string array to check if it is not valid
                if(validExpression(expression)==false || operandCheck(expression)==false){
                    if(operandCheck(expression)==false){
                        //if there are more operators than operands it will print a message
                        System.out.println("For every K operands, there are not K-1 operators");
                    }
                    //the program will simply return not valid and go to the next line
                     System.out.println("Line number " + counter+ " is not valid");
                     System.out.println();
                }
                else{ 
                    //this for loop will go each element in the array 
                    for(int i = 0; i<expression.length;i++){
                        //if the element is not a number 
                        if(isNumber(expression[i])==false){ 
                            //it will pop the last 2 elements and save it
                            Object top = stack.pop();
                            Object bottom = stack.pop();
                            //then save the sign into string
                            String sign = expression[i];
                            //i will send the saved objects into the calculate method
                            Object product = calculate(top, bottom, sign);
                            //after it calculates this will push the result of that into the stack and continue into the next element
                            stack.push(product);
                        }
                        //if the element is a number it will push into stack
                        else{
                        stack.push(expression[i]);
                        }
                    }
                    //after it traversed the whole array it will pop the last element in the stack
                Object result = stack.pop();
                //this will the the result of the expression and it will print it
                System.out.println("Line number "+counter+" has a result of "+result );
                System.out.println();
                }
            }
        }
         //this catches the error as well if there are not any expressions
        catch(Exception e){
           System.out.println("Error:There is no input" );
           System.exit(0); 
            
        }
        
    }
    //this boolean method will return true if the first 2 elements are operands and the last element is a operator
    public static boolean validExpression(String[] expression){
        //saves the boolean to be returned
        boolean valid = true;
        //if the last element is a number
        if(isNumber(expression[expression.length-1])==true){
            System.out.println("The last element in the expression is a operand");
            //then the expression is not valid
            valid = false;
        }
        //if the first two elements are not numbers then the expression is also not valid
        if(isNumber(expression[0])==false && isNumber(expression[1])==false){
            System.out.println("The first two elements are not numbers");
            valid = false;
        }
        //return the boolean after it checks the expression
        return valid;
    }
    //this boolean also checks the expression for K and K-1
    public static boolean operandCheck(String[] expression){
        //saves the boolean to check
        boolean valid = false;
        //saves the number of operand and operators
        int operand = 0;
        int operators =0;
         
        //this for loop traverse the array
        for(int i=0; i<expression.length;i++){
            //if the element is a number then it adds one to the operand
            if(isNumber(expression[i]) ==true){
                 operand++;
            }
            //else it adds one to the operators
            else{
            operators++;
            }
        }
        //if the number of operators is equal to the number of operands minus one then the expression is valid
        if(operand-1 == operators){
            valid = true;
        }
        //returns the boolean of the expression being valid or not
        return valid;
    }
    //this method returns a double calculating the objects sent to it
    public static double calculate(Object first, Object second, String sign ){
        //this saves the outcome after calculating
        double product= 0;
        //this converts the first and second objects into doubles
        double top = new Double(first.toString());
        double bottom = new Double(second.toString());
            //each if statement checks the sign if it equal + - * or / the calculates accordingly. 
            if(sign.equals("+")) {
                product = bottom + top;
            } 
            if(sign.equals("-")) {
                product = bottom - top; 
            } 
            if(sign.equals("*")) {
                product = bottom * top; 
            } 
            if(sign.equals("/")) {
                product = bottom / top; 
            } 
      //this returns the outcome after calulating
      return product;
    }
    //this method is to check if the element is a number or not
    public static boolean isNumber(String s){
        try{
            //i convert the element into an integer
            //if it fails then it goes to the catch statement 
            Integer.parseInt(s);
            
        }
        catch(NumberFormatException e){
             //the catch statement returns false
            return false;
        }
         //if the the catch is not reached then it returns true
        return true;
    }
    
    
}
