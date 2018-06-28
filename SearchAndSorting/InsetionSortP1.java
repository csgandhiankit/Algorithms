import java.io.*;
import java.util.*;


public class InsertionSortP1{


	 public static void insertIntoSorted(int[] ar) {
        int temp = ar[ar.length-1];
        int idx = ar.length -1;
       for(int i = ar.length-2; i >= 0; i--){
           int val = ar[i];
           if (val > temp){
               swap(ar, i, idx);
           }else if(val < temp){
               printArray(ar);
           }
       } 
    }
    
    public static void swap(int[] a, int s, int e){
        int temp = a[s];
        a[s] = a[e];
        a[e] = temp;
    }
    


    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
        }
        insertIntoSorted(ar);
    }
    
   
}