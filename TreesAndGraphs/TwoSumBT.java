// Given a binary search tree T, where each node contains a positive integer, and an integer K,
// you have to find whether or not there exist two different nodes A and B such that A.value + B.value = K.
//Memory O(height)

import java.util.*;
import java.io.*;

public class TwoSumBT{

	public static int t2Sum(TreeNode A, int B) {

		ArrayList<Integer> arr =  new ArrayList<Integer>();

		inOrder(A, arr);

		int start = 0;
		int end = arr.size() - 1;
		while(start < end){
			int sum = arr.get(start) + arr.get(end);
			if(sum == B){
				return 1;
			}else if(sum < B){
				start++;
			}else{
				end--;
			}

		}
		return 0;
    }

	
	public static void inOrder(TreeNode node, ArrayList<Integer> arr){
		if(node.left != null){
			inOrder(node.left, arr);
		}

		arr.add(node.data);

		if(node.right != null){
			inOrder(node.right, arr);
		}

	}



	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};

  		TreeNode node = TreeNode.createMinimalBST(arr);

  		node.print();

  		int B = 9;

  		int res = t2Sum(node, B);

  		String s = res == 1 ? "Sum Exists!" : "No such two nodes exists!";
  		System.out.println(s);	
  	}
}
