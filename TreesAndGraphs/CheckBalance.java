public class CheckBalance{

	public static int getHeight(TreeNode root){
		if(root == null) return -1;
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}


	//Recursive method to check balance of tree
	// runs in O(n log n ) time since for each node we recurse through entire subtree
	public static boolean checkBalance(TreeNode node){
		if (node == null) return true;
		int diff = 0;
		if(node.left != null && node.right != null){
		diff = Math.abs(node.left.height() -  node.right.height());
		System.out.println(diff);
		}
		if(diff > 1)
		{
			return false;
		}
		else{
			return checkBalance(node.left) && checkBalance(node.right);
		}
		

	}

	public static int checkHeight(TreeNode node){
		if(node == null) return -1;

		int leftHeight = checkHeight(node.left);
		if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // pass error up

		int rightHeight = checkHeight(node.right);
		if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; //pass error up

		int diff = Math.abs(leftHeight - rightHeight);
		if(diff > 1) return Integer.MIN_VALUE; //found error, pass it back
		else{
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}


	public static boolean isBalanced(TreeNode node){
		return checkHeight(node) != Integer.MIN_VALUE;
	}




	public static void main(String[] args){
		int[] test = new int[]{1, 2, 3, 4, 5, 6, 7, 8,9,10};

		TreeNode pass = TreeNode.createMinimalBST(test);


		pass.print();
		boolean p = isBalanced(pass);
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
		boolean f = isBalanced(fail);
		String res = f == true ? "Pass" : "Fail";
		System.out.println("Expected: Fail Actual: " + res);

	}
}