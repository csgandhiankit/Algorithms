import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RepeatedString {
    
    public static long countAs(String s, long n){
        int strLen = s.length();
        long len = Long.valueOf(strLen);
        HashMap<Integer, Long> map = new HashMap<Integer, Long>();
        long as = 0L;
        for(int i = 0; i < strLen;i++)
        {
            if(s.charAt(i) == 'a') {
                as++;
            }
            map.put(i+1, as);
        }

        long rep = n / len;
        long diff = n % len;
		// long lenStr = len * rep;
	
		// long diff = n - (len * rep);
		System.out.println("diff" + diff);
 
        int dif = Math.toIntExact(diff);
        

        long rem = !map.containsKey(dif) ? 0L : map.get(dif);
         return (rep * as) + rem;
      
        
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        
        long res = countAs(s, n);
        System.out.println("Num of a's in string " + s + " are: "+  res);
    }
}
