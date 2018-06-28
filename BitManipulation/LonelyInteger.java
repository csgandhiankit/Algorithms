import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LonelyInteger {
    
    public static int lonelyInteger(int[] a) {
        int len = a.length;
        if(len % 2 != 1) return -1; // error
        int mask = 0;
        for(int i = 0; i < len; i++)
        {
            // if((mask & (1 << a[i])) > 0)
            // {
            //     mask = mask & (~(1 << a[i])); //setting bit value from 1 to 0
            // }
            // else if((mask & (1 << a[i])) == 0){
            //      mask |= (1 << a[i]);       // setting bit value from 0 to 1  
            // }
            System.out.println("a[i]: " + a[i] + " and mask :" + mask);
            mask ^= a[i];
        }
        return mask;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        System.out.println(lonelyInteger(a));
        //System.out.println((int)Math.sqrt(lonelyInteger(a)));
    }   
}
