public class MinimalTree{

	public static TreeNode createMinTree(int[] a, int start, int end){
		if(end < start) return null;
		int mid = (end + start) / 2;

		TreeNode n = new TreeNode(a[mid]);
		n.setLeftChild(createMinTree(a, start, mid - 1));
		n.setRightChild(createMinTree(a, mid + 1, end));
		return n;

	}

	public static TreeNode createMinTree(int[] a){
		return createMinTree(a, 0, a.length - 1);
	}



	public static void main(String[] args){
		int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7,8,9, 10};

		TreeNode node = createMinTree(arr);
		 
		System.out.println("height: " + node.height());
		node.print();
		
		

		// System.out.println(node.findMin(node).data);
		// System.out.println(node.findMax(node).data);
	}
}

