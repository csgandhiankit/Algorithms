import java.util.*;
import java.io.*;

public class Graph{

	private ArrayList<Project> nodes = new ArrayList<Project>();
	private HashMap<String, Project> map = new HashMap<String, Project>();

	public Project getOrCreateNode(String project)
	{
		if(!map.containsKey(project))
		{
		 	Project pNode = new Project(project);
		 	map.put(project, pNode);
		 	nodes.add(pNode);
		}

		return map.get(project);
	}


	public void addEdge(String source, String destination)
	{
		Project s = getOrCreateNode(source);
		Project d = getOrCreateNode(destination);
		s.addNeighbor(d);
	}


	public ArrayList<Project> getNodes(){ return this.nodes; }



	public static void main(String[] args)
	{

	}
}