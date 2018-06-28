import java.io.*;
import java.util.*;


public class InsertionSortP1{



	 public static void insertIntoSorted(int[] ar) {
        int temp = ar[ar.length-1];
        int idx = ar.length -1;
        int i = ar.length-1;
       for( i = ar.length-1; i > 0; i--){
           int val = ar[i-1];
           if (val > temp){
               swap(ar, i, val);
               printArray(ar);
           }else if(val < temp){
              ar[i] = temp;
               printArray(ar);
               break;
           }
       }
       if(i == 0){
        ar[0] = temp;
        printArray(ar);
       }

    }
    
    public static void swap(int[] a, int s, int e){     
        a[s] = e;
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