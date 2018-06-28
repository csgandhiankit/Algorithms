import java.util.*;
import java.io.*;


public class SyncShopping{

	static class Edge{
		private int start;
		private int end;
		private int cost;

		public Edge(int start, int end, int cost){
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		public int getStart(){return this.start;}
		public int getEnd(){return this.end;}
		public int getCost(){return this.cost;}

	}


	





	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int numCenters = in.nextInt();
		int numRoads = in.nextInt();
		int numTypes = in.nextInt();


		Map<Integer, int[]> map = new HashMap<Integer, int[]>();
		for(int i = 0; i < numCenters; i++){

			int numTypeFishes = in.nextInt();
			int[] types = new int[numTypeFishes];
			for(int j = 0; j < numTypeFishes; j++){
				types[j] = in.nextInt();
			}
			map.put(i + 1, types);
		}


		List<Edge> edges = new ArrayList<Edge>();

		for(int i = 0; i < numRoads; i++){
			int start = in.nextInt();
			int end = in.nextInt();
			int cost = in.nextInt();
			Edge edge = new Edge(start, end, cost);
			edges.add(edge);
		}



	}
}