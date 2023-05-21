934. Shortest Bridge

You are given an n x n binary matrix grid where 1 represents land and 0 represents water.

An island is a 4-directionally connected group of 1's not connected to any other 1's. 
  There are exactly two islands in grid.

You may change 0's to 1's to connect the two islands to form one island.

Return the smallest number of 0's you must flip to connect the two islands.

 

Example 1:

Input: grid = [[0,1],[1,0]]
Output: 1
Example 2:

Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2
Example 3:

Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1

  
  // Solution 
  
  class Solution {
    public class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    
    int [][] dirs={{1,0},{0,1},{-1,0},{0,-1}};
    public int shortestBridge(int[][] grid) {
         ArrayDeque<Pair> q=new ArrayDeque<>();
    boolean flag=false;//as we are going to stop by the time we find first whole island
    boolean [][] visited=new boolean[grid.length][grid[0].length];
    // Now search for first island and when we find first island using DFS then we will find the level using BFS
    for(int i=0;i<grid.length  && flag==false;i++){
        for(int j =0;j<grid[i].length && flag==false;j++){
            if(grid[i][j]==1){//by the time we find first 1 we will apply DFS and it will fill all 1 adjacent to it i.e its neighbour
                DFS(grid,i,j,visited,q);
                flag=true;
            }
        }
    }
    
    // after apply DFS queue will be filled with all the islands with 1 and now we will apply bfs
    
    int level=-1;//it is which we are going to return as  after finding the island we are going to make a bridge so that 2 island can connect
    
    while(q.size()!=0){
        int size=q.size();
        level++;
        
        // now this(following one) loop we do BFS
        while(size-->0){
            Pair rem=q.removeFirst();
            
            // Now after removing check for 0 then mark them as visited and by the time when we will find a unvisited 1 then that means we have reached the land and will return the value of level
             for(int i =0;i<dirs.length;i++){
          int newrow=rem.x+dirs[i][0];
            int newcol=rem.y+dirs[i][1];
            
              if(newrow>=0 && newcol>=0 && newrow<grid.length && newcol<grid[0].length && visited[newrow][newcol]==false ){
                  if(grid[newrow][newcol]==1){
                      return level;
                  }
                  
                  q.add(new Pair(newrow,newcol));
                  visited[newrow][newcol]=true;//not to come back again it this
            }
        }
    }
    }
    return -1;//if 1 is not found then i.e bridge cannot be made as there is no land
    }
    
    
    
    public void DFS(int [][] grid,int row,int col,boolean [][] visited,ArrayDeque<Pair> q){
             visited[row][col]=true;
      q.add(new Pair(row,col));//add row and coloum to the queue of the island
      
      for(int i =0;i<dirs.length;i++){
          int newrow=row+dirs[i][0];
            int newcol=col+dirs[i][1];
            
            // DFS will be only call if newrow and coloum are 1 and they are not visited.
            if(newrow>=0 && newcol>=0 && newrow<grid.length && newcol<grid[0].length && visited[newrow][newcol]==false && grid[newrow][newcol]==1){
                DFS(grid,newrow,newcol,visited,q);
            }
      }
  
    }
}

