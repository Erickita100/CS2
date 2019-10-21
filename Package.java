/* Najera Ericka
CS 2401 
LAB 3
*/


class Package {
    
    //this declares all the variables private
    
private double width;
private double height;
private double length;
    
//my constructor gets the values from my main method and assigns them to the corresponding in the class
Package(double width, double height, double length){
    this.width = width;
    this.height = height;
    this.length = length;
}
//this returns the width of the package
double getWidth(){
    return width;
}
//this returns the height of the package
double getHeight(){
    return height;
}
//this returns the length of the package
double getLength(){
    return length;
}
//this sets the width to any input the user provides
void setWidth(double w){
width =w;
}
//this sets the height to any input the user provides
void setHeight(double h){
height = h;
}
//this sets the length to any input the user provides
void setLength(double l){
length = l;
}
//this returns the volume of the package by multiplying its dimentions
double getVolume(){
    double vol =0;
    vol = width*height*length;
    return vol;
}
//this returns if the package is a cube or not
//by checking if all the dimentions have the same value
boolean isCube(){
    if(width==height && height==length){
        return true;
    }
    return false;
}

}
