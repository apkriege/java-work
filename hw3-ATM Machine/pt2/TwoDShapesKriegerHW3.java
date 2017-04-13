// Homework 3: 2D Array 
// Student Name: Adam Krieger
// Course: CIS357, Winter 2017 
// Instructor: Il-Hyung Cho
// Date finished: 3/3/2017
// Program description: This program creates a list of 9 objects and then
// sorts them based on their area
//

import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TwoDShapesKriegerHW3{
    public static void main(String args[]){
        
        ArrayList<GeometricObject> geoArr = new ArrayList<GeometricObject>();
        geoArr.add(new ComparableCircle(1));
        geoArr.add(new ComparableCircle(2));
        geoArr.add(new ComparableCircle(3));
        geoArr.add(new ComparableRectangle(1, 4));
        geoArr.add(new ComparableRectangle(2, 6));
        geoArr.add(new ComparableRectangle(4, 9));
        geoArr.add(new ComparableTriangle(3, 2, 3));
        geoArr.add(new ComparableTriangle(2, 3, 4));
        geoArr.add(new ComparableTriangle(4, 5, 6));

        System.out.println("Unsorted list of geometric objects: ");
        for(int i=0; i<9; i++){
            System.out.println(geoArr.get(i));
        }
        
        System.out.println("\nSorted list of geometric objects: ");
        Collections.sort(geoArr);
        
        for(int i=0; i<9; i++){
            System.out.println(geoArr.get(i));
        }
    }
}

