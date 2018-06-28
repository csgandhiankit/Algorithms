import java.util.*;
import java.io.*;

public class DupSubTree{

	public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        postOrder(root, new HashMap<String, Integer>(), list);
        return list;
    }	

    public static String postOrder(TreeNode node, HashMap<String, Integer> map, List<TreeNode> list){
    	if(node == null) return "";
    	String str = node.data + "," + postOrder(node.left, map, list) + "," + postOrder(node.right, map, list);
    	
    	if(map.getOrDefault(str, 0) == 1) list.add(node); //return 1 if key is in map else returns deafult value (0)
    	map.put(str, map.getOrDefault(str, 0) + 1);
    	return str;
    }


	public static void main(String[] args) {
		int[] arr = new int[] {2, 1, 1};

  		TreeNode node = TreeNode.createMinimalBST(arr);

  		node.print();

  		List<TreeNode> list = findDuplicateSubtrees(node);
  		String s = list.size() > 0? "Duplicate Subtree Exists" : "Duplicate subtree doesnt exist";
  		System.out.println(s);
  		for(TreeNode t : list){
  			System.out.print(t.data + " ");
  		}
	}
}