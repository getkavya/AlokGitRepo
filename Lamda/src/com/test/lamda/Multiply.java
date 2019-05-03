package com.test.lamda;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail


//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
class Multiply {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */
    int i;
    Scanner input = new Scanner (System.in);
    System.out.print("Input the first number: ");
    int a = input.nextInt();
    System.out.print("Input the second number: ");
    int b = input.nextInt();
    System.out.print("Input the third number: ");
    int c = input.nextInt();
    
    for (i=1; i<=b ; i++){
       if (i%b == 0)
        System.out.println("Fizz");
        else
        System.out.println(i);
    }
   for (i=1; i<=c ; i++){
       
	   if (i%b == 0 && i%5 != 0)
        System.out.println("Fizz");
        else if (i%5 == 0 && i%b!=0)
        System.out.println("Buzz");
        else if (i%5 == 0 && i%b==0)
        System.out.println("FizzBuzz");
        else
        System.out.println(i);
   }
 }
    
    }

   




