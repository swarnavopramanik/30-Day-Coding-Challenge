1572. Matrix Diagonal Sum

Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not 
part of the primary diagonal.

 

Example 1:


Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.
Example 2:

Input: mat = [[1,1,1,1],
              [1,1,1,1],
              [1,1,1,1],
              [1,1,1,1]]
Output: 8
Example 3:

Input: mat = [[5]]
Output: 5
  
  // Solution 
  
  class Solution {
   /*  public int diagonalSum(int[][] mat) {
        int sum=0;
        int k=mat.length;
        for(int i=0;i<mat.length;i++){//first loop
            for(int j=0;j<mat.length;j++){//2nd loop
                if(i==j || i+j==mat.length-1){//same as printing "X" pattern
                    sum+=(mat[i][j]);//getting sum
                }
                
            }
        }
        return sum;//return sum
    } */

 public int diagonalSum(int[][] mat) {
    int n = mat.length;
    int primarySum = 0, secondarySum = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i == j) {
                primarySum += mat[i][j];
            } else if (i + j == n - 1) {
                secondarySum += mat[i][j];
            }
        }
    }
    return primarySum + secondarySum;
}

} 

