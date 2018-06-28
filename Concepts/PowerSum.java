import java.util.*;
import java.io.*;

public class PowerSum{


	public static int getPowerSum(int x, int n, int i){
		x = x - (int) Math.pow(i, n);
        if (x == 0) return 1;
        if (x > 0) {
            int sum = 0;
            for (int j = i + 1; Math.pow(j, n) <= x; j++)
                sum += getPowerSum(x, n, j);
            return sum;
        } else return 0;
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		int num = getPowerSum(n, k, 0);
		System.out.println(num);

	}
}