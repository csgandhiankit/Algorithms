import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RunningMedian {
    
    public static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        if(lowers.size() == 0 || number < lowers.peek())
        {
            lowers.add(number);
        }else{
            highers.add(number);
        }
    }
    
    public static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
        
        if(biggerHeap.size() - smallerHeap.size() >= 2)
        {
            smallerHeap.add(biggerHeap.poll());
        }
        
    }
    
    public static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
        if(biggerHeap.size() == smallerHeap.size()){
            return ((double) smallerHeap.peek() + biggerHeap.peek()) / 2;
        }else{
            return biggerHeap.peek();
        }
    }
    
    
    
    public static double[] getMedians(int[] a){
        PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(a.length, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return -1 * a.compareTo(b);
            }
        });
        PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
        double[] medians = new double[a.length];
        for(int i = 0; i < a.length; i++)
        {
            int number = a[i];
            addNumber(number, lowers, highers); //adds number two left or right heap based on value
            rebalance(lowers, highers); //rebalances the two heaps if difference is >=2
            medians[i] = getMedian(lowers, highers); //gets the median for current values
        }
        return medians;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        for(double med: getMedians(a)){
            System.out.println(med);
        }
    }
}
