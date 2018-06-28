public class InvertBST{


	public static TreeNode invertBST(TreeNode root){

		if(root == null) return null;
		//Swap values of left and right subtree
		TreeNode temp = root.left;
		root.left = invertBST(root.right);
		root.right = invertBST(temp);
		return root;
	}


	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};

  		TreeNode node = TreeNode.createMinimalBST(arr);

  		System.out.println("Before inverting...");
  		node.print();

  		node = invertBST(node);

  		System.out.println("After inverting...");
  		node.print();

	}
}