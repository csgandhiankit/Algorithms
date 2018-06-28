import java.util.*;
import java.io.*;

//GraphString representation as an Adjacency list
//Question for this GraphString : refer to pg 106 of ctci
public class GraphString{
	private HashMap<String, Node> nodeLookup = new HashMap<String, Node>();

	public static class Node{
		private String id;
		private boolean visited;
		private double dis;
		LinkedList<Node> adjacent = new LinkedList<Node>();
		LinkedList<Node> incoming = new LinkedList<Node>();
		
		private Node(String id){
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

	private void addNode(String data){
		Node node = new Node(data);
		nodeLookup.put(data, node);
	}

	//returns a node with given id
	private Node getNode(String id){
		return nodeLookup.get(id);
	}

	public void addEdge(String source, String destination){
		Node s = getNode(source);
		Node d = getNode(destination);		
		s.adjacent.add(d);
		d.incoming.add(s);
	}

	

	//GraphString traversal techniques BFS/DFS
	public void BFS(String startVertex){
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


	public void DFS(String startVertex){
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



	public boolean hasPathDFS(String source, String destination){
		Node s = getNode(source);
		Node d = getNode(destination);
		HashSet<String> visited = new HashSet<String>();
		return hasPathDFS(s, d, visited);
	}

	public boolean hasPathDFS(Node source, Node destination, HashSet<String> visited){
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
		HashSet<String> visited = new HashSet<String>();
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
		for(String i : nodeLookup.keySet()){
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
		for(String i : nodeLookup.keySet()){
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


	// public boolean[][] convertListToMatrix(){
	// 	int size = nodeLookup.size();

	// 	boolean[][] matrix = new boolean[size][size];

	// 	for(int i : nodeLookup.keySet()){
	// 		Node node = getNode(i);
	// 		if(node.adjacent.size() > 0){
	// 			for(Node child: node.adjacent){
	// 				matrix[node.id][child.id] = true;						
	// 			}
	// 		}
	// 	}
	// 	return matrix;
	// }


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

	


	public void removeAllEdges(String source, HashMap<String, Node> map)
	{
		Node s = getNode(source);
		for(String i : map.keySet()){
			Node node = getNode(i);
			if(node != s){
				if(node.incoming.size() > 0)
				{
					node.incoming.remove(s);
					
				}
				if(node.adjacent.size() > 0)
				{
					node.adjacent.remove(s);
				}
			}
		}
	}




	public static void main(String[] args){
		GraphString g = new GraphString();


		g.addNode("a"); //a
		g.addNode("b"); //b 
		g.addNode("c"); //c
		g.addNode("d"); //d
		g.addNode("e"); //e
		g.addNode("f"); //f
		g.addNode("g"); //g

	
		
		g.addEdge("f", "a");
		g.addEdge("f", "b");
		g.addEdge("f", "c");
		g.addEdge("c", "a");
		g.addEdge("b", "a");
		g.addEdge("b", "e");
		g.addEdge("a", "e");
		g.addEdge("d", "g");

		System.out.println("outgoing edges....");
		g.print();
		System.out.println("\n");
		//g.DFS(5);


		g.printIncomingEdges();







		


		//converting adjacency list to matrix
		// boolean[][] matrix = g.convertListToMatrix();
		// g.printMatrix(matrix);

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