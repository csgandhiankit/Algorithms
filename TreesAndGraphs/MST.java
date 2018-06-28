import java.util.*;
import java.io.*;



//Prims algorithm on Adjacency list 
public class MST{
	 static HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();
	 static ArrayList<Edge> edges = new ArrayList<Edge>();


	public static class Node{
		private int val;
		private boolean isVisited;
		ArrayList<Edge> adjEdges = new ArrayList<Edge>();

		public Node(int val)
		{
			this.val = val;
			isVisited = false;
		}

		public void markVisited(){
			this.isVisited = true;
		}
		public void addEdge(Node to, int w){
			Edge e = new Edge(this, to, w);	
			adjEdges.add(e);		
			
		}

		public ArrayList<Edge> getAdjEdges()
		{
			return adjEdges;
		}


	}

	//helper class to wrap edge weights
    public static class Edge{
        private Node a;
        private Node b;
        private int w;

        public Edge(Node a, Node b, int w){
            this.a = a;
            this.b = b;
            this.w = w;
        }

        public int getEdgeWeight(){
            return this.w;
        }
    }

     public static void addNodeAndEdge(int a, int b, int w){
     	//adding edge to edges list
    

     	//updating adjacent edges in Node map
     	Node aa = nodeLookup.containsKey(a) == false ? new Node(a) : nodeLookup.get(a);
     	Node bb = nodeLookup.containsKey(b) == false?  new Node(b) : nodeLookup.get(b);
     	Edge e = new Edge(aa, bb, w);
     	edges.add(e);
     	
     	//adding edge between a and b
     	aa.addEdge(bb, w);

     	//updating nodes in hash map
     	nodeLookup.put(a, aa);
     	nodeLookup.put(b, bb);
 
    }


    //Helper method to sort edges array in increasing order
    public static void sort(ArrayList<Edge> edges)
    {
    	Collections.sort(edges, new Comparator<Edge>(){
    		@Override
    		public int compare(Edge e1, Edge e2)
    		{
    			return e1.getEdgeWeight() - e2.getEdgeWeight();
    		}
    	});
    }


    public static  void printNodesAndEdges(){

    	for(int i : nodeLookup.keySet())
    	{
    		Node n = nodeLookup.get(i);
    		if(n.adjEdges.size() > 0)
    		{
 	  			for(Edge e : n.adjEdges)
    			{
    				int from = e.a.val;
    				int to = e.b.val;
    				int w = e.w;
    				System.out.println("(" + from +", " + to + ") == >" + w);
    			}
    		}
    	}

    	
    }

    public static void printEdges(ArrayList<Edge> edges)
    {
    	for(Edge e : edges)
    	{
    		System.out.println("(" + e.a.val +", " + e.b.val + ") == >" + e.w);
    	}
    }



    public static void doPrims(int start){
    	Node s = nodeLookup.get(start);
    	ArrayList<Edge> edgeList = s.adjEdges;
    	s.markVisited();
    	int nodeCount = 1;
    	int totCost = 0;
    	sort(edgeList);
    	doPrims(start, edgeList, nodeCount, totCost);
    }

    //recursive prims algorithm helper method
    public static void doPrims(int start, ArrayList<Edge> edges, int nodeCount, int totCost){
    	System.out.println(start + " cost : " + totCost );
    	if(nodeCount == nodeLookup.size()) {
    		System.exit(1);
    		return;
    	}

    	if (edges.size() > 0) {
    		Iterator<Edge> iter = edges.iterator();
    		while(iter.hasNext()){
    			Edge e = iter.next();
    			Node a = e.a;
    			Node b = e.b;
    			int w = e.w;
    			int aa = a.val;
    			int bb = b.val;
    			if(!b.isVisited){
    				b.markVisited();
    				totCost += w;
    				iter.remove();
    				ArrayList<Edge> temp = edges;
    				Iterator<Edge> it = b.adjEdges.iterator();
    				while(it.hasNext())
    				{
    					Edge ee = it.next();
    					temp.add(ee);
    				}
    				sort(temp);
    				doPrims(bb, temp, ++nodeCount, totCost);
    			}
    		}
    	}
    }


  
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();


        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();
          	addNodeAndEdge(a, b, w);
		}
		doPrims(1);
		

	}

}