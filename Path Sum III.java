437. Path Sum III
Medium
9.5K
463
Companies
Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

 

Example 1:


Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.
Example 2:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3
  
  
  // Solution 
  
  /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    long count = 0;
    long simi = 0;
    long numele = 0;
    
    public void pathi(TreeNode root , int targetSum , long simi) {
        if(root == null) {
            return;
        }
        if(simi == targetSum) {
            count++;
        }
        if(root.left != null) {
            pathi(root.left , targetSum , simi + root.left.val);
        }
        if(root.right != null) {
            pathi(root.right , targetSum , simi + root.right.val);
        }
    }

    public void inorder(TreeNode root , int targetSum) {
        if(root != null) {
            numele++;
            inorder(root.left , targetSum);
            pathi(root , targetSum , root.val);
            inorder(root.right , targetSum);
        }
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        inorder(root, targetSum);
        return (int)count;
    }
}

