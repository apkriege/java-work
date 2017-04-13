// Program 4: Student grade program 
// Course: CIS357 
// Instructor: Il-Hyung Cho 
// Student: Adam Krieger
// Program Description: This program calculates the grades and class 
// averages and formats the data into a table

#include <iostream>
#include<fstream> 
#include <cstdlib>
#include <stdio.h>
using namespace std; 

#include "student.h"
#include "student.cpp"

const int NUM_STDS = 10;

int main() {   
    StudData stdList[NUM_STDS];
    int num;                                // size of array
    initialize_std_list(stdList, num);      // initializes the item table   
    //print_std_list(stdList, num);         // print the read data   
    printStudents(stdList, num);
    print_avg(stdList, num);
    
    return 0; 
}


