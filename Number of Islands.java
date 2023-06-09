// LeetCode Question 200

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

// Solution 

class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0)
            return 0;
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        for(int i=0;i<m; i++)
        {
            for(int j=0;j<n; j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    merge(grid, i, j);
                }
            }
        }
        return count;
    }
    public void merge(char[][] grid, int i, int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length)
            return;
        if(grid[i][j]=='1') 
        {
            grid[i][j]='0';
            merge(grid, i-1,j);
            merge(grid, i+1,j);
            merge(grid, i,j-1);
            merge(grid, i,j+1);
        }
    }
}
