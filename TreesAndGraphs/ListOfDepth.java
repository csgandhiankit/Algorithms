import java.util.*;
import java.io.*;

public class ListOfDepth{



	//creating level list of a BS modifying BFS
	public static ArrayList<LinkedList<TreeNode>> getLists(TreeNode root){

		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

		LinkedList<TreeNode> current = new LinkedList<TreeNode>();

		if(root != null)
		{
			current.add(root);
		}

		while(current.size() > 0)
		{
			result.add(current);
			LinkedList<TreeNode> parents = current; //add previos level

			current = new LinkedList<TreeNode>(); //creating list for next level.
			for(TreeNode parent : parents){
				if(parent.left != null)
				{
					current.add(parent.left);
				}
				if(parent.right != null){
					current.add(parent.right);
				}
			}
		}

		return result;
	}

	public static ArrayList<LinkedList<TreeNode>> generateLevelLists(TreeNode root)
	{
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		generateLevelLists(root, lists, 0);
		return lists;

	}


	//Method 2: modifying pre-order traversal
	public static void generateLevelLists(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){

		if(root == null) return;

		LinkedList<TreeNode> list= null;

		if(lists.size() == level){
			list = new LinkedList<TreeNode>(); //is list size is equal to level passed in, that means the level hasnt been traversed yet.

			lists.add(list);
		}else{
			list = lists.get(level); //else if the level has already added, get the list at that level and append root element to it
		}

		list.add(root);
		generateLevelLists(root.left, lists, level +1);
		generateLevelLists(root.right, lists, level + 1);


	}


	//helper method to print lists of each level of a BS
	public static void printLists(ArrayList<LinkedList<TreeNode>> lists){

		int depth = 0;
		for(LinkedList<TreeNode> l : lists){
			Iterator<TreeNode> i = l.listIterator();
			System.out.print("Link list at depth " + depth + ":");
			while(i.hasNext()){
				System.out.print(" " + ((TreeNode)i.next()).data);
			}
			System.out.println();
			depth++;
		}

	}



	public static void main(String[] args)
	{

		int[] data = {1, 2, 3, 4, 5, 6, 7, 11, 12, 14, 15};
		

		//TreeNode bs = createTreeFromArray(data);

		

		 TreeNode node = TreeNode.createMinimalBST(data);
		 
		
		 node.print();
		
		 //using method 1
		//ArrayList<LinkedList<TreeNode>> list = getLists(node);

		 //Method 2
		ArrayList<LinkedList<TreeNode>> list = generateLevelLists(node);

		printLists(list);



		
	}
}