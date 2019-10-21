import java.io.*;
import java.util.Scanner;
//the scanner class is used to get a line of code and recognize the different segments 
//or spaces to break it up into pieces
class ScanTest{
	public static void main (String[]args){
	Scanner s =null;
	try{
		s = new Scanner(new File("input.txt"));
		while(s.hasNextLine()){
		//to see whether there are other input after that line of code
		String line = s.nextLine();
		//creates a string from the input
		
		String[] a = line.split("");
		System.out.println(a.length);
		//this creates an array and makes a new slot after each spot
		//the a.length prints the number of characters in the line
		
		Scanner ls = new Scanner(line);
		//this is to create a scanner object and break up "line" into pieces
		
		for(int i = 0; i<3; i++){
			double d = ls.nextDouble();
			//nextDouble makes ls, which is the scanner object, into doubles instead of strings
			System.out.print(d+"-");
			}
			System.out.println();
			//this two lines prints the double followed by a "-". 		}
		}catch(Exception eee){
			eee.printStackTrace();
			}
		}
		// if the condition for the for loop fails then it will go to this option
		//printStackTrack allows you to see where the error of code is found 
		}