package com.test;

import java.util.ArrayList;
import java.util.List;

public class UniTakeHomeTest {

	public static void main(String[] args) {
		
		try {

			if(args.length<1) {
				System.out.println("To run this program one should provide atleast one argument");
				System.out.println("For example, java com.test.UniTakeHomeTest 124");
			}else if(args.length == 1) {
				
				System.out.println("The following function 'fun()' was as defined in the question \n");
				fun(Integer.parseInt(args[0]));
				
				System.out.println("The following function 'fun2()' has been defined to answer 4(b) & (c) \n");
				fun2(Integer.parseInt(args[0]));
			}else if(args.length >1) {
				
				for(int count =0;count<args.length;count++) {
					fun2(Integer.parseInt(args[count]));
				}
			}
		}catch(NumberFormatException nfe) {
			System.out.println("Incorrect argument !! which is not a valid integer number has been encountered, please enter a correct one and run the program again, bye!!");
		}

	}
	
	public static void fun(int x) {
		int a, b, c, d;
		d = 1;
		for (a = 1; a <= x; a++) {
			b = a;
			c = 1;
			while (b > 0) {
				c &= b % 2;
				b /= 2;
			}
			d += c;
		}
		System.out.println("output from fun() with input "+x+" : "+d);
	}
	
	
	/**
	 * Function takes an integer value as upper limit and calculates the count of occurrences of numbers ( inclusive of that upper limit value)
	 * which would comply with the mathematical series as follow,
	 * 
	 * 1,3,7,15,31,63,... [starting with 1, the next value of this series is calculated as (value * 2+1)] 
	 * 
	 * Expected result: 
	 * 
	 * Case 1:
	 * In case upper limit is provided as 8 [or any number which is > 7 and < 15]
	 * result = 4 [this is due to the counter already initialized with value 1 and the first occurrence of a value increments the counter to value 2]
	 * 
	 * Case 2:
	 * Alternatively, in case it is expected to get result = 8
	 * Upper limit value to be provided, in the range of >= 127 and <255 { presentation value[count of occurrence]: 1[2],3[3],7[4],15[5],31[6],63[7],127[8],255[9] }
	 * So any value out of possible 128 different values (>= 127 and <255) would result in result = 8
	 * 
	 * @param x
	 */
	private static void fun2(int x) {
		int counter,y;
		
		/** Initialization of var counter*/
		counter = 1;
		
		/** Initialization of var y*/
		y = 1;
		
		/** Declaration and instantiation of an empty array of type int,
		 *  of length x*2+2, i.e. if x is 127, array will be initialized with a length of 127*2+2=256 */
		int arr[] = new int[x*2+2];
		while (y <= x) {
			/** First value would always be 1, it is added to the list*/
			if(y == 1) {
				/** Next value of that array is being calculated based on the formula, [y = y*2+1]
				 * and added to the array index 'y' */
				y = y*2+1;
				arr[y] = y;
				counter++;
			}else {
				/** If the value of var 'y' matches with the value of array index 'y', 
				 * calculate the next value based on the formula [y = y*2+1] and add it to the list */
				if(arr[y] == y) {
					y = y*2+1;
					arr[y] = y;
					counter++;
				}
					
				
			}
				
			
		}
		System.out.println("output from fun2() with input "+x+" : "+counter);
	}
	
	

}
