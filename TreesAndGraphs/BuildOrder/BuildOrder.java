import java.util.*;
import java.io.*;


public class BuildOrder{


	//method that executes the main algorithm to find a suitable build order
	public static Project[] findBuildOrder(String[] projects, String[][] dependencies)
	{
		Graph g = buildGraph(projects, dependencies);
		for(Project p : g.getNodes()){
			System.out.print(p.getName() + " ==> ");
			for(Project child : p.getChildren()){
			System.out.print(child.getName() + " ");
		}
		System.out.println();
		}
		return orderProjects(g.getNodes());
	}

	//helper method to build graph from nodes and edges
	public static Graph buildGraph(String[] projects, String[][] dependencies)
	{
		Graph g = new Graph();
		//adding all nodes to the graph
		for(String name: projects){
			g.getOrCreateNode(name);
		}

		//adding all edges between the nodes
		for(String[] dependency : dependencies){
			String s = dependency[0];
			String d = dependency[1];
			g.addEdge(s, d);
		}
		return g;
	}

	public static Project[] orderProjects(ArrayList<Project> projects){
		Project[] order = new Project[projects.size()];


		//adding roots to the build order first
		int endList = addNonDependent(order, projects, 0);


		int nextNodeToProcess = 0;
		while(nextNodeToProcess < order.length){
			Project current = order[nextNodeToProcess];

			if(current == null){
				return null;
			}

			ArrayList<Project> children = current.getChildren();
			for(Project child: children){
				child.decrementDependencies();
			}

			endList = addNonDependent(order, children, endList);
			nextNodeToProcess++;
		}

		return order;

	}

	public static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset){
		for(Project p : projects){
			if(p.getNumDependencies() == 0){
				order[offset] = p;
				offset++;
			}

		}

		return offset;
	}


	//helper method to convert nodes and edges into a graph and get build order and return it as String array
	public static String[] buildOrderWrapper(String[] projects, String[][] dependencies) {
		Project[] buildOrder = findBuildOrder(projects, dependencies);
		if (buildOrder == null) return null;
		String[] buildOrderString = convertToStringList(buildOrder);
		return buildOrderString;
	}
		
	//helper method to convert Project array to String array
	public static String[] convertToStringList(Project[] projects) {
		String[] buildOrder = new String[projects.length];
		for (int i = 0; i < projects.length; i++) {
			buildOrder[i] = projects[i].getName();
		}
		return buildOrder;
	}



 	public static void main(String[] args) {
	String[] projects = {"a", "b", "c", "d", "e", "f", "g"};
		String[][] dependencies = {
				{"a", "e"},
				{"b", "a"},
				{"b", "e"},
				{"c", "a"},
				{"d", "g"},
				{"f", "a"},
				{"f", "b"},
				{"f", "c"}};
		//Method1 Runtime = O(P + D) P = num of projects and D = num of dependencies
		String[] buildOrder = buildOrderWrapper(projects, dependencies);
		if (buildOrder == null) {
			System.out.println("Circular Dependency.");
		} else {
			System.out.println("Build Order ==>");
			for (String s : buildOrder) {
				System.out.print(s + " ");
			}
		}
	}
}