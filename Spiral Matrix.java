54. Spiral Matrix

Given an m x n matrix, return all elements of the matrix in spiral order.
  
Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

// Solution 

class Solution {
    
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>(); // Initialize a list to store the spiral order of matrix elements
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            // If the matrix is null or has 0 rows or columns, return the empty result list
            return res;
        }
        
        int m = matrix.length; // Get the number of rows in the matrix
        int n = matrix[0].length; // Get the number of columns in the matrix
        int row = 0; // Initialize the starting row index
        int col = 0; // Initialize the starting column index
        
        // Traverse the matrix in a spiral order
        while (row < m && col < n) {
            // Traverse the top row from left to right
            for (int i = col; i < n; i++) {
                res.add(matrix[row][i]); // Add the current element to the result list
            }
            row++; // Move to the next row
            
            // Traverse the right column from top to bottom
            for (int i = row; i < m; i++) {
                res.add(matrix[i][n - 1]); // Add the current element to the result list
            }
            n--; // Move to the previous column
            
            // Check if there are remaining rows to traverse
            if (row < m) {
                // Traverse the bottom row from right to left
                for (int i = n - 1; i >= col; i--) {
                    res.add(matrix[m - 1][i]); // Add the current element to the result list
                }
                m--; // Move to the previous row
            }
            
            // Check if there are remaining columns to traverse
            if (col < n) {
                // Traverse the left column from bottom to top
                for (int i = m - 1; i >= row; i--) {
                    res.add(matrix[i][col]); // Add the current element to the result list
                }
                col++; // Move to the next column
            }
        }
        
        return res; // Return the result list
    }
}

