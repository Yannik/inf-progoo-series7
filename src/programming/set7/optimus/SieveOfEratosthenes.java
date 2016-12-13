package programming.set7.optimus;

import acm.program.ConsoleProgram;

/*

Array: An array is a collection of values of the same type. In my class, `primes` is an array of type boolean.
       An array has to be initialized with a defined size.

List: A list is a collection of values of the same type. The difference to an array is that it does not have a
      fixed size and therefore items can be added without worrying about whether the list is "full" or not.

Exception: An exception halts the program execution due to an error. However, exceptions can be handled without
           completely stopping the programm execution using a try-catch block.

`throw`: The `throw` keyword must be followed by an instance of `Exception` (possibly as subclass). It throws
         this exception and halts the program flow, possibly completely stopping program execution or being
         handled by a catch-block.

 */

/**
 * This class calculates primes from 2 to a given number using
 * the sieve of eratosthenes method.
 */
public class SieveOfEratosthenes extends ConsoleProgram {
    public void run() {
        int size = readInt("Show primes between 2 and :");

        // as size includes the 0, increment it by one
        size++;

        // all primes are `false` by default.
        // as we are eliminating primes, we are setting this to true, if a number is not a prime.
        // so, a number is a prime if it is still `false` after running the sieve.
        boolean[] primes = new boolean[size];

        int currentInt = 2;
        while (currentInt*currentInt < size) {
            // assert that multiples of currentInt are not primes
            for (int i = currentInt * currentInt; i < size; i = i + currentInt) {
                primes[i] = true;
            }

            // set next currentInt to the next prime
            for (int i = currentInt + 1; i < size; i++) {
                if (!primes[i]) {
                    currentInt = i;
                    break;
                }
            }
        }

        // print out all primes starting with 2
        for (int i = 2; i < size; i++) {
            if (!primes[i]) {
               print(i + " ");
            }
        }
    }
}
