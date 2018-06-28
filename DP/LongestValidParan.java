import java.util.*;
import java.io.*;


public class LongestValidParan{


	public static int longestValidParentheses(String a) {
	    int len = a.length();
	    if(len == 0) return 0;
	    int max = 0;

	    Stack<Integer> st = new Stack<Integer>();
	    st.push(-1);

	    for(int i = 0; i < a.length(); i++){
	    	char c = a.charAt(i);

	    	if(c == '(') st.push(i);
	    	else{
	    		int top =  st.pop(); //pop if c == ')'

	    		if(!st.isEmpty()) //if stack is not empty update length of max valid substring
	    		{
	    			max = Math.max(max, i - st.peek());
	    		}
	    		else{
	    			st.push(i);
	    		}
	    	}
	    }

	    return max;
	}

	public static void generateSubs(String a){
		for(int i = 0; i < a.length(); i++){
			for(int j = i + 1; j <= a.length(); j++){
				System.out.println(a.substring(i, j));
			}
		}
	}

	public static void main(String[] args) {
		 String[] testCases = {"(()", "((()()()()))", "()())()()(","(())" };
		 int[] res = {2, 12, 4, 4};

		 for(int i = 0; i < testCases.length; i++){
		 	int ans = longestValidParentheses(testCases[i]);
		 	if(ans == res[i]) System.out.println("LongestValidParan length : " + ans);
		 }
	}
}