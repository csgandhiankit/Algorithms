public class Successor{
	//find the next element in-order
	public static TreeNode findSuccessor(TreeNode n){
		// if(d == node.data && node.right != null) 
		// 	{
		// 		return node.right;
		// 	}
		// if(d < node.data){
		// 	return findSuccessor(node.left, d);
		// }
		// else if( d > node.data){
		// 	return findSuccessor(node.right, d);
		// }
		// return node;

		if(n == null) return null;

		//if n has right subtree, get the leftmost element in right subtree
		if(n.right != null){
			return leftMostChild(n.right);
		}else{

			TreeNode q = n;
			TreeNode x = q.parent;

			//go up until we're on the left of n instead of right
			while(x != null && x.left != q)
			{
				//System.out.println("Before seting: x: " + x.data + " q: " + q.data);
				q = x;
				x = x.parent;
				//System.out.println("after seting: x: " + x.data + " q: " + q.data);
			}
			return x;
		}

	}


	public static TreeNode leftMostChild(TreeNode n){
		if(n == null) return null;
		while(n.left != null){
			n = n.left;
		}
		return n;
	}




	public static void main(String[] args){

		//int[] test = new int[]{1, 2, 3, 4, 5, 6, 7, 8,9,10};

		//TreeNode pass = TreeNode.createMinimalBST(test);

		// TreeNode fail = new TreeNode(5);

		// fail.insert(8);
		// fail.insert(2);
		// fail.insert(1);
		// fail.insert(11);
		// fail.insert(12);
		// fail.insert(13);
		// fail.insert(7);
		// fail.insert(15);
		// fail.insert(3);
		// fail.insert(7);
		// fail.insert(0);

		// fail.print();

		// TreeNode node = findSuccessor(fail);
		// System.out.println(node.data);





		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		root.print();
		for (int i = 0; i < array.length; i++) {
			TreeNode node = root.find(array[i]);
			TreeNode next = findSuccessor(node);
			if (next != null) {
				System.out.println(node.data + "->" + next.data);
			} else {
				System.out.println(node.data + "->" + null);
			}
		}
	}
}


