import java.io.*;
import java.util.*;

public class ValidateBST{

	//best approach time = O(N) and space = O(lg N ) due to recursive call stack
	public static boolean isValidBST(TreeNode root){
		if(root == null) return false;
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isValidBST(TreeNode root, int min, int max){
		if(root ==  null) return true;
		return min < root.data && root.data < max && isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);

	}



	//method 2 : in order traversal of tree and storing elements in an array and checking if the array is sorted. 
	public static void copyBST(TreeNode root, ArrayList<Integer> array){
		if(root == null) return;
		copyBST(root.left, array);
		array.add(root.data);
		copyBST(root.right, array);
	}


	public static boolean checkBST(TreeNode root){
		ArrayList<Integer> array = new ArrayList<Integer>();
		copyBST(root, array);
		for(int i = 1; i< array.size(); i++)
		{
			if(array.get(i) <= array.get(i-1)) return false;
		}
		return true;
	}


	static Integer lastVisiter = null;

	//Method 3 = compare the elements as we traverse
	public static boolean checkBST2(TreeNode n){
		if(n == null) return true;

		if(!checkBST2(n.left)) return false;

		if(lastVisiter != null && n.data <= lastVisiter) return false;

		//else set last visited to n.data
		lastVisiter = n.data;

		if(!checkBST2(n.right)) return false;

		return true;
	}







	public static void main(String[] args){

		int[] test = new int[]{1, 2, 3, 4, 5, 6, 7, 8,9,10};

		TreeNode pass = TreeNode.createMinimalBST(test);


		pass.print();
		boolean p = checkBST2(pass);
		String result = p == true ? "Pass" : "Fail";
		System.out.println("Expected: Pass Actual: " + result);

		TreeNode fail = new TreeNode(4);

		fail.insert(8);
		fail.insert(2);
		fail.insert(1);
		fail.insert(11);
		fail.insert(12);
		fail.insert(13);
		fail.insert(7);
		fail.insert(15);
		fail.insert(3);
		fail.insert(7);
		fail.insert(0);

		fail.print();
		boolean f = checkBST2(fail);
		String res = f == true ? "Pass" : "Fail";
		System.out.println("Expected: Fail Actual: " + res);

		
		

	}
}