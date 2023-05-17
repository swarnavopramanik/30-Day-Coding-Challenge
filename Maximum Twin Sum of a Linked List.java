2130. Maximum Twin Sum of a Linked List

In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.

Given the head of a linked list with even length, return the maximum twin sum of the linked list.

 

Example 1:


Input: head = [5,4,2,1]
Output: 6
Explanation:
Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
There are no other nodes with twins in the linked list.
Thus, the maximum twin sum of the linked list is 6. 
Example 2:


Input: head = [4,2,2,3]
Output: 7
Explanation:
The nodes with twins present in this linked list are:
- Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
- Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
Thus, the maximum twin sum of the linked list is max(7, 4) = 7. 
Example 3:


Input: head = [1,100000]
Output: 100001
Explanation:
There is only one node with a twin in the linked list having twin sum of 1 + 100000 = 100001.
  
  // Solution 
  
  /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {

        // Reverse the first half 
        // Keep a pointer at first element and another pointer at (n/2) th element [0-based].
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
        // Reverse first half 
        // 3 -> 2 -> 1 -> 4 -> 5 -> 6 -> null
        // First pointer at 3 and second pointer at 4
        // Now we can use slow and fast pointer to get both first and second pointer
        // Keep both slow and fast at head and after each iteration move slow by one and fast by 2 steps
        // It is observered that after iterating the slow points at 4 i.e (n/2)
        // We need to keep track of 1 2 3 as we want to reverse it
        // So we take another pointer pointing to null initially and keep the record of previous node
        // Now we can reverse it.

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse from prev pointer

        ListNode rev = null;
        ListNode curr = head;
        while(curr != slow) {
            ListNode temp = curr.next;
            curr.next = rev;
            rev = curr;
            curr = temp;
        }

        ListNode back = rev;
        ListNode front = slow;
        int ans = 0;
        while(back != null) {
            ans = Math.max(ans , front.val + back.val);
            front = front.next;
            back = back.next;
        }
        return ans;


        /*

        // This is the naive approach where we clone the list and reverse the cloned list and iterate
        // Only n/2 times (n - count of nodes)

        ListNode curr = head;
        ListNode front = head;
        ListNode dummy = new ListNode();
        ListNode ok = dummy;
        while(curr != null) {
            ok.next = new ListNode(curr.val);
            ok = ok.next;
            curr = curr.next;
        }
        curr = head;
        int timesToIterate = countNodes(curr) >> 1;
        ListNode back = reverse(dummy.next);
        System.out.println(timesToIterate);
        int maximumSum = 0;
        while(timesToIterate --> 0) {
            int currSum = front.val + back.val;
            maximumSum = Math.max(maximumSum , currSum);
            front = front.next;
            back = back.next;
        }
        return maximumSum;
        */
    }
    static int countNodes(ListNode head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
    static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}


 
