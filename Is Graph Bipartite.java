785. Is Graph Bipartite?

There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, 
where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. 
  The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in 
the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.

 

Example 1:


Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
Example 2:


Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
 
  
  // Solution 
  
            /*   Beats 66.41%  Runtime: 0 ms  */

class Solution {
    public boolean isBipartite(int[][] graph) 
    {
        int n=graph.length;
        int [] color = new int[n];
        for(int i=0;i<n;i++)
        {
            if(color[i]!=0)
            {
                continue;
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            color[i]=1;
            
            while(!q.isEmpty())
                {
                    int cur=q.peek();
                    q.remove();

                        for(int x : graph[cur])
                        {
                                if(color[x]==0)
                                {
                                    color[x]=-color[cur];
                                    q.add(x);
                                }
                                else if(color[x]!=-color[cur])
                                {
                                    return false;
                                }
                        }
                }
        }
        return true;
    }
} 




                /*  <----:USING BFS:---> */

              /* Beats 16.53%   */

/* class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        
        int color[]=new int[n+1];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(checkBipartite(i,adj,color)==false){
                    return false;
                }
            }
        }
        return true;
    }
// colors a component 
    public boolean checkBipartite(int i,ArrayList<ArrayList<Integer>>adj,int color[]){
        Queue<Integer>q=new LinkedList<>();
        q.add(i);
        color[i]=0;

        while(!q.isEmpty()){
            int node=q.poll();
            
            for(int e:adj.get(node)){
                if(color[e]==-1){// if the adjacent node is yet not colored
                    color[e]=1-color[node];// you will give the opposite color of the node 
                    q.add(e);
                }
                else if(color[e]==color[node]){// is the adjacent guy having the same color 
                    return false;
                }
            }
            
        }
        return true;

    }
}
 
 */

           /*        <----:USING DFS:---> */
          /*  Beats 20.30% */
/*

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        
        int color[]=new int[n+1];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(dfs(i,0,color,adj)==false){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int node, int col, int color[], ArrayList<ArrayList<Integer>>adj) {   
        color[node] = col; 
        // traverse adjacent nodes
        for(int it : adj.get(node)) {
            // if uncoloured
            if(color[it] == -1) {
                if(dfs(it, 1 - col, color, adj) == false) return false; 
            }
            // if previously coloured and have the same colour
            else if(color[it] == col) {
                return false; 
            }
        }
        
        return true; 
    }
} 

*/

