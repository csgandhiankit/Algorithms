import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedBrackets {
    
    public static boolean isBalanced(String expression) {
       // char[] temp = expression.toCharArray();
       //  for(int i = 0; i < temp.length; i++)
       //      {
       //      if(temp[i] == temp[(temp.length-1) - i])
       //          {
       //          return true;
       //      }
       //      else
       //          {
       //         continue;
       //      }
       //  }
       //  return true;

        char[] temp = expression.toCharArray();
        Stack<Character> s = new Stack<Character>();
        if(temp.length == 0) return false;
        for (char c : temp) {
        if      (c == '{') s.push('}');
        else if (c == '[') s.push(']');
        else if (c == '(') s.push(')');
        else {
            if (s.empty() || c != s.peek())
                return false;
        s.pop();
            }
        }
    return s.empty();
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
