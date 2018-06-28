import java.util.*;
import java.io.*;


class Result {
	public TreeNode node;
	public boolean isAncestor;
	public Result(TreeNode n, boolean isAncestor){
		this.node = n;
		this.isAncestor = isAncestor;
	}
}

public class CommonAncestorBest{

		public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
			// if(root == null) return null;

			// if(root == p || root == q) return root;


			// TreeNode x = commonAncestor(root.left, p, q);
			// if(x != null && x != p && x != q) return x;

			// TreeNode y = commonAncestor(root.right, p, q);
			// if(y != null && y != p && y != q) return y;


			// //if p and q are on differnt sides
			// if(x != null && y != null){
			// 	return root;
			// }else if(root == p || root == q){
			// 	return root;
			// }else{
			// 	return x == null ? y : x; //return non-null value;
			// }
			Result r = commonAncestorHelper(root, p , q);
			if(r.isAncestor){
				return r.node;
			}
			return null;


		}

		public static Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return new Result(null, false);

		if (root == p && root == q) return new Result(root, true);
		
		
		Result rx = commonAncestorHelper(root.left, p, q);
		if (rx.isAncestor) { // Found common ancestor
			return rx;
		}
		
		Result ry = commonAncestorHelper(root.right, p, q);
		if (ry.isAncestor) { // Found common ancestor
			return ry;
		}

		
		if (rx.node != null && ry.node != null) {
			return new Result(root, true); // This is the common ancestor
		} else if (root == p || root == q) {
			/* If were currently at p or q, and we also found one of those
			 * nodes in a subtree, then this is truly an ancestor and the
			 * flag should be true. */
			boolean isAncestor = rx.node != null || ry.node != null;
			return new Result(root, isAncestor);
		} else {
			return new Result(rx.node != null ? rx.node : ry.node, false);
		}
	}	
	
	




	public static void main(String[] args){
		int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15};

		TreeNode node = TreeNode.createMinimalBST(test);

		node.print();

		TreeNode p = node.find(3);
		TreeNode q = node.find(15);

		TreeNode x = commonAncestor(node, p, q);

		System.out.println("CommonAncestor  of " + p.data + " and " + q.data + " is "  + x.data);

	}
}