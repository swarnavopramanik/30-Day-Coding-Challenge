1547. Minimum Cost to Cut a Stick
Hard

Given a wooden stick of length n units. The stick is labelled from 0 to n. 
  For example, a stick of length 6 is labelled as follows:


Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.

You should perform the cuts in order, you can change the order of the cuts as you wish.

The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts. 
  When you cut a stick, it will be split into two smaller sticks (i.e. the sum of their lengths is the 
  length of the stick before the cut). Please refer to the first example for a better explanation.

Return the minimum total cost of the cuts.

 

Example 1:


Input: n = 7, cuts = [1,3,4,5]
Output: 16
Explanation: Using cuts order = [1, 3, 4, 5] as in the input leads to the following scenario:

The first cut is done to a rod of length 7 so the cost is 7. The second cut is done to a rod of 
length 6 (i.e. the second part of the first cut), the third is done to a rod of length 4 and the 
last cut is to a rod of length 3. The total cost is 7 + 6 + 4 + 3 = 20.
Rearranging the cuts to be [3, 5, 1, 4] for example will lead to a scenario with 
total cost = 16 (as shown in the example photo 7 + 4 + 3 + 2 = 16).
Example 2:

Input: n = 9, cuts = [5,6,1,4,2]
Output: 22
Explanation: If you try the given cuts ordering the cost will be 25.
There are much ordering with total cost <= 25, for example, the order [4, 6, 5, 2, 1] has 
total cost = 22 which is the minimum possible.
  
  // Solution 
  
  class Solution {
  public int minCost(int n, int[] cuts) {
    int[] A = new int[cuts.length + 2];
    System.arraycopy(cuts, 0, A, 1, cuts.length);
    A[0] = 0;
    A[A.length - 1] = n;

    Arrays.sort(A);

    // dp[i][j] := minCost(cuts[i..j])
    int[][] dp = new int[A.length][A.length];

    for (int d = 2; d < A.length; ++d)
      for (int i = 0; i + d < A.length; ++i) {
        final int j = i + d;
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; ++k)
          dp[i][j] = Math.min(dp[i][j], A[j] - A[i] + dp[i][k] + dp[k][j]);
      }

    return dp[0][A.length - 1];
  }
}



 
