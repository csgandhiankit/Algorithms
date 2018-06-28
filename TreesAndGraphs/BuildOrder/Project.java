import java.io.*;
import java.util.*;

public class Project{

	private ArrayList<Project> children = new ArrayList<Project>();
	private HashMap<String, Project> map = new HashMap<String, Project>();

	private String name;
	private int dependencies = 0;

	public Project(String p)
	{
		this.name = p;
	}

	public void incrementDependencies() { this.dependencies++;}
	public void decrementDependencies() { this.dependencies--;}

	public String getName(){ return this.name; }

	public ArrayList<Project> getChildren(){ return this.children;}
	public int getNumDependencies(){ return this.dependencies; }

	public void addNeighbor(Project p){
		if(!map.containsKey(p.getName()))
		{
			children.add(p);
			map.put(p.getName(), p);
			p.incrementDependencies();
		}
	}



	public static void main(String[] args){

	}
}