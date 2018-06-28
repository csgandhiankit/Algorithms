public class CommonAncestor{


	//Method 1 : links to parents Runtime = O(d) d = depth of deeper node
	public static TreeNode commonAncestor(TreeNode p, TreeNode q){
		int delta = depth(p) - depth(q); //get difference in depths


		TreeNode first = delta > 0 ? q : p; //shallower path
		TreeNode second = delta > 0? p : q; //deeper path
		second = goUpBy(second, Math.abs(delta)); //move deeper node up

		//find paths of intersection of both nodes
		while(first != second && first != null && second != null){
			first = first.parent;
			second = second.parent;
		}

		return first == null || second == null ? null : first;

	}


	public static TreeNode goUpBy(TreeNode node, int delta){
		while(delta > 0 && node != null){
			node = node.parent;
			delta--;
		}
		return node;
	}


	public static int depth(TreeNode node){
		int depth = 0;
		while(node != null){
			node = node.parent;
			depth++;
		}
		return depth;

	}



	public static void main(String[] args){
		int[] test = {1, 2, 3, 4, 5, 6, 7, 10, 11, 12, 13, 15};

		TreeNode node = TreeNode.createMinimalBST(test);

		node.print();
		TreeNode p = node.find(4);
		TreeNode q = node.find(11);

		TreeNode result = commonAncestor(p, q);

		System.out.println("CommonAncestor  of " + p.data + " and " + q.data + " is "  + result.data);



	}
}