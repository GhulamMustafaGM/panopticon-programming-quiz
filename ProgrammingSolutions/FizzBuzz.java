// Program that prints the numbers from 1 to 100.

import java.util.*;

class FizzBuzz {
	public static void main(String args[]) {

		int n = 100;

		// Set loop for 100 that prints the numbers from 1 to 100 times.
		for (int x = 1; x <= n; x++) {

			// Multiples of both three and five pring "FizzBuzz"
			// place of the number
			if (x % 15 == 0)
				System.out.print("FizzBuzz" + " ");

			// Multiples of five print "Buzz"
			// in place of the number
			else if (x % 5 == 0)
				System.out.print("Buzz" + " ");
			// Multiples fo three print "Fizz"
			// in place of the number

			else if (x % 3 == 0)
				System.out.print("Fizz" + " ");

			else // Print the numbers
				System.out.print(x + " ");
		}
	}
}

/*
 * Output:
 * 
 * 1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11
 * Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz
 * Fizz 22 23 Fizz Buzz 26 Fizz 28 29 FizzBuzz
 * 31 32 Fizz 34 Buzz Fizz 37 38 Fizz Buzz 41
 * Fizz 43 44 FizzBuzz 46 47 Fizz 49 Buzz Fizz
 * 52 53 Fizz Buzz 56 Fizz 58 59 FizzBuzz 61
 * 62 Fizz 64 Buzz Fizz 67 68 Fizz Buzz 71
 * Fizz 73 74 FizzBuzz 76 77 Fizz 79 Buzz Fizz
 * 82 83 Fizz Buzz 86 Fizz 88 89 FizzBuzz 91
 * 92 Fizz 94 Buzz Fizz 97 98 Fizz Buzz
 * 
 */

/*
 * In summary,
 * Fizzbuzz is a fun game played. It is simple game in which when we turn comes,
 * then we need to say the next number. Game rules following:
 * 
 * If number is divisible by 3, then we need to say "Fizz"
 * If number is divisible by 5, then we need to say "Buzz"
 * If number is divisible by 3 and 5 both, then we need to say "FizzBuzz"
 * Otherise, we just need to say next number.
 */
