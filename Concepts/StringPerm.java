import java.util.*;
import java.io.*;


class StringPerm{

	public static void generatePerms(String str){
		generatePerms(str, "");
	}

	public static void generatePerms(String str, String prefix){
		if(str.length() == 0) System.out.println(prefix);

		for(int i = 0; i < str.length(); i++){
			String rem = str.substring(0, i) + str.substring(i+1);
			generatePerms(rem, prefix+str.charAt(i));
		}
	}


	public static void main(String[] args) {
		String test = "ABC";
		generatePerms(test);
	}
}