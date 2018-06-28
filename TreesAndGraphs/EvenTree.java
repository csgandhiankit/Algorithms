import java.io.*;
import java.util.*;

public class EvenTree{

	static HashMap<Integer, Node> map = new HashMap<Integer, Node>();

	static ArrayList<Edge> edges = new ArrayList<Edge>();



	public static class Node{
		int val;
		boolean visited;
		LinkedList<Node> adjacent = new LinkedList<Node>();

		public Node(int val){
			this.val = val;
			this.visited = false;
		}

		public LinkedList<Node> getEdges(){
			return this.adjacent;
		}

		public void markVisited(){
			this.visited = true;
		}


	}

	public static class Edge{
		int a;
		int b;

		public Edge(int a, int b){
			this.a = a;
			this.b = b;
		}

	}

	public static void DFS(int n){
		Node node = map.get(n);
		Stack<Node> s = new Stack<Node>();
		int count = 0;
		s.push(node);
		DFS(count , s);
	}

	public static void DFS(int count, Stack<Node> s){
		count++;
		if(s.size() == 0) 
			{
				System.out.println("Count: " + count);
				return;
			}

		while(!s.empty()){

			Node n = s.pop();
			System.out.print(n.val + " ");
			//System.out.println("Count: " + count);
			

			if(n.adjacent.size() > 0){
				for(Node nodes: n.adjacent){
					s.push(nodes);
					DFS(count, s);
				}
			}
		}

	}



	public static void addNodes(int n){
		for(int i =1; i <= n; i++){
			Node node = new Node(i);
			map.put(i, node);
		}
	}

	public static void printEdges(){
		for(Edge e: edges){
			System.out.println("( " + e.a + ", " + e.b + " )");
		}
		System.out.println();
	}

	public static void printAdjList(){
		for(int i : map.keySet()){
			Node node = map.get(i);
			System.out.print(i + " : ");
			if(node.adjacent.size() > 0){
				for(Node nn : node.adjacent){
					System.out.print(nn.val+ " ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();

		addNodes(n); //add nodes of graph



		//add all edges to a list
		for(int i = 0; i < m; i++){
			int a = in.nextInt();
			int b = in.nextInt();
			Node aa = map.get(a);
			Node bb = map.get(b);
			bb.adjacent.add(aa);
			Edge e = new Edge(a, b);
			edges.add(e);
		}

		printEdges();
		printAdjList();


		DFS(1);
		

	}

}