import java.util.*;
import java.io.*;

public class Graph{

	public static class Node{
		private int data;
		private boolean visited;
		private int dis;
		private LinkedList<Node> adjacent = new LinkedList<Node>();

		public Node(int data){
			this.data = data;
			this.visited = false;
			this.dis = 0;
		}

		public LinkedList<Node> getAdjList(){
			return this.adjacent;
		}

		public void markVisited(){
			this.visited = true;
		}

	}

	HashMap<Integer, Node> map = new HashMap<Integer, Node>();

	public  void addNode(int data){
		Node node = new Node(data);
		map.put(data, node);
	}

	public  Node getNode(int data){
		return map.get(data);
	}


	public void addEdge(int s, int d){
		Node source = map.get(s);
		Node dest = map.get(d);
		source.adjacent.add(dest);
	}


	public void printGraph(){

		for(int i : map.keySet()){
			System.out.print(i + ": ");
			if(map.get(i).adjacent.size() > 0){
				for(Node n: map.get(i).adjacent){
					System.out.print(n.data + " ");
				}
			}
		System.out.println();

		}
	}

	/**********Traveral Methods***************/

	public boolean hasDFS(int source, int destination){
		Node s = map.get(source);
		Node d = map.get(destination);
		HashSet<Integer> visited = new HashSet<Integer>();
		return hasDFS(s, d, visited);
	}

	public boolean hasDFS(Node source, Node destination, HashSet<Integer> visited){
		if(visited.contains(source.data)){
			return false;
		}
		visited.add(source.data);
		System.out.print(source.data + " => ");
		if(source == destination){
			return true;
		}
		for(Node n : source.adjacent){
			if(hasDFS(n, destination, visited)){
				return true;
			}
		}
		return false;
	}


	public boolean hasBFS(int source, int destination){
		Node s = map.get(source);
		Node d = map.get(destination);
		HashSet<Integer> visited = new HashSet<Integer>();
		LinkedList<Node> nextToVisit = new LinkedList<Node>();
		nextToVisit.add(s);

		while(!nextToVisit.isEmpty()){
			Node node = nextToVisit.remove();
			if(node == d){
				System.out.print(node.data);
				System.out.print(" Dis between " + source + " and " + destination + " is: " + (node.dis + 1)  + " \n");
				return true;
			}
			if(visited.contains(node.data)){
				continue;
			}
			visited.add(node.data);
			System.out.print(node.data + " => ");
			

			if(node.adjacent.size() > 0){
				for(Node child : node.adjacent){				
				child.dis = node.dis + 1;
				nextToVisit.add(child);
				}
			}
		}
		return false;
	}



	public static void main(String[] args) {
		Graph g = new Graph();
		g.addNode(1);
		g.addNode(3);
		g.addNode(4);
		g.addNode(5);
		g.addNode(6);
		g.addNode(7);
		g.addNode(8);
		g.addNode(9);


		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(6, 7);
		g.addEdge(6, 5);
		g.addEdge(7, 8);
		g.addEdge(8, 5);
		g.addEdge(8, 9);


		g.printGraph();
		long t0 = System.currentTimeMillis();
		boolean res = g.hasBFS(1, 9);
		long t1 = System.currentTimeMillis();
		System.out.println("Total time taken: "+ (t1-t0) + " ms");
		String s = res == true? "Path Exists!" : "Path doesnt exist!";
		System.out.println(s);

	}
}