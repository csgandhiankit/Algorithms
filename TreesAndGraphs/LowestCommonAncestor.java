public class LowestCommonAncestor{

    public static TreeNode lca(TreeNode root,int v1,int v2)
    {
    if(root == null) return root;
    
    if(v1 < root.data && v2 < root.data){ 
        return root = lca(root.left, v1, v2);
    }
    else if(v1 > root.data && v2 > root.data){
        return root = lca(root.right, v1, v2);
    }
    else{
        return root;
    }
       
    }

    public static void print(Node root){
        if(root != null){
            print(root.left);
            System.out.print(root.data+" ");
            print(root.right);
        }
    }





    public static void main(String[] args){

        int[] arr = new int[] {1, 2, 3, 4,5 ,6 ,8,9, 11, 23, 33};

        TreeNode node = TreeNode.createMinimalBST(arr);

        node.print();

        TreeNode result = lca(node, 4, 6);

        System.out.println(result.data);

    }


}


