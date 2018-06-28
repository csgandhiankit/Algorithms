import java.io.*;
import java.util.*;


public class AppendAndDel{


   public static boolean compareStrings(String a, String b, int k){
   	int i =0;
   	for(i = 0; i < a.length()  && i < b.length(); i++){
   		if(a.charAt(i) != b.charAt(i)){
   			break;
   		}
   	}

   	int aDiff = a.length() - i;
   	int bDiff = b.length() - i;

   	int p = k - aDiff - bDiff;

   	if(p == 0){
   		return true;
   	}
   	else if(p < 0){
   		return false;
   	}
   	else{
   		if(p % 2 == 0){
   			return true;
   		}
   		else{
   			if(p >= (i * 2)){ //in case of a == b
      				return true;
   			}
   			else{
   				return false;
   			}
   		}
   	}

	}


	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();
        boolean result = compareStrings(s, t, k);
        String ans = result == true ? "Yes" : "No";
        System.out.println(ans);
	}


}