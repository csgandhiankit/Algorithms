import java.util.*;
import java.io.*;

//Moore's voting problem
public class VotingProblem {
    
 	 	
  	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
   //Run time complexity = O(n) space = O(N) : inefficient
	public static int majorityElement(final List<Integer> a) {
	    
	    if(a.size() == 1) return a.get(0);
	    
	   for(int i = 0; i < a.size(); i++){
	   		int val = a.get(i);
	   		// System.out.println("list val" + val);
	       if(!map.containsKey(val)){
	           map.put(val, 1);
	       }
	       else{
	           map.put(val, map.get(val) + 1);
	       }
	   }
	   double max = Math.floor(a.size()/2);
	   System.out.println(max);
	   int maxEle = -1;
	   for(int i : map.keySet())
	   {
	   	System.out.println("map.get(i)" + map.get(i));
	       if(map.get(i) > max){
	           max = map.get(i);
	           maxEle = i;
	       }
	   }
	   
	   return maxEle;
	    
	}


	//runtime = O(N) , Space complextiy = O(1)
	public static int majorityValue(final List<Integer> a){

		if(a == null) return -1;

		
		double freq  = Math.floor(a.size() / 2);

		int maxValue  = a.get(0);
		int count = 1;
		for(int i = 1; i < a.size(); i++){
			int val = a.get(i);
			if(val == maxValue){
				count++;
			}else if(count == 1){
				maxValue = val;
			}else{
				count--;
			}
		}
		count = 0;
		for(int i : a){
			if(i == maxValue){
				count++;
			}
		}


		return  count > freq ? maxValue : -1;


	}

	public static int findMajority(final List<Integer> a){
		if(a == null) return -1;
	int maxValue  = a.get(0);
		int count = 1;
		for(int i = 1; i < a.size(); i++){
			int val = a.get(i);
			if(val == maxValue){
				count++;
			}else if(count == 1){
				maxValue = val;
			}else{
				count--;
			}
		}
		return maxValue;
	}


	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		while(n > 0)
		{
			int val = in.nextInt();
			list.add(val);
			n--;
		}

		//int res = majorityValue(list);

		//teting majority value
		int majorValue = findMajority(list);
		System.out.println("Major value "+ majorValue);

	}
}
