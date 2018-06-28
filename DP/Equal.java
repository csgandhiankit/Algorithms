import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Equal {

    static final int ONE = 1;
    static final int TWO = 2;
    static final int FIVE = 5;

    public static class MinMax{
      int min;
      int max;
      int minIdx;
      int maxIdx;
      MinMax(int min, int minIdx, int max, int maxIdx){
        this.min = min;
        this.max = max;
        this.maxIdx = maxIdx;
        this.minIdx = minIdx;
      }
    }

    //O(N^2 * max(diff)) = to be approximate
    public static int equalizeArray(int[] arr){

      MinMax minMax = getMinMax(arr);

      int min = minMax.min;
      int max = minMax.max;
      int maxIdx = minMax.maxIdx;
      int minIdx = minMax.minIdx;

      int diff = max - min;

    //  System.out.println("min idx" + minIdx + " max idx " + maxIdx);
    int count = 0;
    while(diff != 0){
       count++;
        for(int i = 0; i < arr.length; i++){
          if(i != maxIdx){
            arr[i] += getDistribution(diff);
          }
        }
       minMax = getMinMax(arr);
       min = minMax.min;
       max = minMax.max;
       maxIdx = minMax.maxIdx;
       minIdx = minMax.minIdx;

       diff = max - min;
       if(diff == 0) break;
  }
  return count;

  }


  public static int getDistribution(int diff){
      if(diff >= 5){
        return 5;
      }else if(diff >=2)
      {
        return 2;
      }
      else{
        return 1;
      }
    }

  public static MinMax getMinMax(int[] arr){
      int max = arr[0];
      int min = arr[0];
      int maxIdx = 0;
      int minIdx = 0;
      for(int i = 1; i < arr.length; i++){
        int val = arr[i];
        //System.out.println(val);
        if(val > max){
          max = val;
          maxIdx = i;
        }
        if(val < min){
          min = val;
          minIdx = i;
        }
      } 
      return new MinMax(min, minIdx, max, maxIdx);
    }


  public static void print(int[] arr){
    	for(int i : arr){
    		System.out.print(i + " ");
    	}
      System.out.println();
    }

//********************************************************//



    public static int function(int temp){
      int x = 0;
      if(temp >= 5){
        x = temp/5;
        temp %= 5;
      }
      if(temp >=2){
        x += temp/2;
        temp = temp%2;
      }
      x += temp;
      return x;
    }


    public static int array_smallest(int[] array, int length){
      int min = Integer.MAX_VALUE;

      int i;
      for(i = 0; i < length; i++){
        if(array[i] < min){
          min = array[i];
        }
      }

      return min;
    }

    public static int mod(int x){
     return Math.abs(x);    
    }
   
  public static void main(String args[] ) throws Exception {
       Scanner in = new Scanner(System.in);
       int numTestCases = in.nextInt();
      int N,min,temp;
       for(int i = 0; i < numTestCases; i++)
       {
          min = 1000000;
       	  int numColleagues = in.nextInt();
       		int arr[] = new int[numColleagues];
       		for(int j = 0; j < numColleagues; j++)
       		{
       			arr[j] = in.nextInt();
            if(arr[j] < min){
              min = arr[j];
            }
       		}
          print(arr); //print initial candy distribution

          int[] sum = new int[6];
          for(int j = 0; j <= 5; j++){
            sum[j] = 0;
            for(int k = 0; k < numColleagues; k++){
              temp = mod(arr[k] - (min - j));
              sum[j] += function(temp);
            }
          }

       		int res = array_smallest(sum, 6); //equalize candy distribution
          System.out.println("number of operations to equalize distribution: " + res);
       		print(arr); //print array after equalizing distribution

       }

       //input format:
       // 1 = num test cases
	   // 4 = num of colleagues
	   // 2 2 3 7 = candy distribution
    }
}
