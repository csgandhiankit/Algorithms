import java.util.*;
import java.io.*;


public class IceCreamParlor{

	//Solution using HashMap, returns same index if the complement and value are same
	//could be fixed using getting different keys from hashmap but that would increase the runtime 
	public static int[] getFlavors(int m, Integer[] cost)
	{
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int i = 0;
		int sum = 0;
		while(i < cost.length ||  sum != m)
		{
			int cst = cost[i];
			int comp = m > cst ? (m - cst) : (cst - m);
			map.put(i, cst);	
			if(map.containsValue(comp) && comp + cst == m)
			{
				int i1 = Arrays.asList(cost).indexOf(cst) + 1;
				int i2 = Arrays.asList(cost).indexOf(comp) + 1;
				int[] temp = i1 < i2 ? new int[] {i1, i2} : new int[]{i2, i1};
				return temp;
			}
			i++;
		}
		return null;


	}


	public static void printArr(int[] a)
	{
		for(int i: a)
		{
			System.out.print(i + " ");
		}
        System.out.println();
	}


	public static int indexOf(int[] menu, int val, int exclude)
	{
		for(int i = 0; i < menu.length; i++)
		{
			if(menu[i] == val && i != exclude)
			{
				return i;
			}
		}
		return -1;
	}


	public static int[] getIndicesFromValue(int[] menu, int val, int comp)
	{
		int index1 = indexOf(menu, val, -1);
		int index2 = indexOf(menu, comp, index1);
		return new int[] {Math.min(index1 + 1, index2 + 1), Math.max(index1 + 1, index2 + 1)};
	}


	//Method2: O(n lg n)
	public static int[] findChoices(int[] menu, int money){
		int[] sortedMenu = menu.clone();
		Arrays.sort(sortedMenu);
		for(int i = 0; i < sortedMenu.length; i++)
		{
			int comp = money - sortedMenu[i];
			int location = Arrays.binarySearch(sortedMenu, i+1, sortedMenu.length, comp);
			if(location >= 0 && location < sortedMenu.length &&  sortedMenu[location] == comp){
				int[] indices = getIndicesFromValue(menu, sortedMenu[i], comp);
				return indices;
			}
		}
		return null;
	}


	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            int[] result = findChoices(a, m);
            printArr(result);
            
        }

	}
}