class Node{

	Node left, right;
	int data;

	public Node(int data)
	{
		this.data = data;
	}

	public void insert(int value)
	{
		if(value <= data) {
			if(left == null) {
				left = new Node(value);
			}
			else {
				left.insert(value);
			}
		} else { 
			if(right == null) {
				right = new Node(value);
			}
			else {
			 right.insert(value);
			}
		}
	}

	public boolean contains(int value)
	{
		if(value == data){
			return true;
		}
		else if(value < data){
			if(left == null){
				return false;
			}
			else{
				return left.contains(value);
			}
		}
		else{
			if(right == null) {
				return false;
			}
			else{
				return right.contains(value);
			}
		}
	}

	public void printInOrder()
	{
		if(left != null)
		{
			left.printInOrder();
		}
		System.out.println(data);
		if(right != null)
		{
			right.printInOrder();
		}
	}

	//check if a tree is binary tree 
	public boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean checkBST(Node node, int min, int max) {
        if (node == null) return true;
        return  min < node.data && node.data < max && 
            checkBST(node.left, min, node.data) && 
            checkBST(node.right, node.data, max);
    }

    /* Python Solution in linera time and constant space
	lastVal = [0]

	def checkBST(root):
 		if not root: return True
  		left = checkBST(root.left)
 		if root.data <= lastVal[0]: return False
 		lastVal[0] = root.data
  		right = checkBST(root.right)
  		return left and right



    */


}