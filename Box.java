/* Najera Ericka
CS 2401 
LAB 5
*/
public class Box {
    
private double length;
private double width;
private double height;
public Box next;

Box(){
}
//this s the contrsutor for each box
Box(double width, double height, double length) {
    this.width = width;
    this.height = height;
    this.length = length;
}
//this getters are to get the width height length and volume of that box
double getWidth(){
    return width;
}
double getHeight(){
    return height;
}
double getLength(){
    return length;
}
//this setters are to the set the variables of the width length height and volume
void setWidth(double w){
    width = w;
}
void setHeight(double h){
    height = h;
}
void setLength(double l){
    length = l;
}
//this returns the volume of that box by multiplying the dimensions
double getVolume(){
    return width*height*length;
}
//this checks if the dimensions are the same then it returns true if they are
boolean isCube(){
    boolean cube = false;
    if(width==height && height == length){
        cube = true;
    }
    return cube;
    
}
   
}


