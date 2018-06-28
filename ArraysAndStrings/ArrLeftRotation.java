import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArrLeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int i=0; i < n; i++){
            //a[a_i] = in.nextInt();
            int newIndex = (i + (a.length - k)) % a.length;
            a[newIndex] = in.nextInt();
        }

        for(int i : a){
            System.out.print(i+ " ");
        }

}

}