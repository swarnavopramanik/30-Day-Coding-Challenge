59. Spiral Matrix II

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

 

Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]
 

// Solution 

class Solution {
    public int[][] generateMatrix(int n) {
        

        int [][] arr = new int[n][n];

        int i = 0;      //starting row index
        int j = 0;      //starting col index

        int k = n;    //ending row index
        int l = n;    //ending col index

        int count = 0;

        boolean flag = true;

        while(flag) {

            flag = false;


            //--------------LEFT --->> RIGHT------------//
            while(j < l)
            {
              arr[i][j] = ++count;
              j++;
                flag = true;
            }
            j--;
            i++;


            //-------------TOP --->> BOTTOM-------------//

            while (i < k) {
                arr[i][j] = ++count;
                i++;
                flag = true;
            }
            j--;
            i--;
            k--;

            //-----------RIGHT --->> LEFT---------//
            while (j >= n - l) {
                arr[i][j] = ++count;
                j--;
                flag = true;
            }
            j++;
            l--;
            i--;

            //----------BOTTOM --->> TOP-------------//
            while (i >= n - k) {
                arr[i][j] = ++count;
                i--;
                flag = true;
            }
            i++;
            j++;
        }


        return arr;
    }
}

