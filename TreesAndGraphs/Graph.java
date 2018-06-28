import java.util.*;
import java.io.*;

//Graph representation as an Adjacency list
//Question for this graph : refer to pg 106 of ctci
public class Graph{
	private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

	public static class Node{
		private int id;
		private boolean visited;
		private double dis;
		LinkedList<Node> adjacent = new LinkedList<Node>();
		LinkedList<Node> incoming = new LinkedList<Node>();
		
		private Node(int id){
			this.id = id;
			this.visited = false;
			this.dis = 0;
		}


		public void markVisited(){
			this.visited = true;
		}

		public LinkedList<Node> getList(){
			return this.adjacent;
		}

		public LinkedList<Node> getIncomingEdges(){
			return this.incoming;
		}
		
	}

	private void addNode(int data){
		Node node = new Node(data);
		nodeLookup.put(data, node);
	}

	//returns a node with given id
	private Node getNode(int id){
		return nodeLookup.get(id);
	}

	public void addEdge(int source, int destination){
		Node s = getNode(source);
		Node d = getNode(destination);		
		s.adjacent.add(d);
		d.incoming.add(s);
	}

	

	//Graph traversal techniques BFS/DFS
	public void BFS(int startVertex){
		Queue<Node> q = new LinkedList<Node>();
		Node s = getNode(startVertex);

		s.markVisited();
		q.add(s);
		BFS(q);
	}

	//recursive  BFS
	public void BFS(Queue<Node> q){
		if(q.isEmpty()) return;
	
		Node s = q.remove();
		System.out.print(s.id + " "); 

		if(s.adjacent.size() > 0){
			for(Node child : s.adjacent){
				if(!child.visited){
					child.markVisited();
					child.dis += s.dis + 1;
					q.add(child);
				}
			}
		}


		BFS(q);

	}


	public void DFS(int startVertex){
		Stack<Node> s = new Stack<Node>();
		Node n = getNode(startVertex);
		n.markVisited();
		s.push(n);
		DFS(n, s);

	}

	public void DFS(Node n, Stack<Node> s){
		if(s.isEmpty()){ 
			return;
		}	
		System.out.print(n.id + " ==> ");
		if(n.adjacent.size() > 0){
			for(Node child: n.adjacent){
				if(!child.visited){
					child.markVisited();
					s.push(child);
					DFS(child, s);
				}
			}
		}
		s.pop();




	}



	public boolean hasPathDFS(int source, int destination){
		Node s = getNode(source);
		Node d = getNode(destination);
		HashSet<Integer> visited = new HashSet<Integer>();
		return hasPathDFS(s, d, visited);
	}

	public boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited){
		if(visited.contains(source.id)) return false; //no path exists

		//else add node to visited set
		visited.add(source.id);
		 if(source == destination){
		 	return true;
		 }
		for(Node child : source.adjacent){
			if(hasPathDFS(child, destination, visited)){
				return true;
			}
		}
		return false;
	}

	//iterative BFS
	public  boolean hasPathBFS(Node source, Node destination){
		LinkedList<Node> nextToVisit = new LinkedList<Node>();
		HashSet<Integer> visited = new HashSet<Integer>();
		nextToVisit.add(source);
		while(!nextToVisit.isEmpty()){
			Node node = nextToVisit.remove();
			if(node == destination){
				return true;
			}
			if(visited.contains(node.id)){
				continue;
			}
			visited.add(node.id);

			for(Node child : node.adjacent){
				nextToVisit.add(child);
			}
		}
		return false; 
	}






	/*Helper methods to manipulate/print matrix */

	public  void print(){
		for(int i : nodeLookup.keySet()){
			Node node = getNode(i);
			System.out.print(node.id + ": ");
			if(node.adjacent.size() > 0){
				for(Node child: node.adjacent){
					
					System.out.print(child.id + " ");
					
				}
			}
			System.out.println();
		}
	}


	public  void printIncomingEdges(){
		System.out.println("printIncomingEdges ...");
		for(int i : nodeLookup.keySet()){
			Node node = getNode(i);
			System.out.print(node.id + ": ");
			if(node.incoming.size() > 0){
				for(Node child: node.incoming){
					
					System.out.print(child.id + " ");
					
				}
			}
			System.out.println();
		}
	}


	public boolean[][] convertListToMatrix(){
		int size = nodeLookup.size();

		boolean[][] matrix = new boolean[size][size];

		for(int i : nodeLookup.keySet()){
			Node node = getNode(i);
			if(node.adjacent.size() > 0){
				for(Node child: node.adjacent){
					matrix[node.id][child.id] = true;						
				}
			}
		}
		return matrix;
	}


	//Not so efficient method to print a boolean matrix
	public void printMatrix(boolean[][] matrix){
		System.out.print("\t");
		for(int i = 0; i < matrix[0].length; i++){
			System.out.print(i + "\t");
		}
		System.out.println();
		for(int i = 0; i < matrix.length; i++){
			System.out.print(i + " | ");
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + "    ");
			}
			System.out.println();
		}
	}


	//in-place transpose
	public boolean[][] getTransponse(boolean[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = i + 1; j < matrix[0].length;j++){
				boolean temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
 			}
		}
		return matrix;
	}

	public static Graph BsToGRapH(TreeNode node){
		if(node == null) return null;
		Graph g = new Graph();
		g.addNode(node.data);
		return BsToGRapH(node, node.left, node.right, g);
	}


	//Helper method to convert BS to Graph
	public static Graph BsToGRapH(TreeNode parent, TreeNode left, TreeNode right, Graph g){
		g.addNode(parent.data);

		//base case
		if(left == null  || right == null) {
			if(left != null)
			{
				g.addNode(left.data);
				g.addEdge(parent.data, left.data);
				return null;
			}else if(right != null){
				g.addNode(right.data);
				g.addEdge(parent.data, right.data);
				return null;
			}
			
		}

		if(left != null){
			g.addNode(left.data);
			g.addEdge(parent.data, left.data);
			BsToGRapH(left, left.left, left.right, g);
		}
		if(right != null)
		{
			g.addNode(right.data);
			g.addEdge(parent.data, right.data);
			BsToGRapH(right, right.left, right.right, g);
		}
		
		return g;
	}





	public static void main(String[] args){
		Graph g = new Graph();

		g.addNode(0);
		g.addNode(1);
		g.addNode(2);
		g.addNode(3);
		g.addNode(4);
		g.addNode(5);


		g.addEdge(0,1);
		g.addEdge(0,4);
		g.addEdge(0,5);
		g.addEdge(1,3);
		g.addEdge(1,4);
		g.addEdge(2,1);
		g.addEdge(3,2);
		g.addEdge(3,4);



		//g.print();

		//System.out.println("Running DFS on the Graph...");
		//g.BFS(0);



		// Graph g1 = new Graph();
		// g1.addNode(0);
		// g1.addNode(1);
		// g1.addNode(2);
		// g1.addNode(3);
		// g1.addNode(4);
		// g1.addNode(5);


		// g1.addEdge(0,1);
		// g1.addEdge(2,0);
		// g1.addEdge(2,4);
		// g1.addEdge(4,3);
		// g1.addEdge(4,5);

		// g1.print();
		// g1.BFS(2);

		//teting bst to graph
		// int[] data = {1, 2, 3, 4, 5, 6, 7, 11, 12, 14, 15};
		// TreeNode node = TreeNode.createMinimalBST(data);
		// node.print();

		// g = g.BsToGRapH(node);
		// g.print();

		// g.BFS(6);




		//converting adjacency list to matrix
		 boolean[][] matrix = g.convertListToMatrix();
		 g.printMatrix(matrix);

		//transposing the matrix to convert from outgoing edges to incoming edges
		// boolean[][] trans = g.getTransponse(matrix);
		// g.printMatrix(trans);


		//Tests for BFS and DFS
		// boolean test = g.hasPathDFS(0, 1);
		// System.out.println("Expected: true Actual: " + test);

		// boolean test1 = g.hasPathDFS(2, 1);
		// System.out.println("Expected: true Actual: " + test1);

		// boolean test2 = g.hasPathDFS(3, 4);
		// System.out.println("Expected: false Actual: " + test2);

		// boolean test3 = g.hasPathDFS(6, 5);
		// System.out.println("Expected: true Actual: " + test3);


		//Test for new implementation of BFS and DFS




	}
}