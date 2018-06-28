import java.util.*;
import java.io.*;

class Brackets{

	public static boolean isValid(String s){
		Stack<Character> st = new Stack<Character>();
		for(char c: s.toCharArray()){
			if(c == '(') st.push(')');
			else if (c == '{') st.push('}');
			else if (c == '[') st.push(']');
			else if (st.isEmpty() || st.pop() != c) return false;
		}
		return st.isEmpty();
	}


	public static void main(String[] args) {
		String[] testCases = {"[({})]", "[]([][])", "({{}})", "()]"};

		for(String s: testCases){
			System.out.println(isValid(s));
		}
	}
}