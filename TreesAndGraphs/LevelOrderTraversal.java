import java.io.*;
import java.util.*;


public class LevelOrderTraversal{

	static class Node{
		Node left, right;
		int data;
		public Node(int data){
			this.data = data;
			left=right=null;
		}

	}

	public static Node insert(Node root, int data){
		if(root == null){
			return new Node(data);
		}
		else{
			Node cur;
			if(data <= root.data){
				cur = insert(root.left, data);
				root.left = cur;
			}else{
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}


	public static void levelOrderTraversal(Node root){
		Queue<Node> q = new LinkedList<Node>();

		if(root != null){
			q.add(root);


			while(!q.isEmpty()){
				Node node = q.remove();

				System.out.print(node.data + " ");

				if(node.left != null){
					q.add(node.left);
				}
				if(node.right != null)
				{
					q.add(node.right);
				}
			}
		}
	}



	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		Node root = null;
		while(n-- > 0){
			int data = in.nextInt();
			root = insert(root, data);
		}
		levelOrderTraversal(root);
		
	}
}