import java.util.*;
import java.io.*;

public class BST{
	
	public static void printInOrder(TreeNode node)
	{
		if(node.left != null)
		{
			printInOrder(node.left);
		}
		System.out.print(node.data + " ");
		if(node.right != null)
		{
			printInOrder(node.right);
		}

	}

	public static void printPreOrder(TreeNode node){
		System.out.print(node.data + " ");
		if(node.left != null)
		{
			printPreOrder(node.left);
		}
		if(node.right != null)
		{
			printPreOrder(node.right);
		}
	}

	// root is always the last node visited
	public static void printPostOrder(TreeNode node){
		if(node.left != null)
		{
			printPostOrder(node.left);
		}
		if(node.right != null)
		{
			printPostOrder(node.right);
		}
		System.out.print(node.data + " ");
	}

	//check if a tree is binary tree 
	public boolean checkBST(TreeNode root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean checkBST(TreeNode node, int min, int max) {
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


  	public static void main(String[] args)
  	{
  		BST b = new BST();
  		int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};

  		TreeNode node = TreeNode.createMinimalBST(arr);

  		node.print();
  		System.out.println("\nIn order traversal..");
  		b.printInOrder(node);

  		System.out.println("\npreo-rder traversal..");
  		b.printPreOrder(node);

  		System.out.println("\npost-order traversal..");
  		b.printPostOrder(node);



  		


  	}


}