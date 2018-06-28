import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class SuperMancunian{
    
    //helper class to wrap edge weights
    public static class Edge{
        private int a;
        private int b;
        private int w;

        public Edge(int a, int b, int w){
            this.a = a;
            this.b = b;
            this.w = w;
        }

        public int getEdgeWeight(){
            return this.w;
        }

    }

    final int N = 200002;
    int[] sz = new int[N];
    int[] par = new int[N];

    ArrayList<Edge> edges_list = new ArrayList<Edge>();

    public  int root(int v){
        if(v == par[v]){
            return v;
        } 
        return par[v] = root(par[v]);

    }

    public  void swap(int[] sz, int a, int b){
        int temp = sz[a];
        sz[a] = sz[b];
        sz[b] = temp;
    }

    public  void unite(int a, int b){
        a = root(a);
        b = root(b);
        if(a == b) return;
        if(sz[a] < sz[b]) swap(sz, a, b);
        sz[a] += sz[b];
        par[b] = a; 
    }


    public void printEdges(ArrayList<Edge> list){
        for(Edge e: list){
            System.out.println("(" +e.a + " " + e.b + ")" + " => " + e.w);
        }
    }

    public void printPar(int[] par)
    {
        int  j = 1;
        for(int i : par){
            if(i != 0){
        System.out.println(j+ " : " + i);
        j++;
    }
     }
    }


	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        SuperMancunian s = new SuperMancunian();

        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();
           Edge e = new Edge(a, b, w);
           s.edges_list.add(e);
        }

        // System.out.println("before sorting");
        // s.printEdges(s.edges_list);

        Collections.sort(s.edges_list, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.getEdgeWeight() - o2.getEdgeWeight();
            }
        });

        System.out.println("after sorting");
         s.printEdges(s.edges_list);


    for(int i=1;i<=n;i++){
        s.sz[i] = 1;  s.par[i] = i;
    }   

    int W = 0;
    int tot = 0;
    for(Edge e : s.edges_list){
        
        int w = e.w;
        int a = e.a;
        int b = e.b;
      //  s.printPar(s.par);
        if(s.root(a) == s.root(b))
        {
            continue;
        }
        W = Math.max(W, w);
        tot += w;
        System.out.println("tot : " + tot);
        s.unite(a, b);
    }
    for(int i=1;i<=n;i++){
        s.sz[i] = 1;  s.par[i] = i;
    }


    int cnt = 0;
    for(Edge e : s.edges_list){
        int w = e.w, a = e.a, b = e.b;
        if(w < W){
            s.unite(a, b);
        }
        else{
            if(s.root(a) != s.root(b))  cnt++;
            System.out.println("a: " + a + " b: " + b + " root(a): " +  s.root(a) + " root(b): " + s.root(b));
        }
    }

    tot -= W;
    System.out.println(tot + " " + cnt);



      
    }
}