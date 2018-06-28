import java.util.*;
import java.io.*;


public class StringPerm{


	public static void generatePerm(String s){
		generatePerm(s, "");
	}

	public static void generatePerm(String s, String prefix){
		if(s.length() == 0) System.out.println(prefix);
		else{
		for(int i = 0; i < s.length(); i++){
			String rem = s.substring(0,i) + s.substring(i + 1);
			generatePerm(rem, prefix + s.charAt(i));
		}

	}
	}


	public static void main(String[] args) {
		String s = "ABC";
		
		generatePerm(s);
	}
}
