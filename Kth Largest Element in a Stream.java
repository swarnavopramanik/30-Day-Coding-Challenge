703. Kth Largest Element in a Stream

Design a class to find the kth largest element in a stream. Note that it is the kth largest element 
in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
 

Example 1:

Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8
 
// Solution 

// Approach 1 ; Method use PriorityQueue

 class KthLargest {
    private int k;
    private Queue<Integer> heap = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) add(num);
    }
    
    public int add(int val) {
        if ( heap.size() < k || val > heap.peek() ) heap.add(val);
        if (heap.size() > k) heap.remove();

        return heap.peek();
    }
} 




// Approach 2 ; Method use BinarySearch 

/* class KthLargest {
    List<Integer> store = new ArrayList<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums)
            store.add(num);
        Collections.sort(store);
    }
    
    public int add(int val) {
        int pos = binarySearch(val); 
        store.add(pos, val);
        return store.get(store.size() - k);
    }
    
    public int binarySearch(int val) {
        int low = 0, high = store.size() - 1, res = high + 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (store.get(mid) == val)
                return mid;
            else if (store.get(mid) > val) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
} 

*/



