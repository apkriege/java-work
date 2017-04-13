// Homework 2: 2D Array 
// Student Name: Adam Krieger
// Course: CIS357, Winter 2017 
// Instructor: Il-Hyung Cho
// Date finished: 2/12/2017
// Program description: This program generates a 2d matrix and finds the 
// lowest consecutive sum of numbers
//

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

class Homework2Krieger{
    
    public static void main(String args[]){
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.print("Enter a choice: (1 for fixed value, 2 for random values) ");
        int n = reader.nextInt();
        
        if(n == 1){
            System.out.print("Choose static array to search: (1 or 2) ");
            int sel = reader.nextInt();
            if(sel == 1){
                testWithFixedValues(4, 1);
            }
            else{
                testWithFixedValues(4, 2);
            }
        }
        else if(n == 2){
            int row, col, num;
            
            // Prompt the user to enter number of rows and columns
            System.out.print("Enter row and column: ");
            row = reader.nextInt();
            col = reader.nextInt();
            
            // Prompt the user for consecutive numbers 
            System.out.print("Enter consecutive number (3, 4, 5): ");
            num = reader.nextInt();
            
            testWithRandomValues(row, col, num);
        }
        else{
            System.out.println("Wrong input. Try again!");
        }
        
    }
    
    public static class Consecutive {
        // Intialize variables
        int low = 9, total, match;
        String start, end, a, b;
        int arr[][];
        String found[];
        
        /**
        * This method sets the inital values for Class Consecutive
        * @param vals This is the first paramter to addNum method
        * @param match  This is the second parameter to addNum method
        * @return Nothing
        */
        void setArr(int[][] vals, int match){
            this.found = new String[match];
            this.arr = vals;
            this.match = match;
        }
        
        /**
        * Sets the starting and ending coordinates within the matrix 
        * and the direction of the consecutive numbers
        * @param x1  Starting x coordinate in matrix
        * @param y1  Starting y coordinate in matrix
        * @param x2  Ending x coordinate in matrix
        * @param y2  Ending y coordinate in matrix
        * @param dir  Direction of consecutive numbers
        * @return Nothing
        */
        void setStartEnd(int x1, int y1, int x2, int y2, String dir){
            int tmp = arr[x1][y1];
            if(tmp < this.low){
                this.low = tmp;
                this.total = tmp*(this.match);
                this.start = "["+x1+", "+y1+"]";
                this.end = "["+x2+", "+y2+"]";
                createHigh(dir, x1, y1);
            }
        }
     
        /**
        * Creates an array of the minimum consecutive numbers to 
        * allow the numbers to be highlighted
        * @param dir  The direction of the matching string
        * @param x  Starting x coordinate in matrix
        * @return y  Sarting y coordinate in matrix
        */   
        void createHigh(String dir, int x, int y){
             if(dir == "vert"){
                for(int i=0; i<match; i++){
                    this.found[i] = ""+(x+i)+y;
                }
            }
            if(dir == "hor"){
                for(int i=0; i<match; i++){
                    this.found[i] = ""+x+(y+i);
                }
            }
            if(dir == "diagr"){
                for(int i=0; i<match; i++){
                    this.found[i] = ""+(x+i)+(y+i);
                }
            }
            if(dir == "diagl"){
                for(int i=0; i<match; i++){
                    this.found[i] = ""+(x+i)+(y-i);
                }
            }
         }
         
        /**
        * If consecutive numbers are found the values are output 
        * otherwise it outputs nothing found
        * @return Nothing
        */
        void output(){
            String tmp;
            String str;
            
            if(this.start != null){
                System.out.print("Consecutive "+this.match+" found: ("+this.start+" - "+this.end+") \n");
            }
            else{
                System.out.print("Consecutive "+this.match+": not found \n");
            }
            
            for(int i=0; i < arr.length; i++){
                System.out.print("[");
                
                for(int j=0; j < arr[0].length; j++){
                    tmp = ""+i+j;
                    
                    // If numbers match array of consective numbers they
                    // are highlighted
                    if(this.start != null && Arrays.asList(this.found).contains(tmp)){
                        str = (char)27 + "[34;43m"+this.arr[i][j]+"" + (char)27 + "[0m";
                    }
                    else{
                        int x = arr[i][j];
                        str = Integer.toString(x);
                    }
                    
                    if(j == arr[0].length-1){
                        System.out.print(str+"");
                    }
                    else{
                        System.out.print(str+", ");
                    }
                }
                System.out.print("]\n");
            }
            
            System.out.println();
            if(this.start != null){
                System.out.println("Minimum of consecutive "+this.match+": "+this.total);
            }
        }
    }
    
    
    /**
    * Passes the array and how many consecutive numbers are being searched
    * to the minimumConsecutiveSum function
    * @param con  Consecutive numbers to find
    * @return Nothing
    */
    public static void testWithFixedValues(int con, int selection){
        int arr1[][] = {
            {0,1,0,3,1,6,1},
            {0,1,6,8,6,0,1},
            {5,6,2,1,8,2,9},
            {6,5,6,1,1,9,1},
            {1,3,6,1,4,0,7},
            {3,3,3,3,4,0,7}
        };
        
        int arr2[][] = {
            {0,1,0,3,1,6,1},
            {0,1,6,8,6,0,1},
            {5,6,2,1,6,2,9},
            {6,5,6,6,1,9,1},
            {1,3,6,1,4,0,7},
            {3,6,3,3,4,0,7}
        };
        
        if(selection == 1){
            minimumConsecutiveSum(arr1, 4);
        }
        else{
            minimumConsecutiveSum(arr2, 4);
        }
    }

    /**
    * Passes randomly generated 2Darray created by calling generate2Darray()
    * and passes it to the minimumConsecutiveSum method
    * @param row First param is number of rows
    * @param col  Second param is number of columns
    * @param match  This is how many consecutive numbers to search
    * @return Nothing
    */
    public static void testWithRandomValues(int row, int col, int match){
        int arr[][];
        arr = generate2Darray(row, col);
        minimumConsecutiveSum(arr, match);
    }
    
    /**
    * This method creates a randomly generated 2 dimensional array based 
    * on the row and col params.
    * @param row  First param is number of rows
    * @param col  Second param is number of columns
    * @return int  Returns randomly generated 2d array
    */
    public static int[][] generate2Darray(int row, int col){
        
        // create2d array based on Random with seed 1
        int retArr[][] = new int[row][col];
        
        Random rand = new Random(1);
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                retArr[i][j] = rand.nextInt(9) + 1;
            }
        }
        
        return retArr;
    }
    
    /**
    * This method iterates through the 2d array and checks each vertically,
    * horizontally, and diagonally for matching consecutive numbers
    * and then runs the output method from the Consective Class
    * @param arr  First param which is a 2d array 
    * @param match  Second param which is consecutive numbers 
    * @return Nothing
    */
    public static void minimumConsecutiveSum(int[][] arr, int match){
        Consecutive con = new Consecutive();
        con.setArr(arr,match);
    
        // Iterate through 2 dimensional array while staying within bounds
        for(int r = 0; r < arr.length; r++){
            for(int c = 0; c < arr[0].length; c++){
                int curr = arr[r][c];
                
                // Checks down of current position in matrix
                int ct = 0; int n = 0;
                while(r+n < arr.length){
                    ct = (curr == arr[r+n][c]) ? ct+1 : 0;
                    if(ct == match){
                        con.setStartEnd(r,c,r+n,c,"vert");
                    }
                    n++;
                }
                
                // Checks right of current position in matrix
                ct = 0; n = 0;
                while(c+n < arr[0].length){
                    ct = (curr == arr[r][c+n]) ? ct+1 : 0;
                    if(ct == match){
                         con.setStartEnd(r,c,r,c+n,"hor");
                    }
                    n++;
                }
                
                // Checks down and right of current position in matrix
                ct = 0; n = 0;
                while(c+n < arr[0].length && r+n < arr.length){
                    ct = (curr == arr[r+n][c+n]) ? ct+1 : 0;
                    if(ct == match){
                         con.setStartEnd(r,c,r+n,c+n,"diagr");
                    }
                    n++;
                }
                
                // Checks down and left of current position in matrix
                n = 0; ct = 0;
                while(r+n < arr.length && c-n > -1){
                    ct = curr == arr[r+n][c-n] ? ct+1 : 0;
                    if(ct == match){
                        con.setStartEnd(r,c,r+n,c-n,"diagl");
                    }
                    n++;
                }
            }
        }
        
        con.output();
    }
    
}