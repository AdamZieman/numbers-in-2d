/**
 * Name: Adam Zieman
 * Course: CSCI 241 - Computer Science I
 * Section: 001
 * Assignment: 8
 *
 * Project/Class Description:
 * This program is intended for the programmer to practice 1-dimensional and
 * 2-dimensional arrays.
 * Known bugs:
 * None
 */
import java.util.*;

public class NumbersIn2D
{
    public static void main(String [] args)  {
        // Call startUp() method to print heading and
        // get value needed for multiply step
        int factor = startUp(); 

        System.out.println("\nOriginal array");
        System.out.println("---------------------------------------");
        int [][] data = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        print2DArray(data);  

        System.out.println("Array entries multiplied by " + factor);
        System.out.println("---------------------------------------");
        multiplyAll(data,factor);
        print2DArray(data);

        System.out.println("After making odds negative");
        System.out.println("---------------------------------------");
        makeOddsNegative(data);
        print2DArray(data);

        System.out.println("Array in one dimension");
        System.out.println("---------------------------------------");
        int [] oneDimArray = make1D(data);
        print1DArray(oneDimArray);

        System.out.println("\nUpside down version");
        System.out.println("---------------------------------------");
        int [][] upsideDownVersion = upsideDown(data);
        print2DArray(upsideDownVersion);

        System.out.println("2d with 4 rows, 3 columns");
        System.out.println("---------------------------------------");
        int [][] twoDimArray = make2D(oneDimArray,4,3);
        print2DArray(twoDimArray); 

        System.out.println("Rotate up by 1 row");
        System.out.println("---------------------------------------");
        rotateUp(twoDimArray);
        print2DArray(twoDimArray); 
    }

    //*** PLEASE PLACE ALL METHODS HERE              ***
    //*** IN ORDER LISTED IN ASSIGNMENT DESCRIPTION  ***
    // print1DArray
    public static void print1DArray(int [] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%4d", array[i]);
        }
        System.out.println();
    }

    // print2DArray
    public static void print2DArray(int [][] array) {
        for (int r = 0; r < array.length; r++) {
            for (int c = 0; c < array[r].length; c++) {
                System.out.printf("%4d", array[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // startUp
    public static int startUp() {
        // Initialize variables
        Scanner keyboard = new Scanner(System.in);
        int num;

        // Program Description
        System.out.println("This program will manipulate a fixed array.");
        System.out.println("The array has 3 rows and 4 columns.");

        // User defines a value between 2 and 7
        do {
            System.out.print("Enter number used for multiply step: ");
            num = keyboard.nextInt();

            // error message when input is out of range
            if (num < 2 || num > 7)
                System.out.println(num + " is an invalid entry! Number must be between 2 and 7.");

        } while (num < 2 || num > 7);

        return num;
    }

    // multiplyAll 
    public static void multiplyAll(int [][] array, int multiplier) {
        // cycles through the 2-D array
        for (int r = 0; r < array.length; r++) {
            for (int c = 0; c < array[r].length; c++) {
                // index value is multiplied by the user defined value
                array[r][c] *= multiplier;
            }
        }
    }

    // makeOddsNegative
    public static void makeOddsNegative(int [][] array) {
        // cycles through the 2-D array
        for (int r = 0; r < array.length; r++) {
            for (int c = 0; c < array[r].length; c++) {
                // checks for odd integers
                if (array[r][c] % 2 != 0)
                // odd integers converted into a negative value
                    array[r][c] *= -1;
            }
        }
    }

    // make1D
    public static int [] make1D(int [][] array2D) {
        // Initialize variables
        int length2DArray = 0;
        int index = 0;
        
        // finds the total length of the 2-D array
        for (int row = 0; row < array2D.length; row++) {
            length2DArray += array2D[row].length;
        }
        
        // Declare and instantiate 1-D array
        int [] array1D = new int [length2DArray];
        
        // cycles through the 2-D array
        for (int r = 0; r < array2D.length; r++) {
            for (int c = 0; c < array2D[r].length; c++) {
                // stores the 2-D array indexs into a 1-D array
                array1D[index] = array2D[r][c];
                
                index++;
            }
        }
        
        return array1D;
    }
    
    // upsideDown
    public static int [][] upsideDown(int [][] originalArray) {
        // Initialize variable
        int index = 0;
        
        // Declare and instantiate upside down array
        int [][] upsideDownArray = new int [3][4];
        
        // cycles through the 2-D array from bottom to top, left to right
        for (int r = originalArray.length - 1; r >= 0; r--) {
            for (int c = 0; c < originalArray[r].length; c++) {
                // vertically flips the array
                upsideDownArray[index][c] = originalArray[r][c];
            }
            index++;
        }
        
        return upsideDownArray;
    }
    
    // make2D
    public static int [][] make2D(int [] array1D, int rows, int cols) {
        // Initialize variable
        int index = 0;
        
        // Declare and instantiate a 2-D array
        int [][] newArray2D = new int [rows][cols];
        
        // cycles through the array
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // converts a 1-D array into a 2-D array
                newArray2D[r][c] = array1D[index];
                index++;
            }
        }
        
        return newArray2D;
    }
    
    // rotateUp
    public static void rotateUp(int [][] array) {
        // Declare and instantiate a 1-D array
        int [] temp = new int [array[0].length];
        
        // stores the first row of the array in the temporary 1-D array 
        for (int cols = 0; cols < temp.length; cols++) {
        temp[cols] = array[0][cols];
    }
        
        // moves the array up a row
        for (int r = 1; r < array.length; r++) {
            for (int c = 0; c < array[r].length; c++) {
                array[r - 1][c] = array[r][c];
            }
        }
        
        // replaces the last row of the modified array with the information stored in the
        // temp array
         for (int k = 0; k < temp.length; k++) {
            array[array.length - 1][k] = temp[k];
        }
    }
}
