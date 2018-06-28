import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Primality {




    private static void printStats(int count, int n, boolean isPrime){
        String caller = Thread.currentThread().getStackTrace()[2].getMethodName();
        System.err.println( caller + " performed " + count + " checks, determined " + n
        + ( (isPrime) ? " is PRIME." : " is NOT PRIME." ) );
    }
    
    //Worst case = O(n)
    public static boolean isPrime(int n)
    {
        int count = 0;

        if(n == 2)
        { 
            System.out.println("Prime");
            printStats(++count, n, true);
            return true;
        }
         if(n == 1 || (1 & n) == 0){
            System.out.println("Not prime");
            printStats(++count, n, false);
            return false;
        }
        
        for(int i = 3; i <= Math.sqrt(n); i+=2)
        {
            count++;
            if(n % i == 0)
            {
                System.out.println("Not prime"); 
                printStats(++count, n, false);
                return false;
            }
        }
        System.out.println("Prime");
        printStats(++count, n, true);
        return true;
    }

    // runtime = O(n^(1/2))
    public static boolean isPrimeBest(int n){
        int count = 0;
        // check lower boundaries on primality
        if( n == 2 ){ 
            printStats(++count, n, true);
            return true;
        } // 1 is not prime, even numbers > 2 are not prime
        else if( n == 1 || (n & 1) == 0){
            printStats(++count, n, false);
            return false;
        }

        // Check for primality using odd numbers from 3 to sqrt(n)
        for(int i = 3; i <= Math.sqrt(n); i += 2){
            count++;
            // n is not prime if it is evenly divisible by some 'i' in this range
            if( n % i == 0 ){ 
                printStats(++count, n, false);
                return false;
            }
        }
        // n is prime
        printStats(++count, n, true);
        return true;
    }

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
             isPrime(n);
        }
        
    }
}
