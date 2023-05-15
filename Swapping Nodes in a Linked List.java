1721. Swapping Nodes in a Linked List

You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node 
from the end (the list is 1-indexed).

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
Example 2:

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]
 

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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        // Move first pointer to the kth node from the beginning
        for (int i = 0; i < k; i++) {
            first = first.next;
        }

        // Move second pointer k positions ahead of first (kth node from the end)
        ListNode temp = first;
        while (temp != null) {
            temp = temp.next;
            second = second.next;
        }

        // Swap the values of the first and second nodes
        int tempVal = first.val;
        first.val = second.val;
        second.val = tempVal;

        return dummy.next;

    }
}

/* Approach
Initialize a dummy node and set its next pointer to the head of the linked list.
Initialize the first and second pointers to the dummy node.
Move the first pointer to the kth node from the beginning by iterating k positions.
Move the second pointer to the kth node from the end by iterating k positions ahead of first.
Swap the values of the first and second nodes.
Return the modified linked list. */



