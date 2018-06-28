/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    boolean checkBST(Node root) {
        if(root.left != null)
		{
			checkBST(root.left);
		}
		System.out.println(root.data);
		if(root.right != null)
		{
			checkBST(root.right);
		}
        return true;
    }

    boolean checkLeft(Node left){
       return false; 
    }
       
    boolean checkRight(Node right){
        return false;
    }

    
