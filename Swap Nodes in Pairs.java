24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the 
values in the list's nodes (i.e., only nodes themselves may be changed.)

Example 1:

Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]
 

// Solution 

class Solution {
    public ListNode swapPairs(ListNode head) {
	    // base case if linkedlist contains zero or only one element in it ( to avoid null pointer exception).
        if(head==null || head.next==null) return head;
        
        ListNode first = head; 
        ListNode second = head.next;
        
        while(first!=null && first.next!=null){
            // swap only the value of first and second node.
            int temp=first.val;
            first.val=second.val;
            second.val=temp;
            
            first = second.next; // Move first node to 3rd node OR two node further.
            if(first!=null) // to avoid null pointer exception.
                second=first.next;  // Move second node to 4th node OR two node further.
        }
        return head; // Return the head node
    }
}

