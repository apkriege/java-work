// Homework 1: Simple Statistics Program 
// Student Name: Adam Krieger
// Course: CIS357, Winter 2017 
// Instructor: Il-Hyung Cho
// Date finished: 1/30/2017
// Program description: This program calculates mean and standard devaition from user input
//

import java.util.Scanner;
import java.util.Arrays;

public class SimpleStat{
  
  public static void main(String args[]){
    
    // declare variables       
    double[] dblArray;     
    double mean, stdDev;
    
    // read input from user by calling readInput()       
    dblArray = readInput();    
    
    // calculate the mean by calling findMean()  
    mean = findMean(dblArray);
    
    // calculate the standard deviation by calling findStdDev()       
    stdDev = findStdDev(dblArray, mean);
  
    // print out the result by calling printResult()       
    printResult(mean, stdDev);
    
  }    
  
  /**     
  * Prompts and reads input from the user   
  * @return returns an array     
  */     
  public static double[] readInput() {  
    Scanner in = new Scanner(System.in);  
    System.out.print("How many numbers? ");  
    int n = in.nextInt();
    
    double[] array = new double[n];  
    
    System.out.print("Enter " + n + " number separated by spaces: ");
    for (int i = 0; i < n; i++)
      array[i] = in.nextDouble();
               
    return array;         
  }         
  
  /**     
  * Calculates and returns the mean of the array 
  * @param array of input as arr
  * @return returns an array     
  */  
  public static double findMean(double[] arr){
    double mean = 0;
    
    for(double i: arr){
      mean += i;
    }
    
    mean = mean / arr.length;
    
    return mean;
  }
  
  /**     
  * Calculates and returns the standard deviation of array 
  * @param array of input as arr, mean of the array as mean
  * @return returns an array     
  */  
  public static double findStdDev(double[] arr, double mean){
    double tmp = 0;
    double stdDev;
    
    for(double i: arr){
      tmp += Math.pow((i - mean), 2);
    }
  
    stdDev = Math.sqrt(tmp/arr.length);
    return stdDev;
  }
  
  /**
  * Prints and formats the values
  * @param mean, stdDev
  */ 
  public static void printResult(double mean, double stdDev){
    System.out.println("");
    System.out.printf("Mean: %.2f \n", mean);
    System.out.printf("Standard Deviation: %.2f", stdDev);
  }
}
