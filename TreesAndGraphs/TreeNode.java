public class TreeNode{
	private int size = 0;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	public int data;



	public TreeNode(int d){
		this.data = d;
		size = 1;
	}

	public void setLeftChild(TreeNode left){
		this.left = left;
		if(left != null){
			left.parent = this;
		}
	}

	public void setRightChild(TreeNode right){
		this.right = right;
		if(right != null){
			right.parent = this;
		}
	}

	public void insert(int d){
		if(d <= data){
			if(left == null){
				setLeftChild(new TreeNode(d));
			}else{
				left.insert(d);
			}
		}else{
			if(right == null){
				setRightChild(new TreeNode(d));
			}else{
				right.insert(d);
			}
		}
		this.size++;

	}


	public TreeNode remove(int d, TreeNode node){
		if(node == null) return node;

		//look in left sub tree
		if(d < node.data){
			node.left = remove(d, node.left);
		}
		else if(d > node.data){ //look in right subtree 
			node.right = remove(d, node.right);
		}
		else if( node.left != null && node.right != null){ //if node to be removed have two children
			node.data = findMin(node.right).data;
			node.right = remove(node.data, node.right);
		}else{
			node = (node.left != null) ? node.left : node.right; // if node to be remove has only one child 

		} 
		return node;
	}


	public TreeNode findMin(TreeNode node){
		if(node == null) return null;
		else if (node.left == null){
			return node;
		}
		return findMin(node.left);

	}

	public TreeNode findMax(TreeNode node){
		if(node == null) return null;
		else if (node.right == null){
			return node;
		}
		return findMax(node.right);

	}	




	public int getSize(){
		return size;
	}

	public boolean isBST(){
		if(left != null){
			if(data < left.data || !left.isBST()){
				return false;
			}
		}
		if(right != null){
			if(data >= right.data || !right.isBST()){
				return false;
			}
		}

		return true;
	}

	public int height(){
		int leftHeight = left != null ? left.height() : -1;
		int rightHeight = right != null ? right.height() : -1;
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public TreeNode find(int d){
		if(d == data){
			return this;
		}else if(d <= data){
			return left != null ? left.find(d) : null;
		}else if( d > data){
			return right != null ? right.find(d) : null;
		}
		return null;
	}

	private static TreeNode createMinimalBST(int[] arr, int start, int end){
			if(end < start) return null;
			int mid = (start + end) / 2;

			TreeNode n = new TreeNode(arr[mid]);
			n.setLeftChild(createMinimalBST(arr, start, mid - 1));
			n.setRightChild(createMinimalBST(arr, mid + 1, end));

			return n;
	}


	public static TreeNode createMinimalBST(int[] arr){
		return createMinimalBST(arr, 0, arr.length -1);
	}

	//by Gayle Laakman Macdowell 
	public static TreeNode createTreeFromArray(int[] array) {
		if (array.length > 0) {
			TreeNode root = new TreeNode(array[0]);
			java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
			queue.add(root);
			boolean done = false;
			int i = 1;
			while (!done) {
				TreeNode r = (TreeNode) queue.element();
				if (r.left == null) {
					r.left = new TreeNode(array[i]);
					i++;
					queue.add(r.left);
				} else if (r.right == null) {
					r.right = new TreeNode(array[i]);
					i++;
					queue.add(r.right);
				} else {
					queue.remove();
				}
				if (i == array.length) {
					done = true;
				}
			}
			return root;
		} else {
			return null;
		}
	}




	public void print(){
		BTreePrinter.printNode(this);
	}


}