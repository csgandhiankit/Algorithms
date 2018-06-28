import java.util.*;
import java.io.*;


public class LargestRectangle{


	public static int largestRectangleAreaBF(ArrayList<Integer> a){
		int largestRect = 0;	

		if(a.size() == 0 || a == null) return largestRect;
		
		final int width = 1; //width of each bar

		for(int  i = 0; i < a.size(); i++){
			System.out.println("largestRect: " + largestRect);
			int height = a.get(i);
			int left = i, right = i;
			while(left >= 0 && a.get(left) >= height){
				left--;
			}
			while(right < a.size() && a.get(right) >= height)
			{
				right++;
			}
			System.out.println("i :"  + i);
			largestRect = Math.max(largestRect, (right - left - 1) * height);
		}

		return largestRect;
	}

	/************Optimal Solution using Stacks *****************/

	public static int getMaxHeight(int oldMaxHeight, int currentHeight, int startIdx, int currentIdx){
		int maxHeight = currentHeight * (currentIdx - startIdx);
		//System.out.println("largestRect: " + Math.max(oldMaxHeight, maxHeight));
		return Math.max(oldMaxHeight, maxHeight);
	}

	public static int largestRectangleArea(ArrayList<Integer> a){
		if(a.size() == 0 || a == null) return 0;
		int largestRect = 0;
		Stack<Integer> indices = new Stack<Integer>();
		Stack<Integer> heights = new Stack<Integer>();

		int i =0;
		for( i = 0; i < a.size(); i++){
			
			int height = a.get(i);
			if(heights.empty() || height > heights.peek())
			{
				indices.push(i);
				heights.push(height);

			}else if(height < heights.peek()){

				//Remove all the elements from top of stack > height
				while(!heights.empty() && heights.peek() > height){
					int topHeight = heights.pop();
					int nextTopHeight = !heights.empty() ? heights.peek() : -1;
					if(height < nextTopHeight){
						largestRect = getMaxHeight(largestRect, topHeight, indices.pop(), i);
					}
					else if(height >= nextTopHeight)
					{
					 	largestRect = getMaxHeight(largestRect, topHeight, indices.peek(), i);
					 	heights.push(height);
					}

				}		
			}
			else{
				largestRect = getMaxHeight(largestRect, heights.pop(), indices.pop(),i);

			}
			
		}

		//remove rest of heights and indices from stacks
		while(!heights.empty() && !indices.empty()){
			int h = heights.pop();
			int startIdx = indices.pop();
			largestRect = getMaxHeight(largestRect, h, startIdx, i);
		}
		

		return largestRect;
	}


	/*****************Optimal Solution Interviewbit ***********/
	static int max(int a,int b){
        return a>b?a:b;
    }
	public static int largestRectangleAreaOp(ArrayList<Integer> a) {
	    Stack<Integer> s=new Stack<Integer>();
	    int i=0,n=a.size();
	    int tp,ar,mx=0;
	    while(i<n){
	        if(s.empty()||a.get(s.peek())<=a.get(i))
	            s.push(i++);
	        else {
	            tp=s.pop();
	            ar= a.get(tp)*(s.empty()?i:i-s.peek()-1);
	            if(ar>mx)
	                mx=ar;
	        }
	        
	    }
	    while(!s.empty()){
	       tp=s.pop();
	            ar= a.get(tp)*(s.empty()?i:i-s.peek()-1);
	            if(ar>mx)
	                mx=ar;
	    }
	    return mx;
	}

	public static void main(String[] args) {
		
		int[][] testCases = {{2,1,5,6,2,3}, {1, 2, 3}, {90, 58, 69, 70, 82, 100, 13, 57, 47, 18 },{1}, {1, 3, 2 ,1 ,2} };
		int[] sols = {10, 4, 1512, 1, 5};
		int count = 0;
		for(int[] testArr: testCases){
		ArrayList<Integer> a = new ArrayList<Integer>();
		System.out.print("[ ");
		for(int i : testArr){
			a.add(i);
			System.out.print(i+ " ");
		}
		System.out.println("]");

		int largestRect = largestRectangleAreaOp(a);
		
		System.out.println("Largest Histogram Area: " + largestRect  + " Expected: "+ sols[count++] +"\n");
	}

	}
}